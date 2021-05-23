package Stepdefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import Baseclass.Utilityclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class fullcartpage extends Utilityclass	{
	@Given("User have to be in full cart page")
	public void user_have_to_be_in_full_cart_page() throws InterruptedException {
			driver.findElement(By.xpath("(//a[@class='nav-a  '])[1]")).click();
		    WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
			search.sendKeys("milk");
			driver.findElement(By.id("nav-search-submit-button")).click();
			JavascriptExecutor js= (JavascriptExecutor) driver;
			WebElement down= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-micro s-grid-status-badge-container'])[4]"));
			js.executeScript("arguments[0].scrollIntoView(true)", down);
			applywaittimeforalllocat();
			driver.findElement(By.xpath("(//input[@class='a-button-input'])[1]")).click();
		    WebElement up = driver.findElement(By.xpath("//img[@alt='Prime Now']"));
			js.executeScript("arguments[0].scrollIntoView(false)", up);
			driver.findElement(By.xpath("//span[@id='nav-cart-count']")).click();
			driver.findElement(By.xpath("(//img[@class='sc-product-image'])[1]")).click();
			 String parentid=driver.getWindowHandle();
			 System.out.println(parentid);
			 Set<String> allwindowid= driver.getWindowHandles();
			 for (String eachid : allwindowid) {
				if (!parentid.equals(eachid)) {
					driver.switchTo().window(eachid);
				}
			}
	}

	@When("User have to increment the quantity to three in quantity selector")
	public void user_have_to_increment_the_quantity_to_three_in_quantity_selector() throws AWTException {
	   driver.findElement(By.xpath("//button[@aria-label='Current quantity 1. Click to change quantity']")).click();
	   Robot r = new Robot();
	   for (int i = 0; i <=2; i++) {
		   r.keyPress(KeyEvent.VK_TAB);
		   r.keyRelease(KeyEvent.VK_TAB);
			}
	   r.keyPress(KeyEvent.VK_ENTER);
	   r.keyRelease(KeyEvent.VK_ENTER);
	  
	}

	@Then("Cart should be updated to three")
	public void cart_should_be_updated_to_three() {
	   WebElement subtotal = driver.findElement(By.xpath("//div[@data-name='Subtotals']"));
	   String quantity= subtotal.getText();
	   Assert.assertTrue("cart is updated", quantity.contains("4"));
	}

	@When("User have to decrement the quantity to one in full cart page")
	public void user_have_to_decrement_the_quantity_to_one_in_full_cart_page() throws AWTException {
		driver.findElement(By.xpath("//button[@aria-label='Current quantity 5. Click to change quantity']")).click();
		   Robot r = new Robot();
		   for (int i = 0; i <=3; i++) {
			   r.keyPress(KeyEvent.VK_SHIFT);
			   r.keyPress(KeyEvent.VK_TAB);
			   r.keyRelease(KeyEvent.VK_SHIFT);
			   r.keyRelease(KeyEvent.VK_TAB);
				}
		   r.keyPress(KeyEvent.VK_ENTER);
		   r.keyRelease(KeyEvent.VK_ENTER);
		   
	}

	@Then("Cart count should be updated")
	public void cart_count_should_be_updated() {
		WebElement subtotal = driver.findElement(By.xpath("//div[@data-name='Subtotals']"));
		   String quantity= subtotal.getText();
		   Assert.assertTrue("cart is updated", quantity.contains("1"));
	}

	@When("User have to delete the asin")
	public void user_have_to_delete_the_asin() {
	     driver.findElement(By.xpath("//input[@value='Delete']")).click();
	     	}

	@Then("Asin should be deleted from cart")
	public void asin_should_be_deleted_from_cart() {
		WebElement emp= driver.findElement(By.xpath("(//div[@class='a-section'])[2]"));
	     String emptymsg= emp.getText();
	     System.out.println(emptymsg);
	     Assert.assertTrue("cart is empty", emptymsg.contains("currently"));
	}



}
