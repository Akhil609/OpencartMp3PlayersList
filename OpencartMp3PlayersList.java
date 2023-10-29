package opencart;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpencartMp3PlayersList {
  
  
  WebDriver driver =new ChromeDriver();
  @Test(priority=1)
  public void Url() {
	  
	  driver.get("https://demo.opencart.com/index.php?route=common/home&language=en-gb");
	  driver.manage().window().maximize();
  }
  @Test(priority=2)
  public void Login() throws InterruptedException {
	  
	  WebElement MyAccount=driver.findElement(By.xpath("//span[contains(text(),'My Account')]"));
	  MyAccount.click();
		 
  }
  @Test(priority=4 )
  public void returningcustomer() throws InterruptedException {
	 
	  WebElement login= driver.findElement(By.xpath("//div[@id='content']/following-sibling::aside/child::div/a[1]"));
	  login.click();
	  
	  
	  WebElement email=driver.findElement(By.xpath("//input[@id='input-email']"));
	  email.sendKeys("akhilsharmaindia@gmail.com");
	  Thread.sleep(300);
	  WebElement password=driver.findElement(By.xpath("//input[@id='input-password']"));
	  password.sendKeys("123456");
	  WebElement loginbutton=driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
	  loginbutton.click();
	  Thread.sleep(10000);
  }
  
  @Test(priority=3)
  public void newUserCredential() throws Exception {
	  WebElement Register= driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
Register.click();

WebElement Firstname= driver.findElement(By.id("input-firstname"));	
Firstname.sendKeys("Akhil");
WebElement Lastname= driver.findElement(By.id("input-lastname"));
Lastname.sendKeys("Sharma");
WebElement email= driver.findElement(By.id("input-email"));
email.sendKeys("akhilsharmaindia@gmail.com");
WebElement password= driver.findElement(By.id("input-password"));
password.sendKeys("123456");

Thread.sleep(300);
  }
	@Test(priority=5, enabled=true)
	public void Mp3playerslinks() throws Exception {
	
		WebElement mp3players=driver.findElement(By.xpath("//div[@id='narbar-menu']/child::ul[1]/child::li[8]/child::a[1]"));
		mp3players.click();
		Thread.sleep(10000);
	WebElement allplayers= driver.findElement(By.xpath("//a[normalize-space()='Show All MP3 Players']"));
	allplayers.click();
	
	Thread.sleep(10000);
	
	List<WebElement> Links= driver.findElements(By.xpath("//a[contains(text(),'- test')]"));
System.out.println("Link size is :"+Links.size());
for(WebElement el:Links) {
	System.out.println(el.getText());
}
driver.close();
	}	

}  
  
  

