package demo;

import java.io.IOException;

import com.future.risk.api.CShfeFtdcReqRiskUserLoginField;
import com.future.risk.api.CShfeFtdcRiskUserApi;
import com.future.risk.api.CShfeFtdcRiskUserSpi;
import com.future.risk.api.CShfeFtdcRspInfoField;
import com.future.risk.api.CShfeFtdcRspRiskUserLoginField;
import com.future.thost.util.LibLoader;;

public class RiskUserSpiImpl extends CShfeFtdcRiskUserSpi{
    
    final static String m_BrokerId = "9999";
    final static String m_UserId = "090985";
    final static String m_InvestorId = "090985";
    final static String m_PassWord = "caojiactp"; 
    final static String m_TradingDay = "20161111";
    final static String m_AccountId = "000326";
    final static String m_CurrencyId = "CNY";
    
    private CShfeFtdcRiskUserApi riskUserApi;
    
    RiskUserSpiImpl(CShfeFtdcRiskUserApi riskUserApi)
    {
        this.riskUserApi =  riskUserApi;
    }

    @Override
    public void OnRspError(CShfeFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
        // TODO Auto-generated method stub
        System.out.println("OnRspError");
    }
    
    @Override
    public void OnHeartBeatWarning(int nTimeLapse) {
        // TODO Auto-generated method stub
        System.out.println("OnHeartBeatWarning:"+nTimeLapse);
    }
    
    @Override
    public void OnFrontDisconnected(int nReason) {
        // TODO Auto-generated method stub
        System.out.println("OnFrontDisconnected");
    }
    
    @Override
    public void OnRspRiskUserLogin(CShfeFtdcRspRiskUserLoginField pRspRiskUserLogin, 
            CShfeFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
        System.out.println(pRspRiskUserLogin.getUserID()+"登录成功");
    };
    
    @Override
    public void OnFrontConnected(){
        System.out.println("On Front Connected");
        
        CShfeFtdcReqRiskUserLoginField loginField = new CShfeFtdcReqRiskUserLoginField();
        loginField.setBrokerID(m_BrokerId);
        loginField.setUserID(m_UserId);
        loginField.setPassword(m_PassWord);
        riskUserApi.ReqRiskUserLogin(loginField, 1);
        System.out.println("Send login ok");
    }


    public static class demo {
        static{
            
            try {
                LibLoader.loadLib("riskuserapi");
                LibLoader.loadLib("libiconv");
                LibLoader.loadLib("riskuserapi_wrap");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        final static String ctp1_TradeAddress = "tcp://180.169.116.118:50001";
        public static void main(String[] args) {
            // TODO Auto-generated method stub
            CShfeFtdcRiskUserApi riskUserApi = CShfeFtdcRiskUserApi.CreateFtdcRiskUserApi("ctpdata/risk/");
            RiskUserSpiImpl riskUserSpiImpl = new RiskUserSpiImpl(riskUserApi);
            riskUserApi.RegisterSpi(riskUserSpiImpl);
            riskUserApi.RegisterFront(ctp1_TradeAddress);
            String date = riskUserApi.GetTradingDay();
            String version = riskUserApi.GetApiVersion();
            System.out.println("时间："+date+" ，版本："+version);
            riskUserApi.Init();
            riskUserApi.Join();
            return;
        }
    }
}

