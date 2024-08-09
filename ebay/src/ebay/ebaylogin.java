package ebay;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ebaylogin {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium webdriver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com");
		
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		WebElement SearchBox = driver.findElement(By.name("_nkw"));
		SearchBox.sendKeys("Apple iPhone 15 Pro Max A2849 Spectrum");
		
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
		SearchBox.submit();
		
		
		String mainpage = driver.getWindowHandle();
		System.out.println("Main Page ID = " +mainpage);
		System.out.println("Main Page Url : " +driver.getCurrentUrl());
		
		driver.findElement(By.cssSelector("li[id='item2dc15592a2'] span[role='heading']")).click();
		
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
		Set<String> allpages = driver.getWindowHandles();
		for(String page : allpages)
		{
			if(!page.equals(mainpage)) {
				driver.switchTo().window(page);
				break;
			}
		}
		System.out.println("Next Page ID : " +driver.getWindowHandle());
		System.out.println("Next Page Url : " +driver.getCurrentUrl());
		
		List<WebElement> products = driver.findElements(By.cssSelector(".ux-layout-section-evo__item.ux-layout-section-evo__item--table-view"));
		System.out.println("\nProduct size: "+products.size());
		for(WebElement product : products) {
			System.out.println("\nProduct Specifications : \n " +product.getText());
		}
		
		
		driver.findElement(By.cssSelector("#atcBtn_btn_1")).click();
		
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
		
		System.out.println("\nAdded to Cart Successfully");
		
		
	}

}
