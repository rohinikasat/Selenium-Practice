package tests;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
	private static SearchContext getShadowRoot(WebDriver driver,WebElement shadowHost) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    return (SearchContext) js.executeScript("return arguments[0].shadowRoot", shadowHost);
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://developer.salesforce.com/signup");
		driver.manage().window().maximize();
		
		WebElement shadowHost = driver.findElement(By.xpath("//section[@class='right']//child::dw-de-signup-form"));
		SearchContext shadowRoot = getShadowRoot(driver,shadowHost);
		WebElement shadowHost2= shadowRoot.findElement(By.cssSelector("form"));
		
		
//		WebElement continent = driver.findElement(By.xpath("//*[@id=\"continents\"]"));
//		Select dSelect = new Select(continent);
//		dSelect.selectByVisibleText("Australia");
//		
//		WebElement month = driver.findElement(By.id("month"));
//		Select mSelect = new Select(month);
//		mSelect.selectByVisibleText("Nov");
//		
//		WebElement year = driver.findElement(By.id("year"));
//		Select ySelect = new Select(year);
//		ySelect.selectByValue("1994");
//		
		//select[contains(@class,'select-element select-element_placeholder')]
	}
}
