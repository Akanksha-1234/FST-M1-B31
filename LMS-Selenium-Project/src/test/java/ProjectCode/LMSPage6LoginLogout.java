package ProjectCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LMSPage6LoginLogout {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "F:\\JAVA\\LMS-Selenium-Project\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver();
		driver.get("https://alchemy.hguy.co/lms/");
	
		//. Logging into the site
				Login(driver);
				LogOut(driver);
				driver.close();
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

}
