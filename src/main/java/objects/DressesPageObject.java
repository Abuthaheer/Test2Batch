package objects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class DressesPageObject extends BasePage {

	@FindBy(xpath = "//*[@class='heading-counter']")
	private WebElement productHeader;

	@FindBys(@FindBy(xpath = "//ul[@class='product_list grid row']/li"))
	private List<WebElement> lstProducts;

	@FindBy(id = "selectProductSort")
	private WebElement dropDownSort;

	@FindBys(@FindBy(xpath = "//*[@class='right-block']//*[@class='price product-price']"))
	private List<WebElement> lstProductPrices;

	@FindBy(xpath = ".//img[contains(@*,'load')]")
	private WebElement iconLoad;

	@FindBys(@FindBy(xpath = "//div[@class='right-block']//*[@class='product-name']"))
	private List<WebElement> lstProductName;
	
	
	

	public DressesPageObject() {
		PageFactory.initElements(driver, this);
	}

	public int getProductCountFromHeaderText() {

		/*
		 * String txt = productHeader.getText(); String[] arr = txt.split(" ");
		 * String number = arr[2]; int value = Integer.parseInt(number); return
		 * value;
		 */

		return Integer.parseInt(productHeader.getText().split(" ")[2]);
	}

	public int getProductCount() {
		return lstProducts.size();
	}

	public String selectSortOption(String input) {
		return selectFromDropDown(dropDownSort, input);
	}

	public List<Double> getProductPrices() {
		List<Double> lst = new ArrayList<Double>();
		isElementVisible(iconLoad);
		isElementInVisible(iconLoad);

		for (WebElement e : lstProductPrices) {
			String txt = e.getText();
			txt = txt.replace("$", "").trim();
			Double b = Double.parseDouble(txt);
			lst.add(b);

			// lst.add(Double.parseDouble(e.getText().replace("$", "").trim()));
		}
		return lst;
	}

	public List<String> getProductNames() {
		ArrayList<String> productNames = new ArrayList<String>();
		isElementVisible(iconLoad);
		isElementInVisible(iconLoad);
		for (WebElement e : lstProductName) {
			String txt = e.getText();
			productNames.add(txt.trim());
		}
		return productNames;
	}

}
