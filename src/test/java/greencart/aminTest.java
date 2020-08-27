package greencart;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class aminTest extends browserInicialize{
	
	
	@BeforeTest
	public void ini() throws IOException
	{
		driver=browserDtails();
		driver.get(prob.getProperty("url"));	
	}
	@Test
	public void run() throws IOException
	{
		
		driver.manage().window().maximize();
		
		pathmethos pm=new pathmethos(driver);
		pm.addtocart();
		pm.bag();
		pm.proceed();
		pm.pcode("rahulshettyacademy");
		pm.apply();
		pm.vcode();
		pm.placeorder();
		pm.select();
		pm.check();
		pm.proceed2();
		
		
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	

}
