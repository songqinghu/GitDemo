package com.git.base.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class CustomerQueueStart implements QueueStart<Info>{

    @Override
    public void threadStart(ArrayBlockingQueue<Info> queue, Integer threadNum) {
        
        CountDownLatch latch = new CountDownLatch(threadNum);
        
        ExecutorService pool = Executors.newFixedThreadPool(threadNum);
        
        DataHandle handle = new DataHandle();
        
        for (int i = 0; i < threadNum; i++) {
           
            customerTask task = new customerTask(queue, latch, 10, handle);
            
            FutureTask<Boolean> future = new FutureTask<Boolean>(task);          
            
            pool.submit(future);
        }
        
        try {
            latch.await();
            pool.shutdown();
            pool.awaitTermination(Integer.MAX_VALUE, TimeUnit.HOURS);
            System.err.println(" the full write is end collection name is test");
        } catch (Exception e) {
           e.printStackTrace();
        }
        
        
        
    }

    
    
   class customerTask implements Callable<Boolean>{

        private ArrayBlockingQueue<Info> queue;
        
        private CountDownLatch latch;
        
        private Integer pageSize;
        
        private DataHandle handle;
        
        public customerTask(ArrayBlockingQueue<Info> queue,
                CountDownLatch latch,
                Integer pageSize,
                DataHandle handle) {
            
            this.queue = queue;
            this.latch = latch;
            this.pageSize = pageSize;
            this.handle = handle;
            
        }
        
        
        
        @Override
        public Boolean call() throws Exception {
            //System.err.println(Thread.currentThread().getName()+ "  start **********");
            //customer
            ArrayList<Info> list = new ArrayList<Info>();
            while(!Thread.currentThread().isInterrupted()){
                if(list.size()<pageSize){
                    
                    Info info = queue.take();
                    
                    if(info != ProductQueueStart.END){
                        list.add(info);
                    }else{
                        //end thread;
                        stopCurrentThread(list);
                    }
                    
                    
                }else{
                    //data handle
                    datahandle(list);
                }
                
                
                
            }
            return true;
        }
        
        protected void stopCurrentThread(List<Info> list){
            
            datahandle(list);
            
            latch.countDown();
            
            try {
                queue.put(ProductQueueStart.END);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.currentThread().interrupt();
            
        }
        
        protected void datahandle(List<Info> list){
            handle.handle(list);
        }
        
        
    }
    
    
}
