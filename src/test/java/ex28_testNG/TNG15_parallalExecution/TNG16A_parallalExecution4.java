package ex28_testNG.TNG15_parallalExecution;

import org.testng.annotations.Test;

public class TNG16A_parallalExecution4 {
    @Test
    public void seqExecu13(){
        System.out.println("TestClass 4 >> TestMethod 1 >> " + Thread.currentThread().getId());
    }

    @Test
    public void seqExecu14(){
        System.out.println("TestClass 4 >> TestMethod 2 >> " + Thread.currentThread().getId());
    }

    @Test
    public void seqExecu15(){
        System.out.println("TestClass 4 >> TestMethod 3 >> " + Thread.currentThread().getId());
    }

    @Test
    public void seqExecu16(){
        System.out.println("TestClass 4 >> TestMethod 4 >> " + Thread.currentThread().getId());
    }
}
