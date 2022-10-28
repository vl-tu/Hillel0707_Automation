package lesson.lesson_10_27.TestIpload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Upload {
    private WebDriver driver;
    WebDriverWait wait;


    @BeforeMethod
    public void setUpTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");
    }

    @Test
    public void test() throws InterruptedException {
        WebElement element = driver.findElement(By.id("file-upload"));
        element.sendKeys("C:\\Users\\tupik\\IdeaProjects\\Hillel0707_Automation\\text");

    }

    @AfterMethod
    public void After() {
        driver.quit();
    }

}
