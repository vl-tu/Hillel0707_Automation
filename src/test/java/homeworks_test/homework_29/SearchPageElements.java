package homeworks_test.homework_29;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchPageElements {
    SelenideElement tittleOfFirstElement = $(By.xpath("//a[contains(@href,'p282196218')]//span[@class='goods-tile__title']"));
    SelenideElement buttonAddToShopingCart = $(By.xpath("//button[@class='buy-button goods-tile__buy-button ng-star-inserted']"));
    SelenideElement counterAtShopingCart = $(By.xpath("//span[@class='counter counter--green ng-star-inserted']"));
    SelenideElement goToShopingCart = $(By.xpath("//button[@class='header__button ng-star-inserted header__button--active']"));

}