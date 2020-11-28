package Stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public RemoteWebDriver driver;
	
	@Given("navigate to login page")
	public void navigate_to_login_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps/control/main");
	}

	@When("enter username {string} and password {string}")
	public void enter_username_and_password(String username, String password) {
		WebElement logo = driver.findElement(By.xpath("//img[contains(text(), logo)]"));
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@And("click login button")
	public void click_login_button() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@Then("page should login successfully")
	public void page_should_login_successfully() {
		String title= driver.getTitle();
	}

	@And("verify crmsfa enter button")
	public void verify_crmsfa_enter_button() {
		WebElement button =  driver.findElement(By.xpath("//input[@value='Logout']"));
	}

	@And("verify logout button")
	public void verify_logout_button() {
		String text = driver.findElement(By.xpath("//input[@type='submit']")).getAttribute("value");
		driver.close();
	}
	
}
