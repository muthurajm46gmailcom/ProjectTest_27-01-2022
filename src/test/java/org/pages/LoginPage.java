package org.pages;

import java.util.List;

import org.baseor.BaseClassOr;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClassOr {
	
	public LoginPage() {
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy (id="email")
	private List<WebElement> textname;
	
	@FindBy (id="pass")
	private WebElement txtPass;
	
	@FindBy (name="login")
	private WebElement clicklogin;
	
	

	public List<WebElement> getTextname() {
		return textname;
	}

	public WebElement getTxtPass() {
		return txtPass;
	}

	public WebElement getClicklogin() {
		return clicklogin;
	}
	
	public void login(String username, String password ) {
		
		sendKeys(getTextname().get(0), username);
		
		sendKeys(getTxtPass(), password);
		
		btnClick(getClicklogin());
		
	}

	

}
