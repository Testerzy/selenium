package domena.pl;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opera.core.systems.OperaDriver;
import com.thoughtworks.selenium.DefaultSelenium;

public class FirstTest {

	@Test
	public void startDriver() throws MalformedURLException
	{
//		System.setProperty("webdriver.chrome.driver", "c:\\selenium\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setPlatform(Platform.LINUX);
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		driver.navigate().to("http://seleniumhq.org");
//		Assert.assertTrue("Nieprawidlowy title", driver.getTitle().toLowerCase().contains("selenium"));
		Assert.assertTrue(driver.getTitle().toLowerCase().contains("selenium"), "Nieprawidlowy title");
//		driver.close();
		driver.quit();
	}
	
//	@Test
	@Parameters({"seleniumHost","seleniumPort","browser","url"})
	public void rcTest(String seleniumHost, int seleniumPort, String browser, String url){
		DefaultSelenium selenium = new DefaultSelenium(seleniumHost, 4444, "*firefox", "http://google.pl");
		selenium.start();
		selenium.open("http://seleniumhq.org");
		Assert.assertTrue(selenium.getTitle().toLowerCase().contains("selenium"), "Nieprawidlowy title");
		selenium.close();
		selenium.stop();
	}
	
}