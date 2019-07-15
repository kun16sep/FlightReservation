/* Author		: Kundan Kumar
 * Date 		: 10 Oct 2019
 * Description	: This is Main class used to run the Test
 */
package com.fr.qa.test;
import com.fr.qa.base.Base;
import com.fr.qa.pages.HomePage;
public class Main extends Base{	
	Main(){
		super();
	}
	public static void main(String[] args) {
		Main m=new Main();
		Base.initilize();
		String expectedTitle="Welcome: Mercury Tours";
		String actualTitle=HomePage.validateHomePage();
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("url launched successfully - "+actualTitle);
		}else {
			System.out.println("There is problem in launching url...");
		}
		driver.quit();
	}

}
