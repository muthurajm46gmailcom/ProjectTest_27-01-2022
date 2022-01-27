package org.test;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.baseor.BaseClassOr;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.pages.FlipkartOrderPage;

public class FlipkartOrderUsingPom extends BaseClassOr {
	
	public static void main(String[] args) throws IOException {
			
		BrowserLaunch("chrome");
		launchUrl("https://www.flipkart.com/");
		maximize();
		implicitWait(10);
		
		System.out.println(currentUrl());
		
		FlipkartOrderPage f=new FlipkartOrderPage();
		
		f.ordering("iphone 12");	
	}	
}
