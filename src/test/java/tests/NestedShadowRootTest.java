package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NestedShadowRootTest {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://developer.salesforce.com/signup");
		driver.manage().window().maximize();
		
		//Provide access to JavaScriptExecutor
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		
		//Find webelement to perform action
		WebElement jobRoleButton = (WebElement) jsExecutor.executeScript("return "
				+ "document.querySelector('dw-de-signup-form')"
				+ ".shadowRoot.querySelector('dx-select')"
				+ ".shadowRoot.querySelector('div>div>div>select')");
		Select selectj = new Select(jobRoleButton);
		selectj.selectByVisibleText("Administrator");
	}
}
