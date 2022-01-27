package org.baseor;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.invoke.SwitchPoint;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.base.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassOr {
	public static WebDriver driver;
	// Browser Launch	
	// public static WebDriver BrowserLaunch() {
	//	WebDriverManager.chromedriver().setup();
	//   driver=new ChromeDriver();
	//   return driver;
	// }
	
	public static WebDriver BrowserLaunch(String browserName) {
		
	//	if (browserName.equals("chrome")) {
	//	WebDriverManager.chromedriver().setup();	
	//	 driver=new ChromeDriver();
		 
	//	}
	//	else if (browserName.equals("firefox")) {
	//		WebDriverManager.firefoxdriver().setup();	
	//		 driver=new FirefoxDriver();
			
	// }
	// else if (browserName.equals("edge")) {
	//	WebDriverManager.edgedriver().setup();	
	//	 driver=new EdgeDriver();
	//}
	//return driver;
		
		
		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();	
			 driver=new ChromeDriver();
			 break;	 
			 
		case "firefox":
			WebDriverManager.firefoxdriver().setup();	
			 driver=new ChromeDriver();
			 break;
			 
		case "edge":
			WebDriverManager.edgedriver().setup();	
			 driver=new EdgeDriver();
			
			break;

		default:
			break;
		}
		return driver;
	}
	// url launch
	public static void launchUrl(String url) {
		
		driver.get(url);
		}
	//maximize
	
	public static void maximize() {
		driver.manage().window().maximize();
		}
	//Impilicit wait
	
	public static void implicitWait(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		}
	
	// Get Current Url
	
	public static String currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	// Title
	
	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	//Click
	public static void btnClick(WebElement e ) {
		e.click();
	}
	
	//quit
	public static void browserQuit( ) {
		driver.quit();
	}
	
	// Drag and Drop
	
	public static void dragandDrop(WebElement src, WebElement des) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src, des).perform();
	}
	
	// Move to element
	public static void moveToElement(WebElement e) {
		Actions a=new Actions(driver);
		a.moveToElement(e).perform();
		}
	
	//Select by index // -----
	public static void selectByIndex(WebElement e, int index) {
		Select s=new Select(e);
		s.selectByIndex(index);
	}
	// DeSelect by index ///---
	public static void deSelectByIndex(WebElement e, int index ) {
		Select s=new Select(e);
		s.deselectByIndex(index);
	}
	// Get Text
	public static String getText(WebElement e) {
		String text = e.getText();
		return text;
	}
	// getAttribute
	public static String getAttribute(WebElement e) {
		String value = e.getAttribute("value");
		return value;
	}
	// Close
	public static void close() {
		driver.close();
	}
	 //SendKeys
	public static void sendKeys(WebElement e, String name) {
		e.sendKeys(name);
	}
	
	// findElement
	public static WebElement findElement(String locatorName, String locator) {
		WebElement e=null;
		if(locatorName.equals("id")) {
			e=driver.findElement(By.id(locator));
		}
		else if(locatorName.equals("name")) {
				e=driver.findElement(By.name(locator));
			}
		else if(locatorName.equals("xpath")) {
				e=driver.findElement(By.xpath(locator));
			}
		return e;
		}

	//Select by Value // -----
		public static void selectByValue(WebElement e, int value) {
			Select s=new Select(e);
			s.selectByValue("value");
		}
	
	//Select by VisibleText // -----
		public static void selectByVisibleText(WebElement e, String Text) {
			Select s=new Select(e);
			s.selectByVisibleText("Text");
		}
				
	
	// DeSelect by Value ///---
		public static void deSelectByValue(WebElement e, int value ) {
			Select s=new Select(e);
			s.deselectByValue("value");
				}
	
		//deSelect by VisibleText // -----
		public static void deSelectByVisibleText(WebElement e, String Text) {
			Select s=new Select(e);
			s.deselectByVisibleText("Text");
				}
	
	//Sleep
		public static void Tosleep(long e) throws InterruptedException {
			Thread.sleep(e);
		}
		
	//contextClick
		public static void contextClick(WebElement e) {
			
		Actions a= new Actions(driver);
			a.contextClick(e).perform();	
		}
		
	//PressShift
		public static void PressShift() throws AWTException {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_SHIFT);
		}
		
	//ReleaseShift
	public static void ReleaseShift() throws AWTException {
		Robot r = new Robot();
		r.keyRelease(KeyEvent.VK_SHIFT);
		}
	
	//Alert--in doubt
	public static Alert Simple;
	public static void Alert( ) {
		 Alert Simple = driver.switchTo().alert();
	}

	//AcceptAlert
	public static void Accept() {
		Simple.accept();
	}
	
	//DismissAlert
	public static void Dismiss() {
		Simple.dismiss();
	}
	// TakeScreenShot
	public static void TakeScreenShot(String filename)throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File Scr = tk.getScreenshotAs(OutputType.FILE);
		File des =new File("C:\\Users\\Muthu Raj\\eclipse-workspace\\MavenProject\\src\\test\\resources\\Screenshot\\"+filename+".png");
	   FileUtils.copyFile(Scr, des);
	}
	
	
	//Single or Multiple
	public static boolean singleorMultiple(WebElement e) {
		Select s=new Select(e);
			boolean multiple = s.isMultiple();
			return multiple;
	}
	
	public static void SwitchToFrame(WebElement e) {
	driver.switchTo().frame(e);
	}
	
	
	public static int getOptions(WebElement e) {
		Select s=new Select(e);
	List<WebElement> options = s.getOptions();
	int dropdownsize = options.size();
	return dropdownsize;
	}
	
	public static void SwitchToFrameByIndex(int i) {
		
		driver.switchTo().frame(i);
	}

	public static void SwitchToFramebyStrinId(String str) {
		
		driver.switchTo().frame(str);
	}

	public static void SwitchToFrameByWebelements(WebElement elements) {
		
		driver.switchTo().frame(elements);
	}

	public static void js(String text, WebElement e) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].setAttribute('value','"+text+"')", e);
	}
	
	public static String getattribute(String text, WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object obj = js.executeScript("arguments[0].setAttribute('value')", e);
		String value = obj.toString();
		return value;
		
		}
	// ScrollDown wrong this correct and use
	public static void ScrollDown(WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].ScrollIntoView(true)", element);
	}

	public static void Scrollup(WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].ScrollIntoView(false)", element);
	}

	public static void ClickByJavascript(WebElement click) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", click);
	}

	public static void SwitchWindow(String str) {
		
		driver.switchTo().window(str);
	}

	public static String GetWindowId() {
		
		String ParentId = driver.getWindowHandle();
		return ParentId;
	}

	public static Set<String> GetAllWindowId() {
		
		Set<String> allIds = driver.getWindowHandles();
		return allIds;
	}
	
	public static String getExcel(String filename, String sheetName, int rowNo, int cellNo) throws IOException {
	
File Location=new File("C:\\Users\\Muthu Raj\\eclipse-workspace\\MavenProject\\src\\test\\resources\\Excel\\"+filename+".xlsx");
		
		FileInputStream fi=new FileInputStream(Location);
		
		Workbook w=new XSSFWorkbook(fi);
		
		Sheet s=w.getSheet(sheetName);
		
		Row row=s.getRow(rowNo);
		
		Cell cell=row.getCell(cellNo);
		
		int type = cell.getCellType();
		
		String value=null;
		if(type==1) {
			 value = cell.getStringCellValue();
			
		}else {
			if(DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat si=new SimpleDateFormat("dd/MMM/yyyy");
				 value = si.format(date);
				
			}else {
					double db = cell.getNumericCellValue();
					long l=(long)db;
					 value = String.valueOf(l);
					
			}}
		return value;
			}

		
		

	}

