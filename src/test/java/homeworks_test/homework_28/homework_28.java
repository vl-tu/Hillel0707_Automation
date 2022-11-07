package homeworks_test.homework_28;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class homework_28 {

    @BeforeTest
    public void before() {
        Configuration.browserSize = "1920x1080";
        open("https://rozetka.com.ua/");
    }

    @Test
    public void test() {

        $(By.xpath("//ul[@class='menu-categories menu-categories_type_main']//li[1]")).click();
        $((By.xpath("//img[@alt='Ноутбуки']/../.."))).click();
        String tittle1 = $(By.xpath("//a[contains(@href,'p354933153')]//span[@class='goods-tile__title']")).getText().trim();
        $(By.xpath("//button[@class='buy-button goods-tile__buy-button ng-star-inserted']")).click();
        String itemInShopingCart = $(By.xpath("//span[@class='counter counter--green ng-star-inserted']")).getText().trim();
        Assert.assertEquals(itemInShopingCart, "1");
        $(By.xpath("//button[@class='header__button ng-star-inserted header__button--active']")).click();
        String itemInShoppingBox = $(By.xpath("//a[@data-testid='title']")).shouldBe(Condition.visible).getText().trim();
        Assert.assertEquals(tittle1, itemInShoppingBox);
    }
}
