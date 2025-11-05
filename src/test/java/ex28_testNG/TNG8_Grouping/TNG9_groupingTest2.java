package ex28_testNG.TNG8_Grouping;

import org.testng.annotations.Test;

public class TNG9_groupingTest2 {
    @Test(groups = {"functional", "regression", "sanity"})
    public void test5(){
        System.out.println("functional_regression_sanity_Test5");
    }

    @Test(groups = {"sanity"})
    public void test6(){
        System.out.println("sanity_Test6");
    }

    @Test(groups = {"regression"})
    public void test7(){
        System.out.println("regression_Test7");
    }

    @Test(groups = {"functional", "smoke"})
    public void test8(){
        System.out.println("functional_smoke_Test8");
    }
}
