package ex27_testNG.TNG17_listeners_reLearnVVI;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TNG18C_suiteListenersImplementation {

    @Test
    public void testMethod1(){
        System.out.println("I'm inside test method 1");
    }
    @Test
    public void testMethod2(){
        System.out.println("I'm inside test method 2");
        Assert.assertTrue(false);
    }
    @Test(timeOut = 1000)
    public void testMethod3() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("I'm inside test method 3");
    }
    @Test(dependsOnMethods = "testMethod3")
    public void testMethod4(){
        System.out.println("I'm inside test method 4");
    }
}
