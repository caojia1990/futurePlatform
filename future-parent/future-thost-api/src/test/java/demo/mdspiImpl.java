package demo;

import com.future.thost.api.*;

public class mdspiImpl extends CThostFtdcMdSpi{
    final static String m_BrokerId = "9999";
    final static String m_UserId = "090985";
    final static String m_InvestorId = "090985";
    final static String m_PassWord = "caojiactp"; 
    final static String m_TradingDay = "20161111";
    final static String m_AccountId = "000326";
    final static String m_CurrencyId = "CNY";
    mdspiImpl(CThostFtdcMdApi mdapi)
    {
        m_mdapi =  mdapi;
    }

    public void OnFrontConnected(){
        System.out.println("On Front Connected");
        CThostFtdcReqUserLoginField field = new CThostFtdcReqUserLoginField();
        field.setBrokerID(m_BrokerId);
        field.setUserID(m_UserId);
        field.setPassword(m_PassWord);
        m_mdapi.ReqUserLogin(field, 0);

    }

    public void OnRspUserLogin(CThostFtdcRspUserLoginField pRspUserLogin, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
        if (pRspUserLogin != null) {
            System.out.printf("Brokerid[%s]\n",pRspUserLogin.getBrokerID());            
        }

        String[] instruementid = new String[1];
        instruementid[0]="cu1807";      
        m_mdapi.SubscribeMarketData(instruementid,1);
    }

    public void OnRtnDepthMarketData(CThostFtdcDepthMarketDataField pDepthMarketData) {
        if (pDepthMarketData != null)
        {
            System.out.printf("AskPrice1[%f]BidPrice1[%f]\n",
                pDepthMarketData.getAskPrice1(),pDepthMarketData.getBidPrice1());
        }
        else
        {
            System.out.printf("NULL obj\n");
        }
    }   
    private CThostFtdcMdApi m_mdapi;
    
    public static class MdapiDemo {
        static{
            
            System.out.println("java.library.path:"+System.getProperty("java.library.path"));
            String os = System.getProperty("os.name");
            if(os.toLowerCase().indexOf("win")>=0){
                System.load("D:/git/futurePlatform/future-parent/future-thost-api/src/main/resources/win/thostmduserapi.dll");
                System.load("D:/git/futurePlatform/future-parent/future-thost-api/src/main/resources/win/thosttraderapi.dll");
                System.load("D:/git/futurePlatform/future-parent/future-thost-api/src/main/resources/win/thosttraderapi_wrap.dll");
            }else {
                System.loadLibrary("thostmduserapi");
                System.loadLibrary("thosttraderapi");
                System.loadLibrary("thosttraderapi_wrap");
            }
        }
        final static String ctp1_MdAddress = "tcp://180.168.146.187:10010";
        public static void main(String[] args) {
            // TODO Auto-generated method stub
            CThostFtdcMdApi mdApi = CThostFtdcMdApi.CreateFtdcMdApi();
            mdspiImpl pMdspiImpl = new mdspiImpl(mdApi);
            mdApi.RegisterSpi(pMdspiImpl);
            mdApi.RegisterFront(ctp1_MdAddress);
            mdApi.Init();
            mdApi.Join();
            return;
        }
    }
}
