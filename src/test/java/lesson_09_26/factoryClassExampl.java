package lesson_09_26;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class factoryClassExampl {
    @Factory
    @Test
    public Object[] getFactoryTests(){
        Object[] factory = new Object[2];
        factory[0] = new OurFirstTest();
        factory[1] = new OurSecondTest();
        return factory;
    }
}
