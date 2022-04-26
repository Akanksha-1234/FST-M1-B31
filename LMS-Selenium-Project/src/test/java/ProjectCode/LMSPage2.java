package ProjectCode;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LMSPage2 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "F:\\JAVA\\LMS-Selenium-Project\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver();
		driver.get("https://alchemy.hguy.co/lms/");
		//Verify the website heading
				WebElement headingLMS = driver.findElement(By.xpath("//div/h1[text()=' Learn from Industry Experts ']"));
				System.out.println("Heading "+headingLMS.getText());
				Assert.assertTrue(headingLMS.getText().equals("Learn from Industry Experts"));
				driver.close();
	}

}
