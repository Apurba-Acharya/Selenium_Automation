package ex27_testNG.TNG11_dataProviderVVI;

import org.testng.annotations.DataProvider;

public class TNG12D_dataProviderClass {

    @DataProvider()
    public String[] dP1() {
        String[] data1 = new String[]{
                "adcd", "xyz", "pqr", "mno"
        };
        return data1;
    }

    @DataProvider()
    public Object[] dP2() {
        Object[] data2 = new Object[]{
                "mno", "sdf", "qse", "okip"
        };
        return data2;
    }
}
