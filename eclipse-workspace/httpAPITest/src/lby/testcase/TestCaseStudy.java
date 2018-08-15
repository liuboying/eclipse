package lby.testcase;
import org.testng.annotations.*;

public class TestCaseStudy {
	//testcase1 
	@Test
	public void testCase1() {
		System.out.println("in testCase1");
	}
	
	
	@Test
	public void testCase2() {
		System.out.println("this is testcase2");
	}

	@BeforeSuite
	public void testCase3() {
		System.out.println("this is @@BeforeSuite");
	}
	@AfterSuite
	public void testCase4() {
		System.out.println("this is @@AfterSuite");
	}
	
	@BeforeClass
	public void testCase5() {
		System.out.println("this is beforclass");
	}
	
	@AfterClass
	public void testCase6() {
		System.out.println("this is afterclass");
	}
	
	@BeforeTest
	public void testCase7() {
		System.out.println("this is @@@BeforeTest");
	}
	@AfterTest
	public void testCase8() {
		System.out.println("this is @@@AfterTest");
	}
	@BeforeMethod
	public void testCase9() {
		System.out.println("this is @BeforeMethod");
	}
	@AfterMethod
	public void testCase10() {
		System.out.println("this is @AfterMethod");
	}
	
}
