import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	
	/*
	 * this method is for testing broken link in orange app's Login page & page appear after login
	 */

	static List<String> failedlink;

	public static void main(String[] args) {

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./Resources/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links are " + links.size());
		failedlink = new ArrayList<String>();
		for (int i = 0; i < links.size(); i++) {
			WebElement ele = links.get(i);
			String url = ele.getAttribute("href");
			System.out.println("Total links are" + links.size());
			ValidateLinks(url);
		}

		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");

		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");

		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String url2 = driver.getCurrentUrl();
		System.out.println("the new url is  "+ url2);
		System.out.println("@@@@@@ New PAGE Links @@@@@@@@@@@@@");
		List<WebElement> links2 = driver.findElements(By.tagName("a"));
		System.out.println("Total links are " + links2.size());
		failedlink = new ArrayList<String>();
		for (int i = 0; i < links2.size(); i++) {
			WebElement ele = links2.get(i);
			String url = ele.getAttribute("href");
			System.out.println("Total links are" + links2.size());
			ValidateLinks(url);
		}
	
	}

	public static void ValidateLinks(String linkUrl) {
		try {

			URL url = new URL(linkUrl);
			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
			httpURLConnect.setConnectTimeout(3000);
			httpURLConnect.connect();
			if (httpURLConnect.getResponseCode() != 200) {
				System.out.println(linkUrl + "-is not giving 200 status code" + httpURLConnect.getResponseMessage());
				failedlink.add(linkUrl);
			}
			if (httpURLConnect.getResponseCode() == 200) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());

			}
			if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - "
						+ HttpURLConnection.HTTP_NOT_FOUND);
				failedlink.add(linkUrl);
			}
			if (failedlink.size() > 0) {
				System.out.println("error in link");
			}
		} catch (Exception e) {

		}

	}

}
