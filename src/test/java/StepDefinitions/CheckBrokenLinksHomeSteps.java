package StepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import tests.TestBase;

public class CheckBrokenLinksHomeSteps extends TestBase{
	
	HomePage BrLinkHome;
	@Given("the user opens the home page URL {string}")
	public void the_user_opens_the_home_page_url(String url) {
		new TestBase().openPortal(url);
	}

	@When("checking for broken links")
	public void checking_for_broken_links() {
		BrLinkHome = new HomePage(driver);
		BrLinkHome.checkForBorkenLinks();
	}

	@Then("the system shall contain only valid links")
	public void the_system_shall_contain_only_valid_links() {
		Assert.assertFalse(BrLinkHome.isBrokenLinkHome());
		driver.close();
	}

}




