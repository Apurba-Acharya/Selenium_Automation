package ex27_testNG.TNG11_dataProvider_TCS;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TNG12C_partiallyDataProvider {
    // indices?: Whatever the data you want to pass those data indexes is called as indices
    // why use?: to pass the partial data to the test methods
    // how to pass?: indices is a parameter of data provider --> @DataProvider(indices = {0,2})
    // id we not use indices then all the value will be pass through test method.

    @Test(dataProvider = "dataProv1")
    public void test(String str) {
        System.out.println(str);
    }
    @DataProvider(indices = {0,2})
    public String[] dataProv1() {
        String[] data = new String[]{
                "adcd", "xyz", "pqr", "mno"
        };
        return data;
    }
}
