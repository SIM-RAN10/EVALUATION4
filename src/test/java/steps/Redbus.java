package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

public class Redbus {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Test
	public void test1() {
		
		driver.findElement(By.cssSelector("[id='src']")).sendKeys("Delhi");
		driver.findElement(By.cssSelector("[id='dest']")).sendKeys("Bangalore");
		// Picking the Date
		driver.findElement(By.cssSelector("[id='onwardCal']")).sendKeys("07/09/2024");
		
		//Click on search button
		driver.findElement(By.id("search_button")).click();
		//Assert the search result
		String search= driver.getPageSource();
		System.out.println(search);
		String word="Oops! No buses found.";
		Assert.assertEquals(word, search);
	
		
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.quit();
	}

}
