package webdrivertest.amazone;

import amazoneMapping.CartPage;
import amazoneMapping.ProductPage;
import amazoneMapping.SearchPage;
import amazoneMapping.StartPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestAmazone {
    private WebDriver driver;

    @Before
    public void Before() {
        System.setProperty("webdriver.chromedriver", "F:\\karas\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void After() {
        driver.quit();

    @Test
    public void Test001Search() {
        StartPage startPageDriver = new StartPage(driver);
        startPageDriver.findProduct("Duck");
        SearchPage searchPageDriver = new SearchPage(driver);
        for (WebElement element : searchPageDriver.getSearchResults()) {
            Assert.assertTrue("Поиск работает неправильно! Следующая строка выдана неверно: " + element.getText(), element.getText().contains("duck") || element.getText().contains("Duck") || element.getText().contains("DUCK"));
        }
    }

    @Test
    public void Test002Search() throws InterruptedException {
        StartPage startPageDriver = new StartPage(driver);
        startPageDriver.findProduct("Duck");
        SearchPage searchPageDriver = new SearchPage(driver);
        int res1 = searchPageDriver.resultCountAfterSearch();
        startPageDriver.babyFilter();
        startPageDriver.searchSubmitClick();
        Thread.sleep(500);
        int res2 = searchPageDriver.resultCountAfterSearch();
        Assert.assertTrue("Количество товаров после фильтрации, больше, чем во всем списке " + res1 + " > " + res2, res1 > res2);
    }

    @Test
    public void Test003SearchAndToCart() {
        StartPage startPageDriver = new StartPage(driver);
        startPageDriver.findProduct("knife kitchen");
        SearchPage searchPageDriver = new SearchPage(driver);
        searchPageDriver.knifeSelect();
        ProductPage productPageDriver = new ProductPage(driver);
        String title = productPageDriver.getProductTitle();
        double price = productPageDriver.getPrice();
        productPageDriver.addToCart();
        productPageDriver.goMainPage();
        startPageDriver.findProduct("duck");
        searchPageDriver.selectProduct7();
        String title2 = productPageDriver.getProductTitle();
        double price2 = productPageDriver.getPrice();
        productPageDriver.addToCart();
        productPageDriver.goMainPage();
        startPageDriver.toCart();
        CartPage cartPageDriver = new CartPage(driver);
        double sum = 0;
        for (Double element : cartPageDriver.getPriceProductsInCart()) {
            Assert.assertTrue("Цена товара в корзине не соответствует цене заказанного товара" + element.toString() + "не равно: " + price + "или: " + price2, element == price || element == price2);
            sum += element;
        }

        Assert.assertTrue("Сумма товаров в корзине, не равняется сумме заказанных товаров", cartPageDriver.getSumInCart() == sum);


        for (WebElement element : cartPageDriver.getNameProductsInCart()) {
            Assert.assertTrue("Наименование товара в корзине не совпадает с заказанным товаром: " + element.getText() + "не равно: " + title + "или: " + title2, element.getText().equals(title) || element.getText().equals(title2));
        }
        Assert.assertFalse("Количество товаров в корзине не равняется двум", cartPageDriver.getPriceProductsInCart().size() != 2);
    }

    @Test
    public void Test004Delete() throws InterruptedException {
        StartPage startPage = new StartPage(driver);
        startPage.findProduct("knife kitchen");
        SearchPage searchPage = new SearchPage(driver);
        searchPage.selectProduct7();
        ProductPage productPage = new ProductPage(driver);
        String name1 = productPage.getProductTitle();
        productPage.addToCart();
        productPage.goMainPage();
        startPage.findProduct("Jenga");
        searchPage.selectProduct8();
        String name2 = productPage.getProductTitle();
        productPage.addToCart();
        productPage.goMainPage();
        startPage.findProduct("Ball");
        searchPage.selectProduct4();
        String name3 = productPage.getProductTitle();
        productPage.addToCart();
        productPage.goMainPage();
        startPage.toCart();
        CartPage cartPage = new CartPage(driver);
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
    public void Test005Updateqty() { //Ищем 3 товара, добавляем в корзину, изменяем количество. Проверяем, что сумма в корзине = сумме заказа
        StartPage startPage = new StartPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        startPage.findProduct("duck");
        searchPage.selectProduct4();
        productPage.setQty6();
        double sum1 = productPage.getPrice() * 6;
        productPage.addToCart();
        productPage.goMainPage();
        startPage.findProduct("tiger");
        searchPage.selectProduct7();
        productPage.setQty3();
        double sum2 = productPage.getPrice() * 3;
        productPage.addToCart();
        productPage.goMainPage();
        startPage.findProduct("cat");
        searchPage.selectProduct4();
        productPage.setQty2();
        double sum3 = productPage.getPrice() * 2;
        double orderSum = sum1 + sum2 + sum3;
        productPage.addToCart();
        productPage.goMainPage();
        startPage.toCart();
        Assert.assertFalse("Сумма заказа в корзине " + cartPage.getSumInCart() + " не равна сумме всех заказанных товаров " + orderSum, cartPage.getSumInCart() != orderSum);
    }
}

