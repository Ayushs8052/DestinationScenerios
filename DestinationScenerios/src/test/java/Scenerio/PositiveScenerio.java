package Scenerio;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PositiveScenerio {
	
	private static WebDriver driver;

	@BeforeMethod
	private void setup() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();

		

		driver.manage().window().maximize();
	}


	@Test
	public void homePage() {

//		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//
//		driver.manage().window().maximize();

		String url = "https://blazedemo.com/index.php";
		driver.get(url);
		System.out.println("Page is Opened");

		// Verify the "Welcome to the Simple Travel Agency!" text
		WebElement SuccesfullMessage = driver.findElement(By.xpath("//div[@class='jumbotron']"));
		String ExpectedResult = "Welcome to the Simple Travel Agency!";
		String ActualResult = SuccesfullMessage.getText();
		Assert.assertTrue(ActualResult.contains(ExpectedResult));

//		Click on "destination of the week! The Beach"!

		WebElement NewUrl = driver.findElement(By.xpath("//a[@href='vacation.html']"));
		NewUrl.click();

		// navigate to Homepage
		WebElement homepage = driver.findElement(By.xpath("//a[@href='index.php']"));
		homepage.click();

//		Select Departure city dropdown 
		WebElement DepartureCityDropdown = driver.findElement(By.xpath("//select[@name='fromPort']"));
		DepartureCityDropdown.click();

// 		Select DepartureCity name 
		WebElement DepartureCityName = driver.findElement(By.xpath("//option[@value='Mexico City']"));
		DepartureCityDropdown.click();

//		Select Destination  city dropdown 
		WebElement DestinationCityDropdown = driver.findElement(By.xpath("//select[@name='toPort']"));
		DestinationCityDropdown.click();

// 		Select Destination City name 
		WebElement DestinationCityName = driver.findElement(By.xpath("//option[@value='London']"));
		DestinationCityName.click();
		
//		Click on Find Flight button 
		WebElement SubmitButton = driver.findElement(By.xpath("//input[@type='submit']"));
		SubmitButton.click();
		
// 		Select the cheapest flight available 
		WebElement CheapestFlight = driver.findElement(By.xpath("/html/body/div[@class='container']/table[@class='table']/tbody/tr[5]/td[1]/input[@value='Choose This Flight']"));
		CheapestFlight.click();
		
//		Check if a field named ‘Total Cost’ is available with price available in xxx.xx format
		WebElement TotalCost = driver.findElement(By.xpath("/html/body/div[@class='container']//em[.='914.76 ']"));
		Assert.assertTrue(TotalCost.isDisplayed());
		
//		Click on purchase flight button 
		
		WebElement PurchaseFlightButton = driver.findElement(By.xpath("//input[@value='Purchase Flight']"));
		PurchaseFlightButton.click();
		
//		Verify that the user is directed to Purchase confirmation page 
		WebElement PurchaseConfirmationPage = driver.findElement(By.xpath("\r\n"
				+ "/html/body/div[2]/div/h1"));
		String ExpectedResult1 = "Thank you for your purchase today!";
		String ActualResult1 = PurchaseConfirmationPage.getText();
		Assert.assertTrue(ActualResult.contains(ExpectedResult));
		
// 		Verifying Purchase ID 
		WebElement id = driver.findElement(By.xpath("/html/body/div[@class='container']//table[@class='table']//td[.='1687521921603']"));
		System.out.println("Purchase ID :  " + id.getText());
		
		driver.close();
		
		
		
		

	}

}
