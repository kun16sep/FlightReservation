/* Author		: Kundan Kumar
 * Date 		: 10 Oct 2019
 * Description	: This is base class used to launch the driver and url based on property file
 */
package com.fr.qa.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fr.qa.utils.TestUtils;

public class Base {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public Base(){
		System.out.println("Calling constructor and loading property file...");
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("D:\\MavenProject\\FlightReservation\\src\\main\\java\\com\\fr\\qa\\config\\config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void initilize() {
		System.out.println("Initilizing property variable and launch the url...");
		String browser=prop.getProperty("browser");
		String url=prop.getProperty("url");
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\MavenProject\\Resources\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.get(url);
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_TIME_OUT, TimeUnit.SECONDS);
	}
}
