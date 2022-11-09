package homeworks_test.homework_29;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CategoryElement {
    SelenideElement notebooksPart = $(By.xpath("//img[@alt='Ноутбуки']/../.."));
}
