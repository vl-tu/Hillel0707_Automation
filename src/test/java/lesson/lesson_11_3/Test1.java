package lesson.lesson_11_3;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class Test1 {
    @BeforeTest
    public void before() {
        Configuration.browserSize = "1920x1080";
        open("https://rozetka.com.ua/");
    }

    @Test
    public void test() {
        $(By.name("search"))
                .setValue("Mac")
                .pressEnter();
        sleep(5000);

    }
}
