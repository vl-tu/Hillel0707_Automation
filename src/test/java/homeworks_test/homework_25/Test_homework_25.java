package homeworks_test.homework_25;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;


public class Test_homework_25 {
    private WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUpTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void Test() throws InterruptedException {

        driver.get("https://rozetka.com.ua/");

        WebElement notebooksAndPCSection = driver.findElement(By.xpath("//ul[@class='menu-categories menu-categories_type_main']//li[1]"));
        notebooksAndPCSection.click();

        WebElement notebooksSection = driver.findElement(By.xpath("//img[@alt='Ноутбуки']/../.."));
        notebooksSection.click();

        WebElement FirstProduct = driver.findElement(By.xpath("//a[contains(@href,'p349995669')][2]"));
        String FirstProductTittle = FirstProduct.getCssValue("title").trim();

        WebElement AddFirstProductToShopCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Купити']/..")));
        AddFirstProductToShopCart.click();

        WebElement buttonShopCart = driver.findElement(By.xpath("//span[@class='counter counter--green ng-star-inserted']"));
        String CountOfProductInShopCart = buttonShopCart.getText().trim();
        if (!CountOfProductInShopCart.equals("1")) {
            assertEquals(CountOfProductInShopCart, "1", "You add to shopping cart more than 1 product");
        }
        buttonShopCart.click();

        WebElement ProductInShoppingCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='cart-product__title']")));
        String TittleOfProductInShoppingCart = ProductInShoppingCart.getCssValue("innerText").trim();

        assertEquals(FirstProductTittle, TittleOfProductInShoppingCart, "In shopping cart wrong product added");

    }

//    @AfterMethod
//    public void After() {
//        driver.quit();
//    }
}



