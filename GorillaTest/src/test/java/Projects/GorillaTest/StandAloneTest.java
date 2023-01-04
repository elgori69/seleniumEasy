package Projects.GorillaTest;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import Projects.pageobjects.LandingPage;
import Projects.pageobjects.ProductCatalogue;

import java.io.*;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		LandingPage landingpage= new LandingPage(driver);
		//Implicit Wait Definition
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		
		//driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("renedelafuente90@gmail.com");
		//driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Selenium123");
		//driver.findElement(By.xpath("//input[@id='login']")).click();
		
		landingpage.loginApplication("renedelafuente90@gmail.com", "Selenium123");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='card-body']/h5/b"));
		List<WebElement> button = driver.findElements(By.xpath("//button[@class='btn w-10 rounded']"));
	

		for (WebElement i : list) {
			String text = i.getText().trim();
			System.out.println(text);
			String var= "adidas original";

			if(text.equalsIgnoreCase(var)) {
				
				driver.findElement(By.xpath("//div[@class='card-body' and contains(., '"+var+"')]//button//i[contains(@class,'fa-shopping-cart')]")).click();
			} 

		}
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		List <WebElement>products= productCatalogue.getProductList();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		

		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("Mexico");
		//action.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "Mexico");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='ta-results list-group ng-star-inserted']")));

driver.findElement(By.xpath("//button[@type='button']")).click();

Actions action = new Actions(driver);
js.executeScript("window.scrollBy(0,250)", "");
Thread.sleep(3000);
action.moveToElement(driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']"))).click().build().perform();

String string= driver.findElement(By.xpath("//h1[@class='hero-primary']")).getText().trim();
System.out.println(string);
Assert.assertEquals("THANKYOU FOR THE ORDER.",string,"The Text does not match with the expected Text");

driver.close();

	}//Main
		
	
	
//for (int i=0; i<= list.length

	// System.out.print(num);
}
