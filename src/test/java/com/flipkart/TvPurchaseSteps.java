package com.flipkart;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class TvPurchaseSteps {
	
	@When("user search tv")
	public void user_search_tv() {
		WebElement search = MobilePurchaseSteps.driver.findElement(By.name("q"));
		search.sendKeys("LG Tv");
        WebElement tvName = MobilePurchaseSteps.driver.findElement(By.xpath("(//div[contains(text(),'LG OLED')])[1]"));
        String tn = tvName.getText();
        tvName.click();
	}

	@When("user choose the tv and doing payments")
	public void user_choose_the_tv_and_doing_payments() {
		String parent = MobilePurchaseSteps.driver.getWindowHandle();
		 Set<String> child = MobilePurchaseSteps.driver.getWindowHandles();
		 for(String x : child) {
		 if(! x .equals(parent)) {
			MobilePurchaseSteps.driver.switchTo().window(x);
			 System.out.println("window switched");
		 }
	}

	}
	@When("user search tv by using one dim list")
	public void user_search_tv_by_using_one_dim_list(DataTable dataTable) {
		List<String> asList = dataTable.asList();

		WebElement search = MobilePurchaseSteps.driver.findElement(By.name("q"));
		search.sendKeys("asList.get(0)");
        WebElement tvName = MobilePurchaseSteps.driver.findElement(By.xpath("(//div[contains(text(),'LG OLED')])[1]"));
		tvName.click();
	MobilePurchaseSteps.driver.quit();
	}
	@When("user search tv by using one dim map")
	public void user_search_tv_by_using_one_dim_map(DataTable dataTable) {
		Map<String,String> asmap = dataTable.asMap(String.class, String.class); 
		WebElement search = MobilePurchaseSteps.driver.findElement(By.name("q"));
		search.sendKeys(asmap.get("Tv1"));
		WebElement mobile =MobilePurchaseSteps. driver.findElement(By.xpath("//button[@type='submit']"));
		mobile.click();
		WebElement redmi = MobilePurchaseSteps. driver.findElement(By.xpath("(//div[contains(text(),'LG OLED')])[1]"));
		redmi.click();

		
	}

}






