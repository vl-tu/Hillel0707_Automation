package homeworks_test.homework_24;

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

import static org.testng.Assert.assertTrue;

public class Test_homework_24 {
    private WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUpTest()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void Test(){

        driver.get("https://rozetka.com.ua/");
        WebElement notebooksAndPCSection = driver.findElement(By.xpath("//a[@href='https://rozetka.com.ua/ua/computers-notebooks/c80253/' and @class='menu-categories__link']"));
        notebooksAndPCSection.click();

        WebElement notebooksSection =driver.findElement(By.xpath("//a[@class='tile-cats__heading tile-cats__heading_type_center ng-star-inserted' and @title='Ноутбуки']"));
        notebooksSection.click();

        WebElement rozetkaFilterSelect = driver.findElement(By.xpath("//a[@data-id='Rozetka']"));
        rozetkaFilterSelect.click();

        WebElement FilterMaxPrice = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='max']")));
        FilterMaxPrice.click();
        FilterMaxPrice.clear();
        FilterMaxPrice.sendKeys("100000");

        WebElement OkButton = driver.findElement(By.xpath("//button[@type='submit']"));
        OkButton.click();

        WebElement FirstProductWithLabel = driver.findElement(By.xpath("//span[@class='goods-tile__label promo-label promo-label_type_popularity ng-star-inserted']/../.."));
        FirstProductWithLabel.click();

        WebElement LabelOnProductPage = driver.findElement(By.xpath("//rz-label[@class='main-slider__label ng-star-inserted']"));
        assertTrue(LabelOnProductPage.isDisplayed(), "Label does not displayed on product page");

    }
    @AfterMethod
    public void After(){
        driver.quit();
    }
}

