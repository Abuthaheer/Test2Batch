package objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject extends BasePage {

	@FindBy(xpath = "(.//*[text()='Dresses'])[2]")
	private WebElement tabDresses;

	@FindBys(@FindBy(xpath = "//ul[@id='homefeatured']/li"))
	private List<WebElement> lstProducts;

	public HomePageObject() {
		PageFactory.initElements(driver, this);
	}

	public void clickDressesTab() {
		tabDresses.click();
	}

	public List<WebElement> getProduct() {
		return lstProducts;
	}

	public boolean verifyAddToCart(WebElement parent) {
		return elementFound(parent.findElement(By.xpath(".//*[text()='Add to cart']")));
	}
	
	public String getProductName(WebElement parent){
		return parent.findElement(By.xpath(".//*[@class='product-name']")).getText();
	}

}
