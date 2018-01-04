package amazoneMapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    private final WebDriver driver;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = ".//*[@id='priceblock_ourprice']")
    private WebElement productPrice;

    @FindBy(xpath = ".//*[@id='add-to-cart-button']")
    private WebElement addToCartButton;

    @FindBy(xpath = ".//*[@id='quantity']")
    private WebElement changeQty;

    @FindBy(xpath = ".//*[@id='productTitle']")
    private WebElement productTitle;

    @FindBy(xpath = ".//*[@id='quantity']/option[@value,2]")
    private WebElement qty2;

    @FindBy(xpath = ".//*[@id='quantity']/option[@value,3]")
    private WebElement qty3;

    @FindBy(xpath = ".//*[@id='quantity']/option[@value,6]")
    private WebElement qty6;

    @FindBy(xpath = ".//*[@id='nav-logo']/a/span[contains(text(),'Amazon')]")
    private WebElement siteLogo;

//    public WebElement getProductTitle() {
//        return productTitle;
//    }

    public void setQty6()  {
        changeQty.sendKeys("6");
    }

    public void setQty2()  {
        changeQty.sendKeys("2");
    }

    public void setQty3()  {
        changeQty.sendKeys("3");
    }
    public double getPrice() {
        String s = productPrice.getText().replace("$", "");
        return Double.parseDouble(s);
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

    public void goMainPage() {
        siteLogo.click();
    }


}

