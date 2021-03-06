package amazoneMapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage {
    private final WebDriver driver;

    public StartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = ".//*[@id='twotabsearchtextbox']")
    private WebElement searchField;

    @FindBy(xpath = ".//*[@id='nav-search']//input[@type='submit']")
    private WebElement searchSubmit;

    @FindBy(xpath = ".//*[@id='nav-cart']")
    private WebElement cartLink;

    @FindBy(xpath = ".//*[@id='searchDropdownBox']/option[@value = 'search-alias=baby-products']")
    private WebElement searchForBaby;

    public void searchInput(String text) {
        searchField.sendKeys(text);
    }

    public SearchPage toSearchPage() {
        searchSubmit.click();
        return new SearchPage(driver);
    }

    public void babyFilter() {
        searchForBaby.click();
    }

    public CartPage toCart() {
        cartLink.click();
        return new CartPage(driver);
    }
}