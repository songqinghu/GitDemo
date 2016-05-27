package com.git.base.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class DataRandProduer {

    
    public synchronized List<Info> getCollections(Integer start,Integer rows) throws InterruptedException{
        ArrayList<Info> list = new ArrayList<>();
        ArrayBlockingQueue<Info> data = MoreThreadByQueue.data;
        for (int i = 0; i < rows; i++) {
            Info info = data.take();//阻塞
            list.add(info);
            if("end".equals(info.getInfo())){
                break;
            }
        }
        return list;
    }
    
}
