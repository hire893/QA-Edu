package stackoverflowMapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class JobsPage {
    private final WebDriver driver;

    public JobsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = ".//*[@id='content']//span[@class='-salary']")
    private List<WebElement> salaryList;

    public double salaryBiggerThan60K() {
        double big = 0;
        double tmp = 0;
        for (WebElement element : salaryList) {
            if (element.getText().contains("$")) {
                tmp = CurrencyConverter.dollarToDollar(element.getText());
                if (tmp > big) big = tmp;
            }
            else if (element.getText().contains("€")) {tmp = CurrencyConverter.euroToDollar(element.getText());
            if (tmp > big) big = tmp;}
            else if (element.getText().contains("£")) {tmp = CurrencyConverter.funtToDollar(element.getText());{
                if (tmp > big) big = tmp;}
            }
            else continue;
        }
        return big;
    }
}



