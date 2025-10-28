package ex28_testNG.TNG17_listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({TNG18A_listeners.class})
public class TNG18B_classListenersImplementation {

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
    @Test(dependsOnMethods = "testMethods 3")
    public void testMethod4(){
        System.out.println("I'm inside test method 4");
    }
}
