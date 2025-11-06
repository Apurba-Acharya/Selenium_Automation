package ex27_testNG.TNG11_dataProviderVVI;

import org.testng.annotations.Test;

public class TNG12D_createSeperateClassForDataProvider {

    // dataProviderClass--> is used when dataProvider class is not in same class. Basically to fetch the data from different class

    @Test (dataProvider = "dP2", dataProviderClass = TNG12D_dataProviderClass.class)
    public void spe01Class(String str){
        System.out.println(str);
    }
}
