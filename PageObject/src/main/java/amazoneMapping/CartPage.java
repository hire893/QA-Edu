package amazoneMapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CartPage {
    private final WebDriver driver;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = ".//*[@id='activeCartViewForm']//span[contains(@class,'sc-product-title')]")
    private List<WebElement> nameProductsInCart;

    @FindBy(xpath = ".//*[@id='sc-subtotal-amount-activecart']/span")
    private WebElement sumInCart;

   @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
   @FindBy(xpath = ".//*[@id='activeCartViewForm']//span[contains(@class,'sc-product-price')]")
    private List<WebElement> priceProductsInCart;

    @FindBy(xpath = ".//*[@id='activeCartViewForm']/div[2]/div[2]//input[contains(@value,'Delete')]")
    private WebElement deleteSecondElementButton;

    public void refresh(){
        getDriver().navigate().refresh();
    }

    public void deleteSecondProductInCart(){
        getDeleteSecondElementButton().click();
    }

    public List<WebElement> getNameProductsInCart() {
        return nameProductsInCart;
    }

    public List<Double> getPriceProductsInCart() {
        List<Double> price = new ArrayList<Double>();
        for (WebElement element : priceProductsInCart
                ) {
            price.add(Double.parseDouble(element.getText().replace("$", "")));
        }
        return price;
    }

    public double getSumInCart() {
        String str = sumInCart.getText().replace("$","");
        return Double.parseDouble(str);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setNameProductsInCart(List<WebElement> nameProductsInCart) {
        this.nameProductsInCart = nameProductsInCart;
    }

    public void setSumInCart(WebElement sumInCart) {
        this.sumInCart = sumInCart;
    }

    public void setPriceProductsInCart(List<WebElement> priceProductsInCart) {
        this.priceProductsInCart = priceProductsInCart;
    }

    public WebElement getDeleteSecondElementButton() {
        return deleteSecondElementButton;
    }

    public void setDeleteSecondElementButton(WebElement deleteSecondElementButton) {
        this.deleteSecondElementButton = deleteSecondElementButton;
    }
}
