package ProjectCode;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LMSPage3 {
public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "F:\\JAVA\\LMS-Selenium-Project\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver();
		driver.get("https://alchemy.hguy.co/lms/");
		//Verify the title of the first info box
				WebElement infoBoxLMS = driver.findElement(By.xpath("//div/h3[text()=' Actionable Training ']"));
				System.out.println("Heading "+infoBoxLMS.getText());
				Assert.assertTrue(infoBoxLMS.getText().equals("Actionable Training"));
				
			driver.close();
}
}
