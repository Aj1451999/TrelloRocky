package handlingframes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class PlayingWithFramesAsNestedFrames
{
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				driver.get("https://demo.automationtesting.in/Frames.html");
				driver.findElement(By.linkText("Iframe with in an Iframe")).click();
				WebElement parentFrame=driver.findElement(By.xpath("//div[@id='Multiple']/iframe")); 
				driver.switchTo().frame(parentFrame);
				WebElement childFrame = driver.findElement(By.xpath("//div[@class='iframe-container']/iframe")); 
				driver.switchTo().frame(childFrame);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Selenium");
				Thread.sleep(2000);
				driver.manage().window(). minimize();
				driver.quit();
	}
}
