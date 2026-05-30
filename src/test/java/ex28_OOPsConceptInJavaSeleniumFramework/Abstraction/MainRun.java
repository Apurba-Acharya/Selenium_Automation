package ex28_OOPsConceptInJavaSeleniumFramework.Abstraction;

public class MainRun {
    public static void main(String[] args) throws InterruptedException {
        BaseTest test = new BaseTest();
        test.openBrowser("edge");
        test.closeBrowser();
    }
}
