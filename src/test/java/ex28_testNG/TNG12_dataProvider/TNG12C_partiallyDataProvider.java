package ex28_testNG.TNG12_dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TNG12C_partiallyDataProvider {
    // indices?: Whatever the data you want to pass those data indexes is called as indices
    // why use?: to pass the partial data to the test methos
    // how to pass?:

    @Test(dataProvider = "dataProv1")
    public void test(String str) {
        System.out.println(str);
    }
    @DataProvider()
    public String[] dataProv1() {
        String[] data = new String[]{
                "adcd", "xyz", "pqr", "mno"
        };
        return data;
    }
}
