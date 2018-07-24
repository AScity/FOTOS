package com.lunova;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class FUaTest {
	private static WebDriver driver;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\Projects\\FUA\\chromedriver.exe");
        System.setProperty("webdriver.edge.driver", "D:\\Projects\\FUA\\MicrosoftWebDriver.exe");
        System.setProperty("webdriver.gecko.driver", "D:\\Projects\\FUA\\geckodriver.exe");
        System.setProperty("webdriver.opera.driver", "D:\\Projects\\FUA\\operadriver.exe");
       
        driver = new ChromeDriver();
        //driver = new EdgeDriver();
        // driver = new FirefoxDriver();
        //driver = new OperaDriver();
        
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://f.ua/");
    }

	@Test
	public void test() {	
		WebElement enterLink = driver.findElement(By.className("not_auth"));
		enterLink.click();
		
		WebElement form = driver.findElement(By.id("user_auth_form"));
		
		WebElement email = form.findElement(By.name("email"));
		email.sendKeys("nastiialu@gmail.com");
		
		WebElement password = form.findElement(By.name("password"));
		password.sendKeys("qwert123");
		
		WebElement logIn = form.findElement(By.xpath("//input[@type='submit' or value='Войти']"));
		logIn.submit();
		
		WebElement catalog = driver.findElement(By.id("ga-master-id"));
		catalog.click();
		
		WebElement teNoutPlanchet = catalog.findElement(By.cssSelector("#main_subrubrics_0 > ul > li:nth-child(1) > div > div.title > a"));
		teNoutPlanchet.click();
		
		WebElement mobTelAcesuar = driver.findElement(By.cssSelector("#show_subcategory_262 > div > div.title > a"));
		mobTelAcesuar.click();
		
		WebElement sensorTel = driver.findElement(By.cssSelector("#show_subcategory_262 > div > div.subcategories > div > ul > li:nth-child(3) > a"));
		sensorTel.click();
		
		WebElement produkt = driver.findElement(By.cssSelector("#item_4699184"));
		produkt.click();
		
		WebElement addMob = driver.findElement(By.cssSelector("#ga-master-id > div:nth-child(5) > div.main.width > div > div.center_wrapper.one_col > div > div > div:nth-child(1) > div.info > div.info_table > div.price_block > div.price_block_container > div.buy_button > a"));
		addMob.click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebElement bascet = driver.findElement(By.cssSelector("#popup_content > div > div.white_part > div > a"));
		bascet.click();
		
		WebElement asert = driver.findElement(By.cssSelector("#cart_container > table > tbody > tr:nth-child(2) > td.title > div > a"));
		WebElement asert1 = asert.findElement(By.linkText("Samsung Galaxy J5 J510H/DS Gold"));
		String text = asert1.getText();
		assertEquals("Samsung Galaxy J5 J510H/DS Gold", text);
		
		
		
		
			
		
	
		
	
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}


}
