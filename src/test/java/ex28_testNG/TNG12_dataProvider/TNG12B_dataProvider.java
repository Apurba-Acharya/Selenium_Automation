package ex28_testNG.TNG12_dataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class TNG12B_dataProvider {
    /* *Is it mandatory to return Pbject[][] (2D array) from the dataProvider?: It is not mandatory to written only object to 2D array from thar dataProvider.
    -> Other supported data type in dataProvider:
    Object[]; Object[][] -> Multi dimensional array; Iterator<Object>; Iterator<Object[]>
    whn we are using Object means any pre-defined/user-defined data types: String, Integer, Float etc.
    why Object?: Because object is the super class of all the classes in Java */

    //ex- 1D String array:
    @Test(dataProvider = "dataProv1")
    public void test(String str) {
        System.out.println(str);
    }
    @DataProvider()
    public String[] dataProv1() {
        /* This type is: 1st defining -> Initializing
        String[] data = new String[2];
        data[0] = "abcd";
        data[1] = "efgh"; */

        // another one is:
        String[] data = new String[]{
                "adcd", "xyz", "pqr"
        };
        return data;
    }

    //ex: 1D Object array:
    @Test(dataProvider = "dataProv2")
    public void test(Object Obj) {
        System.out.println(Obj);
    }
    @DataProvider()
    public Object[] dataProv2() { // When user needs to store any kind of data types the Object array is required.
        Object[] objec = new Object[]{
                1, 2, "Hello", 3
        };
        return objec;
    }

    //ex 1: String multi dimentional array:
    @Test(dataProvider = "dataProv3")
    public void multi1(String st[]) { //st[]?: because 2D array is the combination of 1D array
        System.out.println(st[0] + " >> " + st[1]);
    }
    @Test(dataProvider = "dataProv3")
    public void multi2(String username, String password) { //st[]?: because 2D array is the combination of 1D array
        System.out.println(username + " >> " + password);
    }
    @DataProvider()
    public String[][] dataProv3() {
        String[][] multiD = new String[][]{
                {"hyr", "123"},
                {"pqr", "456"},
                {"xyz", "789"}
        };
        return multiD;
    }

    //ex 2:
    @Test(dataProvider = "dataProv4")
    public void multi5(String [] sgs ) { //st[]?: because 2D array is the combination of 1D array
        for(int i=0; i<sgs.length; i++){
            System.out.println(sgs[i]);
        }
    }
    @DataProvider()
    public String[][] dataProv4() {
        String[][] multiDi = new String[][]{
                {"hyr", "123", "854", "ABCD"},
                {"pqr", "456"},
                {"xyz", "789", "123456"}
        };
        return multiDi;
    }

    //Ex 3: Combination of integer and sting in multi-dimentional array:
    @Test(dataProvider = "dataProv5")
    public void multi6(Object [] sgsb ) {
        for(int i=0; i<sgsb.length; i++){
            System.out.println(sgsb[i]);
        }
    }
    @DataProvider()
    public Object[][] dataProv5() {
        Object[][] multiDia = new Object[][]{
                {"hyr", 123, 54, "ABCD"},
                {"pqr", "456"},
                {"xyz", 789, 123456}
        };
        return multiDia;
    }

    //Ex 4: Iterator: is used for reading the value from collections
    @Test(dataProvider = "dataProv6")
    public void multi7(String ssb ) {
        System.out.println(ssb);
    }
    @DataProvider()
    public Iterator<String> dataProv6() {
        List<String> muliDia = new ArrayList<>();
        muliDia.add("Java");
        muliDia.add("Knoledge");
        return muliDia.iterator();
    }

    //Ex 5: when we can use iterator of string/abject array?
    @Test(dataProvider = "dataProv7")
    public void multi8(String [] sa ) {
        System.out.println(sa[0] + " >> "+sa[1]);
    }
    @DataProvider()
    public Iterator<String[]> dataProv7() { //everythis will be same for object also
        Set<String[]> mulia = new HashSet<>(); // here we can use any type of collections
        mulia.add(new String[] {"Java", "Today"});
        mulia.add(new String[] {"Knoledge", "now"});
        return mulia.iterator();
    }
}