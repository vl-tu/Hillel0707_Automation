package homeworks_test.homework_29;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ShopingCartElement {
    SelenideElement tittleofElementInShopingCart = $(By.xpath("//a[@data-testid='title']"));
}
