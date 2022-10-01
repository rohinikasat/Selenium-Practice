package tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeClass {
public static void main(String[] args) throws IOException {
	
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://developer.salesforce.com/signup");
	//Collect all the links from the webpage. All the links are associated with the Tag ‘a‘

	 List<WebElement> links = driver.findElements(By.tagName("a"));
	 List<String> urllinks = new LinkedList();

	//Create a list of type WebElement to store all the Link elements in it.

	 for(int i=0; i<links.size(); i++) {

	      WebElement element = links.get(i);

	           String url=element.getAttribute("href");

	            urllinks.add(url); }

	//Now Create a Connection using URL object( i.e ., link)
	 for(int i = 0; i<urllinks.size();i++) {
	
	 URL link = new URL(urllinks.get(i));

	//Connect using Connect Method

	  HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();

	//Use getResponseCode () to get response code
	  System.out.println(httpConn.getResponseCode());

	  if(httpConn.getResponseCode()!= 200)

	//Throw exception, if any error occurred

	  { System.out.println("BrokenLink");}
	  
	  else  {System.out.println("Works");}
	  
	  driver.quit();

	 }
	 
	  


}
}
