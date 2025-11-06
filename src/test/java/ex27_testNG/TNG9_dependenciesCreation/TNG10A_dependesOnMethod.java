package ex27_testNG.TNG9_dependenciesCreation;

import org.testng.annotations.Test;

public class TNG10A_dependesOnMethod {

    /* Priority will simply ignore if we use priority with dependsOnMethods.
    Because dependsOnMethods will internally recognize that which test case is depends on whome */
    // * what will happen if dependent test got failed?: Then the remaining test will go to skip status

    static String trackingNumber= null;
    @Test()
    public void CreateShipment(){
        trackingNumber= "ABC12YH";
        System.out.println(5/0); //Dummy SOUT failed the below @Test methods
        System.out.println("CreateShipment");

    }

    @Test(dependsOnMethods = {"CreateShipment"}, alwaysRun = true) //alwaysRun = true: this test method will always run even if dependent methods got failed.
    public void TrackShipment() throws Exception {
        if(trackingNumber!=null){
            System.out.println("TrackShipment");
        }else{
            throw new Exception("Invalid tracking number");
        }

    }

    @Test(dependsOnMethods = {"CreateShipment", "TrackShipment"})
    public void CancelShipment() throws Exception {
        if (trackingNumber != null) {
            System.out.println("CancelShipment");
        } else {
            throw new Exception("Invalid tracking number");
        }
    }
}
