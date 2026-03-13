import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Standalone {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		String title= driver.findElement(By.xpath("//div/h1")).getText();
		String windowHandle1 = driver.getWindowHandle();
		System.out.print(title);

		Assert.assertTrue(title.equalsIgnoreCase("Automation Testing Practice"));
		
		driver.findElement(By.xpath("//a[text()='Udemy Courses']")).click();
		String windowHandle2 = driver.getWindowHandle();
		driver.navigate().back();
		//driver.switchTo().window(windowHandle1);   ---- wont work since its the same window
		
		List<WebElement> services = driver.findElements(By.xpath("//div[@id='PageList2']//ul/li"));
		
		Iterator<WebElement> it = services.iterator();
		it.next();
		it.next();
		WebElement thirdOption = it.next();
		thirdOption.click();    // can use services.get(2).click(); instead of iterator
		
		driver.navigate().back();
		driver.findElement(By.id("name")).sendKeys("Priya");
		driver.findElement(By.cssSelector("input[id='email']")).sendKeys("abc.gmail.com");
		driver.findElement(By.id("phone")).sendKeys("123456789");
		driver.findElement(By.id("textarea")).sendKeys("pune");
		driver.findElement(By.xpath("//input[@id='female']")).click();
		driver.findElement(By.cssSelector("input[id='tuesday']")).click();
		
		WebElement countryDrpDwn = driver.findElement(By.xpath("//select[@id='country']"));
		Select country = new Select(countryDrpDwn);
		//country.selectByIndex(2);
		//country.selectByContainsVisibleText("Canada");
		country.selectByValue("india");
		
		WebElement colorDrpDwn= driver.findElement(By.id("colors"));
		Select color = new Select(colorDrpDwn);
		//color.selectByVisibleText("Blue");
		color.selectByValue("red");
		
		WebElement sortedList = driver.findElement(By.id("animals"));
		Select animals = new Select(sortedList);
		//color.selectByVisibleText("Blue");
		animals.selectByValue("elephant");
		
		driver.findElement(By.id("datepicker")).click();
		int x =0;
		/*do {
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
		x++;
		}while ( x<=5); */
		
		while( x<=5)
		{
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			x++;
		}
		
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='9']")).click();
		driver.findElement(By.id("txtDate")).click();
		
	}

}
