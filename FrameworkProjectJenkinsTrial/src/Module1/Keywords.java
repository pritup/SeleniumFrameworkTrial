package Module1;
//http://www.vogella.de/articles/JavaRegularExpressions/ar01s05.html
//import static org.junit.Assert.assertEquals;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
//import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
// testng
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
//import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.Select;
public class Keywords
{
	public static Logger APPICATION_LOGS = Logger.getLogger("devpinoyLogger");
	public static Properties CONFIG;
	public static Properties OR;
	public static Properties APPTEXT;	
	public static Xls_Reader testData;	
	static WebDriver wbdv=null;
	public static int count = 0;
	protected static EventFiringWebDriver driver=null;
	public static Xls_Reader d=new Xls_Reader(System.getProperty("user.dir")+"\\src\\Module1\\Yapmo.xlsx");
	// navigate

	public static void navigate() throws IOException
	{	
		CONFIG = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\config\\config.properties");
		CONFIG.load(fs);
		OR = new Properties();
		fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\config\\OR.properties");
		OR.load(fs);
		// app text prop load
		APPTEXT = new Properties();
		fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\config\\app_text.properties");
		APPTEXT.load(fs);
		try
		{
		if(wbdv == null)
		{
			if(CONFIG.getProperty("testBrowser").equalsIgnoreCase("Firefox"))
			{
				wbdv = new FirefoxDriver();
				driver = new EventFiringWebDriver(wbdv);
				DesiredCapabilities dc=new DesiredCapabilities();
				dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,UnexpectedAlertBehaviour.ACCEPT);
				driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
				String Url=CONFIG.getProperty("testSiteURL");
				driver.get(Url);
				driver.manage().window().maximize();
				Thread.sleep(2000);
			}
			else if(CONFIG.getProperty("testBrowser").equalsIgnoreCase("ie"))
			{
				 DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			 	 capabilities.setCapability("iexplore.binary","C:/Program Files/Internet Explorer/iexplore.exe");
			 	 System.setProperty("webdriver.ie.driver","D:/IEDriverServer.exe");
			 	 wbdv=new InternetExplorerDriver(capabilities); 
			 	 driver=new EventFiringWebDriver(wbdv);	
				driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
				String Url=CONFIG.getProperty("testSiteURL");
				driver.get(Url);
				driver.manage().window().maximize();				
				Thread.sleep(1000);
			}
			else if(CONFIG.getProperty("testBrowser").equalsIgnoreCase("Chrome"))
			{
				 DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			 	 capabilities.setCapability("binary","C:\\Users\\freightmail\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
			 	 System.setProperty("webdriver.ie.driver","D:\\chromedriver_win32\\chromedriver.exe");
			 	 wbdv=new InternetExplorerDriver(capabilities); 
			 	 driver=new EventFiringWebDriver(wbdv);	
				driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
				String Url=CONFIG.getProperty("testSiteURL");
				driver.get(Url);
				driver.manage().window().maximize();
			}
		}	
		}
		catch(Throwable t)
		{
	    	System.out.println(t.getMessage());
		}
	}
	public static void waitr(String Element)throws Exception
	{
		CONFIG = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\config\\config.properties");
		CONFIG.load(fs);
				
		try
		{
			WebDriverWait DW= new WebDriverWait(driver,30);
			DW.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("Element"))));
		}
		catch(Throwable t)
		{
			t.getMessage();
		}
	}
	public static void ScrollDown(String name)throws Throwable 
	{
        try
        {
        	for(int i=0;i<20;i++)
        	{
        		driver.findElement(By.tagName("body")).sendKeys(Keys.DOWN);       
        	}        
 }
 catch(Exception t)
 {
	File screenshotfailure=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
 	FileUtils.copyFile(screenshotfailure, new File(CONFIG.getProperty("Screenshot") +"\\" +name + ".png"));
 	APPICATION_LOGS.info("Error while executing FrameHandle -"+ t.getMessage());
 }
    }
	
	public static String MouseOver(String Object,String name) throws Exception
	{
		OR = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\config\\OR.properties");
		OR.load(fs);
		try
		{		
		 Actions builder = new Actions(driver);
		 WebElement tagElement = driver.findElement(By.xpath(OR.getProperty(Object)));
		 builder.moveToElement(tagElement).build().perform();
		 Thread.sleep(2000);
		}
		catch(Throwable t)
		{			
			File screenshotfailure=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	FileUtils.copyFile(screenshotfailure, new File(CONFIG.getProperty("Screenshot") +"\\" +name + ".png"));
	    	System.out.println(t.getMessage());
		}
		return "True";
	}
	public static String GetText(String Object) throws Exception
	{
		OR = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\config\\OR.properties");
		OR.load(fs);
		try
		{		
		 driver.findElement(By.xpath(OR.getProperty(Object))).getText();
		 String a=driver.findElement(By.xpath(OR.getProperty(Object))).getText();
		 System.out.println(a);
		}
		catch(Throwable t)
		{		
	    	System.out.println(t.getMessage());
		}
		return "Pass";
	}
	public static String Clear(String Object) throws Exception
	{
		OR = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\config\\OR.properties");
		OR.load(fs);
		try
		{		
		 driver.findElement(By.xpath(OR.getProperty(Object))).clear();
		 String a=driver.findElement(By.xpath(OR.getProperty(Object))).getText();
		 System.out.println(a);
		}
		catch(Throwable t)
		{		
	    	System.out.println(t.getMessage());
		}
		return "Pass";
	}
	public static void ClickLink(String object,String name) throws Exception
	{	
		//APPICATION_LOGS.debug("Executing Navigate");
		OR = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\config\\OR.properties");
		OR.load(fs);
		// app text prop load
		
		try
		{
		driver.findElement(By.xpath(OR.getProperty(object))).click();
		}
		catch(Throwable t)
		{
			//count = count + 1;
			File screenshotfailure=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	FileUtils.copyFile(screenshotfailure, new File(CONFIG.getProperty("Screenshot") +"\\" +name + ".png"));
	    	System.out.println(t.getMessage());
		}
	}
	
	public static void SwitchWindow(String name) throws IOException
	{
	
		System.out.println("SwitchWindow Started");
		try
		{
		  Set<String> win=driver.getWindowHandles();
		  System.out.println(win.size());
		  Iterator<String> it=win.iterator();
		  String parentwin=it.next();
		  String childwin=it.next();
		  driver.switchTo().window(parentwin);
		  driver.switchTo().defaultContent();
		}
		catch(Throwable t)
		{
			File screenshotfailure=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	FileUtils.copyFile(screenshotfailure, new File(CONFIG.getProperty("Screenshot") +"\\" +name + ".png"));
//			File screenshotfailure=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//	    	FileUtils.copyFile(screenshotfailure, new File(CONFIG.getProperty("Screenshot")));
	    	System.out.println(t.getMessage());
			// report error
//			APPICATION_LOGS.debug("Error while executing SwitchWindow -" + t.getMessage());
			APPICATION_LOGS.info("Error while executing SwitchWindow -" + t.getMessage());
		}				  
	}
	
	public static void WindowHandle(String name) throws IOException
	{
	
		try
		{
			for(String WinHandle:driver.getWindowHandles())
			{
				driver.switchTo().window(WinHandle);
			}
		}
		catch(Throwable t)
		{
			File screenshotfailure=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	FileUtils.copyFile(screenshotfailure, new File(CONFIG.getProperty("Screenshot") +"\\" +name + ".png"));
//			File screenshotfailure=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//	    	FileUtils.copyFile(screenshotfailure, new File(CONFIG.getProperty("Screenshot")));
	    	System.out.println(t.getMessage());// report error
			APPICATION_LOGS.info("Error while executing SwitchWindow -" + t.getMessage());
//			return "Fail - Couldnt WindowHandle";
		}
		
		  
	}

	public static void FrameHandle(String object,String name) throws IOException
	{		
		OR = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\config\\OR.properties");
		OR.load(fs);		
		try
		{
			WebElement wb=driver.findElement(By.xpath(OR.getProperty(object)));
			driver.switchTo().frame(wb);
		}
		catch(Throwable t)
		{
			File screenshotfailure=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	FileUtils.copyFile(screenshotfailure, new File(CONFIG.getProperty("Screenshot") +"\\" +name + ".png"));
			// report error
			APPICATION_LOGS.info("Error while executing FrameHandle -"+ t.getMessage());					
		}		 
	}
