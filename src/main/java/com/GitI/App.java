package com.GitI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

/**
 * GIT url Test!
 *
 */
public class App {

	public static void main(String args[]) throws Exception {
 //Browser initialization
		System.setProperty("webdriver.chrome.driver", ".\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
 //open App	
		driver.get("https://github.com/");
		//System.out.println(driver.getTitle());
		//Assert.assertEquals("The world’s leading software development platform · GitHub", driver.getTitle());
		
 //data from local file
        File file = new File(".\\src\\properties\\appConfig.properties");
        BufferedReader br = new BufferedReader(new FileReader(file));
        Properties pr = new Properties();
        pr.load(br);
        String User_ID=pr.getProperty("USERNAME");
        String User_Password=pr.getProperty("PASSWORD");		
 //Functionality Test
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("login_field")).sendKeys(User_ID);
        driver.findElement(By.id("password")).sendKeys(User_Password);
        driver.findElement(By.name("commit")).click();
 //Close Browser       
		driver.quit();

	}
}