package com.git.test.junit.c_runwith;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import com.git.test.junit.a_person.PersonTest;


@RunWith(Categories.class)
@SuiteClasses(PersonTest.class)
@IncludeCategory(AFunctionTest.class)
public class CategoryTest {

}
