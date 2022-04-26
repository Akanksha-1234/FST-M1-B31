package ProjectCode;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LMSPage4_5 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "F:\\JAVA\\LMS-Selenium-Project\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver();
		driver.get("https://alchemy.hguy.co/lms/");
		//Verify the title of the second most popular course	
				WebElement coursenameLMS = driver.findElement(By.xpath("//div/h3[contains(text(),'Email Marketing Strategies')]"));
				System.out.println("Heading "+coursenameLMS.getText());
				Assert.assertTrue(coursenameLMS.getText().equals("Email Marketing Strategies"));
				
				//Navigate to the “My Account” page on the site.
				driver.findElement(By.xpath("//li/a[contains(text(),'My Account')]")).click();
				driver.getTitle();
				Boolean var = driver.findElement(By.xpath("//div/h1[contains(text(),'My Account')]")).isDisplayed();
				if(var){
					System.out.println("In to My Account Page");
				}else{
					System.out.println("Not Reached ");
				}
			driver.close();	

	}

}
