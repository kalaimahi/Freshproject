package Stepdefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Baseclass.Utilityclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class detailpage extends Utilityclass {
	@Given("User have to be in detail page")
	public void user_have_to_be_in_detail_page() {
		driver.findElement(By.xpath("(//a[@class='nav-a  '])[1]")).click();
	    WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("milk");
		driver.findElement(By.id("nav-search-submit-button")).click();
		JavascriptExecutor js= (JavascriptExecutor) driver;
		WebElement down= driver.findElement(By.id("B07HGS47N1-add-to-cart-announce"));
		js.executeScript("arguments[0].scrollIntoView(true)", down);
		driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
		String parentid=driver.getWindowHandle();
		 System.out.println(parentid);
		 Set<String> allwindowid= driver.getWindowHandles();
		 for (String eachid : allwindowid) {
			if (!parentid.equals(eachid)) {
				driver.switchTo().window(eachid);
			}
		}
	}

	@When("User have to add asin to cart from detail page")
	public void user_have_to_add_asin_to_cart_from_detail_page() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement ele= wait.until(ExpectedConditions.presenceOfElementLocated(By.className("a-button-input")));
	    ele.click();
	}

	@Then("Asin should present in cart")
	public void asin_should_present_in_cart() {
	    driver.findElement(By.xpath("//span[@id='nav-cart-count']")).click();
	 WebElement subtotal=   driver.findElement(By.xpath("data-name=\"Subtotals\""));
	    String msg= subtotal.getText();
	    System.out.println(msg);
	    if (msg.contains("1")) {
			System.out.println("1 asin is added to cart");
		}
	    else {
			System.out.println("1 asin is not added to cart");
		}
	    
	}

	@When("VST should present in buybox")
	public void vst_should_present_in_buybox() throws InterruptedException {
	    WebElement vst=driver.findElement(By.xpath("//span[@class='a-size-base a-color-secondary a-text-normal']"));
	    String vstmsg =vst.getText();
	    System.out.println(vstmsg);
	    if (vstmsg.contains("600")) {
	    	System.out.println("VST is correct");
			}
	    else {
			System.out.println("VST is not correct");
		}
	    	}
	

	@Then("VST value should match the expected value")
	public void vst_value_should_match_the_expected_value() {
		WebElement vst=driver.findElement(By.xpath("//span[@class='a-size-base a-color-secondary a-text-normal']"));
	   String message= vst.getText();
	    if (message.contains("600")) {
			System.out.println("VST i correct");
		}
	    else {
			System.out.println("VST is not correct");
		}
	}

	@When("Add three quantities to cart")
	public void add_three_quantities_to_cart() throws AWTException {
		WebElement quantity= driver.findElement(By.xpath("(//button[@class='a-button-text'])[1]"));
		 quantity.click();
		 Robot r = new Robot();
		 for (int i = 0; i < 2; i++) {
			 r.keyPress(KeyEvent.VK_TAB);
			 r.keyRelease(KeyEvent.VK_TAB);
		}
		 r.keyPress(KeyEvent.VK_ENTER);
		 r.keyRelease(KeyEvent.VK_ENTER);
	     WebDriverWait wait = new WebDriverWait(driver, 10);
		 WebElement ele= wait.until(ExpectedConditions.presenceOfElementLocated(By.className("a-button-input")));
		 ele.click();
		
	}

	@Then("Asin should be added to cart")
	public void asin_should_be_added_to_cart() throws InterruptedException {
		driver.findElement(By.xpath("//span[@id='nav-cart-count']")).click();
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   WebElement subtotal= driver.findElement(By.xpath("//span[@id='sc-subtotal-label-buybox']"));
		    String msg= subtotal.getText();
		    System.out.println(msg);
		    if (msg.contains("3")) {
				System.out.println("3 asin is added to cart");
			}
		    else {
				System.out.println("3 asin is not added to cart");
			}
	}
	


}
