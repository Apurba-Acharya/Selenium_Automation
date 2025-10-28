package ex28_testNG.TNG15_parallalExecution;

import org.testng.annotations.Test;

public class TNG16A_parallalExecution1 {
    @Test
    public void seqExecu1(){
        System.out.println("TestClass 1 >> TestMethod 1 >> " + Thread.currentThread().getId());
    }

    @Test
    public void seqExecu2(){
        System.out.println("TestClass 1 >> TestMethod 2 >> " + Thread.currentThread().getId());
    }

    @Test
    public void seqExecu3(){
        System.out.println("TestClass 1 >> TestMethod 3 >> " + Thread.currentThread().getId());
    }

    @Test
    public void seqExecu4(){
        System.out.println("TestClass 1 >> TestMethod 4 >> " + Thread.currentThread().getId());
    }
}
