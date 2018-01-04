package webdrivertest.amazone;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestAmazone {
    private static WebDriver driver;
    private WebElement searchForm;
    private WebElement lupa;
    private WebElement addToCart;

    @Before
    public void Before() {
        System.setProperty("webdriver.chromedriver", "F:\\karas\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        searchForm = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        lupa = driver.findElement(By.xpath(".//input[@class='nav-input' and @type='submit']"));
    }

    // @After
    //public void After() {
    //    driver.close();
    //  }

    @Test
    public void Test001Search() {
        searchForm.sendKeys("duck");
        lupa.click();
        List<WebElement> result = driver.findElements(By.xpath("//div[contains(@id,'atfResults')]/ul/li[position()>3 and position()<19]//h2"));
        for (WebElement element : result) {
            Assert.assertTrue("Поиск работает неправильно! Следующая строка выдана неверно: " + element.getText(), element.getText().contains("duck") || element.getText().contains("Duck") || element.getText().contains("DUCK"));
            //System.out.println(element.getText());
        }
    }

    @Test
    public void Test002Search() {
        int numForAll = 0;
        int numForKids = 0;
        String str;
        searchForm.sendKeys("duck");
        lupa.click();
        List<WebElement> result = driver.findElements(By.xpath(".//*[@id='s-result-count']"));
        for (WebElement element : result) {
            str = element.getText();
            // System.out.println(element.getText());
            String[] strarray1 = str.split(" ", 5);
            strarray1[2] = strarray1[2].replaceAll(",", "");
            // System.out.println(strarray1[2]);
            numForAll = Integer.parseInt(strarray1[2]);
            // System.out.println(numForAll);
        }
        driver.findElement(By.xpath(".//*[contains(text(),'Baby Products')]/parent::div")).click();
        //driver.findElement(By.xpath("//div[contains(@id,'atfResults')]/ul/li//h2"));
        List<WebElement> qty = driver.findElements(By.xpath(".//*[@id='s-result-count']"));
        for (WebElement el1 : qty) {
            str = el1.getText();
            // System.out.println(str);
            String[] words = str.split(" ", 5);
            // System.out.println(words[2]);
            words[2] = words[2].replaceAll(",", "");
            numForKids = Integer.parseInt(words[2]);
            // System.out.println(numForKids);
        }
        Assert.assertTrue("Количество товаров после фильтрации, больше, чем во всем списке " + numForKids + " > " + numForAll, numForAll > numForKids);
    }

    @Test
    public void Test003Search() {
        //Search, add to cart, name&price save for knife
        searchForm.sendKeys("knife kitchen");
        lupa.click();
        driver.findElement(By.xpath("//*[@id='s-results-list-atf']//h2[contains(text(),'8 Inch')]")).click();
        WebElement webName = driver.findElement(By.xpath(".//*[@id='productTitle']"));
        String name = webName.getText();
        addToCart = driver.findElement(By.xpath(".//*[@id='add-to-cart-button']"));
        addToCart.click();
        WebElement price = driver.findElement(By.xpath(".//*[@id='hlb-subcart']//span[@class='a-color-price hlb-price a-inline-block a-text-bold']"));
        double doublePrice = Double.parseDouble(price.getText().replace("$", ""));
        //System.out.println(doublePrice);
// Search, add to cart, name&price save for duck
        driver.get("https://www.amazon.com/");
        searchForm = driver.findElement(By.id("twotabsearchtextbox"));
        searchForm.sendKeys("duck");
        searchForm.submit();
        driver.findElement(By.xpath(".//*[@id='result_0']//h2")).click();
        WebElement webNameDuck = driver.findElement(By.xpath(".//*[@id='productTitle']"));
        String nameDuck = webNameDuck.getText();
        WebElement priceDuck = driver.findElement(By.xpath(".//*[@id='priceblock_ourprice']"));
        double doublePriceDuck = Double.parseDouble(priceDuck.getText().replace("$", ""));
        //System.out.println(doublePriceDuck);
        driver.findElement(By.xpath(".//*[@id='add-to-cart-button']")).click();
// Check Cart
        driver.findElement(By.xpath(".//*[@id='nav-cart']")).click();
        List<WebElement> cartItems = driver.findElements(By.xpath(".//*[@id='activeCartViewForm']//span[contains(@class,'sc-product-title')]"));
        for (WebElement element : cartItems) {

            // System.out.println(element.getText());
//check the name of items in the cart
            Assert.assertTrue("Ordered items are not equal the items in the cart:" + element.getText(), element.getText().equals(name) || element.getText().equals(nameDuck));
        }
        Assert.assertFalse("q-ty of elements is invalid", cartItems.size() != 2); //check the qty in the cart
        String sSumInCart = driver.findElement(By.xpath(".//*[@id='sc-subtotal-amount-activecart']/span")).getText().replace("$", "");
        double sumInCart = Double.parseDouble(sSumInCart);
        double countedSum = doublePrice + doublePriceDuck;
        Assert.assertEquals("Sum is invalid" + sumInCart + "not equal" + doublePriceDuck + "+" + doublePrice, sumInCart, countedSum, 0.01);
    }

    @Test
    public void Test004Deleting() {
        searchForm.sendKeys("jenga");
        searchForm.submit();
        WebElement webElem1 = driver.findElement(By.xpath(".//*[@id='result_6']//h2"));
        String nameFirst = webElem1.getText();
        driver.findElement(By.xpath(".//*[@id='result_6']//h2")).click();
        driver.findElement(By.xpath(".//*[@id='add-to-cart-button']")).click();
        driver.navigate().back();
        driver.navigate().back();
        WebElement webElem2 = driver.findElement(By.xpath(".//*[@id='result_3']//h2"));
        String nameSec = webElem2.getText();
        driver.findElement(By.xpath(".//*[@id='result_3']//h2")).click();
        driver.findElement(By.xpath(".//*[@id='add-to-cart-button']")).click();
        driver.navigate().back();
        driver.navigate().back();
        WebElement webElem3 = driver.findElement(By.xpath(".//*[@id='result_1']//h2"));
        String nameThird = webElem3.getText();
        driver.findElement(By.xpath(".//*[@id='result_1']//h2")).click();
        driver.findElement(By.xpath(".//*[@id='add-to-cart-button']")).click();
        driver.navigate().back();
        driver.navigate().back();
        driver.findElement(By.xpath(".//*[@id='nav-cart']")).click();
        List<WebElement> cartItems = driver.findElements(By.xpath(".//*[@id='activeCartViewForm']//span[contains(@class,'sc-product-title')]"));
        for (WebElement element : cartItems) {
            Assert.assertTrue("Error", element.getText().equals(nameFirst) || element.getText().equals(nameSec) || element.getText().equals(nameThird));
        }
        driver.findElement(By.xpath(".//*[@id='activeCartViewForm']/div[2]/div[2]//input[contains(@value,'Delete')]")).click();
        driver.findElement(By.xpath(".//*[@id='nav-cart']")).click();
        List<WebElement> cartItemsAfterDelete = driver.findElements(By.xpath(".//*[@id='activeCartViewForm']//span[contains(@class,'sc-product-title')]"));
        for (WebElement element : cartItemsAfterDelete) {
            Assert.assertFalse("Attention! Deleted element in Cart" + element.getText(), element.getText().equals(nameSec));
            Assert.assertTrue("Attention! Items in cart are invalid after deleting 2nd item", element.getText().equals(nameFirst) || element.getText().equals(nameThird));
        }
    }

    @Test
    public void Test005ChangeCount() { //Добавляем 2 товара в корзину, запоминаем цены, изменяем количество первого на 6, второго на 2 - проверяем общую сумму
        searchForm.sendKeys("Duck");
        searchForm.submit();
        driver.findElement(By.xpath(".//*[@id='result_8']//h2")).click();
        WebElement wPrice1 = driver.findElement(By.xpath(".//*[@id='priceblock_ourprice']"));
        double price1 = Double.parseDouble(wPrice1.getText().replace("$", ""));
        driver.findElement(By.xpath(".//*[@id='add-to-cart-button']")).click();
        driver.findElement(By.xpath(".//*[@id='nav-logo']/a/span[contains(text(),'Amazon')]")).click();
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("PowerGrid");
        driver.findElement(By.xpath(".//input[@class='nav-input' and @type='submit']")).click();
        driver.findElement(By.xpath(".//*[@id='result_1']//h2")).click();
        WebElement wPrice2 = driver.findElement(By.xpath(".//*[@id='priceblock_ourprice']"));
        double price2 = Double.parseDouble(wPrice2.getText().replace("$", ""));
        driver.findElement(By.xpath(".//*[@id='add-to-cart-button']")).click();
        driver.findElement(By.xpath(".//*[@id='nav-cart']")).click();
        driver.findElement(By.xpath(".//*[@id='a-autoid-0-announce']")).click();
        driver.findElement(By.xpath(".//*[@id='dropdown1_5']")).click();
        driver.findElement(By.xpath(".//*[@id='nav-cart']")).click();
        driver.findElement(By.xpath("//*[@id='a-autoid-2-announce']")).click();
       // driver.findElement(By.xpath(".//*[@id=a-autoid-2-announce]")).click();
        driver.findElement(By.xpath(".//*[@id='dropdown1_2']")).click();
        driver.findElement(By.xpath(".//*[@id='nav-cart']")).click();
        List<WebElement> cartPrice = driver.findElements(By.xpath(".//*[@id='activeCartViewForm']//span[contains(@class,'sc-product-price')]"));
        double cartPrice1 = Double.parseDouble(cartPrice.get(0).getText().replace("$", ""));
        double cartPrice2 = Double.parseDouble(cartPrice.get(1).getText().replace("$", ""));
        System.out.println(cartPrice1);
        System.out.println(price1);
        System.out.println(cartPrice2);
        System.out.println(price2);
        Assert.assertTrue("Items in the card have another price", (cartPrice1 == price1 || cartPrice2 == price1) && (cartPrice2 == price1 || cartPrice2 == price2));
        double sum;
        if (cartPrice1 == price1) {
            sum = cartPrice1 * 3+ cartPrice2 * 6;
        } else sum = cartPrice1 * 6 + cartPrice2 * 3;
        WebElement wSumInCart = driver.findElement(By.xpath(".//*[@id='sc-subtotal-amount-activecart']/span"));
        String sSumInCart = wSumInCart.getText().replace("$", "");
        double sumInCart = Double.parseDouble(sSumInCart);
       Assert.assertTrue("The sum is invalid",sum==sumInCart);

    }

}



