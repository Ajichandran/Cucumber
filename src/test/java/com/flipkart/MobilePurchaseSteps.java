package com.flipkart;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MobilePurchaseSteps {
	static WebDriver driver;
	@Given("user launches flipkart application")
	public void user_launches_flipkart_application() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}

	@Given("user login into flipkart")
	public void user_login_into_flipkart() {
		 WebElement closebtn = driver.findElement(By.xpath("//button[text()='✕']"));
		  closebtn.click();
	}

	@When("user search mobile")
	public void user_search_mobile() {
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("Redmi");
		WebElement mobile = driver.findElement(By.xpath("//button[@type='submit']"));
		mobile.click();
        String s = mobile.getText();
        mobile.click();
	}
	@When("user choose mobile and doing payments")
	public void user_choose_mobile_and_doing_payments() {
		String parent = driver.getWindowHandle();
		 Set<String> child = driver.getWindowHandles();
		 for(String x : child) {
		 if(! x .equals(parent)) {
			 driver.switchTo().window(x);
			 System.out.println("window switched");
		 }
       }
	}

	@Then("user receive order confirmation message")
	public void user_receive_order_confirmation_message() {
		WebElement redmi = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
		String s = redmi.getText();
		System.out.println(s);
		redmi.click();
		
	}
	@When("user search mobile by using one dim list")
	public void user_search_mobile_by_using_one_dim_list(DataTable dataTable){
		
		List<String> asList = dataTable.asList();
		
		WebElement search =driver.findElement(By.name("q"));
		search.sendKeys(asList.get(0));
		WebElement mobile = driver.findElement(By.xpath("//button[@type='submit']"));
		mobile.click();
        String s = mobile.getText();
        mobile.click();
        driver.quit();
	}
	@When("user search mobile by using one dim map")
	public void user_search_mobile_by_using_one_dim_map(DataTable dataTable) {
		Map<String,String> asmap = dataTable.asMap(String.class, String.class); 
		WebElement search =driver.findElement(By.name("q"));
		search.sendKeys(asmap.get("Phone1"));
		WebElement mobile = driver.findElement(By.xpath("//button[@type='submit']"));
		mobile.click();
		WebElement redmi = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
		redmi.click();

	}
	@When("user search mobile {string}")
	public void user_search_mobile(String names) {
		WebElement search =driver.findElement(By.name("q"));
		search.sendKeys(names);
		WebElement redmi = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
		redmi.click();


		
	}

	}
	

