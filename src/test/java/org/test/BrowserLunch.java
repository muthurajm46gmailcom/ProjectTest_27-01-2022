package org.test;

import java.io.File;
import java.io.IOException;

import org.baseor.BaseClassOr;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.pages.LoginPage;

public class BrowserLunch extends BaseClassOr {
	
	public static void main(String[] args) throws IOException {
		
		
		BrowserLaunch("chrome");
		launchUrl("https://www.facebook.com/");
		maximize();
		implicitWait(10);
		
		System.out.println(currentUrl());
		
		
		LoginPage l=new LoginPage();
		
		sendKeys(l.getTextname().get(0), getExcel("Excel", "Muthu", 3, 0));
		
		String txtna = getAttribute(l.getTextname().get(0));
		System.out.println(txtna);
		
		
		sendKeys(l.getTxtPass(), getExcel("Excel", "Muthu", 3, 3));
		String PassVal = getAttribute(l.getTxtPass());
		System.out.println(PassVal);
	
		
		btnClick(l.getClicklogin());
		
		
		
		
	
		
		
	}
	
	

}
