package vrt;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class VrtShared {
	Properties props = new Properties();
	public static String testUrl;
	public static String browser;
	public static String releaseDir;
	public static WebDriver driver;
	
	
	public void setup() {
		try{
		InputStream resourceStream =  this.getClass().getResourceAsStream("config.properties");
		    props.load(resourceStream);
		} catch (IOException e) {
		      e.printStackTrace();
	    }
		 testUrl= props.getProperty("testUrl");
		 browser = props.getProperty("browser");
		 
		 try {
			 if(browser.equals("Firefox")){
			 driver=new FirefoxDriver();
			 System.out.println("Mozilla Browser started");
			 }
			 else if(browser.equals("IE")){
			 driver=new InternetExplorerDriver();
			 System.out.println("IE Browser started");
			 }
			 else if (browser.equals("Chrome")){
			 driver = new ChromeDriver();
			 System.out.println("Chrome Browser started");
			 }
			 int implicitWaitTime=(10);
			 
			 driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
			 driver.get(testUrl);
			 
			 } catch (Exception e) {
			 System.out.println("Not able to open Browser --- "+ e.getMessage());
			 
			 }

	}
	
	public void takeScreenshot(String strscrshFileName, String strscrshFilePath)
			{
		try {
			if (driver != null && !driver.toString().contains("null")) {
				
				File scrFile1 = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.FILE);
				strscrshFileName = strscrshFileName + ".png";

				File file = new File(strscrshFilePath + "/" +browser + "/" +strscrshFileName);
				FileUtils.copyFile(scrFile1, file);

			} else {				
				System.out
						.println("Unable to Generate Screen Print - Browser is already closed or not opened");
			}
		} catch (IOException e) {
			System.out.println("Unable to Generate Screen Print");
			e.printStackTrace();			
		}

	}

}
