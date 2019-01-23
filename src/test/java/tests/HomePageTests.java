package tests;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import objects.HomePageObject;

public class HomePageTests {

	HomePageObject hp;
	
	int value = new Random().nextInt(70000);
	String email = "TestAbuAutomation" + value + "@gmail.com";
	

	public HomePageTests() {
		hp = new HomePageObject();
	}

	@Test
	public void verifyAddToCartButton() {
		List<WebElement> products = hp.getProduct();
		for (WebElement prod : products) {
			Assert.assertTrue(hp.verifyAddToCart(prod),
					"Failed: Add to cart button is not present for the product" + hp.getProductName(prod));
		}

	}

}
