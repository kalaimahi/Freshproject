package Baseclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpojo extends Utilityclass{
	public Loginpojo() {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="ap_email")
	private WebElement txtusername;
	@FindBy(id="continue")
	private WebElement continuebutt;
	@FindBy(id="ap_password")
	private WebElement txtpassword;
	@FindBy(id="signInSubmit")
	private WebElement signinbutt;
	@FindBy(id="createAccountSubmit")
	private WebElement createacc;
	public WebElement getTxtusername() {
		return txtusername;
	}
	public WebElement getContinuebutt() {
		return continuebutt;
	}
	public WebElement getTxtpassword() {
		return txtpassword;
	}
	public WebElement getSigninbutt() {
		return signinbutt;
	}
	public WebElement getCreateacc() {
		return createacc;
	}
}
