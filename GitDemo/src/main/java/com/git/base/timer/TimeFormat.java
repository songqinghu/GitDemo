package com.git.base.timer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormat {

    public static void main(String[] args) {
        
        long time =1468251330397l;
        
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        System.out.println(format);
        
    }
}
