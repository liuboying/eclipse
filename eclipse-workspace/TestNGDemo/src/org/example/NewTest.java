package org.example;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class NewTest {
//  @Test
//  public void f() {
//	  System.out.println("@Test");
//  }
//  @BeforeMethod
//  public void beforeMethod() {
//	  System.out.println("BeforeMethod");
//  }

  @Test
  public void testAdd() {
	  
	  int actual =1 ;
	  assertEquals(actual, 1);
  }
  
  
}
