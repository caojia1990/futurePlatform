package demo;

import java.io.IOException;

import com.future.thost.api.CThostFtdcMdApi;
import com.future.thost.util.LibLoader;

public class MdapiDemo {
    static{
        
        System.out.println("java.library.path:"+System.getProperty("java.library.path"));
        /*String os = System.getProperty("os.name");
        if(os.toLowerCase().indexOf("win")>=0){
            System.load("D:/git/futurePlatform/future-parent/future-thost-api/src/main/resources/win/thostmduserapi.dll");
            System.load("D:/git/futurePlatform/future-parent/future-thost-api/src/main/resources/win/thosttraderapi.dll");
            System.load("D:/git/futurePlatform/future-parent/future-thost-api/src/main/resources/win/thosttraderapi_wrap.dll");
        }else {
            System.loadLibrary("thostmduserapi");
            System.loadLibrary("thosttraderapi");
            System.loadLibrary("thosttraderapi_wrap");
        }*/
        
        try {
            LibLoader.loadLib("thostmduserapi");
            LibLoader.loadLib("thosttraderapi");
            LibLoader.loadLib("iconv");
            LibLoader.loadLib("thosttraderapi_wrap");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
