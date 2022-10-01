package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDOMwithoutFindElementMethod {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://developer.salesforce.com/signup");
		driver.manage().window().maximize();
		
		//Provide access so the driver can execute JavaScript
		JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
		
		//Execute JavaScript to return a WebElement
		WebElement jobField= (WebElement) jsexecutor.executeScript("return document."
				+ "querySelector(\"#maincontent > div > section.right > div > dw-de-signup-form\")"
				+ ".shadowRoot.querySelector(\"form > dx-select:nth-child(4)\")"
				+ ".shadowRoot.querySelector(\"#select\")");
		
		//Perform Action on the WebElement
		Select selectj = new Select(jobField);
		selectj.selectByVisibleText("Administrator");
		
	}

}
