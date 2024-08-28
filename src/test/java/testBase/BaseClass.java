package testBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

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
public  Logger logger;	
public Properties p;


	@BeforeClass(groups={"sanity","regression","master"})
	@Parameters({"os","browser"})
	public void setUp(String os , String browser) throws IOException {	
		
		//Loading config.properties
		FileReader file = new FileReader(".//src/test/resources/config.properties");
		p = new Properties();
		p.load(file);
		
		//Logging
		logger = LogManager.getLogger(this.getClass());
		
		
		//cross browser
		switch(browser.toLowerCase()) {
		case "chrome": 
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default :
			logger.error("Invalid browser name has been passed =>"+browser);
			return;
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		driver.get(p.getProperty("appURL"));  //reading URL from config.properties file
		driver.manage().window().maximize();
	}
	
	
	@AfterClass(groups={"sanity","regression","master"})
	public void tearDown() {
		driver.quit();
	}
	
	public String randomString() {
    	return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomNumber() {
    	return RandomStringUtils.randomNumeric(10);
    }
    
    public String randomAlphanumeric() {
    	return RandomStringUtils.randomAlphanumeric(8);
    }

    
    public String captureScreen(String tname) throws IOException{
    	String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    	
    	TakesScreenshot takeScreenShot = (TakesScreenshot)driver;
    	File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
    	
    	String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+tname + "_"+timeStamp + ".png";
    	File targetFile = new File(targetFilePath);
    	
    	sourceFile.renameTo(targetFile);
    	return targetFilePath;
    }
}
