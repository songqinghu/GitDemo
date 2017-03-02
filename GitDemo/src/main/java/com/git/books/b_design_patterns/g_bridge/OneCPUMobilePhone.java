package com.git.books.b_design_patterns.g_bridge;

/**
 * 
 * @Description: 1个cpu的手机  手机系统下的具体实现类  client将要调用的对象
 * @author: songqinghu
 * @date: 2017年3月2日 下午2:47:39
 * Version:1.0
 */
public class OneCPUMobilePhone extends MobilePhone {

    public OneCPUMobilePhone(Brand brand) {
        super(brand);
    }

    @Override
    public void run() {
        System.out.println("the one cpu mobile phone is run and the brand is : " + brand.getBrandLogo());
    }

    
}
