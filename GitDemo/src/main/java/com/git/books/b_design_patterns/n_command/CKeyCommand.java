package com.git.books.b_design_patterns.n_command;

/**
 * @Description: a 按键命令封装类  命令类中要有执行类的引用
 * @author: songqinghu
 * @date: 2017年3月10日 上午11:37:29
 * Version:1.0
 */
public class CKeyCommand implements KeyBoardCommand {

    private ScreenDisplay screenDisplay;
    
    public CKeyCommand(ScreenDisplay screenDisplay) {
        
        this.screenDisplay=screenDisplay;
    }
    
    
    @Override
    public void execute(KeyModel model) {
        if(KeyModel.Capital.equals(model)){
            screenDisplay.printKey("C");
        }else{
            screenDisplay.printKey("c");
        }
    }

}
