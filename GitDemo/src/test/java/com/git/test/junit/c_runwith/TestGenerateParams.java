package com.git.test.junit.c_runwith;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestGenerateParams {

private String greeting;
    
    public TestGenerateParams(String greeting)
    {
        super();
        this.greeting = greeting;
    }

    @Test
    public void testParams()
    {
        System.out.println(greeting);
    }
    
    @Parameters
    public static List<String[]> getParams(){
        ArrayList<String[]> list = new ArrayList<String[]>();
        list.add(new String[]{"one"});
        list.add(new String[]{"two"});
        list.add(new String[]{"three"});
        list.add(new String[]{"four"});
        return list;
    }
    
    
    /**
     * 这里的返回至少是二维数组
     * @return
     */
//    @Parameters
//    public static List<String[]> getParams()
//    {
//        return 
//                Arrays.asList(new String[][]{{"hello"}, 
//                        {"hi"}, 
//                        {"good morning"},
//                        {"how are you"}});
//    }
    
    
}
