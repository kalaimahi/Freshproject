package Stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Baseclass.Utilityclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchatc extends Utilityclass {
	@Given("User have to search an item and in search result page")
	public void user_have_to_search_an_item_and_in_search_result_page() {
	    driver.findElement(By.xpath("(//a[@class='nav-a  '])[1]")).click();
	    WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("apple");
		driver.findElement(By.id("nav-search-submit-button")).click();
	}

	@When("User have to add an item to cart")
	public void user_have_to_add_an_item_to_cart() {
		WebDriverWait wait= new WebDriverWait(driver,120);
		WebElement ele= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@class='a-button-input'])[1]")));
	    ele.click();
	    	
	    	}

	@Then("Cart should be updated and its count should be one")
	public void cart_should_be_updated_and_its_count_should_be_one() {
		WebElement cartcount=driver.findElement(By.id("nav-cart-count"));
		String cartvalue=cartcount.getAttribute("class");
		System.out.println(cartvalue);
		if (cartvalue.contains("1")) {
			System.out.println("Asin is added and cart is updated");
		}
		else {
			System.out.println("Asin is not added");
		}
			    
	}

}
