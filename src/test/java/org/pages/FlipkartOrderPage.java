package org.pages;

import java.util.List;
import java.util.Set;

import org.baseor.BaseClassOr;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class FlipkartOrderPage extends BaseClassOr{
	
		public FlipkartOrderPage() {
		PageFactory.initElements(driver, this);	
	}
	    @FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
		private WebElement closelogin;
	    
	    @CacheLookup
	    @FindBys({@FindBy(xpath="//input[@type='text']"),@FindBy(xpath="//input[@name='q']")})
		private List<WebElement> textProduct;
		
	    @FindAll({@FindBy(xpath="//butto[@class='L0Z3Pu']"),@FindBy(xpath="//button[@type='submit']")})
		private WebElement searchbtn;
		
	    @FindAll({@FindBy(xpath="//div[text()='APPLE iPhone 12 (Black, 64 GB)']"),@FindBy(xpath="//div[@class='_4rR01T']")})
		private WebElement clickproduct;
	    
	    @FindBys({@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA ihZ75k _3AWRsL']"),@FindBy(xpath="//button[@type='button']")})
		private WebElement clickbuynow;
		
		   
		public WebElement getCloselogin() {
			return closelogin;
		}

		public List<WebElement> getTextProduct() {
			return textProduct;
		}

		public WebElement getSearchbtn() {
			return searchbtn;
		}

		public WebElement getClickproduct() {
			return clickproduct;
		}

		public WebElement getClickbuynow() {
			return clickbuynow;
		}
		
		public void ordering(String productName) {
			btnClick(getCloselogin());
			
			sendKeys(getTextProduct().get(0), productName);
			
			btnClick(getSearchbtn());
			
			btnClick(getClickproduct());
			
			String ParentId = GetWindowId();
			System.out.println(ParentId);
			
			Set<String> AllIds = GetAllWindowId();
			System.out.println(AllIds);
			
			for (String eachId:AllIds){
				if(!ParentId.equals(eachId)) {
					System.out.println(eachId);
					SwitchWindow(eachId);
				}}
			btnClick(getClickbuynow());	

		}
}
