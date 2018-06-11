package demo;

import com.future.thost.api.*;;

public class TraderSpiImpl extends CThostFtdcTraderSpi{    
    final static String m_BrokerId = "9999";
    final static String m_UserId = "090985";
    final static String m_InvestorId = "090985";
    final static String m_PassWord = "caojiactp"; 
    final static String m_TradingDay = "20161111";
    final static String m_AccountId = "000326";
    final static String m_CurrencyId = "CNY";
    TraderSpiImpl(CThostFtdcTraderApi traderapi)
    {
        m_traderapi =  traderapi;
    }

    @Override
    public void OnFrontConnected(){
        System.out.println("On Front Connected");
        CThostFtdcReqUserLoginField field = new CThostFtdcReqUserLoginField();
        field.setBrokerID(m_BrokerId);
        field.setUserID(m_UserId);
        field.setPassword(m_PassWord);
        field.setUserProductInfo("JAVA_API");
        m_traderapi.ReqUserLogin(field,0);
        System.out.println("Send login ok");
    }

    @Override
    public void OnRspUserLogin(CThostFtdcRspUserLoginField pRspUserLogin, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast)
    {
        if (pRspInfo != null && pRspInfo.getErrorID() != 0)
        {
            System.out.printf("Login ErrorID[%d] ErrMsg[%s]\n", pRspInfo.getErrorID(), pRspInfo.getErrorMsg());

            return;
        }
        System.out.println("Login success!!!");
        
        /*{
            CThostFtdcQryTradingAccountField qryTradingAccount = new CThostFtdcQryTradingAccountField();
            qryTradingAccount.setBrokerID(m_BrokerId);
            //qryTradingAccount.setCurrencyID(m_CurrencyId);
            qryTradingAccount.setInvestorID(m_InvestorId);
            int r = m_traderapi.ReqQryTradingAccount(qryTradingAccount, 1);
            System.out.println(r);
        }*/
        
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        /*{
            CThostFtdcQryInstrumentField pQryInstrument = new  CThostFtdcQryInstrumentField();
            int r= m_traderapi.ReqQryInstrument(pQryInstrument, 2);
            System.out.println(r);
        }*/
        
        {
            //查询结算单
            CThostFtdcQrySettlementInfoField field = new CThostFtdcQrySettlementInfoField();
            field.setBrokerID(m_BrokerId);
            field.setInvestorID(m_InvestorId);
            field.setTradingDay("20180608");
            int r= m_traderapi.ReqQrySettlementInfo(field, 3);
            System.out.println(r);
        }
    }
    
    @Override
    public void OnRspOrderInsert(CThostFtdcInputOrderField pInputOrder, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
        
        System.out.printf("OnRspOrderInsert InstrumentID[%s] price[%f]\n",pInputOrder.getInstrumentID(),pInputOrder.getLimitPrice());
    };
    
    @Override
    public void OnRtnOrder(CThostFtdcOrderField pOrder) {
        System.out.printf("OnRtnOrder InstrumentID[%s] price[%f]\n",pOrder.getInstrumentID(),pOrder.getLimitPrice());
    };
    
    @Override
    public void OnRspQryInstrument(CThostFtdcInstrumentField pInstrument, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
        
        System.out.printf("OnRspQryInstrument InstrumentID[%s] \n",pInstrument.getInstrumentID());
    };
    
    @Override
    public void OnRspQryTradingAccount(CThostFtdcTradingAccountField pTradingAccount, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) 
    {
        if (pRspInfo != null && pRspInfo.getErrorID() != 0)
        {
            System.out.printf("OnRspQryTradingAccount ErrorID[%d] ErrMsg[%s]\n", pRspInfo.getErrorID(), pRspInfo.getErrorMsg());

            return;
        }

        if (pTradingAccount != null)
        {
            System.out.printf("Balance[%f]Available[%f]WithdrawQuota[%f]Credit[%f]\n",
                pTradingAccount.getBalance(), pTradingAccount.getAvailable(), pTradingAccount.getWithdrawQuota(),
                pTradingAccount.getCredit());
        }
        else
        {
            System.out.printf("NULL obj\n");
        }
    }
    
    @Override
    public void OnRspQrySettlementInfo(CThostFtdcSettlementInfoField pSettlementInfo, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast){
        System.out.println(pSettlementInfo.getContent());
    }

    private CThostFtdcTraderApi m_traderapi;
    
    public static class demo {

        static{
            System.load("D:/git/futurePlatform/future-parent/future-thost-api/src/main/resources/win/thostmduserapi.dll");
            System.load("D:/git/futurePlatform/future-parent/future-thost-api/src/main/resources/win/thosttraderapi.dll");
            System.load("D:/git/futurePlatform/future-parent/future-thost-api/src/main/resources/win/libiconv.dll");
            System.load("D:/git/futurePlatform/future-parent/future-thost-api/src/main/resources/win/thosttraderapi_wrap_code.dll");
        }
        final static String ctp1_TradeAddress = "tcp://180.168.146.187:10001";
        public static void main(String[] args) {
            // TODO Auto-generated method stub
            CThostFtdcTraderApi traderApi = CThostFtdcTraderApi.CreateFtdcTraderApi();
            TraderSpiImpl pTraderSpi = new TraderSpiImpl(traderApi);
            traderApi.RegisterSpi(pTraderSpi);
            traderApi.RegisterFront(ctp1_TradeAddress);
            traderApi.SubscribePublicTopic(THOST_TE_RESUME_TYPE.THOST_TERT_RESTART);
            traderApi.SubscribePrivateTopic(THOST_TE_RESUME_TYPE.THOST_TERT_RESTART);
            traderApi.Init();
            traderApi.Join();
            return;
        }
    }
}