public static void Login()throws Exception
{
	driver.findElement(By.xpath(OR.getProperty("EmialID_TextField"))).sendKeys(d.getCellData("Login", "Username", 7));
	driver.findElement(By.xpath(OR.getProperty("Password_TextField"))).sendKeys(d.getCellData("Login", "Password", 7));
	Keywords.ClickLink("Login_btn", "Login_btn");
	Keywords.waitr("YapmoLogo_Login");
	if(driver.getTitle().equalsIgnoreCase("Qualitree"))
	{
		System.out.println("Launched");		
	}
}
public static void OtherMemberLogin()throws Exception
{
	driver.findElement(By.xpath(OR.getProperty("EmialID_TextField"))).sendKeys(d.getCellData("Notification", "Username", 2));
	driver.findElement(By.xpath(OR.getProperty("Password_TextField"))).sendKeys(d.getCellData("Notification", "Password", 2));
	Keywords.ClickLink("Login_btn", "Login_btn");
	Keywords.waitr("YapmoLogo_Login");
	if(driver.getTitle().equalsIgnoreCase("Qualitree"))
	{
		System.out.println("Launched");		
	}
}
	public static String linkpresent(String object,String name)throws Exception
	{
		OR = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\config\\OR.properties");
		OR.load(fs);
		// app text prop load
		try
		{
			if(driver.findElements(By.xpath(OR.getProperty(object))).size()!=0)
			{
				System.out.println("True");
			}
			else
			{
				System.out.println("False");
			}			
		}
		catch(Exception e)
	    {
			File screenshotfailure=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	FileUtils.copyFile(screenshotfailure, new File(CONFIG.getProperty("Screenshot") +"\\" +name + ".png"));
	    	System.out.println(e.getMessage());
	    }
		return "true";
	}
	public static void Screenshot(String name) throws IOException
	{
		File screenshotfailure=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(screenshotfailure, new File(CONFIG.getProperty("Screenshot") +"\\" +name + ".png"));
    	
	}
	public static void Select(String object,String name) throws IOException
	{
		String a=APPTEXT.getProperty(name);
		int a1=Integer.parseInt(a);
		new Select(driver.findElement(By.xpath(OR.getProperty(object)))).selectByIndex(a1);
	}
	public static void SelectByValue(String object,String name) throws IOException
	   {
	  new Select(driver.findElement(By.xpath(OR.getProperty(object)))).selectByVisibleText(APPTEXT.getProperty(name));
	   }
	public static String verifyText(String object,String name) throws IOException
	{
		CONFIG = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\config\\config.properties");
		CONFIG.load(fs);
		OR = new Properties();
		fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\config\\OR.properties");
		OR.load(fs);
		// app text prop load
		APPTEXT = new Properties();
		fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\config\\app_text.properties");
		APPTEXT.load(fs);
		String RegisterActual=driver.findElement(By.xpath(OR.getProperty(object))).getText();
	    String RegisterExpected=APPTEXT.getProperty(object);
	    try
	    {
	    Assert.assertEquals(RegisterActual.trim() , RegisterExpected.trim());
	    
	    }
	    catch(Exception e)
	    {
	    	File screenshotfailure=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	FileUtils.copyFile(screenshotfailure, new File(CONFIG.getProperty("Screenshot") +"\\" +name + ".png"));
	    	System.out.println(e.getMessage());
	    }
	    return "Pass";
	}
	
	public static String PngExt(String name)throws Exception
	{
		try
		{
		Robot r=new Robot();
		Thread.sleep(2000); 
		r.keyPress(KeyEvent.VK_ENTER); // confirm by pressing Enter in the start
		r.keyRelease(KeyEvent.VK_ENTER); 
		Thread.sleep(2000); 		    
		r.keyPress(KeyEvent.VK_P); // picture Name
		r.keyRelease(KeyEvent.VK_P); 
		r.keyPress(KeyEvent.VK_R); // picture Name
		r.keyRelease(KeyEvent.VK_R);
	    r.keyPress(KeyEvent.VK_PERIOD); // Period means .(dot)
	    r.keyRelease(KeyEvent.VK_PERIOD); 
	    r.keyPress(KeyEvent.VK_P); // only J from JPG
	    r.keyRelease(KeyEvent.VK_P); 
	    r.keyPress(KeyEvent.VK_N); // only P from JPG
	    r.keyRelease(KeyEvent.VK_N); 
	    r.keyPress(KeyEvent.VK_G);  //only G from JPG
	    r.keyRelease(KeyEvent.VK_G); 
	    Thread.sleep(3000); 
	    r.keyPress(KeyEvent.VK_ENTER); // confirm by pressing Enter in the start
		r.keyRelease(KeyEvent.VK_ENTER);
		}
		catch(Exception e)
	    {
	    	File screenshotfailure=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	FileUtils.copyFile(screenshotfailure, new File(CONFIG.getProperty("Screenshot") +"\\" +name + ".png"));
	    	System.out.println(e.getMessage());
	    }
		return "Pass";
	}
		public static String JpegExt(String name)throws Exception
		{
			try
			{
			Robot r=new Robot();
			Thread.sleep(2000); 
			r.keyPress(KeyEvent.VK_ENTER); // confirm by pressing Enter in start
			r.keyRelease(KeyEvent.VK_ENTER); 
			Thread.sleep(2000); 		    
			r.keyPress(KeyEvent.VK_P); // picture Name
			r.keyRelease(KeyEvent.VK_P); 
			r.keyPress(KeyEvent.VK_R); // picture Name
			r.keyRelease(KeyEvent.VK_R);
		    r.keyPress(KeyEvent.VK_PERIOD); // Period means .(dot)
		    r.keyRelease(KeyEvent.VK_PERIOD); 
		    r.keyPress(KeyEvent.VK_J); // only J from JPG
		    r.keyRelease(KeyEvent.VK_J); 
		    r.keyPress(KeyEvent.VK_P); // only P from JPG
		    r.keyRelease(KeyEvent.VK_P); 
		    r.keyPress(KeyEvent.VK_E);  //only G from JPG
		    r.keyRelease(KeyEvent.VK_E); 
		    r.keyPress(KeyEvent.VK_G);  //only G from JPG
		    r.keyRelease(KeyEvent.VK_G); 
		    Thread.sleep(2000);
		    r.keyPress(KeyEvent.VK_ENTER); // confirm by pressing Enter in start
			r.keyRelease(KeyEvent.VK_ENTER);
			}
			catch(Exception e)
		    {
		    	File screenshotfailure=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    	FileUtils.copyFile(screenshotfailure, new File(CONFIG.getProperty("Screenshot") +"\\" +name + ".png"));
		    	System.out.println(e.getMessage());
		    }
		return "Pass";
	}
