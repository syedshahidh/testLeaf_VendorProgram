package VendorName.BlueLagoon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BlueLagoon {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		
		driver.get("https://acme-test.uipath.com/account/login");
		//System.out.println(driver.getTitle());
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com",Keys.TAB);
		driver.findElementById("password").sendKeys("leaf@12");
		driver.findElementById("buttonLogin").click();
		
		Actions builder= new Actions(driver);
		WebElement mouseOver = driver.findElementByXPath("(//button[contains(@class,'btn btn-default')])[5]");
		builder.moveToElement(mouseOver).perform();
		driver.findElementByLinkText("Search for Vendor").click();
		
		driver.findElementById("vendorName").sendKeys("Blue Lagoon");
		driver.findElementById("buttonSearch").click();
		String countryName = driver.findElementByXPath("(//td[text()='Blue Lagoon']/following-sibling::td)[4]").getText();
		System.out.println(countryName);
		
		driver.findElementByLinkText("Log Out").click();
		driver.close();
		
	}
	
}
