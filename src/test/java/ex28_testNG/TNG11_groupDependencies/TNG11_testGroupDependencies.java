package ex28_testNG.TNG11_groupDependencies;

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

//    //Ex 1:
//    @Test(dependsOnGroups = {"smoke"}, alwaysRun = true) //if there is any failure in groups still test0 will get execute
//    public void test0(){
//        System.out.println("main Test");
//    }

    @Test(dependsOnGroups = {"smoke", "sanity", "regression"}) //if there is any failure in groups still test0 will get execute
    public void test0(){
       System.out.println("main Test");
   }
}
