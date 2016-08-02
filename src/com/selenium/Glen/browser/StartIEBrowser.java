package com.selenium.Glen.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StartIEBrowser {
	private String projectPath = System.getProperty("user.dir");
	private DesiredCapabilities dc = null;
	private WebDriver driver;

	@BeforeClass
	public void StartBeforeIEBrowser() {
		System.setProperty("webdriver.ie.driver", projectPath+"\\src\\tools\\IEDriverServer.exe");
		dc = DesiredCapabilities.internetExplorer();
		dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true); // 忽略安全选项中保护模式
		dc.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private"); // 禁用IE缓存
		dc.setCapability("ignoreZoomSetting", true);
		// IE默认启动保护模式，要么手动在浏览器的设置中关闭保护模式，要么在代码中加上这一句，即可
		dc.setCapability("ignoreProtectedModeSettings", true);
		driver = new InternetExplorerDriver(dc);
	}

	@Test
	public void StartIEBr() {
		driver.manage().window().maximize(); // 屏幕最大化
		// driver.get("javascript:document.getElementId('overridelink').click()");
		// //取消安全证书提示
		driver.get("http://www.baidu.com/");
		System.out.println("start firefox browser succeed...");

		
	}
	
//	@AfterTest
//	public void afterTest(){
//		driver.close();
//	}

}
