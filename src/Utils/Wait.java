package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 等待超时
 * @author zhulibin
 *
 */
public class Wait {
	private WebDriver driver;
	private int timeout = 10;

	public Wait(WebDriver driver) {
		this.driver=driver;
	}
	
	//等元素出现,如果超过10m则是超时,不等了,算超时
	public void waitForElementPresent(String locator){
		(new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}
	
	//等元素可以点击即有效,如果等待超过10m,不等了,算超时
	public void waitForElementIsEnable(String locator){
		(new WebDriverWait(driver,timeout)).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	}
	
	
	public void waitFor(long timeout){
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
