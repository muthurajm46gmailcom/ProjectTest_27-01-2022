package org.base;

 
import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.awt.Robot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
 public static WebDriver driver;
 public	static Actions ac;
 public static Robot r;
 public static Alert al;
 public	static TakesScreenshot tk;
 public	static Select s;
 public	static JavascriptExecutor js;

	public static void todriver() {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
	}

	
	public static void togeturl(String url) {
		// TODO Auto-generated method stub
		driver.get(url);
	}

	public static void tomaxi() {
		// TODO Auto-generated method stub
		driver.manage().window().maximize();
	}

	public static String toGetTitle() {
		// TODO Auto-generated method stub
		String title = driver.getTitle();
		return title;
	}

	public String toGetCurrentUrl() {
		// TODO Auto-generated method stub
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static void toClick(WebElement click) {
		// TODO Auto-generated method stub
		click.click();
	}

	public static void tosendkeys(WebElement send, String s) {
		// TODO Auto-generated method stub
		send.sendKeys(s);

	}

	public static void toNavigateback() {
		// TODO Auto-generated method stub
		driver.navigate().back();
	}

	public static void toNavigateForward() {
		// TODO Auto-generated method stub
		driver.navigate().forward();
	}

	public static void Tosleep(long a) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(a);
	}

	public static void toMovetoElements(WebElement target) {
		// TODO Auto-generated method stub
		ac = new Actions(driver);
		ac.moveToElement(target).perform();
		;
	}

	public static void toDragAndDrop(WebElement source, WebElement target) {
		// TODO Auto-generated method stub
		ac = new Actions(driver);
		ac.dragAndDrop(source, target).perform();
		;
	}

	public static void toDoubleClick(WebElement target) {
		// TODO Auto-generated method stub
		ac = new Actions(driver);
		ac.doubleClick(target).perform();
		;
	}

	public static void toRightClick(WebElement target) {
		// TODO Auto-generated method stub
		ac = new Actions(driver);
		ac.contextClick(target).perform();
		;
	}

	public static void toBuild() {
		// TODO Auto-generated method stub
		ac = new Actions(driver);
		ac.build();
	}

	public static void toKeyPressShift() throws AWTException {
		// TODO Auto-generated method stub
		r = new Robot();
		r.keyPress(KeyEvent.VK_SHIFT);
	}

	public static void tokeyReleaseShift() throws AWTException {
		// TODO Auto-generated method stub
		r = new Robot();
		r.keyRelease(KeyEvent.VK_SHIFT);
	}

	public static void toKeyPressEnter() throws AWTException {
		// TODO Auto-generated method stub
		r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);

	}

	public static void toKeyReleaseEnter() throws AWTException {
		// TODO Auto-generated method stub
		r = new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void toAlert() {
		// TODO Auto-generated method stub
		al = driver.switchTo().alert();
	}

	public static void toAccept() {
		// TODO Auto-generated method stub
		al.accept();
	}

	public static void toDismiss() {
		// TODO Auto-generated method stub
		al.dismiss();
	}

	public static void toTakeScreenShot() {
		// TODO Auto-generated method stub
		tk = (TakesScreenshot) driver;
		tk.getScreenshotAs(OutputType.FILE);
	}

	public static void toCopyfile(File srcFile, File destFile) throws IOException {
		// TODO Auto-generated method stub
		FileUtils.copyFile(srcFile, destFile);

	}

	public static void toImplictWait() {
		// TODO Auto-generated method stub
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public static void toClose() {
		// TODO Auto-generated method stub
		driver.close();
	}

	public static void visibilityEnable(WebElement check) {
		// TODO Auto-generated method stub
		check.isEnabled();
	}

	public static void visibilityDisplayed(WebElement check) {
		// TODO Auto-generated method stub
		check.isDisplayed();
	}

	public static void visibilitySelected(WebElement check) {
		// TODO Auto-generated method stub
		check.isSelected();
	}

	public static void urlNavigation(String url) {
		// TODO Auto-generated method stub
		driver.navigate().to(url);
	}

	public static void toRefresh() {
		// TODO Auto-generated method stub
		driver.navigate().refresh();
	}

	public static void toSwitchToFrame(WebElement ele) {
		// TODO Auto-generated method stub
		driver.switchTo().frame(ele);
	}

	public static void toSelectByValue(WebElement element, String str) {
		// TODO Auto-generated method stub
		s = new Select(element);
		s.selectByValue(str);
	}

	public static void toSelectByText(WebElement element, String str) {
		// TODO Auto-generated method stub
		s = new Select(element);
		s.selectByVisibleText(str);
	}

	public static void toSelectbyindex(WebElement element, int a) {
		// TODO Auto-generated method stub
		s = new Select(element);
		s.selectByIndex(a);
	}

	public static void toCheckMultiple(WebElement element) {
		// TODO Auto-generated method stub
		s = new Select(element);
		s.isMultiple();
	}

	public static void toGetOptions(WebElement elements) {
		// TODO Auto-generated method stub
		s = new Select(elements);
		s.getOptions();

	}

	public static void toGetAllSelectedOptions(WebElement element) {
		// TODO Auto-generated method stub
		s = new Select(element);
		s.getAllSelectedOptions();
	}

	public static void toGetFirstSelectedOption(WebElement element) {
		// TODO Auto-generated method stub
		s = new Select(element);
		s.getFirstSelectedOption();

	}

	public static void toGetDeselectByIndex(WebElement element, int index) {
		// TODO Auto-generated method stub
		s = new Select(element);
		s.deselectByIndex(index);
	}

	public static void toGetDeselectByValue(WebElement element, String str) {
		// TODO Auto-generated method stub
		s = new Select(element);
		s.deselectByValue(str);
	}

	public static void toGetDeselectByText(WebElement element, String str) {
		// TODO Auto-generated method stub
		s = new Select(element);
		s.deselectByVisibleText(str);
	}

	public static void toDeselectAll(WebElement element) {
		// TODO Auto-generated method stub
		s = new Select(element);
		s.deselectAll();
	}

	public static void toSwitchToFrameByIndex(int i) {
		// TODO Auto-generated method stub
		driver.switchTo().frame(i);
	}

	public static void toSwitchToFramebyStrinId(String str) {
		// TODO Auto-generated method stub
		driver.switchTo().frame(str);
	}

	public static void toSwitchToFrameByWebelements(WebElement elements) {
		// TODO Auto-generated method stub
		driver.switchTo().frame(elements);
	}

	public static void toScrollDown(WebElement element) {
		// TODO Auto-generated method stub
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].ScrollIntoView(true)", element);
	}

	public static void toScrollup(WebElement element) {
		// TODO Auto-generated method stub
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].ScrollIntoView(false)", element);
	}

	public static void ToClickByJavascript(WebElement click) {
		// TODO Auto-generated method stub
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", click);
	}

	public static void toSwitchWindow(String str) {
		// TODO Auto-generated method stub
		driver.switchTo().window(str);
	}

	public static void toGetWindowId() {
		// TODO Auto-generated method st
		driver.getWindowHandle();
	}

	public static void toGetAllWindowId() {
		// TODO Auto-generated method stub
		driver.getWindowHandles();
	}
}