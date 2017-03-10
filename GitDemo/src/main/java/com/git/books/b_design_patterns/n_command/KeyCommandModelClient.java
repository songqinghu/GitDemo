package com.git.books.b_design_patterns.n_command;
/**
 * @Description: 命令模式测试类
 * @author: songqinghu
 * @date: 2017年3月10日 下午3:15:43
 * Version:1.0
 */
public class KeyCommandModelClient {

    
    public static void main(String[] args) {
        
        KeyInputInvoking invoking = new KeyInputInvoking(new KeyScreenDisplay());
        invoking.printA(KeyModel.Capital);
        invoking.printB(KeyModel.Capital);
        invoking.printC(KeyModel.Capital);
        invoking.printA(KeyModel.Small);
        ScreenDisplay display = new KeyScreenDisplay();
        invoking.addSomeKeys(new AKeyCommand(display),KeyModel.Small);
        invoking.addSomeKeys(new BKeyCommand(display), KeyModel.Capital);
        invoking.addSomeKeys(new CKeyCommand(display), KeyModel.Small);
        
        invoking.printSomeKeys();
        
        
        
    }
}
