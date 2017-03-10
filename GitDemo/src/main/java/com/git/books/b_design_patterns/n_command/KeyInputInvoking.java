package com.git.books.b_design_patterns.n_command;
/**
 * @Description: 键盘输入调用类 用来调用指定的键盘命令
 * @author: songqinghu
 * @date: 2017年3月10日 下午2:47:51
 * Version:1.0
 */
public class KeyInputInvoking {
    
    private KeyBoardCommand akeyCommand;
    
    private KeyBoardCommand bkeyCommand;
    
    private KeyBoardCommand ckeyCommand;
    
    private OrderKeyCommand orderCommand = new OrderKeyCommand();
    
    public KeyInputInvoking(ScreenDisplay display) {

        akeyCommand = new AKeyCommand(display);
        bkeyCommand = new BKeyCommand(display);
        ckeyCommand = new CKeyCommand(display);
        
    }
    
    public void printA(KeyModel model){
        akeyCommand.execute(model);
    }
    
    public void printB(KeyModel model){
        bkeyCommand.execute(model);
    }
    
    public void printC(KeyModel model){
        ckeyCommand.execute(model);
    }
    
    
    public void addSomeKeys(KeyBoardCommand command,KeyModel model){
        orderCommand.add(command, model);
    }
    
    public void printSomeKeys(){
        orderCommand.execute();
    }
    

}
