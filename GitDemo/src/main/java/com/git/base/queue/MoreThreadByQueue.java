package com.git.base.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 多线程解决方案之 生产者消费者模式
 * --->读写分离
 * 加入缓冲队列的demo
 * @author songqinghu
 *
 */
public class MoreThreadByQueue {

    public static ArrayBlockingQueue<Info> data = new ArrayBlockingQueue<>(200000);
    
    private static Integer count  =0;
    
    public static void main(String[] args) throws InterruptedException {
        // info data pool init
        addData();
        //start
       initStart();
       System.out.println("total quantity :  " + count);
    }
   
    
    private static void addData() throws InterruptedException{
        for (int i = 0; i < 190000; i++) {
            Info info = new Info();
            info.setInfo("info "+ i);
            data.put(info);
        }
        Info info = new Info();
        info.setInfo("end");
        data.put(info);//毒丸
        System.out.println("数据导入结束!");
    }
    
    
    /**
     * 
     * @描述：init params and start threads 
     * @return void
     * @exception
     * @createTime：2016年5月27日
     * @author: songqinghu
     */
    private static void initStart(){
        final int productThreadNum = 4;
        final  int customerThreadNum =2;
        final  ArrayBlockingQueue<Info> queue = new ArrayBlockingQueue<Info>(10000);
        
        
        CustomerQueueStart customer = new CustomerQueueStart();
        Thread  t =  new Thread(){
            public void run(){
                ProductQueueStart product = new ProductQueueStart();
                product.threadStart(queue, productThreadNum);
            }
        };
        t.start();
        
        //the main thread is wait end in customer
        customer.threadStart(queue, customerThreadNum);
        
        System.out.println("******the full index is end {collection name}");
    }
    
    public synchronized static void addSize(Integer size){
        count +=size;
    }
    
}
