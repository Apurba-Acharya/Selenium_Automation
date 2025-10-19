package ex28_testNG.TNG9_Grouping;

import org.testng.annotations.Test;


@Test(groups= {"all"})
public class TNG9C_partialGrouping1 {

    @Test(groups = {"smoke"})
    public void test1(){
        System.out.println("Test1");
    }

    @Test(groups = {"smoke", "sanity", "windows.smoke"})
    public void test2(){
        System.out.println("Test2");
    }

    @Test(groups = {"smoke","functional"})
    public void test3(){
        System.out.println("Test3");
    }

    @Test(groups = {"functional", "regression", "windows.sanity", "ios.sanity"})
    public void test4(){
        System.out.println("Test4");
    }
    @Test
    public void test5(){
        System.out.println("Test5");
    }
}
