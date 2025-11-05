package ex28_testNG.TNG9_dependenciesCreation;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TNG10B_ignoredSkippedDeletedDependsOnMethod {

    // * what will happen if dependent test got failed?: Then the remaining test will go to skip status

    static String trackingNumber= null;

    @Ignore //If we ignored/skipped/deleted, dependent method then remaining @Test methods will get failed.
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
