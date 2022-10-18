package lesson.lesson_09_26;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyFirstTestRun {
    private WebDriver driver;

//    @BeforeClass
//    public void setUp() {
//        WebDriverManager.chromedriver().setup();
//    }

    @BeforeTest
    public void setUpTest()
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        @Test
        public void firstRun () {
            driver.get("https://www.google.com/");
            WebElement buttonSearch = driver.findElement(By.name("btnk"));
            buttonSearch.click();
        }
    }

