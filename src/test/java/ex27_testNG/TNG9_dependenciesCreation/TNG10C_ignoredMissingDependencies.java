package ex27_testNG.TNG9_dependenciesCreation;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TNG10C_ignoredMissingDependencies {

    static String trackingNumber= null;

    @Ignore
    @Test()
    public void CreateShipment(){
        trackingNumber= "ABC12YH";
        System.out.println(5/0); //Dummy SOUT to failed this test case
        System.out.println("CreateShipment");
    }

    @Test(dependsOnMethods = {"CreateShipment"}, ignoreMissingDependencies = true) //ignoreMissingDependencies = true: If dependent method is deleted/skipped/ignored then also TrackShipment will get execute.
    public void TrackShipment() throws Exception {
        if(trackingNumber!=null){
            System.out.println("TrackShipment");
        }else{
            throw new Exception("Invalid tracking number"); // Due to TrackShipment is skipped. so, tracking number also not getting store in = trackingNumber
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
