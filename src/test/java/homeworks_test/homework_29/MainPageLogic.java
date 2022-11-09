package homeworks_test.homework_29;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.page;

public class MainPageLogic extends MainPageElement{
   public CategoryLogic clickToCategory(SelenideElement category){
category.shouldBe(Condition.visible);
category.click();
return page(CategoryLogic.class);
   }

}
