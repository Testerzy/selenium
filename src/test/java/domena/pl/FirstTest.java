package domena.pl;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class FirstTest {

	WebDriver driver;
	Actions actions;
	
	@BeforeClass
	public void setUp(){
//		System.setProperty("webdriver.chrome.driver", "D:\\WORK\\Selenium\\chromedriver.exe");
		FirefoxProfile profile = new FirefoxProfile();
		profile.setEnableNativeEvents(true);
		driver = new FirefoxDriver(profile);
		actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	@Test(enabled=false)
	public void startDriver() throws MalformedURLException
	{
//		System.setProperty("webdriver.chrome.driver", "c:\\selenium\\chromedriver.exe");
		
//		DesiredCapabilities cap = DesiredCapabilities.firefox();
//		cap.setPlatform(Platform.LINUX);
//		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		driver.navigate().to("http://seleniumhq.org");
		Assert.assertTrue(driver.getTitle().toLowerCase().contains("selenium"), "Nieprawidlowy title");
//		driver.close();
//		driver.quit();
	}
	
	@Test(enabled=false)
	public void Test2(){
		driver.navigate().to("http://www.w3schools.com/html/html5_draganddrop.asp");
//		WebElement src = driver.findElement(By.id("div1"));
//		WebElement dst = driver.findElement(By.id("div2"));
//		actions.dragAndDrop(src, dst).build().perform();
		
//		driver.navigate().refresh();
//		actions.clickAndHold(driver.findElement(By.id("div1"))).moveToElement(driver.findElement(By.id("div2"))).release(driver.findElement(By.id("div2"))).build().perform();
		
		actions.dragAndDropBy(driver.findElement(By.id("div1")), 50, 0);
		
		driver.get("http://www.w3schools.com/html/tryit.asp?filename=tryhtml5_draganddrop");
		driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
		actions.dragAndDrop(driver.findElement(By.id("drag1")), driver.findElement(By.id("div1"))).build().perform();
	}
	
	@Test(enabled=false)
	public void test3(){
		driver.get("https://jqueryui.com/sortable");
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement src = driver.findElement(By.xpath("//*[@id='sortable']/li[1]"));
		WebElement target = driver.findElement(By.xpath("//*[@id='sortable']/li[7]"));
//		actions.dragAndDrop(src, target).build().perform();
		
		actions.clickAndHold(src).moveToElement(target).release(target).build();
		actions.perform();
	}
	
	@Test(enabled=false)
	public void test4(){
		driver.get("http://html5demos.com/drag");
		WebElement sr = driver.findElement(By.id("one"));
		WebElement dst = driver.findElement(By.id("bin"));
//		(new Actions(driver)).dragAndDrop(sr, dst).build().perform();
//		actions = new Actions(driver);
		actions.clickAndHold(sr).moveToElement(dst).release().build().perform();
//		actions.moveToElement(sr);
//		actions.clickAndHold();
//		actions.moveToElement(dst).build().perform();
	}
	
	@Test
	public void test5(){
		driver.get("http://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement src = driver.findElement(By.id("draggable"));
		WebElement dst = driver.findElement(By.id("droppable"));
		
		//no1
//		actions.dragAndDropBy(src, 200, 20).build().perform();
//		actions.clickAndHold(src).moveToElement(dst).release().build().perform();
		actions.dragAndDrop(src, dst).build().perform();
		
	}
	
//	@Test
//	@Parameters({"seleniumHost","seleniumPort","browser","url"})
//	public void rcTest(String seleniumHost, int seleniumPort, String browser, String url){
//		DefaultSelenium selenium = new DefaultSelenium(seleniumHost, 4444, "*firefox", "http://google.pl");
//		selenium.start();
//		selenium.open("http://seleniumhq.org");
//		Assert.assertTrue(selenium.getTitle().toLowerCase().contains("selenium"), "Nieprawidlowy title");
//		selenium.close();
//		selenium.stop();
//	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
}
