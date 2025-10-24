package ex28_testNG.TNG16_parallalExecution;

import org.testng.annotations.Test;

public class TNG16A_parallalExecution3 {
    @Test
    public void seqExecu9(){
        System.out.println("TestClass 3 >> TestMethod 1 >> " + Thread.currentThread().getId());
    }

    @Test
    public void seqExecu10(){
        System.out.println("TestClass 3 >> TestMethod 2 >> " + Thread.currentThread().getId());
    }

    @Test
    public void seqExecu11(){
        System.out.println("TestClass 3 >> TestMethod 3 >> " + Thread.currentThread().getId());
    }

    @Test
    public void seqExecu12(){
        System.out.println("TestClass 3 >> TestMethod 4 >> " + Thread.currentThread().getId());
    }
}
