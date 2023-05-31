package screenShots;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TakeScreenShotOfFBLoginpage 
{
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		String timeStamp = LocalDateTime.now().toString().replace(":", "-");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/");
		TakesScreenshot tss = (TakesScreenshot)driver;
		File tempFile = tss.getScreenshotAs(OutputType.FILE);
		//for(int i=0;i<3;i++)
		//{
		File destFile= new File("./screenShotsTaken/"+timeStamp+"logiPageimage.jpg");
		FileUtils.copyFile(tempFile, destFile);
		//}
		//Thread.sleep(3000);
		//String path=tempFile.getAbsolutePath();
		//System.out.println(path);
		driver.manage().window().minimize();
		Thread.sleep(3000);
		driver.quit();
	}

}
