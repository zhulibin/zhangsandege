package com.selenium.Glen.browser;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StartChromeBrowser {
	private WebDriver chromeWD = null;
	//private DesiredCapabilities capabilities =null;
	private String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeStartBrowser(){
		System.setProperty("webdriver.chrome.driver", projectPath+"\\src\\tools\\chromedriver.exe");
//		capabilities = DesiredCapabilities.chrome();
//		capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
//		capabilities.setCapability("chrome.switches", Arrays.asList("--proxy-server=http://your-proxy-domain:4443"));
		
		//option可以替代DesiredCapabilities针对浏览器设置属性
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-test-type"); 
		options.addArguments("--start-maximized");
		options.addArguments("--proxy-server=http://your-proxy-domain:4443");
		chromeWD = new ChromeDriver(options);
	}
	
	@Test
	public void startChrome(){
		chromeWD.get("http://www.baidu.com");
		
	}
//	
//	@AfterTest
//	public void endChrome(){
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		chromeWD.close();
//	}
}
