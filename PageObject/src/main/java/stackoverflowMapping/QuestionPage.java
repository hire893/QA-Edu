package stackoverflowMapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuestionPage {
    private final WebDriver driver;

    public QuestionPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = ".//p[@class='label-key'][contains(text(),'asked')]//following::p[1]")
    private WebElement questionsDayMarker;

    public boolean isTodayQuestion(){
        return questionsDayMarker.getText().contains("today");
    }

}
