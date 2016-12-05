package com.git.test.junit.c_runwith;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.git.test.junit.a_person.Person;
import com.git.test.junit.a_person.PersonImpl;

public class BFunctionTest {

    private Person person;
    
    @Before
    public void before(){
        person = new PersonImpl(10, "tom");
    }
    
    @Test
    public void TastGetAge(){
        int age = person.getAge();
        Assert.assertEquals(age, 10);
    }
    @Test
    public void TestGetName(){
        String name = person.getName();
        Assert.assertEquals(name, "tom");
    }
    
}
