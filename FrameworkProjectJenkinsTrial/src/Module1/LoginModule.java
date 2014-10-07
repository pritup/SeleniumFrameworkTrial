package Module1;

import java.io.File;
import java.io.IOException;
import java.awt.List;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.opera.core.systems.scope.protos.UmsProtos.Status;
public class LoginModule extends Keywords
{
@Test
public static void LoginTestCase() throws Throwable
{
	Xls_Reader d=new Xls_Reader(System.getProperty("user.dir")+"\\src\\Module1\\Yapmo.xlsx");
	//Xls_Reader d=new Xls_Reader("C:\\Users\\freightmail\\Desktop\\Yapmo.xlsx");
	File newfile =  new File(System.getProperty("user.dir")+"\\src\\HTML_REPORTS\\Login.htm");
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
	
	sb.append("<h1>LOGIN MODULE</h1>");

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
	
	//Keywords.navigate();
	myList.add("Application opened.User is in"+" "+driver.getTitle()+" "+"page");
	myList1.add("Pass");
	//Negative Link
	try
	{
	linkpresent("Yapmo_Logo", "YapmoLogo");
	linkpresent("EmialID_TextField", "EmialID_TextField");
	linkpresent("Password_TextField", "Password_TextField");
	linkpresent("Login_btn", "Login_btn");
	linkpresent("Password_ResetLink", "Password_ResetLink");
	myList.add("Yapmo_Logo,EmialID_TextField,Password_TextField,Login_btn and Password_ResetLink links are present on the"+" "+driver.getTitle()+" "+"page.");
	myList1.add("Pass");
	}
	catch(Exception e)
	{
		myList.add("Yapmo_Logo,EmialID_TextField,Password_TextField,Login_btn and Password_ResetLink links are not present on the"+" "+driver.getTitle()+" "+"page.");
		myList1.add("Fail");
	}
	//Positive Login
	for(int i=2;i<7;i++)
	{
		Thread.sleep(2000);
		Clear("EmialID_TextField");
		driver.findElement(By.xpath(OR.getProperty("EmialID_TextField"))).sendKeys(d.getCellData("Login", "Username", i));
		Clear("Password_TextField");
		driver.findElement(By.xpath(OR.getProperty("Password_TextField"))).sendKeys(d.getCellData("Login", "Password", i));
		ClickLink("Login_btn", "Login_btn");
		Thread.sleep(3000);
		System.out.println(Keywords.GetText("ErrorMessage"));
		String ErrorMessage_Display=driver.findElement(By.xpath(OR.getProperty("ErrorMessage"))).getText();
	
			myList.add(ErrorMessage_Display+" "+"error message is displayed.");
			myList1.add("Pass");	
	}
		//*Positive Login*//
//		Clear("EmialID_TextField");
//		Clear("Password_TextField");
//		driver.findElement(By.xpath(OR.getProperty("EmialID_TextField"))).sendKeys(d.getCellData("Login", "Username", 7));
//		driver.findElement(By.xpath(OR.getProperty("Password_TextField"))).sendKeys(d.getCellData("Login", "Password", 7));
//		ClickLink("Login_btn", "Login_btn");
//		waitr("YapmoLogo_Login");
//		if(driver.getTitle().equalsIgnoreCase("Qualitree"))
//		{
//			System.out.println("def");
//			myList.add("User is logged into the Yapmo application.");
//			myList1.add("Pass");
//		}
//		linkpresent("YapmoLogo_Login", "YapmoLogo_Login");
//		verifyText("WelcomeText", "WelcomeText");
//		verifyText("Welcum_msg", "Welcum_msg");
//		verifyText("MakePost_home_btn", "MakePost_home_btn");
//		verifyText("JoinLoop_home_btn", "JoinLoop_home_btn");
//		verifyText("CreateLoop_home_btn", "CreateLoop_home_btn");
//		verifyText("MyTasks_home_Link", "MyTasks_home_Link");
//		verifyText("RecentlyUsedHashtag_Home_Link", "RecentlyUsedHashtag_Home_Link");
//		linkpresent("NotificationIcon", "NotificationIcon");
//		verifyText("UserName", "UserName");
//		linkpresent("UserProfileImage", "UserProfileImage");
//		verifyText("Create_Link", "Create_Link");
//		linkpresent("SearchIcon", "SearchIcon");
//		if(linkpresent("YapmoLogo_Login", "YapmoLogo_Login").equals("true") && Keywords.linkpresent("NotificationIcon", "NotificationIcon").equals("true")&& Keywords.linkpresent("UserProfileImage", "UserProfileImage").equals("true")&& Keywords.linkpresent("SearchIcon", "SearchIcon").equals("true"))
//		{
//			myList.add("Homescreen of the application is displayed which contains Yapmo Logo"+" "+APPTEXT.getProperty("UserName")+","+APPTEXT.getProperty("WelcomeText")+" "+APPTEXT.getProperty("WelcomeText")+","+APPTEXT.getProperty("MakePost_home_btn")+","+APPTEXT.getProperty("JoinLoop_home_btn")+" "+"and"+" "+APPTEXT.getProperty("CreateLoop_home_btn")+" "+"buttons."+" "+APPTEXT.getProperty("MyTasks_home_Link")+" "+"and"+" "+APPTEXT.getProperty("RecentlyUsedHashtag_Home_Link")+" "+"Links."+" "+APPTEXT.getProperty("Create_Link")+",Search Icon and Notification Icon.");
//			myList1.add("Pass");
//		}
//		else
//		{
//			myList.add("Few icons missing from the homepage.");
//			myList1.add("Pass");
//		}
//		
//		MouseOver("QualitreeIcon", "QualitreeIcon");
//		Thread.sleep(2000);
//		linkpresent("Home_SideBar_Link", "Home_SideBar_Link");
//		verifyText("Featured_SideBar_Link", "Featured_SideBar_Link");
//		verifyText("LoopsManager_SideBar_Link", "LoopsManager_SideBar_Link");
//		verifyText("PinnedLoop_SideBar_Link", "PinnedLoop_SideBar_Link");	
//		ScrollDown("ScrollDown SideMenuBar");
//		verifyText("Bookmarks_SideBar_Link", "Bookmarks_SideBar_Link");
//		linkpresent("Subscription_SideBar_Link", "Subscription_SideBar_Link");
//		verifyText("UserSearch_SideBar_Link", "UserSearch_SideBar_Link");		
//		verifyText("Help_SideBar_Link", "Help_SideBar_Link");		
//		verifyText("Logout_SideBar_Link", "Logout_SideBar_Link");		
//		myList.add(APPTEXT.getProperty("Home_SideBar_Link")+","+APPTEXT.getProperty("Featured_SideBar_Link")+","+APPTEXT.getProperty("LoopsManager_SideBar_Link")+","+APPTEXT.getProperty("PinnedLoop_SideBar_Link")+","+APPTEXT.getProperty("Bookmarks_SideBar_Link")+","+APPTEXT.getProperty("Subscription_SideBar_Link")+","+APPTEXT.getProperty("UserSearch_SideBar_Link")+","+APPTEXT.getProperty("Help_SideBar_Link")+" "+"and"+" "+APPTEXT.getProperty("Logout_SideBar_Link")+" Links are pinned on the slide menu bar.");
//		myList1.add("Pass");
//		//ProfileLink//
//		ClickLink("UserName", "UserName");
//		waitr("EditLink_ProfilePage");
//		linkpresent("Contact_ProfilePage", "Contact_ProfilePage");		
//		verifyText("Email_Contact_ProfilePage", "Email_Contact_ProfilePage");		
//		verifyText("Mobile_Contact_ProfilePage", "Mobile_Contact_ProfilePage");		
//		verifyText("WorkPhone_Contact_ProfilePage", "WorkPhone_Contact_ProfilePage");
//		verifyText("Company_Contact_ProfilePage", "Company_Contact_ProfilePage");
////		if(Keywords.verifyText("Contact_ProfilePage", "Contact_ProfilePage").equals("pass"))
////		{
//		myList.add(APPTEXT.getProperty("Email_Contact_ProfilePage")+","+APPTEXT.getProperty("Mobile_Contact_ProfilePage")+","+APPTEXT.getProperty("WorkPhone_Contact_ProfilePage")+" "+"and"+" "+APPTEXT.getProperty("Company_Contact_ProfilePage")+" "+"is displayed under"+" "+APPTEXT.getProperty("Contact_ProfilePage")+" "+"Section of Profile Page.");
//		myList1.add("Pass");
////		}
////		else
////		{
////			myList.add("Contact details are not displayed on profile page");
////			myList1.add("Fail");
////		}
//		int HT_Count=driver.findElements(By.xpath(OR.getProperty("HashtagSubscription_Count_ProfilePage"))).size();
//		System.out.println(HT_Count);
//		myList.add("Hashtags are displayed on the profile page. User is subscribed to"+" "+HT_Count+" "+"Hashtags.");
//		myList1.add("Pass");
//		int MS_Count=driver.findElements(By.xpath(OR.getProperty("MemberSubscription_ProfilePage"))).size();
//		System.out.println("MS_Count="+MS_Count);
//		myList.add("Member Subscription is displayed on the profile page. User is subscribed to"+" "+MS_Count+" "+"Members.");
//		myList1.add("Pass");
//		int LM_Count=driver.findElements(By.xpath(OR.getProperty("LoopsMembership_ProfilePage"))).size();
//		System.out.println("LM_Count="+LM_Count);
//		myList.add("Loop Membership is displayed on the profile page. User is subscribed to"+" "+LM_Count+" "+"Loops.");
//		myList1.add("Pass");
//		//Keywords.linkpresent("EditLink_ProfilePage", "EditLink_ProfilePage");
//		driver.navigate().refresh();
//		Thread.sleep(2000);
//	
//		ClickLink("EditLink_ProfilePage", "EditLink_ProfilePage");
//		waitr("FirstName_Profile");
//		verifyText("Upload_btn", "Upload_btn");
//		verifyText("FirstName_Profile", "FirstName_Profile");
//		verifyText("LastName_Profile", "LastName_Profile");
//		verifyText("Office_Profile", "Office_Profile");
//		verifyText("Title_Profile", "Title_Profile");
//		verifyText("Email_Profile", "Email_Profile");
//		verifyText("Location_Profile", "Location_Profile");
//		verifyText("Bio", "Bio");
//		verifyText("Mobile_Profile", "Mobile_Profile");
//		verifyText("Cmpny_Profile", "Cmpny_Profile");
//		verifyText("Publish_btn_Profile", "Publish_btn_Profile");
//		myList.add(APPTEXT.getProperty("Upload_btn")+","+APPTEXT.getProperty("FirstName_Profile")+","+APPTEXT.getProperty("LastName_Profile")+","+APPTEXT.getProperty("Office_Profile")+","+APPTEXT.getProperty("Title_Profile")+","+APPTEXT.getProperty("Email_Profile")+","+APPTEXT.getProperty("Location_Profile")+","+APPTEXT.getProperty("Bio")+","+APPTEXT.getProperty("Mobile_Profile")+","+APPTEXT.getProperty("Cmpny_Profile")+" "+"and"+" "+APPTEXT.getProperty("Publish_btn_Profile")+"is displayed when user clicks on Profile Edit Link.");
//		myList1.add("Pass");
//		ClickLink("Upload_btn", "Upload_btn");
//		myList.add("Upload button clicked.");
//		myList1.add("Pass");
//		Thread.sleep(2000);
//		PngExt("UploadImage_Png");
//		Thread.sleep(3000);
//		ClickLink("Publish_btn_Profile", "Publish_btn_Profile");
//		myList.add("Image Loading...");
//		myList1.add("Pass");
//		driver.navigate().refresh();
//		Thread.sleep(2000);
//		ClickLink("EditLink_ProfilePage", "EditLink_ProfilePage_AfterUploadImage");
//		Thread.sleep(3000);
//		linkpresent("ProfileImage", "ProfileImage");	
//		myList.add("Image Uploaded");
//		myList1.add("Pass");
//		Keywords.ClickLink("ProfileSideBarClose", "ProfileSideBarClose");
//		myList.add("Edit Profile Side Bar is closed.");
//		myList1.add("Pass");
				
		
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

		output = new FileWriter(System.getProperty("user.dir")+"\\src\\HTML_REPORTS\\Login.htm");
		output.write(sb.toString());
		output.close();
		
}

}

