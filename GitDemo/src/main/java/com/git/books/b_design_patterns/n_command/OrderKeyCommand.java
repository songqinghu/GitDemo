package com.git.books.b_design_patterns.n_command;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 键盘命令存储起来,序列的输入。
 * @author: songqinghu
 * @date: 2017年3月10日 下午2:57:55
 * Version:1.0
 */
public class OrderKeyCommand implements KeyBoardCommand {

    private List<KeyBoardCommand> orderKeys = new ArrayList<KeyBoardCommand>();     
    
    private List<KeyModel> keyModels = new ArrayList<KeyModel>();
    
    @Override
    public void execute(KeyModel model) {
        execute();
    }

    public  void execute() {
        for (int i = 0; i < orderKeys.size(); i++) {
            orderKeys.get(i).execute(keyModels.get(i));
        }
        orderKeys.clear();
        keyModels.clear();
    }
    /*
     * 添加一个输入进入序列中
     */
    public void add(KeyBoardCommand key,KeyModel model){
        orderKeys.add(key);
        keyModels.add(model);
    }
    

}
