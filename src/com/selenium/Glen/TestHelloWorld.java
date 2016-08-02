package com.selenium.Glen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestHelloWorld {

    public static void main(String[] args) {
    	//StartIEAndCloseProtectedMode();

    }
    
        /**
         * 启动IE浏览器
         */
        public static void StartFirefoxAndCloseProtectMode(){
            
            //如果火狐浏览器没有默认安装在C盘，需要制定其路径
            System.setProperty("webdriver.firefox.bin", "E:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"); 
            WebDriver driver = new FirefoxDriver();
            driver.get("http://www.baidu.com/");
            
            driver.manage().window().maximize();
            
            WebElement txtbox = driver.findElement(By.name("wd"));
            txtbox.sendKeys("Glen");
            
            WebElement btn = driver.findElement(By.id("su"));
            btn.click();
            
            driver.close();
        }

}