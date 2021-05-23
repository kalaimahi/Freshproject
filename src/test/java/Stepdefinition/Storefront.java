package Stepdefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Baseclass.Utilityclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Storefront extends Utilityclass {
	@Given("User have to be in amazon homepage")
	public void user_have_to_be_in_amazon_homepage() {
	   String url= driver.getCurrentUrl();
	   if (url.contains("nav_logo")) {
		System.out.println("User is in homepage");
	}
	   else {
		System.out.println("User is not in homepage");
	}
	}

	@When("User have to click amazonfresh and navigate to fresh storefront")
	public void user_have_to_click_amazonfresh_and_navigate_to_fresh_storefront() throws AWTException {
		driver.findElement(By.id("searchDropdownBox")).click();
		Robot r = new Robot();
		for (int i = 0; i <5; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("apple");
		driver.findElement(By.id("nav-search-submit-button")).click();
   
	}

	@When("Verify that asins present in storefront is fresh asins")
	public void verify_that_asins_present_in_storefront_is_fresh_asins() throws InterruptedException {
		
	    WebElement store = driver.findElement(By.xpath("//img[@class='nav-categ-image']"));
	    store.click();
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebElement down = driver.findElement( By.xpath("(//i[@class='a-icon a-icon-next'])[1]"));
	    js.executeScript("arguments[0].scrollIntoView(true)", down);
	    WebElement up = driver.findElement(By.xpath("//img[@alt='Prime Now']"));
	    js.executeScript("arguments[0].scrollIntoView(false)", up);
	}

	@Then("User should be in fresh storefront")
	public void user_should_be_in_fresh_storefront() {
	    String url= driver.getCurrentUrl();
	    if (url.contains("storefront")) {
			System.out.println("User is in fresh storefront");
		}
	    else {
			System.out.println("User is not in fresh storefront");
		}
	}


}
