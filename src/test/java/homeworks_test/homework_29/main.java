package homeworks_test.homework_29;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class main {
    MainPageLogic MainPageLogic = new MainPageLogic();
    SearchPageLogic SearchPageLogic = new SearchPageLogic();

    @BeforeTest
    public void before() {
        Configuration.browserSize = "1920x1080";
        open("https://rozetka.com.ua/");
    }

    @Test
    public void test(){
      MainPageLogic
              .clickToCategory(MainPageLogic.noteboocksAndPcCategory)
              .clickToPartNotebook(new CategoryLogic().notebooksPart)
              .getTittle(SearchPageLogic.tittleOfFirstElement);
      SearchPageLogic.addToShopingCart(SearchPageLogic.buttonAddToShopingCart);
      SearchPageLogic.checkCountOfItemsInShopingCart(SearchPageLogic.counterAtShopingCart);
      SearchPageLogic.clickToOpenShopingCart(SearchPageLogic.goToShopingCart)
              .getTittleFromShopingCart(new ShopingCartLogic().tittleofElementInShopingCart)
              .checkTittles(SearchPageLogic.tittleOfFirstElementInSearchPage, new ShopingCartLogic().tittleOfElementInShopingCart);

    }
}
