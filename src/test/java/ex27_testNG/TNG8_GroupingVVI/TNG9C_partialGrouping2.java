package ex27_testNG.TNG8_GroupingVVI;

import org.testng.annotations.Test;

public class TNG9C_partialGrouping2 {
    @Test(groups = {"functional", "regression", "sanity"})
    public void test5(){
        System.out.println("Test5");
    }

    @Test(groups = {"sanity", "smoke", "ios.smoke"})
    public void test6(){
        System.out.println("Test6");
    }

    @Test(groups = {"regression", "windows.functional", "ios.functional"})
    public void test7(){
        System.out.println("Test7");
    }

    @Test(groups = {"functional", "smoke"})
    public void test8(){
        System.out.println("Test8");
    }
}
