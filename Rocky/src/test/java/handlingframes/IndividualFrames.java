package handlingframes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class IndividualFrames {
public static void main(String[] args) throws Exception {
	WebDriver driver=new EdgeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
	driver.switchTo().frame("packageFrame");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//li//span[text()='Action']")).click();
	Thread.sleep(2000);
	driver.switchTo().defaultContent();
	driver.switchTo().frame("classFramea");
	driver.findElement(By.xpath("(//ul/li[2]/a[@target='_top'])[1]")).click();
	Thread.sleep(2000);
	driver.manage().window().minimize();
	driver.quit();
	
	
}
}
