package ProjectCode;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LMSPage1 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "F:\\JAVA\\LMS-Selenium-Project\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver();
		
		//Verify the website title
		driver.get("https://alchemy.hguy.co/lms/");
		Thread.sleep(2000);
		System.out.println("Title :"+driver.getTitle());
		
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Alchemy LMS – An LMS Application";
		Assert.assertTrue(ExpectedTitle.equals(ActualTitle));
		driver.close();


	}

}
