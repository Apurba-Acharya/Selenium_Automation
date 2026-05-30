package ex28_OOPsConceptInJavaSeleniumFramework.Polymorphism;

public class P2_TestClassMethodOverriding {
    public static void main(String[] args) throws InterruptedException {
        P2_BaseClassMethodOverriding obj = new P2_BrowserMethodOverriding();
        obj.openBrowser();
        obj.closeBrowser();
    }
}