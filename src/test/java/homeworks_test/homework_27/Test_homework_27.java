package homeworks_test.homework_27;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class Test_homework_27 {
    private WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUpTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void Test() throws InterruptedException {
        CheckCountInSectionPromoProducts();
        CheckPriceOfFirstProductInPromoSection();
        ReturnAndReCheckCountInSectionPromoProducts();
    }

    private void CheckCountInSectionPromoProducts() {
        driver.get("https://rozetka.com.ua/");
        int countOfElements = driver.findElements(By.xpath("//section//li")).size();
        Assert.assertEquals(countOfElements, 6, "At section less than 6 elements");
    }

    private void CheckPriceOfFirstProductInPromoSection() {
        WebElement priceOfFirstProductInSectionPromoProducts = driver.findElement(By.xpath("//section/rz-goods-section/ul/li[1]//span[@class='tile__price-value']"));
        String price = priceOfFirstProductInSectionPromoProducts.getText().trim();
        WebElement firstProduct = driver.findElement(By.xpath("//section/rz-goods-section/ul/li[1]"));
        firstProduct.click();
        WebElement priceOfProductInProductPage = driver.findElement(By.xpath("//div/p[@class='product-prices__big product-prices__big_color_red']"));
        String price2 = priceOfProductInProductPage.getText().trim().substring(0, 3);
        Assert.assertEquals(price, price2, "Price not the same");
    }

    private void ReturnAndReCheckCountInSectionPromoProducts() {
        WebElement mainPage = driver.findElement(By.xpath("//*[@href='https://rozetka.com.ua/ua/']"));
        mainPage.click();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://rozetka.com.ua/ua/", "This is not main page or URL isn`t correct");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1500)", "");
        int countOfElementsRetest = driver.findElements(By.xpath("//section[5]//li")).size();
        Assert.assertEquals(countOfElementsRetest, 6, "At section less than 6 elements");
    }

    @AfterMethod
    public void After() {
        driver.quit();
    }
}

