package amazoneMapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SearchPage {
    private final WebDriver driver;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public List<WebElement> getSearchResults() {
        return searchResults;
    }

    @FindBy(xpath = ".//div[contains(@id,'atfResults')]/ul/li[position()>3 and position()<19]//h2")
    private List<WebElement> searchResults;

    @FindBy(xpath = ".//*[@id='s-result-count']")
    private List<WebElement> sResultCount;

    @FindBy(xpath = "//*[@id='s-results-list-atf']//h2[contains(text(),'8 Inch')]")
    private WebElement search8InchKnife;

    @FindBy(xpath = ".//*[@id='productTitle']")
    private WebElement productName;

    @FindBy(xpath = ".//*[@id='result_8']//h2")
    private WebElement product8;

    @FindBy(xpath = ".//*[@id='result_7']//h2")
    private WebElement product7;

    @FindBy(xpath = ".//*[@id='result_4']//h2")
    private WebElement product4;

    public int resultCountAfterSearch() {

        int count = 0;

        for (WebElement element : sResultCount) {
            List<String> parts = Arrays.asList(element.getText().split(" "));
            count = Integer.parseInt(parts.get(2).replace(",",""));
        }
        return count;
    }

    public ProductPage knifeSelect(){
        search8InchKnife.click()        ;
        return new ProductPage(driver);
    }

    public ProductPage toRandomProductPage() {
        Random random = new Random();
        WebElement randomElement = searchResults.get(random.nextInt(12));
        randomElement.click();
        return new ProductPage(driver);
    }

    public String getProductName(){
        return productName.getText();
    }

//    public ProductPage selectProduct8(){
//        product8.click();
//    }
//
//    public void selectProduct7(){
//        product7.click();
//    }
//
//    public ProductPage selectProduct4(){
//        product4.click();
//    }
}








