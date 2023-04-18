package banking3.testngmarch27;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class baseclass {
	public WebDriver driver;
	
	@BeforeMethod
	  @Parameters({"url", "brow"})
	  public void beforeMethod(String url, String brow) {
		  System.out.println("This is before method");
		  
		  if(brow.contains("chrome")) {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\manic\\eclipse-workspace\\google\\drivers\\chromedriver.exe");
	driver= new ChromeDriver();  // Opening chrome browser
		  }
		  
		  else if (brow.contains("firefox")) {
		    
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\manic\\eclipse-workspace\\Gmail\\driver\\geckodriver.exe");
	driver= new FirefoxDriver();  // Opening firefox browser
		  }
		  else {
	System.setProperty("webdriver.edge.driver", "C:\\Users\\manic\\eclipse-workspace\\Gmail\\driver\\msedgedriver.exe");
	driver= new EdgeDriver();  // Opening edge browser
		  }

		        driver.get(url);	
		      
	  }
	
	
	
	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("This is after method");
		  driver.close();
	  }
	  
	  
	  
	  public void shots() throws IOException {	  
		  File cap=	  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(cap, new File("C:\\Users\\user\\eclipse-workspace\\testngmarch27\\screenshots\\1.png"));  
		    }
		    
		    
		    public void shotsv2(String name) throws IOException {	  
		  File cap=	  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(cap, new File("C:\\Users\\user\\eclipse-workspace\\testngmarch27\\screenshots\\"+ name +".png"));  
		    }
		    


}
