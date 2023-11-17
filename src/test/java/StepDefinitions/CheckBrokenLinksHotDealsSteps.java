package StepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HotDealsPage;
import tests.TestBase;

public class CheckBrokenLinksHotDealsSteps extends TestBase {
	HotDealsPage BrLinkHotDeals;

	@Given("the user opens the hot deals page URL {string}")
	public void the_user_opens_the_hot_deals_page_url(String url) {
		new TestBase().openPortal(url);
	}

	@When("checking for broken links in hot deals page")
	public void checking_for_broken_links_in_hot_deals_page() {
		BrLinkHotDeals = new HotDealsPage(driver);
		BrLinkHotDeals.checkForBorkenLinks();
	}

	@Then("the system shall contain only valid links in hot deals page")
	public void the_system_shall_contain_only_valid_links_in_hot_deals_page() {
		Assert.assertFalse(BrLinkHotDeals.isBrokenLinkHotDeals());
		driver.close();
	}
}
