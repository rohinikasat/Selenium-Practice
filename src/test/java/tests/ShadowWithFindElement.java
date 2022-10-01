package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowWithFindElement {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://developer.salesforce.com/signup");
		driver.manage().window().maximize();
		
		//Find Shadow Host
		WebElement shadowHost = driver.findElement(By.tagName("dw-de-signup-form"));
		
		
		//Execute JavaScript to return the shadow root
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		SearchContext shadowRoot =  (SearchContext) jsExecutor.executeScript("return arguments[0].shadowRoot", shadowHost);
		
		
		//Find the webElement then perform an action on the WebElement
		WebElement jobRole = shadowRoot.findElement(By.cssSelector("dx-select"));
		WebElement jobRole1 =(((jobRole.findElement(By.xpath("//div"))).findElement(By.xpath("//div"))).findElement(By.xpath("//div")));
		
		System.out.println(jobRole1);
		
//		Select selectj = new Select(jobField);
//		selectj.selectByVisibleText("Administrator");
	}

}
