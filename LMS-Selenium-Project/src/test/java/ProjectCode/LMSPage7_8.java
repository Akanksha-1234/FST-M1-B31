package ProjectCode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LMSPage7_8 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "F:\\JAVA\\LMS-Selenium-Project\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver();
		driver.get("https://alchemy.hguy.co/lms/");
		//Count the number of courses
				driver.findElement(By.xpath("//li/a[contains(text(),'All Courses')]")).click();
				List<WebElement> list = driver.findElements(By.xpath("//div[@class='ld-course-list-items row']//div[@class='caption']/h3"));
				System.out.println(list.size());
				 for (WebElement webElement : list) {
			            String courseName = webElement.getText();
			            System.out.println(courseName);
			        }
				 
				// Navigate to the “Contact Us” page and complete the form
				 FillContactUsForm(driver);
				 driver.close();
				
	}
	public static void FillContactUsForm(WebDriver driver){
		driver.findElement(By.xpath("//li/a[contains(text(),'Contact')]")).click();
		 if(driver.findElement(By.xpath("//div/form[@id='wpforms-form-8']")).isDisplayed()){
			 
		 WebElement Name = driver.findElement(By.xpath("//div/form[@id='wpforms-form-8']//input[@id='wpforms-8-field_0']"));
		 WebElement Email = driver.findElement(By.xpath("//div/form[@id='wpforms-form-8']//input[@id='wpforms-8-field_1']"));
		 WebElement Subject = driver.findElement(By.xpath("//div/form[@id='wpforms-form-8']//input[@id='wpforms-8-field_3']"));
		 WebElement Comment = driver.findElement(By.xpath("//div/form[@id='wpforms-form-8']//textarea[@id='wpforms-8-field_2']"));
		 
		 Name.sendKeys("Akanksha");
		 Email.sendKeys("A@gmail.com");
		 Subject.sendKeys("LMS Project Assignment");
		 Comment.sendKeys("In Progress!!!!!!!!");
		 
		 driver.findElement(By.xpath("//button[contains(text(),'Send Message')]")).click();
		 
		 boolean Msg = driver.findElement(By.xpath("//*[contains(text(),'Thanks for contacting us! We will be in touch with you shortly.')]")).isDisplayed();
		 if(Msg){
			 System.out.println("Comment Submitted !!!");
			 System.out.println("Content: "+driver.findElement(By.xpath("//*[contains(text(),'Thanks for contacting us! We will be in touch with you shortly.')]")).getText());
		 }
		 		 
		 }else{
			 System.out.println("Form is not Displayed ");
		 }
	}

}
