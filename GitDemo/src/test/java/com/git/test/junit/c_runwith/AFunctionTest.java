package com.git.test.junit.c_runwith;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.git.test.junit.a_person.Person;
import com.git.test.junit.a_person.PersonImpl;

public class AFunctionTest {

    private Person person;
    
    @Before
    public void before(){
        person = new PersonImpl(20, "lilei");
    }
    
    @Test
    public void TastGetAge(){
        int age = person.getAge();
        Assert.assertEquals(age, 20);
    }
    @Test
    public void TestGetName(){
        String name = person.getName();
        Assert.assertEquals(name, "lilei");
    }
    
    
}
