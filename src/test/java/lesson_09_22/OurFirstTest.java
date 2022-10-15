package lesson_09_22;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OurFirstTest {
    @BeforeTest
    public void beforeTest(){
        System.out.println("excuted method before test");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("always before method");
    }
    @Test (description = "описание теста")
        public void firstTest(){
        System.out.println("Open google.com.ua");
    }
    @Test (alwaysRun = true)
    public void secondTest(){
        System.out.println("open apple.com");
    }
    @Test (dependsOnMethods = "second test")
    public void thirdTest(){
        System.out.println("open 1");
    }

    @Test (dataProvider = "someone")
    public void fourthTest(){
        System.out.println("open 1");
    }

    @Test (priority = 1)
    public void NextTest(){
        System.out.println("open 1");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("excuted method after test");
    }
}
