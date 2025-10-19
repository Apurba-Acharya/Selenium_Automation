package ex28_testNG.TNG9_Grouping;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;


public class TNG9_groupingTest1 {

    // What is grouping? : Using TestNG we can categorize multiple tests in one group. (Ex: SmokeGroup-10 TestCase, functionalFroup-90 TestCase etc.)
    // Why needs? : If we want to execute test as a part of some categorize then needs grouping concepts.
    // If we not configure grouping in testNG.xml then the execution will be based on all class level.


    @Test(groups = {"smoke"})
    public void test1(){
        System.out.println("Test1");
    }

    @Test(groups = {"smoke", "sanity"})
    public void test2(){
        System.out.println("Test2");
    }

    @Test(groups = {"smoke","functional"})
    public void test3(){
        System.out.println("Test3");
    }

    @Test(groups = {"functional", "regression"})
    public void test4(){
        System.out.println("Test4");
    }
}
