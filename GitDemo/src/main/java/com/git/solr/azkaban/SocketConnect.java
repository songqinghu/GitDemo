package com.git.solr.azkaban;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * socket 检测 定时任务存活状态
 * @author songqinghu
 *
 */
public class SocketConnect {

    private final static String IP = "10.125.2.47";
    
    private final static Integer PORT=8443;
    
    public static void main(String[] args) throws UnknownHostException, IOException {
        
        
       Socket socket = new Socket(IP, PORT);
       
       boolean connected = socket.isConnected();
       
       System.out.println(connected);
        
       socket.close();
        
        
    }
    
    
    
}
