package RestTesting;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class TestNG {
	@BeforeSuite
	public void BS()
	{
		System.out.println("This is going to Before execute first");
	}
	@BeforeTest
public void BT()
{
		System.out.println("This is going to Before Test suite ");
}
	@BeforeClass
	public void BC()
	{
		System.out.println("This is going to Before Class executed ");
	}
	
	@BeforeMethod
	public void BM()
	{
		System.out.println("This is going to Before every test Method ");
	}
	@Test
	public void TestCase1()
	{
	}
	@Test
	public void TestCase2()
	{
	}
	
	@AfterMethod
	public void AM()
	{
		System.out.println("This is going to execute after every test Method ");
	}
	@AfterClass
	public void AC()
	{
		System.out.println("This is going to execute after the class ");
	}
	@AfterTest
	public void AT()
	{
		System.out.println("This will excute after all the test is executed");
	}
	
	@AfterSuite
	public void AS()
	{
		System.out.println("This will execute after evertything at the end");
	}
}
