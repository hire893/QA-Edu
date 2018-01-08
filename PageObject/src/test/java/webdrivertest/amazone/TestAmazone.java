package webdrivertest.amazone;

import amazoneMapping.CartPage;
import amazoneMapping.ProductPage;
import amazoneMapping.SearchPage;
import amazoneMapping.StartPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestAmazone {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
    }

    @Before
    public void before() {
        System.setProperty("webdriver.chromedriver", "F:\\karas\\chromedriver.exe");
        driver.get("https://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }

    @Test
    public void test001Search() {
        StartPage startPage = new StartPage(driver);
        startPage.searchInput("duck");
        SearchPage searchPage = startPage.toSearchPage();
        for (WebElement element : searchPage.getSearchResults()) {
            Assert.assertTrue("Поиск работает неправильно! Следующая строка выдана неверно: " + element.getText(), element.getText().contains("duck") || element.getText().contains("Duck") || element.getText().contains("DUCK"));
        }
    }

    @Test
    public void test002Search() throws InterruptedException {
        StartPage startPage = new StartPage(driver);
        startPage.searchInput("Duck");
        SearchPage searchPage = startPage.toSearchPage();
        int res1 = searchPage.resultCountAfterSearch();
        startPage.babyFilter();
        startPage.toSearchPage();
        Thread.sleep(500);
        int res2 = searchPage.resultCountAfterSearch();
        Assert.assertTrue("Количество товаров после фильтрации, больше, чем во всем списке " + res1 + " > " + res2, res1 > res2);
    }

    @Test
    public void test003SearchAddToCart() {
        StartPage startPage = new StartPage(driver);
        startPage.searchInput("knife kitchen");
        SearchPage searchPage = startPage.toSearchPage();
        ProductPage productPage = searchPage.knifeSelect();
        String title = productPage.getProductTitle();
        double price = productPage.getPrice();
        productPage.addToCart();
        productPage.goMainPage();
        startPage.searchInput("duck");
        startPage.toSearchPage();
        searchPage.toRandomProductPage();
        String title2 = productPage.getProductTitle();
        double price2 = productPage.getPrice();
        productPage.addToCart();
        productPage.goMainPage();
        CartPage cartPage = startPage.toCart();
        double sum = 0;
        for (Double element : cartPage.getPriceProductsInCart()) {
            Assert.assertTrue("Цена товара в корзине не соответствует цене заказанного товара" + element.toString() + "не равно: " + price + "или: " + price2, element == price || element == price2);
            sum += element;
        }
        Assert.assertEquals("Сумма товаров в корзине" + sum + ", не равняется сумме заказанных товаров" + cartPage.getSumInCart(), cartPage.getSumInCart(), sum, 0.01);
        for (WebElement element : cartPage.getNameProductsInCart()) {
            Assert.assertTrue("Наименование товара в корзине не совпадает с заказанным товаром: " + element.getText() + "не равно: " + title + "или: " + title2, element.getText().equals(title) || element.getText().equals(title2));
        }
        Assert.assertFalse("Количество товаров в корзине не равняется двум", cartPage.getPriceProductsInCart().size() != 2);
    }

    @Test
    public void test004Delete() throws InterruptedException {
        StartPage startPage = new StartPage(driver);
        startPage.searchInput("knife kitchen");
        SearchPage searchPage = startPage.toSearchPage();
        ProductPage productPage = searchPage.toRandomProductPage();
        String name1 = productPage.getProductTitle();
        productPage.addToCart();
        productPage.goMainPage();
        startPage.searchInput("Jenga");
        startPage.toSearchPage();
        searchPage.toRandomProductPage();
        String name2 = productPage.getProductTitle();
        productPage.addToCart();
        productPage.goMainPage();
        startPage.searchInput("Ball");
        startPage.toSearchPage();
        searchPage.toRandomProductPage();
        String name3 = productPage.getProductTitle();
        productPage.addToCart();
        productPage.goMainPage();
        CartPage cartPage = startPage.toCart();
        cartPage.deleteSecondProductInCart();
        Thread.sleep(200);
        cartPage.refresh();
        List<WebElement> productInCart = cartPage.getNameProductsInCart();
        for (WebElement element : productInCart) {
            Assert.assertFalse("Attention! Deleted element in Cart" + element.getText() + "     " + name2, element.getText().equals(name2));
            Assert.assertTrue("Attention! Items in cart are invalid after deleting 2nd item" + element.getText() + "name 1:   " + name1 + "name3:  " + name3, element.getText().equals(name1) || element.getText().equals(name3));
        }
    }

    @Test
    public void test005UpdateQty() { //Ищем 3 товара, добавляем в корзину, изменяем количество. Проверяем, что сумма в корзине = сумме заказа
        StartPage startPage = new StartPage(driver);
//        CartPage cartPage = new CartPage(driver);
        startPage.searchInput("duck");
        SearchPage searchPage = startPage.toSearchPage();
        ProductPage productPage = searchPage.toRandomProductPage();
        productPage.setQty6();
        double sum1 = productPage.getPrice() * 6;
        productPage.addToCart();
        productPage.goMainPage();
        startPage.searchInput("tiger");
        startPage.toSearchPage();
        searchPage.toRandomProductPage();
        productPage.setQty3();
        double sum2 = productPage.getPrice() * 3;
        productPage.addToCart();
        productPage.goMainPage();
        startPage.searchInput("cat");
        startPage.toSearchPage();
        searchPage.toRandomProductPage();
        productPage.setQty2();
        double sum3 = productPage.getPrice() * 2;
        double orderSum = sum1 + sum2 + sum3;
        productPage.addToCart();
        productPage.goMainPage();
        CartPage cartPage = startPage.toCart();
        Assert.assertFalse("Сумма заказа в корзине " + cartPage.getSumInCart() + " не равна сумме всех заказанных товаров " + orderSum, cartPage.getSumInCart() != orderSum);
    }
}

