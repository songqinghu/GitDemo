package com.git.base.queue;

import java.util.List;

public class DataHandle {

    public boolean  handle(List<?> list){
        for (Object object : list) {
            System.out.println(object.toString());
        }
        MoreThreadByQueue.addSize(list.size());
        list.clear();
        
        return true;
    }
    
    
}
