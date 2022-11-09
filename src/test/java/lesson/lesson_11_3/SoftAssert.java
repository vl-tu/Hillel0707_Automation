package lesson.lesson_11_3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SoftAssert {
    @Test(enabled = true)
    public void testCaseOne() {
        System.out.println("***Test case one started");
        Assert.assertEquals(5,5);
        System.out.println(" hard assert success...");
        Assert.assertTrue("hello".equals("Hello"));
        System.out.println("*** test case execute successfully ***");
    }

@Test(enabled = false)
    public void testCaseTwo(){
        org.testng.asserts.SoftAssert softAssert = new org.testng.asserts.SoftAssert();
    System.out.println("***Test case one started");
    softAssert.assertEquals(5,5);
    System.out.println(" hard assert success...");
    softAssert.assertTrue("hello".equals("Hello"));
    System.out.println("*** test case execute successfully ***");
    softAssert.assertAll();
    }
}