//		public static String SendKeys(String name,String Object) throws Exception
//		{
//			try
//			{
//				driver.findElement(By.xpath(OR.getProperty(Object))).sendKeys()
//			}
//			catch(Exception e)
//		    {
//		    	File screenshotfailure=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		    	FileUtils.copyFile(screenshotfailure, new File(CONFIG.getProperty("Screenshot") +"\\" +name + ".png"));
//		    	System.out.println(e.getMessage());
//		    }
//			return "Pass";
//		}
		public static String GifExt(String name)throws Exception
		{
			try
			{
			Robot r=new Robot();
			Thread.sleep(2000); 
			r.keyPress(KeyEvent.VK_ENTER); // confirm by pressing Enter in start
			r.keyRelease(KeyEvent.VK_ENTER); 
			Thread.sleep(2000); 		    
			r.keyPress(KeyEvent.VK_P); // picture Name
			r.keyRelease(KeyEvent.VK_P); 
			r.keyPress(KeyEvent.VK_R); // picture Name
			r.keyRelease(KeyEvent.VK_R);
		    r.keyPress(KeyEvent.VK_PERIOD); // Period means .(dot)
		    r.keyRelease(KeyEvent.VK_PERIOD); 
		    r.keyPress(KeyEvent.VK_G); // only J from JPG
		    r.keyRelease(KeyEvent.VK_G); 
		    r.keyPress(KeyEvent.VK_I); // only P from JPG
		    r.keyRelease(KeyEvent.VK_I); 
		    r.keyPress(KeyEvent.VK_F);  //only G from JPG
		    r.keyRelease(KeyEvent.VK_F); 
		    Thread.sleep(2000);
		    r.keyPress(KeyEvent.VK_ENTER); // confirm by pressing Enter in start
			r.keyRelease(KeyEvent.VK_ENTER);
			}
			catch(Exception e)
		    {
		    	File screenshotfailure=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    	FileUtils.copyFile(screenshotfailure, new File(CONFIG.getProperty("Screenshot") +"\\" +name + ".png"));
		    	System.out.println(e.getMessage());
		    }
			return "Pass";
		}
		public static String File(String name)throws Exception
		{
			try
			{
			Robot r=new Robot();
			Thread.sleep(2000); 
			r.keyPress(KeyEvent.VK_ENTER); // confirm by pressing Enter in start
			r.keyRelease(KeyEvent.VK_ENTER); 
			Thread.sleep(2000); 		    
			r.keyPress(KeyEvent.VK_X); // picture Name
			r.keyRelease(KeyEvent.VK_X); 
			r.keyPress(KeyEvent.VK_M); // picture Name
			r.keyRelease(KeyEvent.VK_M);
			r.keyPress(KeyEvent.VK_L); // picture Name
			r.keyRelease(KeyEvent.VK_L);
		    r.keyPress(KeyEvent.VK_PERIOD); // Period means .(dot)
		    r.keyRelease(KeyEvent.VK_PERIOD); 
		    r.keyPress(KeyEvent.VK_X); // only X
		    r.keyRelease(KeyEvent.VK_X); 
		    r.keyPress(KeyEvent.VK_L); // only L
		    r.keyRelease(KeyEvent.VK_L); 
		    r.keyPress(KeyEvent.VK_S);  //only S 
		    r.keyRelease(KeyEvent.VK_S); 
		    r.keyPress(KeyEvent.VK_X);  //only X 
		    r.keyRelease(KeyEvent.VK_X); 
		    Thread.sleep(2000); 
		    r.keyPress(KeyEvent.VK_ENTER); // confirm by pressing Enter in start
			r.keyRelease(KeyEvent.VK_ENTER);
			}
			catch(Exception e)
		    {
		    	File screenshotfailure=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    	FileUtils.copyFile(screenshotfailure, new File(CONFIG.getProperty("Screenshot") +"\\" +name + ".png"));
		    	System.out.println(e.getMessage());
		    }
			return "Pass";
		}
		public static String Video(String name)throws Exception
		{
			try
			{
			Robot r=new Robot();
			Thread.sleep(2000); 
			r.keyPress(KeyEvent.VK_ENTER); // confirm by pressing Enter in start
			r.keyRelease(KeyEvent.VK_ENTER); 
			Thread.sleep(2000); 		    
			r.keyPress(KeyEvent.VK_V); // picture Name
			r.keyRelease(KeyEvent.VK_V); 
		    r.keyPress(KeyEvent.VK_PERIOD); // Period means .(dot)
		    r.keyRelease(KeyEvent.VK_PERIOD); 
		    r.keyPress(KeyEvent.VK_W); // only X
		    r.keyRelease(KeyEvent.VK_W); 
		    r.keyPress(KeyEvent.VK_M); // only L
		    r.keyRelease(KeyEvent.VK_M); 
		    r.keyPress(KeyEvent.VK_V);  //only S 
		    r.keyRelease(KeyEvent.VK_V); 
		    Thread.sleep(2000); 
		    r.keyPress(KeyEvent.VK_ENTER); // confirm by pressing Enter in start
			r.keyRelease(KeyEvent.VK_ENTER);
			}
			catch(Exception e)
		    {
		    	File screenshotfailure=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    	FileUtils.copyFile(screenshotfailure, new File(CONFIG.getProperty("Screenshot") +"\\" +name + ".png"));
		    	System.out.println(e.getMessage());
		    }
			return "Pass";
		}
		public static String Checkboxstatus(String Object,String name)throws Exception
		{
			try
			{
			String a=driver.findElement(By.id(OR.getProperty(Object))).getAttribute("value");
			System.out.println("CheckboxStatus="+a);
			if(a.equalsIgnoreCase("�n"))
			{
				return "on";
			}
			else
			{
				return "off";
			}
			}
			catch(Exception e)
		    {
		    	File screenshotfailure=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    	FileUtils.copyFile(screenshotfailure, new File(CONFIG.getProperty("Screenshot") +"\\" +name + ".png"));
		    	System.out.println(e.getMessage());
		    }
			return "pass";
		}
		
		}
