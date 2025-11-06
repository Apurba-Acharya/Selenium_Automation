package ex28_OOPsConceptInJavaSeleniumFramework.Polymorphism;

public class P2_TestClassMethodOverriding {
    public static void main(String[] args) throws InterruptedException {
        P2_BaseClassMethodOverriding obj = new TestBrowserMethodOverriding();
        obj.openBrowser();
        obj.closeBrowser();
    }
}