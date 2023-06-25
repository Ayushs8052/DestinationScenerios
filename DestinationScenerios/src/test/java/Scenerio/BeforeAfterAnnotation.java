package Scenerio;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class BeforeAfterAnnotation {
	
	private static WebDriver driver;

	@BeforeMethod
	private void setup() {
		System.out.println("Starting Login Test");
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();

		

		driver.manage().window().maximize();
	}

}
