package stackoverflowMapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = ".//*[@id='search']/input")
    private WebElement searchForm;

    @FindBy(xpath = ".//*[@id='tabs']//span[contains(@class,'bounty-indicator-tab')]")
    private WebElement tabFeatured;

    @FindBy(xpath = ".//a[contains(@class,'login-link btn-topbar-primary')]")
    private WebElement signUpButton;

    @FindBy(xpath = ".//div[@class='question-summary narrow']//h3/a")
    private List<WebElement> listOfQuestions;

    @FindBy(xpath = ".//*[@id='nav-jobs']")
    private WebElement jobButton;


    public int getTabFeatured() {
        return Integer.parseInt(tabFeatured.getText());
    }

    public SignUpPage tooSignUpPage() {
        signUpButton.click();
        return new SignUpPage(driver);
    }

    public QuestionPage clickRandomQuestion() {
        Random random = new Random();
        WebElement randomElement = listOfQuestions.get(random.nextInt(90));
        randomElement.click();
        return new QuestionPage(driver);
    }

    public JobsPage toJobsPage(){
        jobButton.click();
        return new JobsPage(driver);
    }


}
