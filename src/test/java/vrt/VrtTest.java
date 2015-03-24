package vrt;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class VrtTest extends VrtShared{
	

	@Test
	public void vrtTestCase(){

		// Drive the application under test (AUT) and 
		
		setup();

		//take a screenshot using any functional automation tool
		takeScreenshot("GoogleHomePage",releaseDir);
		// Compare the screenshot with an initial "baseline" image by comparing images pixel wise or using image comparison libraries  
		// Report the differences
	    // Update the baseline as needed

		

	}
	
}
