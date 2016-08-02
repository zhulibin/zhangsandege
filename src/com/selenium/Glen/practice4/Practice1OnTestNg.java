package com.selenium.Glen.practice4;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Practice1OnTestNg {
	
	/**
	 * 从xml配置文件中取出"<parameter name="TestData" value="\src\tools\test.properties" />"
	 * 的Value值,如果没有name="TestData"的值是空,那么取出的值是"aaa"
	 */
	@Parameters({"TestData"})
	@Test
	public void test1(@Optional("aaa")String testData){
			System.out.println("-------testData的值是--------");
			System.out.println(System.getProperty("user.dir")+testData);
	}
}
