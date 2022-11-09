package homeworks_test.homework_29;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.page;

public class ShopingCartLogic extends ShopingCartElement{
    String tittleOfElementInShopingCart;
    public ShopingCartLogic getTittleFromShopingCart(SelenideElement tittle2){
        tittle2.shouldBe(Condition.visible);
        tittleOfElementInShopingCart = tittle2.getCssValue("innerText").trim();
        return page(ShopingCartLogic.class);
    }

    public ShopingCartLogic checkTittles(String tittleSearchPage, String tittleShopingCart){
        Assert.assertEquals(tittleSearchPage, tittleShopingCart);
        return page(ShopingCartLogic.class);
    }

}
