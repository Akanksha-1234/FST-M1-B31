package ProjectCode;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LMS_Project{

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
	
	public static Boolean LogOut(WebDriver driver){
		driver.navigate().to("https://alchemy.hguy.co/lms/my-account/");
		if(driver.findElement(By.xpath("//div//img[@class='avatar avatar-26 photo']")).isDisplayed()){
			driver.findElement(By.xpath("//div/a[contains(text(),'Logout')]")).click();
			return false;
		}else{
			System.out.println("Already LogOut!!! Please Login again");
			return true;
		}
					
	}
	public static void Login(WebDriver driver){
		    driver.navigate().to("https://alchemy.hguy.co/lms/my-account/");
			driver.findElement(By.xpath("//div/a[contains(text(),'Login')]")).click();
			if(driver.findElement(By.xpath("//p/label[contains(text(),'Username or Email Address')]")).isDisplayed()){
				driver.findElement(By.xpath("//p/input[@id='user_login']")).click();
				driver.findElement(By.xpath("//p/input[@id='user_login']")).sendKeys("root");
				driver.findElement(By.xpath("//p/input[@id='user_pass']")).click();
				driver.findElement(By.xpath("//p/input[@id='user_pass']")).sendKeys("pa$$w0rd");			
				driver.findElement(By.xpath("//p[@class='login-submit']/input[@value='Log In']")).click();			
				if(driver.findElement(By.xpath("//li/a[contains(text(),'Howdy, ')]/span[contains(text(),'root')]")).isDisplayed()){
					System.out.println("Login Sucessfully !!!!!!");
					System.out.println("Username :"+driver.findElement(By.xpath("//li/a[contains(text(),'Howdy, ')]/span[contains(text(),'root')]")).getText());
				}
			}	
		else{
			System.out.println("Login Failed!!!");
		}
		
	}
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "F:\\JAVA\\LMS-Selenium-Project\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver();
		try {
		
		//Verify the website title
		driver.get("https://alchemy.hguy.co/lms/");
		Thread.sleep(2000);
		System.out.println("Title :"+driver.getTitle());
		
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Alchemy LMS – An LMS Application";
		Assert.assertTrue(ExpectedTitle.equals(ActualTitle));
		
		//Verify the website heading
		WebElement headingLMS = driver.findElement(By.xpath("//div/h1[text()=' Learn from Industry Experts ']"));
		System.out.println("Heading "+headingLMS.getText());
		Assert.assertTrue(headingLMS.getText().equals("Learn from Industry Experts"));
			
		//Verify the title of the first info box
		WebElement infoBoxLMS = driver.findElement(By.xpath("//div/h3[text()=' Actionable Training ']"));
		System.out.println("Heading "+infoBoxLMS.getText());
		Assert.assertTrue(infoBoxLMS.getText().equals("Actionable Training"));
		
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
		
		//. Logging into the site
		Login(driver);
		LogOut(driver);
		
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
		 
		 //Navigate to a particular lesson and complete it.		 
		 Login(driver);
		 driver.findElement(By.xpath("//li/a[contains(text(),'All Courses')]")).click();
//		 driver.findElement(By.xpath("//div/h3[contains(text(),'Email Marketing Strategies')]/..//p/a[contains(text(),'See more...')]")).click();
//		 driver.findElement(By.xpath("//div[contains(text(),'Developing Strategy')]")).click();
//		 driver.findElement(By.xpath("//div[@class='ld-breadcrumbs']//div[contains(text(),'Complete')]")).click();
//		 driver.findElement(By.xpath("//div[contains(text(),'Monitoring & Digital Advertising')]")).click();
//		 driver.findElement(By.xpath("//div[@class='ld-breadcrumbs']//div[contains(text(),'Complete')]")).click();
//		 driver.findElement(By.xpath("//div[contains(text(),'Investment & Marketing  Final Strategies')]")).click();
//		 driver.findElement(By.xpath("//div[@class='ld-breadcrumbs']//div[contains(text(),'Complete')]")).click();
		 //Verify Mark as Complete
		 driver.findElement(By.xpath("//div/h3[contains(text(),'Email Marketing Strategies')]/..//p/a[contains(text(),'See more...')]")).click();
		 driver.findElement(By.xpath("//div[text()='Complete']")).isDisplayed();
		 LogOut(driver);
		 
		 driver.close();
		} catch (Exception e) {
			//driver.close();
			e.printStackTrace();
			
		}

	}

}
