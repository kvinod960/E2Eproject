package Academy.E2EProject1;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobject.LandingPage;
import pageobject.LoginPage;
import resource.Base;

public class HomePage extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException, InterruptedException 
	{
		driver=initializeDriver();
		
	}	
	
	@Test(dataProvider ="getData")
	public void basepageNavigation(String username, String Password, String Text) throws InterruptedException  {
		
		
		//Accessing methods from another class
		//using inheritance and creating object of that class and invoke methods
		driver.get("http://qaclickacademy.com/");		
		driver.manage().window().maximize();
		Thread.sleep(5000);		
		LandingPage l = new LandingPage(driver);
		l.getLogin();
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(Password);
		lp.getlogin().click();	
		//System.out.println(Text);
		log.info(Text);
	}
	@DataProvider
	public Object[][] getData()
	{
		//Row stand for how many different data types test should run
		//Column stand for how many values need to pass per each test
		Object[][] data = new Object[2][3];
		data[0][0]="kvinod960@gmail.com";
		data[0][1]="Optum@3001";
		data[0][2]="Restricteduser";		
		data[1][0]="kvinod13948@gmail.com";
		data[1][1]= "Optum@3001";
		data[1][2]="nonrestricted user";
		return data;		
		
	}	
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
