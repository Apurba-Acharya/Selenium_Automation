package ex28_testNG.TNG15_parallalExecution;

import org.testng.annotations.Test;

public class TNG16A_parallalExecution2 {
    @Test
    public void seqExecu5(){
        System.out.println("TestClass 2 >> TestMethod 1 >> " + Thread.currentThread().getId());
    }

    @Test
    public void seqExecu6(){
        System.out.println("TestClass 2 >> TestMethod 2 >> " + Thread.currentThread().getId());
    }

    @Test
    public void seqExecu7(){
        System.out.println("TestClass 2 >> TestMethod 3 >> " + Thread.currentThread().getId());
    }

    @Test
    public void seqExecu8(){
        System.out.println("TestClass 2 >> TestMethod 4 >> " + Thread.currentThread().getId());
    }
}
