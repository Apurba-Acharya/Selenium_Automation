package ex27_testNG.TNG6_PriorityVVI;

import org.testng.annotations.Test;

public class TNG7_priority {
    /* 1. What is priority:
     2. why need to use priority?: If we do not use priority, TestNG will set the priority based on assKey (alphabetically) value. To avoid them needs to use priority.
     3. how to define?: Using priority keyword
     4. TestNG internally doesn't maintain the order of test case execution, so that's why prioritization is required
     5. what is the default value of priority?: 0
     6. can we pass negative values to priority?: Yes, we can because priority can accept integer value. So, it can be -ve (2^31) to +ve(2^31-1)
     7. what happens when the same priority is provided to multiple methods?: 1st it will try to find out how many methods are there with the same
        priority number then based on assKey (alphabetically) value it will execute. */

    @Test(priority=-1)
    public void SignUp(){
        System.out.println("Sign Up");
    }

    @Test(priority=2)
    public void LogIn(){
        System.out.println("Log In");
    }

    @Test(priority=3)
    public void SearchForTheFlight(){
        System.out.println("Search For The Flight");
    }

    @Test(priority=4)
    public void BookTheFlight(){
        System.out.println("Book The Flight");
    }

    @Test(priority=5)
    public void SaveTheTicket(){
        System.out.println("Save The Ticket");
    }

    @Test(priority=5)
    public void LogOut(){
        System.out.println("Log Out");
    }
}