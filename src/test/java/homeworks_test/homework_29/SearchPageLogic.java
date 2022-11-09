package homeworks_test.homework_29;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.page;

public class SearchPageLogic extends SearchPageElements{
    public String tittleOfFirstElementInSearchPage;

    public ShopingCartLogic getTittle(SelenideElement tittle1){
        tittle1.shouldBe(Condition.visible);
        tittleOfFirstElementInSearchPage = tittle1.getText().trim();
        return page(ShopingCartLogic.class);
    }
    public ShopingCartLogic addToShopingCart(SelenideElement buttonAdd){
        buttonAdd.shouldBe(Condition.visible);
        buttonAdd.click();
        return page(ShopingCartLogic.class);
    }
    public ShopingCartLogic checkCountOfItemsInShopingCart(SelenideElement count){
        count.shouldBe(Condition.visible);
       String counterValue =  count.getText().trim();
        Assert.assertEquals(counterValue, "1");
        return page(ShopingCartLogic.class);
    }
    public ShopingCartLogic clickToOpenShopingCart(SelenideElement buttonRedirect){
        buttonRedirect.shouldBe(Condition.visible);
        buttonRedirect.click();
        return page(ShopingCartLogic.class);
    }

}
