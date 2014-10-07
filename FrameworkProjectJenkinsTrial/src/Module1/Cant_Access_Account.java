package Module1;

import java.awt.List;
import java.io.File;
import java.io.FileWriter;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Cant_Access_Account extends Keywords
{
	@Test(priority=1,enabled=true)
	public static void TestCantaccessaccount()throws Throwable
	{
	//Xls_Reader d=new Xls_Reader(System.getProperty("user.dir")+"\\src\\Module1\\Yapmo.xlsx");
	File newfile =  new File(System.getProperty("user.dir")+"\\src\\HTML_REPORTS\\Cant_access_Act.htm");
	StringBuilder sb = new StringBuilder();
	sb.append("<html>");
	sb.append("<head>");
	sb.append("</head>");
	sb.append("<body style="+"background-color:LemonChiffon"+">");
	sb.append("<div style='height='240px''>");
	sb.append("<img src='Qualitree.png' align='left' height='60px' wight ='235px' /> ");
	//sb.append("<div align="+ "right"+">");
	sb.append("<img src='yapmo.png'  align='right' height='60px' wight ='235px' /> ");
	sb.append("</div>");
	sb.append("<br />");
	sb.append("<div align="+ "center"+">");
	
	sb.append("<h1>SET PASSWORD</h1>");

	sb.append("</div>");
	sb.append("<div align="+ "center"+">");
	sb.append("<Table border="+"1"+" bordercolor="+"BLACK"+">" );
	sb.append("<th align="+ "center"+">"); 	
	sb.append("<h3>S.No</h3>");
	sb.append("</th>");
	sb.append("<th align="+ "center"+">");    	
	sb.append("<h3>DESCRIPTION</h3>");
	sb.append("</th>");
	sb.append("<th>");
	sb.append("<h3>STATUS</h3>");
	sb.append("</th>");      
	List myList = new List();
	List myList1 = new List();
	
	Keywords.navigate();
	myList.add("Application opened.User is in"+" "+driver.getTitle()+" "+"page");
	myList1.add("Pass");
	String PaswrdReset_Link=driver.findElement(By.xpath(OR.getProperty("PaswrdReset_Link"))).getText();
	System.out.println("PaswrdReset_Link="+PaswrdReset_Link);
	Keywords.ClickLink("PaswrdReset_Link", "PaswrdReset_Link");
	myList.add("'"+PaswrdReset_Link+"' link clicked.");
	myList1.add("Pass");
	String Message=driver.findElement(By.xpath(OR.getProperty("PasswordReset_MessageDisplay"))).getText();
	System.out.println("Message="+Message);
	Keywords.linkpresent("PaswrdReset_Link", "PaswrdReset_Link");
	Keywords.linkpresent("EmailAddress_TextField", "EmailAddress_TextField");
	Keywords.linkpresent("SendPswrd_btn_ResetPswrdPage", "SendPswrd_btn_ResetPswrdPage");
	Keywords.linkpresent("ReturnToLogin_Link", "ReturnToLogin_Link");
	myList.add("User is navigated to password reset page with '"+Message+"' message displayed, 'Email Address' text field, 'Send Password Reset' button and 'Return to Login' link clicked.");
	myList1.add("Pass");
	//Click on Return To Login Link//
//	Keywords.ClickLink("ReturnToLogin_Link", "ReturnToLogin_Link");
//	Thread.sleep(2000);
//	if(driver.findElement(By.xpath(OR.getProperty("SetPassword_Login_Btn"))).isDisplayed())
//	{
//		myList.add("'Return to Login' link clicked.");
//		myList1.add("Pass");
//	}
//	Keywords.ClickLink("PaswrdReset_Link", "PaswrdReset_Link");
//	Thread.sleep(2000);
//	if(driver.findElement(By.xpath(OR.getProperty("PaswrdReset_Link"))).isDisplayed())
//	{
//		myList.add("'Can't access your account?' link clicked.");
//		myList1.add("Pass");
//	}
//	Keywords.Clear("EmailAddress_TextField");
//	driver.findElement(By.xpath(OR.getProperty("EmailAddress_TextField"))).sendKeys(d.getCellData("Login", "EmailAddress", 2));
//	Keywords.ClickLink("SendPswrd_btn_ResetPswrdPage", "SendPswrd_btn_ResetPswrdPage");
//	Thread.sleep(5000);
//	String ErrorMessage=driver.findElement(By.xpath(OR.getProperty("MessageDisplay_HeaderBar"))).getText();
//	System.out.println("ErrorMessage="+ErrorMessage);
//	myList.add("'"+ErrorMessage+"' message is displayed when '"+d.getCellData("Login", "Description_ResetEmailId", 2)+"'.");
//	myList1.add("Pass");
//	Keywords.ClickLink("PaswrdReset_Link", "PaswrdReset_Link");
//	Thread.sleep(2000);	
//	for(int i=3;i<5;i++)
//	{
//		Keywords.Clear("EmailAddress_TextField");
//		driver.findElement(By.xpath(OR.getProperty("EmailAddress_TextField"))).sendKeys(d.getCellData("Login", "EmailAddress", i));
//		Keywords.ClickLink("SendPswrd_btn_ResetPswrdPage", "SendPswrd_btn_ResetPswrdPage");
//		Thread.sleep(5000);
//		String ErrorMessage1=driver.findElement(By.xpath(OR.getProperty("MessageDisplay_HeaderBar"))).getText();
//		System.out.println("ErrorMessage1="+ErrorMessage1);
//		myList.add("'"+ErrorMessage+"' message is displayed when '"+d.getCellData("Login", "Description_ResetEmailId", i)+"'.");
//		myList1.add("Fail");
//		Keywords.ClickLink("PaswrdReset_Link", "PaswrdReset_Link");
//		Thread.sleep(2000);		
//	}
//	Keywords.Clear("EmailAddress_TextField");
//	driver.findElement(By.xpath(OR.getProperty("EmailAddress_TextField"))).sendKeys(d.getCellData("Login", "EmailAddress", 5));
//	Keywords.ClickLink("SendPswrd_btn_ResetPswrdPage", "SendPswrd_btn_ResetPswrdPage");
//	Thread.sleep(5000);
//	String ErrorMessage2=driver.findElement(By.xpath(OR.getProperty("MessageDisplay_HeaderBar"))).getText();
//	System.out.println("ErrorMessage2="+ErrorMessage2);
//	myList.add("'"+ErrorMessage2+"' message is displayed when '"+d.getCellData("Login", "Description_ResetEmailId", 5)+"'.");
//	myList1.add("Pass");
//	Keywords.ClickLink("PaswrdReset_Link", "PaswrdReset_Link");
//	Thread.sleep(2000);	
	//Positive EmailId//
//	driver.findElement(By.xpath(OR.getProperty("EmailAddress_TextField"))).sendKeys(d.getCellData("Login", "EmailAddress", 6));
//	Keywords.ClickLink("SendPswrd_btn_ResetPswrdPage", "SendPswrd_btn_ResetPswrdPage");
//	Thread.sleep(5000);
//	String ErrorMessage1=driver.findElement(By.xpath(OR.getProperty("CorrectEmailId_Message"))).getText();
//	System.out.println("ErrorMessage1="+ErrorMessage1);
//	myList.add("'"+ErrorMessage1+"' message is displayed when user enters valid EmailId in 'Email Address' text field.");
//	myList1.add("Pass");
//	Thread.sleep(1000);
//	Keywords.ClickLink("CorrectEmailId_ReturnLink", "CorrectEmailId_ReturnLink");
	
	
	int count1=myList.getItemCount();
	System.out.println(count1);
	int p=0;
	int u=0;
	for(int i=0; i<count1;i++)
	{
		u= u+1;
	  sb.append("<tr>");
	  sb.append("<td >");
	  sb.append(u);	  
	  sb.append("</td>");
	  sb.append("<td >");
	  System.out.println(myList.getItem(p));
	  sb.append(myList.getItem(p));
	  
	  sb.append("</td>");
	  if(myList1.getItem(p).toString().equals("Fail"))
	  {		  
	  sb.append("<td style='background-color:Red;'>");
	  }
	  else
	  {
		  sb.append("<td style='background-color:Green;'>");
	  }
	  sb.append(myList1.getItem(p));
	  System.out.println(myList1.getItem(p));
	  sb.append("</td>");
	  sb.append("</tr>");
	  p++;
	}
	sb.append("</Table>");
	sb.append("</div>");
	sb.append("<body>");
	sb.append("</body>");
	sb.append("</html>");
	FileWriter output = null;

	output = new FileWriter(System.getProperty("user.dir")+"\\src\\HTML_REPORTS\\Cant_access_Act.htm");
	output.write(sb.toString());
	output.close();	
	}	
}
