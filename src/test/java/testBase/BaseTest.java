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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseTest {
	
	public static WebDriver driver;
	public Logger logger;  //log4j
	public Properties pr;
	
	
	@BeforeClass(groups={"Sanity","Regression","Master"})
	@Parameters({"os","broswer"})
	public void setUp(String os,String br) {
		
		//loading config.properties file
		try {
			FileReader file=new FileReader(".//src/test/resources/config.properties");
			pr=new Properties();
			try {
				pr.load(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger=LogManager.getLogger(this.getClass());
		
		
		switch(br.toLowerCase()) {
		case "chrome":driver=new ChromeDriver(); break;
		case "edge":driver=new EdgeDriver(); break;
		case "firefox":driver=new FirefoxDriver(); break;
		default : System.out.println("Invalid browser name");return;
		
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		driver.get(pr.getProperty("appURL"));  //reading URL from .properties file
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups={"Sanity","Regression","Master"})
	public void tearDown() {
		driver.quit();
	}
	
	public String getRandomString() {
		return RandomStringUtils.randomAlphabetic(5);
	}
	
	public String getRandomNumber() {
		return RandomStringUtils.randomNumeric(10);
	}
	
	public String getAlphanumeric() {
		return RandomStringUtils.randomAlphabetic(3)+"@"+RandomStringUtils.randomNumeric(3);
	}
	
	public String captureScreen(String tname) throws IOException{
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
		File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String tagetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
		File targetFile=new File(tagetFilePath)	;
		
		sourceFile.renameTo(targetFile);
		
		return tagetFilePath;
		
		
		
		
	}
}
