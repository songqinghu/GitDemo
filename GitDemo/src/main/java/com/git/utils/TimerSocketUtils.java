package com.git.utils;

import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 判断azkaban服务是否存活着
 * @author songqinghu
 *
 */
public class TimerSocketUtils {

    
    public static void main(String[] args) {
        System.out.println(isLive());
    }
    
    
    
    private static String ADDRESS = null;//地址
    
    private static Integer PORT = null;//端口
    
    public static boolean reload = true;//是否重新加载  动态加载使用
    
    
    private static boolean isContinue = true;
    
    
    private static void init(){
        if(reload){
            
            ADDRESS = "10.69.213.66";
            PORT = 5672;
            if("false".equals(ADDRESS) || 0 == PORT){
                ADDRESS =null;
                PORT =null;
                isContinue = false;
            }
            reload = false;
        }
    }
    
    //判断azkaban服务的存活状况
    public static boolean  isLive(){
        init();
        if(isContinue){
            Socket socket;
           try {
               socket = new Socket();
               InetSocketAddress socketAddress = new InetSocketAddress(ADDRESS, PORT);
               socket.connect(socketAddress, 1000);
               boolean result = socket.isConnected();
               socket.close();
               return result;
           } catch (Exception e) {
               socket =null;
           } 
        }
        return false;
    }
    
    
}
