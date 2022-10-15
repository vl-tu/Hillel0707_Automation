package lesson_09_26;

import org.testng.annotations.Test;

public class OurSecondTest {
    @Test(groups = {"regression"})
    public void thirdTestMethod() {

        System.out.println("It is third test method");
    }
}

