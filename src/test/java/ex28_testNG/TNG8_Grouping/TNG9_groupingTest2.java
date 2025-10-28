package ex28_testNG.TNG8_Grouping;

import org.testng.annotations.Test;

public class TNG9_groupingTest2 {
    @Test(groups = {"functional", "regression", "sanity"})
    public void test5(){
        System.out.println("Test5");
    }

    @Test(groups = {"sanity", "smoke"})
    public void test6(){
        System.out.println("Test6");
    }

    @Test(groups = {"regression"})
    public void test7(){
        System.out.println("Test7");
    }

    @Test(groups = {"functional", "smoke"})
    public void test8(){
        System.out.println("Test8");
    }
}
