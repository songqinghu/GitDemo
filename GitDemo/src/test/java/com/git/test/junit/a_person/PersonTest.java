package com.git.test.junit.a_person;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.git.test.junit.c_runwith.AFunctionTest;
import com.git.test.junit.c_runwith.BFunctionTest;
/**
 * 
 * @Description: 基本方法测试类
 * @author: songqinghu
 * @date: 2016年12月5日 下午3:39:57
 * Version:1.0
 */
public class PersonTest {

    private Person person;
    
    @Before
    public void before(){
        person = new PersonImpl(10, "tom");
    }
    
    @Test
    @Category(AFunctionTest.class)
    public void TastGetAge(){
        int age = person.getAge();
        Assert.assertEquals(age, 10);
    }
    @Test
    @Category(AFunctionTest.class)
    public void TestGetName(){
        String name = person.getName();
        Assert.assertEquals(name, "tom");
    }
    
    @Test(timeout=100)
    @Category(BFunctionTest.class)
    public void TeatPersonWalk(){
        person.walk();
        
    }
    @Test(expected=IllegalArgumentException.class)
    @Category(BFunctionTest.class)
    public void TestException(){
        String talkTo = person.talkTo("lalala");
        Assert.assertNotNull(talkTo);
    }
    
    
    
    
    
}
