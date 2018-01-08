package stackoverflowMapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

        private final WebDriver driver;

        public SignUpPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
            this.driver = driver;
        }
    @FindBy(xpath = ".//*[@id='openid-buttons']/div[contains(@class,'google')]")
    private WebElement googleButton;

    @FindBy(xpath = ".//*[@id='openid-buttons']/div[contains(@class,'facebook')]")
    private WebElement facebookButton;

    public boolean googleContains() {
        return googleButton.isDisplayed();
    }

    public boolean facebookContains() {
        return facebookButton.isDisplayed();
    }

}
