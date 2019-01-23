package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import objects.DressesPageObject;
import objects.HomePageObject;

public class DressesPageTests {

	HomePageObject hp;
	DressesPageObject dp;

	public DressesPageTests() {
		hp = new HomePageObject();
		dp = new DressesPageObject();
	}

	@BeforeMethod
	public void beforePreReq() {
		hp.clickDressesTab();
	}

	@Test
	public void verifyProductCount() {
		Assert.assertEquals(dp.getProductCountFromHeaderText(), dp.getProductCount(), "Failed: Count mismatched");
	}

	@Test
	public void verifyPriceInAscendingOrder() {
		dp.selectSortOption("price:asc");
		List<Double> prices = dp.getProductPrices();

		for (int index = 0; index < prices.size() - 1; index++) {
			System.out.println("Price " + prices.get(index));
			Assert.assertTrue(prices.get(index) < prices.get(index + 1),
					"Failed: price not in ascending order at index" + index);

		}

	}

	@Test
	public void verifyProductNamesInAscendingOrder() {
		hp.clickDressesTab();
		dp.selectSortOption("name:asc");
		List<String> names = dp.getProductNames();
		for (int i = 0; i < names.size() - 1; i++) {
			System.out.println(names.get(i).compareTo(names.get(i + 1)));
			Assert.assertTrue(names.get(i).compareTo(names.get(i + 1)) <= 0,
					"Not in ascending order and the product name is " + names.get(i));
		}

	}

}
