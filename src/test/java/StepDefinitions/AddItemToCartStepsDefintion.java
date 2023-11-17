package StepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.HomePage;
import pages.HotDealsPage;
import pages.ItemDetailsPage;
import tests.TestBase;

public class AddItemToCartStepsDefintion extends TestBase {
	HotDealsPage hotDeals;
	CartPage cart;
	ItemDetailsPage itemDetails;
	String name = "";
	String price = "";

	@Given("the user opens the portal URL {string}")
	public void the_user_opens_the_portal_url(String url) throws IOException {
		new TestBase().openPortal(url);
	}

	@And("scrolls down to Hot deals sections")
	public void scrolls_down_to_hot_deals_sections() throws InterruptedException {
		new HomePage(driver).scrollToHotDeals();
	}

	@And("clicks to view all items in the Hot deals sections")
	public void clicks_to_view_all_items_in_the_hot_deals_sections() {
		new HomePage(driver).clickOnViewAllButton();
	}

	@When("clicks to view the details of any item")
	public void clicks_to_view_the_details_of_any_item() {

		hotDeals = new HotDealsPage(driver);
		itemDetails = new ItemDetailsPage(driver);
		name = hotDeals.getItemName();
		price = hotDeals.getItemPrice();
		hotDeals.clickOnItem();

		Assert.assertTrue(name.equals(itemDetails.getItemName()));
		Assert.assertTrue(price.equals(itemDetails.getItemPrice()));
	}

	@And("the user clicks to add the item to the cart")
	public void the_user_clicks_to_add_the_item_to_the_cart() {

		itemDetails.addItemToCart();
	}

	@And("opens the cart from the header")
	public void opens_the_cart_from_the_header() {

		itemDetails.clickOnCart();
	}

	@Then("the item will be displayed with same price and same number of items added")
	public void the_item_will_be_displayed_with_same_price_and_same_number_of_items_added() {
		cart = new CartPage(driver);
		Assert.assertTrue(name.equals(cart.getItemName()));
		Assert.assertTrue(price.equals(cart.getItemPrice()));
		cart.isQtyDisplayed();
		driver.close();
	}
}
