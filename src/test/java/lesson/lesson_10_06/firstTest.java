package lesson.lesson_10_06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class firstTest {
    private WebDriver driver;
    WebDriverWait wait;
    final String EXPECTEDTEXT = "Комп'ютер Apple Mac Studio M1 Ultra/48 ядер GPU/64GB/1TB";


//

    @BeforeMethod
    public void setUpTest()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rozetka.com.ua/");
    }
    @Test
    public void RozetkaTest(){

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys("Mac");

        WebElement buttonSearch = driver.findElement(By.xpath("//button[contains(@class, 'button_color_green')]"));
        buttonSearch.click();

        WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class = 'goods-tile__title']")));
        String titleOfFirstProduct = firstProduct.getText().trim();

        Assert.assertEquals(titleOfFirstProduct, EXPECTEDTEXT);

    }
@AfterMethod
    public void After(){
        driver.quit();
}
}
