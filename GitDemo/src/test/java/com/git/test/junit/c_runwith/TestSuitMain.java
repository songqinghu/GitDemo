package com.git.test.junit.c_runwith;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({AFunctionTest.class,BFunctionTest.class})
public class TestSuitMain {

}
