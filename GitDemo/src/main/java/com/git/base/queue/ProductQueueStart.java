package com.git.base.queue;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class ProductQueueStart implements QueueStart<Info>{

    //the thread end flag
    public static Info END = new Info();
    
    
    
    @Override
    public void threadStart(ArrayBlockingQueue<Info> queue, Integer threadNum)  {
        //the threads var 
        CountDownLatch latch = new CountDownLatch(threadNum);
        
        ExecutorService pool = Executors.newFixedThreadPool(threadNum);
        
        
        for (int i = 0; i < threadNum; i++) {
            DataRandProduer provider = new DataRandProduer();
            productTask task = new productTask(latch, queue, provider);
            pool.submit(task);
        }
        
        try {
            latch.await();
            pool.shutdown();
            pool.awaitTermination(Integer.MAX_VALUE, TimeUnit.HOURS);
            
            queue.put(END);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    
    private class productTask implements Callable<Boolean>{

        private CountDownLatch latch =null;
        
        private ArrayBlockingQueue<Info> queue =null;
        
        private DataRandProduer provider;
        
        public productTask(CountDownLatch latch,ArrayBlockingQueue<Info> queue,DataRandProduer provider) {
                this.latch = latch;
                this.queue = queue;
                this.provider = provider;
        }

        @Override
        public Boolean call() throws Exception {
            //product
            while(true){
                List<Info> list = provider.getCollections(1, 10);
                if(list.size()>0){
                    for (Info info : list) {
                        if(!"end".equals(info.getInfo())){
                            queue.put(info);
                        }else{
                            Info in = new Info();
                            in.setInfo("end");
                            MoreThreadByQueue.data.put(in);
                            latch.countDown();
                            return true;
                        }
                    }
                }
            }
        }

        
        
        
        
    }
    

}
