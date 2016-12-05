package com.git.test.junit.a_person;

public class PersonImpl implements Person {

    private int age;
    
    private String name;
    
    
    public PersonImpl() {
    
    }
    
    public PersonImpl(int age,String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String talkTo(String message) {
        if(!"hello".equals(message)){
            throw new IllegalArgumentException();
        }
        return message;
    }

    @Override
    public void walk() {
        
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("walk");
    }
    
    
  
}
