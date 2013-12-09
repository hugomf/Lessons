package my.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import my.test.Browser;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Companies {
	static WebElement status;
	static Select statusMenu;
	static WebElement filterBtn; 
	static WebElement editTD;
	static WebElement editTDLink;
	
	public static void filter() {
		status = Browser.instance.findElement(By.id("status"));
		filterBtn = Browser.instance.findElement(By.id("filtr"));
		statusMenu = new Select(status);
		statusMenu.selectByValue("0");
		filterBtn.click();
		Browser.instance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public static void edit() {
		//find link in table data with waiting statement
		Alert refreshingSplashScreen = (new WebDriverWait(Browser.instance, 10))
				  .until(ExpectedConditions.alertIsPresent());
		try {
			refreshingSplashScreen.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement editLink = Browser.instance.findElement(By
					.cssSelector("html body div#wrapper div#page-wrapper div.row div.col-lg-12 table#news.table tbody#tab tr td a"));
		editLink.click();
	
	}

	public static void GoTo() {
		// TODO Auto-generated method stub
		Browser.instance.get("http://dev.570-570.kz/admin/ru/companies");
	}

	public static boolean checkStatus() {
		//Pause for refreshing table
		Browser.instance.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
		//Get all table rows 
		List<WebElement> rows = Browser.instance.findElement(By.id("tab")).findElements(By.tagName("tr"));
		
		//Create lists for columns and right data list
		List<WebElement>cols = null;
		ArrayList<WebElement> tempList = new ArrayList<WebElement>();
		
		//Adding table data in columns List 
		for(WebElement row:rows) {
			cols = row.findElements(By.xpath("//td[5]"));
		}
		
		for(int i = 0; i<cols.size(); i++) {
				if(cols.get(i)
						.getText()
						.equals("�� ���������")) {
					System.out.println(cols.get(i).getText());
					tempList.add(cols.get(i));
				}
		}
		//�������
		if(tempList.size() > 7) {
			return true;
		} else {
			return false;
		}
		
		
	}
	
}
