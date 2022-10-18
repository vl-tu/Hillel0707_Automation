package lesson.lesson_09_26;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExmpl {
    @DataProvider(name = "routes")
    public Object[][] dataProviderMethod(){
        return new Object[][]{{"route1, www.itHillel.com.ua/contacts"},
                            {"route2, www.itHillel.com.ua"},
                             {"route3, www.itHillel.com.ua"},
                            {"route4, www.itHillel.com.ua"},
                            {"route5, www.itHillel.com.ua"}};
    }
    @Test(dataProvider = "routes")
    public void testCheckingLogo(String data){
        System.out.println("test started with: " + data);
        System.out.println("checking logo");

    }
}
