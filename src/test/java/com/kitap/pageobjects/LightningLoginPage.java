package com.kitap.pageobjects;

import java.util.List;
  

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.BinaryDecoder;

public class LightningLoginPage extends kitap.SFPageBase {

	@FindBy(name = "username")
	private WebElement uname;

	@FindBy(name = "pw")
	
	private WebElement password;

	@FindBy(id = "Login")
	private WebElement login_button;

	@FindBy(xpath = "")
	private List<WebElement> sessionErrorMessage;

	public LightningLoginPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(driver, this);// Creates instance for all web elements
	}

	/**
	 *
	 * @author KT1456
	 * @date: 15/06/2022
	 * @return the SF Lightning page class instance.
	 * @throws InterruptedException
	 */
	public void login(String userid, String passwordtext) throws InterruptedException {

		Thread.sleep(8000); 
     // waitForSFPagetoLoad();
        
		 String str="Jasper@143";
		uname.sendKeys(userid);
		
		byte[] decodedString = Base64.decodeBase64(passwordtext);
	     // System.out.println("Decoded value is " + new String(decodedString));
	          String value = new String(decodedString);
     	password.sendKeys(value);
     	safeClick(login_button);

		
		  waitForSFPagetoLoad(); try {
		  
		  Alert alert = driver.switchTo().alert(); String alertText = alert.getText();
		  System.out.println("Alert data: " + alertText); alert.accept();
		  
		  } catch (NoAlertPresentException e) {
		  
		  }
		  
		  waitForSFPagetoLoad();
		 
	}
	
	public void applauncher(String appname) throws InterruptedException {
		
			String accountappurl = getURL(appname);
			System.out.println("account URL is" + accountappurl);
			String cleanurl = accountappurl.replace("[\"", "").replace("\"]", "");
			System.out.println("Navigating to App URL as : " + cleanurl);
			openHomepage(cleanurl + "?eptVisible=1");
			waitForSFPagetoLoad();
}


}

	
	

	


