package ex28_testNG.TNG11_dataProvider;

import org.testng.annotations.Test;

public class TNG12D_createSeperateClassForDataProvider {

    // dataProviderClass--> is used when dataProvider class is not in same class. Basically to fetch the data from different class

    @Test (dataProvider = "dP2", dataProviderClass = TNG12D_dataProviderClass.class)
    public void speClass(String str){
        System.out.println(str);
    }
}
