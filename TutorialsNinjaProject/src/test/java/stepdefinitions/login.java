package stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
public class login {

	WebDriver driver;
	
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		
		driver = DriverFactory.getDriver();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
	
		
	}
	@When("User enters valid email address {string} into email field")
	public void user_enters_valid_email_address_into_email_field(String emailText) {
		
		driver.findElement(By.id("input-email")).sendKeys(emailText);
		
	    
	}

	@And("User enters valid password {string} into password field")
	public void user_enters_valid_password_into_password_field(String PasswordText) {
		
		driver.findElement(By.id("input-password")).sendKeys(PasswordText);
	    
	}

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
	
	    
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	    
	}



	@When("User enters invalid email address{string} to email field")
	public void user_enters_invalid_email_address_shobitha_gmail_com_to_email_field(String invalidEmailText) {
	    
		driver.findElement(By.id("input-email")).sendKeys(invalidEmailText);
	}

	@And("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidPasswordText) {
		
		
		driver.findElement(By.id("input-password")).sendKeys(invalidPasswordText);
	}

	

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
		
     Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
	
	}

	@When("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {
	    
		driver.findElement(By.id("input-email")).sendKeys("");
	}

	@And("User dont enter password  into password field")
	public void user_dont_enter_password_into_password_field() {
		
		driver.findElement(By.id("input-password")).sendKeys("");
	    
	}


}
