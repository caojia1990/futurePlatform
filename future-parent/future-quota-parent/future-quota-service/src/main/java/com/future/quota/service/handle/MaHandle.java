package com.future.quota.service.handle;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import com.future.market.api.vo.DepthMarketData;
import com.future.quota.api.vo.KlineRange;
import com.future.quota.service.dao.KlineRangeDao;

/**
 * MA指标生成线程
 * @author caojia
 */
public class MaHandle implements Runnable {
    
    private static MaHandle MA_HANDLE;
    
    static Logger logger = Logger.getLogger(MaHandle.class);
    
    private static LinkedBlockingQueue<DepthMarketData> MARKET_QUEUE = new LinkedBlockingQueue<>();
    
    private static LinkedList<Double> CLOSE_PRICE_LIST = new LinkedList<Double>();
    
    private Map<String, KlineRange> rangeMap = new HashMap<>();
    
    private final KlineRangeDao klineRangeDao;
    
    public MaHandle(ApplicationContext context){
        
        this.klineRangeDao = context.getBean(KlineRangeDao.class);
        
    }
    
    @Override
    public void run() {

        while (true) {
            
            DepthMarketData marketData = null;
            try {
                marketData = MARKET_QUEUE.take();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            String instrumentId = marketData.getInstrumentID();
            String product = instrumentId.replaceAll("[^a-z^A-Z]", "");
            
            //先从缓存中找出该品种的k线横坐标
            KlineRange klineRange = rangeMap.get(product);
            if(klineRange == null){
                
            }else {
                //如果k线横坐标存在，判断本次行情的更新时间是否落在该k线横坐标周期内
                if(marketData.getUpdateTime().compareTo(klineRange.getBeginTime()) > -1 
                        && marketData.getUpdateTime().compareTo(klineRange.getEndTime()) < 1){
                    
                }else {
                    //如果当前时间不在缓存的k先横坐标内，先保存上一周期k线，再查询新的坐标范围
                    
                }
            }
            
        }
        
    }
    
    
    
    public static void START(ApplicationContext context){
        
        if(MA_HANDLE == null){
            MA_HANDLE = new MaHandle(context);
            new Thread(MA_HANDLE).start();
        }
    }
    
    public static void OFFERMARKET(DepthMarketData marketData){
        MARKET_QUEUE.offer(marketData);
    }
    
    public static void main(String[] args) {
        
    }

}
