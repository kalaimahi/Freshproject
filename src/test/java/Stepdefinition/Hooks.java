package Stepdefinition;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Baseclass.Loginpojo;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Loginpojo {
	@Before
	public void befscenario() {
		chromebrowser();
		maxwindow();
		Launchurl("https://www.amazon.in/");
		driver.findElement(By.xpath("//span[@id=\"nav-link-accountList-nav-line-1\"]")).click();
		Loginpojo l = new Loginpojo();
		WebElement user= l.getTxtusername();
		 filltextbox(user, "kalaivani2396@gmail.com");
		 l.getContinuebutt().click();
		 WebElement pass=l.getTxtpassword();
		 filltextbox(pass, "keerthi5212");
		 l.getSigninbutt().click();
		 String parentid=driver.getWindowHandle();
		 System.out.println(parentid);
		 Set<String> allwindowid= driver.getWindowHandles();
		 for (String eachid : allwindowid) {
			if (!parentid.equals(eachid)) {
				driver.switchTo().window(eachid);
			}
		}
		 
		 

	}
	@After
	public void aftrclass() throws InterruptedException {
		Thread.sleep(5000);
		

	}

}
