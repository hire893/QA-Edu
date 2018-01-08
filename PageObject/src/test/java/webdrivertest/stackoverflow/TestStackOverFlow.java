package webdrivertest.stackoverflow;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import stackoverflowMapping.JobsPage;
import stackoverflowMapping.MainPage;
import stackoverflowMapping.QuestionPage;
import stackoverflowMapping.SignUpPage;
import java.util.concurrent.TimeUnit;

public class TestStackOverFlow {
    private WebDriver driver;

    @Before
    public void before() {
        System.setProperty("webdriver.chromedriver", "F:\\karas\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://stackoverflow.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void after() {
        driver.quit();
    }

    @Test
    public void testOfFeaturesTab() {
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue("Количество фич" + mainPage.getTabFeatured() + " не больше 300 ", mainPage.getTabFeatured() > 300);
    }

    @Test
    public void testGoogleFacebookButtonOnSignupPage() {
        MainPage mainPage = new MainPage(driver);
        SignUpPage signUpPage = mainPage.tooSignUpPage();
        Assert.assertTrue("Кнопка facebook не отображается", signUpPage.facebookContains());
        Assert.assertTrue("Кнопка google не отображается", signUpPage.googleContains());
    }

    @Test
    public void testPostDay() {
        MainPage mainPage = new MainPage(driver);
        QuestionPage questionPage = mainPage.clickRandomQuestion();
        Assert.assertTrue("вопрос не был создан сегодня", questionPage.isTodayQuestion());
    }

    @Test
    public void testJobSalary() {
        MainPage mainPage = new MainPage(driver);
        JobsPage jobsPage = mainPage.toJobsPage();
        Assert.assertTrue("Нет зарплаты больше 60К у.е. Наибольшая зп = " + jobsPage.salaryBiggerThan60K(), jobsPage.salaryBiggerThan60K()>60.0);
    }

    
}
