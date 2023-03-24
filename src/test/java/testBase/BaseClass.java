package testBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;//import from java.utils
	
	
	@BeforeClass(groups= {"Master","Sanity","Regression"})
	@Parameters("browser")
	public void setup(String br)
	{
		rb=ResourceBundle.getBundle("config");//Load config.properties file
		
		logger=LogManager.getLogger(this.getClass());
		if(br.equals("edge"))
		{
		driver=  new EdgeDriver();
		}
		else if(br.equals("chrome"))
		{
		driver=  new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
		driver=  new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Master","Sanity","Regression"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomString() {
		
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomNumber() {
		
		String generatedNumber=RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	
	public String captureScreen(String tname)
	{
		/*SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmSS");
		Date dt = new Date();
		String timeStap = df.format(dt);*/
		//Above can be written in one statement as below 
		String timeStap=new SimpleDateFormat("yyyyMMddhhmmSS").format(new Date());
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStap+".png";
		
		try
		{
			FileUtils.copyFile(source, new File(destination));
		}
		
		catch(Exception e)
		{
			e.getMessage();
		}
		return destination;
	}

}
