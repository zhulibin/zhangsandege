package com.selenium.Glen.group;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;

import com.selenium.Glen.BrowserCompitable.BrowserCompatible;
import com.selenium.Glen.BrowserCompitable.BrowserTypes;

public class Practice1OnTestng {
	
	@Test(groups="submodule1")
	public void testSunModule1(){
		BrowserCompatible bc = new BrowserCompatible(BrowserTypes.ie);
		WebDriver driver = bc.driver;
		driver.get("http://www.baidu.com");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		}
	
	@Test(groups="submodule2")
	public void testSunModule2(){
		System.out.println("---submodule2---");
		BrowserCompatible bc = new BrowserCompatible(BrowserTypes.firefox);
		WebDriver driver = bc.driver;
		driver.get("http://www.baidu.com");
		try {
			Thread.sleep(5000);
			driver.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(groups="submodule3")
	public void testSunModule3(){
		System.out.println("---submodule3---");
		BrowserCompatible bc = new BrowserCompatible(BrowserTypes.chrome);
		WebDriver driver = bc.driver;
		driver.get("http://www.baidu.com");
		try {
			Thread.sleep(5000);
			driver.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
