package com.selenium.Glen.browser;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StartIFireforeBrowser {
	public WebDriver ffwd = null;
	public FirefoxProfile firefoxProfile = null;
	public String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeTest() {
		System.setProperty("webdriver.firefox.bin", "E:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"); 
		File firebug = new File(projectPath+"\\src\\tools\\firebug@software.joehewitt.com.xpi"); 
		File firpath = new File(projectPath+"\\src\\tools\\FireXPath@pierre.tholence.com.xpi"); 
		
		firefoxProfile = new FirefoxProfile();
		
		try {
			firefoxProfile.addExtension(firpath);
			firefoxProfile.addExtension(firebug);
			firefoxProfile.setPreference("webdriver.accept.untrusted.certs", "true");
			firefoxProfile.setPreference("extensions.firebug.currentVersion", "2.0.16");
			firefoxProfile.setPreference("network.proxy.type", 0);
			firefoxProfile.setPreference("network.proxy.http", "10.1.1.0");
			firefoxProfile.setPreference("network.proxy.http_port", 3128);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ffwd = new FirefoxDriver(firefoxProfile);
	}
	
	@Test
	public void searchOnBaidu(){
		ffwd.manage().window().maximize();
		ffwd.get("http://www.baidu.com");
		//System.out.println(Locator.username1);
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void quitBr(){
		ffwd.quit();
	}
}
