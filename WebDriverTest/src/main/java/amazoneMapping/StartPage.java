package amazoneMapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage {
    private WebDriver driver;
    public StartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(xpath = ".//*[@id='twotabsearchtextbox']")
    public WebElement searchField;

    @FindBy(xpath = ".//*[@id='nav-search']//input[@type='submit']")
    public WebElement searchSubmit;

}
