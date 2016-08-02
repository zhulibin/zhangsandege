package com.selenium.Glen.BrowserCompitable;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserCompatible {
	public String projectPath = System.getProperty("user.dir");
	public DesiredCapabilities dc = null;
	public WebDriver driver = null;
	
	public BrowserCompatible(String browserType){
		switch (browserType) {
		case "IE":
			System.setProperty("webdriver.ie.driver", projectPath+"\\src\\tools\\IEDriverServer.exe");
			dc = DesiredCapabilities.internetExplorer();
			dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true); // 忽略安全选项中保护模式
			dc.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private"); // 禁用IE缓存
			dc.setCapability("ignoreZoomSetting", true);
			// IE默认启动保护模式，要么手动在浏览器的设置中关闭保护模式，要么在代码中加上这一句，即可
			dc.setCapability("ignoreProtectedModeSettings", true);
			driver = new InternetExplorerDriver(dc);
			break;
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", projectPath+"\\src\\tools\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("-test-type"); 
			options.addArguments("--start-maximized");
			options.addArguments("--proxy-server=http://your-proxy-domain:4443");
			driver = new ChromeDriver(options);
			break;
		case "Firefox":
			System.setProperty("webdriver.firefox.bin", "E:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"); 
			File firebug = new File(projectPath+"\\src\\tools\\firebug@software.joehewitt.com.xpi"); 
			File firpath = new File(projectPath+"\\src\\tools\\FireXPath@pierre.tholence.com.xpi"); 
			
			FirefoxProfile firefoxProfile = new FirefoxProfile();
			
			try {
				firefoxProfile.addExtension(firpath);
				firefoxProfile.addExtension(firebug);
				firefoxProfile.setPreference("webdriver.accept.untrusted.certs", "true");
				firefoxProfile.setPreference("extensions.firebug.currentVersion", "2.0.16");
//				firefoxProfile.setPreference("network.proxy.type", 0);
//				firefoxProfile.setPreference("network.proxy.http", "10.1.1.0");
//				firefoxProfile.setPreference("network.proxy.http_port", 3128);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			driver = new FirefoxDriver(firefoxProfile);
			break;	
		}
	}
	
	
}
