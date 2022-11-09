package homeworks_test.homework_29;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.page;

public class CategoryLogic extends CategoryElement{

    public SearchPageLogic clickToPartNotebook(SelenideElement partNotebooks){
        partNotebooks.shouldBe(Condition.visible);
        partNotebooks.click();
        return page(SearchPageLogic.class);
    }


}
