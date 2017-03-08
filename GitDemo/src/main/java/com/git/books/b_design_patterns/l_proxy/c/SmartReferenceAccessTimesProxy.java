package com.git.books.b_design_patterns.l_proxy.c;

public class SmartReferenceAccessTimesProxy implements AccessTimes {

    private AccessTimesProxy proxy;
    public SmartReferenceAccessTimesProxy(AccessTimesProxy proxy) {
        this.proxy = proxy;
    }
    
    @Override
    public void access() {
        proxy.access();
        AccessCount.getInstance().add();
    }

    
}

//访问计数器
class AccessCount{
    
    private long countNum=0;
    
    private AccessCount() {
        //write some thing
    }
    //内部类单例
    private static class AccessInner{
        private static  AccessCount count = new AccessCount();
    }
    
    public static AccessCount getInstance(){
        return AccessInner.count;
    }
    
    public void add(){
          countNum++;
    }
    
    public long getCountNum(){
        return countNum;
    }
}