package ex27_testNG.TNG8_GroupingVVI;
import org.testng.annotations.Test;

public class TNG9_groupingTest1 {

    /* 1. What is grouping?: Using TestNG, we can categorize multiple tests in one group. (Ex: SmokeGroup-10 TestCase, functionalFroup-90 TestCase etc.)
     2. Why needs?: If we want to execute test as a part of some categorizing, then needs grouping concepts.
     3. If we do not configure grouping in testNG.xml, then the execution will be based on all class levels. */

    @Test(groups = {"smoke"})
    public void test1(){
        System.out.println("smoke_Test1");
    }

    @Test(groups = {"smoke", "sanity"})
    public void test2(){
        System.out.println("smoke_sanity_Test2");
    }

    @Test(groups = {"functional"})
    public void test3(){
        System.out.println("functional_Test3");
    }

    @Test(groups = {"functional", "regression", "smoke"})
    public void test4(){
        System.out.println("functional_regression_smoke_Test4");
    }
}
