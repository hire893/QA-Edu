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

<<<<<<< HEAD
    @FindBy(xpath = ".//*[@id='quantity']/option[@value,2]")
    private WebElement qty2;
=======
<<<<<<< HEAD
    @FindBy(xpath = ".//*[@id='quantity']/option[@value,2]")
    private WebElement qty2;
=======
    @FindBy(xpath = ".//*[@id='quantity']/option[@value,1]")
    private WebElement qty1;
>>>>>>> cf9e1e6fb1624b034394cee12db0584e48f85520
>>>>>>> 30c1821011eb72e30d615cd918be64caa75ba454

    @FindBy(xpath = ".//*[@id='quantity']/option[@value,3]")
    private WebElement qty3;

    @FindBy(xpath = ".//*[@id='quantity']/option[@value,6]")
    private WebElement qty6;

    @FindBy(xpath = ".//*[@id='nav-logo']/a/span[contains(text(),'Amazon')]")
    private WebElement siteLogo;

<<<<<<< HEAD
=======
//    public WebElement getProductTitle() {
//        return productTitle;
//    }

<<<<<<< HEAD
>>>>>>> 30c1821011eb72e30d615cd918be64caa75ba454
    public void setQty6()  {
        changeQty.sendKeys("6");
    }

    public void setQty2()  {
        changeQty.sendKeys("2");
    }

    public void setQty3()  {
        changeQty.sendKeys("3");
    }
<<<<<<< HEAD

=======
=======
>>>>>>> cf9e1e6fb1624b034394cee12db0584e48f85520
>>>>>>> 30c1821011eb72e30d615cd918be64caa75ba454
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

