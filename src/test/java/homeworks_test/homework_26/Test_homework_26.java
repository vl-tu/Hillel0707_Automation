package homeworks_test.homework_26;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class Test_homework_26 {

    private WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUpTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void Test() throws InterruptedException, FileNotFoundException {
        GoToNotebooksSection();
        Map<String, String> map = WriteTittleAndPriceToMap();
        WriteMapToTXT(map);


    }

    private void GoToNotebooksSection() {
        driver.get("https://rozetka.com.ua/");
        WebElement notebooksAndPCSection = driver.findElement(By.xpath("//ul[@class='menu-categories menu-categories_type_main']//li[1]"));
        notebooksAndPCSection.click();

        WebElement notebooksSection = driver.findElement(By.xpath("//img[@alt='Ноутбуки']/../.."));
        notebooksSection.click();
    }

    private Map<String, String> WriteTittleAndPriceToMap() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);

        List<WebElement> tittle = driver.findElements(By.xpath("//span[@class='goods-tile__title']"));
        List<String> titleOfProduct = new ArrayList<>();
        for (WebElement element : tittle) {
            titleOfProduct.add(element.getText());
        }

        List<WebElement> price = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));
        List<String> priceOfProduct = new ArrayList<>();
        for (WebElement element : price) {
            priceOfProduct.add(element.getText());
        }

        Map<String, String> tittleAndPrice = new HashMap<>();
        for (int i = 0; i < tittle.size(); i++) {
            tittleAndPrice.put(titleOfProduct.get(i), priceOfProduct.get(i));
        }

        return tittleAndPrice;
    }

    private void WriteMapToTXT(Map<String, String> map) throws FileNotFoundException {

        PrintWriter writer = new PrintWriter("Tittle and price of products");

        for (Map.Entry<String, String> i : map.entrySet()) {
            writer.println(i.getKey() + " - " + i.getValue());
        }
        writer.close();


    }

    @AfterMethod
    public void After() {
        driver.quit();
    }
}

