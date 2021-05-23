package Baseclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utilityclass {
public static WebDriver driver;
	
	public static void chromebrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}
	public static void Launchurl(String url) {
		driver.get(url);

	}
	public static void maxwindow() {
		driver.manage().window().maximize();

	}
	public static void pagetitle() {
		String titlename =driver.getTitle();
		System.out.println(titlename);

	}
	public static void closebrowser() {
		driver.quit();

	}
public static void fetchurl() {
	String url =driver.getCurrentUrl();
	System.out.println(url);

}
public static void filltextbox(WebElement element,String value) {
	element.sendKeys(value);
	}
	
public static void btnclick(WebElement element) {
	element.click();
}
public static void applywaittimeforalllocat() {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

}










}
