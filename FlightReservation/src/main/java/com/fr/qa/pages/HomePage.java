/* Author		: Kundan Kumar
 * Date 		: 10 Oct 2019
 * Description	: This is Main class used to run the Test
 */
package com.fr.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fr.qa.base.Base;

public class HomePage extends Base{
	//Page factory or ObjectRepository
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[4]/td[2]/div/input")
	WebElement signIn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public static String validateHomePage() {
		return driver.getTitle();
	}
	public void login(String uname,String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		signIn.click();
	}
}
