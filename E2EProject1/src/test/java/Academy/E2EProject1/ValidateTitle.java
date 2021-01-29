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

public class ValidateTitle extends Base {
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException, InterruptedException
	{
		driver=initializeDriver();
		log.info("Driver is Initialized");
		driver.get("http://qaclickacademy.com/");
		log.info("URL Launched sucessfully");
		driver.manage().window().maximize();
		Thread.sleep(5000);		
	}	

	@Test
    public void basepageNavigation() 
	{			
		LandingPage l = new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		log.info("Sucessfully validated the Test Message");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
}

	

