package ex29_OOPsConceptInJavaSeleniumFramework.Polymorphism;

public class TestClassMethodOverriding {
    public static void main(String[] args) throws InterruptedException {
        BaseClassMethodOverriding obj = new TestBrowserMethodOverriding();
        obj.openBrowser();
        obj.closeBrowser();
    }
}