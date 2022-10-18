package lesson.lesson_10_17;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class FindElements {
    private WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUpTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rozetka.com.ua/");
    }

    @Test
    public void Test() {
        WebElement notebooksAndPCSection = driver.findElement(By.xpath("//a[@href='https://rozetka.com.ua/ua/computers-notebooks/c80253/' and @class='menu-categories__link']"));
        notebooksAndPCSection.click();

        WebElement notebooksSection = driver.findElement(By.xpath("//a[@class='tile-cats__heading tile-cats__heading_type_center ng-star-inserted' and @title='Ноутбуки']"));
        notebooksSection.click();

       List<WebElement> tittleOgGoods = driver.findElements(By.xpath("//*[@class='goods-tile__inner']"));
       int countsOfGoods = tittleOgGoods.size();

       assertEquals(countsOfGoods, 60);
       }

    @AfterMethod
    public void After(){
        driver.quit();
    }
}

