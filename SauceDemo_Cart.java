package jar;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SauceDemo_Cart {
	
	WebDriver driver;
	String url="https://www.saucedemo.com/";
	String driverPath="..\\AutomationPractice\\Drivers\\chromedriver.exe";
	Actions actions;
	
	
	@BeforeSuite
		public void SetUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", driverPath);
		ChromeOptions options=new ChromeOptions();
        options.addArguments("remote-allow-origins=*");
        driver=new ChromeDriver(options);
        driver.get(url);
        actions = new Actions(driver);
        
        
	}
	
	@AfterSuite
	public void CloseNav() {
		//driver.close();
	}
	
	@Test
	public void CartTest() {
		
		WebElement username=driver.findElement(By.id("user-name"));
		username.sendKeys("standard_user");
		
		WebElement pass=driver.findElement(By.id("password"));
		pass.sendKeys("secret_sauce");
		
		WebElement click=driver.findElement(By.id("login-button"));
		actions.moveToElement(click).click().perform();
		
		WebElement selectItem=driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
		actions.moveToElement(selectItem).click().perform();
		
		WebElement goToCart=driver.findElement(By.className("shopping_cart_link"));
		actions.moveToElement(goToCart).click().perform();
		
		WebElement checkCart=driver.findElement(By.className("inventory_item_name"));
		String actualLabel = checkCart.getText();
		String expectedLabel = ("Sauce Labs Backpack");
		Assert.assertEquals(actualLabel, expectedLabel);
		
		WebElement checkOut=driver.findElement(By.id("checkout"));
		actions.moveToElement(checkOut).click().perform();
		
		WebElement firstName=driver.findElement(By.id("first-name"));
		firstName.sendKeys("Sebastian");
		
		WebElement lastName=driver.findElement(By.id("last-name"));
		lastName.sendKeys("Elefante");
		
		WebElement zipCode=driver.findElement(By.name("postalCode"));
		zipCode.sendKeys("1234");
		
		WebElement continueBtn=driver.findElement(By.id("continue"));
		actions.moveToElement(continueBtn).click().perform();
		
		WebElement checkoutOverview=driver.findElement(By.className("inventory_item_name"));
		String actualLabel2= checkoutOverview.getText();
		String ExpectedLabel2 = ("Sauce Labs Backpack");
		Assert.assertEquals(actualLabel2, ExpectedLabel2);
		
		WebElement finish=driver.findElement(By.id("finish"));
		actions.moveToElement(finish).click().perform();
		
		WebElement thankYou=driver.findElement(By.className("complete-header"));
		String actualLabel3 = thankYou.getText();
		String expectedLabell3 = ("Thank you");
		Assert.assertTrue(actualLabel3.contains(expectedLabell3));
	
	}
}
