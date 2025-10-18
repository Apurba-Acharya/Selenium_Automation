package ex28_testNG;

import org.testng.annotations.Test;

public class TNG7_priority {
    // What is priority:
    //why needs to use priority ? : If we not use priority TestNG will set the priority baased on assKey (alphabatically) value. To avoid them needs to use priority.
    // how to define ? : using priority keyword
    // TestNG internally doesn't maintain the order of test case executio, so that's why prioritazation is required
    // what is the default value of priority? : 0
    // can we pass negative values to priority ? : Yes we can because priority can accept integer value. So, it can be -ve (2^31) to +ve(2^31-1)
    // what happens when same priority is provided to multiple methods? : 1st it will try to find out how many methods are there with same priority number then based on assKey (alphabatically) value it will execute.

    @Test(priority=-1)
    public void SignUp(){
        System.out.println("SignUp");
    }

    @Test(priority=2)
    public void LogIn(){
        System.out.println("LogIn");
    }

    @Test(priority=3)
    public void SearchForTheFlight(){
        System.out.println("SearchForTheFlight");
    }

    @Test(priority=4)
    public void BookTheFlight(){
        System.out.println("BookTheFlight");
    }

    @Test(priority=5)
    public void SaveTheTicket(){
        System.out.println("SaveTheTicket");
    }

    @Test(priority=5)
    public void LogOut(){
        System.out.println("LogOut");
    }
}