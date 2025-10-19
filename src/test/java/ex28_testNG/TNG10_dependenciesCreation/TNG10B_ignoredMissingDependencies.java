package ex28_testNG.TNG10_dependenciesCreation;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TNG10B_ignoredMissingDependencies {

    /* Priority will simply ignore if we use priority with dependsOnMethods.
    Because dependsOnMethods will internally recognize that which test case is dendeds on whome */
    // what will happen if dependendent test got failed? : Then the remaining test will go to skip status

    static String trackingNumber= null;

    @Ignore //If we ignored dependent method then remaining test case will get failed.
    @Test()
    public void CreateShipment(){
        System.out.println(5/0); //Dummy SOUT to failed this test case
        System.out.println("CreateShipment");
        trackingNumber= "ABC12YH";
    }

    @Test(dependsOnMethods = {"CreateShipment"}, ignoreMissingDependencies = true) //ignoreMissingDependencies = true: If dependent method is deleted/skipped/ignored then also CancelShipment will get execute.
    public void TrackShipment() throws Exception {
        if(trackingNumber!=null){
            System.out.println("TrackShipment");
        }else{
            throw new Exception("Invalid tracking number");
        }
    }

    @Test(dependsOnMethods = {"CreateShipment", "TrackShipment"}, ignoreMissingDependencies = true)
    public void CancelShipment() throws Exception {
        if (trackingNumber != null) {
            System.out.println("CancelShipment");
        } else {
            throw new Exception("Invalid tracking number");
        }
    }
}
