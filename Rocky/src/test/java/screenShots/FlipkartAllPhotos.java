package screenShots;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
public class FlipkartAllPhotos {

		public static void main(String[] args) throws IOException, Throwable {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Object key = Keys.ESCAPE;
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		//driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[1]/div/a[1]")).click();
		//String Popup = null;
		//driver.switchTo().window(Popup).close();
		//TakesScreenshot tss = (TakesScreenshot)driver;
		for(int i=0;i<=7;i++)
		{
			String timeStamp = LocalDateTime.now().toString().replace(":", "-");
		WebElement logo =  driver.findElement(By.xpath("//div[@class='eFQ30H'][i]/a"));
		File tempFile = logo.getScreenshotAs(OutputType.FILE);
		File destFile= new File("./screenShotsTaken/"+timeStamp+"flipkartcategoryicon.png");
		FileUtils.copyFile(tempFile, destFile);
		}
		Thread.sleep(3000);
		//String path=tempFile.getAbsolutePath();
		//System.out.println(path);
		driver.manage().window().minimize();
		
		driver.quit();
	}
	}

