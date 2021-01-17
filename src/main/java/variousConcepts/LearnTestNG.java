package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LearnTestNG {

	WebDriver driver;
	@BeforeMethod
	public void init() {
			System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\budha\\\\Aug2020\\\\FirstSeleniumProject\\\\driver\\\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.techfios.com/billing/?ng=admin/");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
	
	@Test
	public void loginTest() {

	Assert.assertEquals("Login Page not found!!","Login - iBilling", driver.getTitle());
		
		WebElement USERNAME_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement PASSWORD_FIELD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement SIGNIN_BUTTON_ELEMENT = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
		
		USERNAME_FIELD_ELEMENT.clear();
		USERNAME_FIELD_ELEMENT.sendKeys("demo@techfios.com");
		
		PASSWORD_FIELD_ELEMENT.clear();
		PASSWORD_FIELD_ELEMENT.sendKeys("abc123");
		SIGNIN_BUTTON_ELEMENT.click();
		
		WebElement Dashboard_button_Element = driver.findElement(By.linkText("Dashboard"));
		String actualDashboardElement = Dashboard_button_Element.getText();
		Assert.assertEquals("Dashboard page not found!!","Dashboard",actualDashboardElement);
	}
	@AfterMethod
	public void TearDown() {
		driver.close();
	}
}
