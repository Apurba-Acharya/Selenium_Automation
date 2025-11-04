package ex28_testNG.TNG7_Ignore;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore // Class level @Ignore anotation
public class TNG8_ignoreTest1 {

    /*If we use @Ignore and Test(enabled=true) both then also that @Test method should be ignored
    because @Ignore is always highest priority */

    @Test(enabled=false)    //enabled/disabled specific test method through @Test method level. ByDefault it should be enabled.
    public void test1(){
        System.out.println("Test1");
    }

    @Test
    public void test2(){
        System.out.println("Test2");
    }

    @Ignore //disabled specific test method through @Ignore seperate anotation level.
    @Test
    public void test3(){
        System.out.println("Test3");
    }

    @Test
    public void test4(){
        System.out.println("Test4");
    }
}
