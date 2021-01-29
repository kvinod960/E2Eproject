 package Academy.E2EProject1;


import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobject.LandingPage;
import pageobject.LoginPage;
import resource.Base;

public class ValidateNavigationBar extends Base {
	
	public static Logger log = LogManager.getLogger(Base.class.getName());	
	
	@BeforeTest
	public void initialize() throws IOException, InterruptedException
	{
		driver=initializeDriver();
		driver.get("http://qaclickacademy.com/");		
		driver.manage().window().maximize();
		Thread.sleep(5000);		
	}

	@Test
public void basepageNavigation() {		
		
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getnavigation().isDisplayed());	
		log.info("Navigation bar is Displayed");
		
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
}
