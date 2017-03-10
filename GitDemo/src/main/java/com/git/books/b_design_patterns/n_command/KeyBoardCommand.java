package com.git.books.b_design_patterns.n_command;
/**
 * @Description: 命令模式 之 键盘按键命令接口类
 * @author: songqinghu
 * @date: 2017年3月10日 上午11:35:53
 * Version:1.0
 */
public interface KeyBoardCommand {

    
    public void execute(KeyModel model);
    
}
