package ex27_testNG.TNG10_groupDependencies;

import org.testng.annotations.Test;

public class TNG11_testGroupDependencies {

    @Test(groups = "smoke")
    public void test1(){
        System.out.println("smoke 1");
    }

    @Test(groups = "smoke")
    public void test2(){
        System.out.println("smoke 2");
    }

    @Test(groups = "smoke")
    public void test3(){
        System.out.println("smoke 3");
    }

    @Test(groups = "sanity")
    public void test4(){
        System.out.println("sanity 4");
    }

    @Test(groups = "sanity")
    public void test5(){
        System.out.println(5/0);
    }

    @Test(groups = "regression")
    public void test6(){
        System.out.println("regression 6");
    }


    @Test(dependsOnGroups = {"smoke", "sanity", "regression"}, alwaysRun = true) //alwaysRun = true -> if there is any failure in groups still test00 will get execute
    public void test00(){
        System.out.println("alwaysRun group : main Test 00");
    }

    @Test(dependsOnGroups = {"smoke", "sanity", "regression"}) // if there is any failure in groups then test01 will not get execute. Here Sanity groups(test5) is fail, so test01 is skipped
    public void test01(){
       System.out.println("main Test 01");
   }
}
