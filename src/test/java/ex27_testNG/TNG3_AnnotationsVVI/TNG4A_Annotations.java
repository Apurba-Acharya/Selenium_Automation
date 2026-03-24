package ex27_testNG.TNG3_AnnotationsVVI;

import org.testng.annotations.*;

public class TNG4A_Annotations {
    // Annotations example: @FindBy(id="username") WebElement usernameTxt;
    // Annotation is a form of metadata that can be added with java source code

    /* Annotations available in testNG: @Test, @BeforeSuite, @AfterSuite, @BeforeClass,
     @AfterClass, @BeforeMethod, @AfterMethod, @BeforeGroup, @AfterGroup, @dataProvider,
     @Parameters, @Factory @Listeners, @Ignore etc. */

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("1. @BeforeSuite → Executes before the entire test suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("2. @AfterSuite → Executes after the entire test suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("3. @BeforeTest → Executes before <test> tag in TNG4A_Annotations.xml");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("4. @AfterTest → Executes after <test> tag in TNG4A_Annotations.xml");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("5. @BeforeClass → Executes before the first @Test method in the current class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("6. @AfterClass → Executes after all @Test methods in the current class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("7. @BeforeMethod → Executes before each @Test method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("8. @AfterMethod → Executes after each @Test method");
    }

    @Test(priority = 1)
    public void test1() {
        System.out.println("9. @Test (test1) → Actual test case 1");
    }

    @Test(priority = 2)
    public void test2() {
        System.out.println("10. @Test (test2) → Actual test case 2");
    }
}
