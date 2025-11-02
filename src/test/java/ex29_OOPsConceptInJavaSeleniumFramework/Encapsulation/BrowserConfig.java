package ex29_OOPsConceptInJavaSeleniumFramework.Encapsulation;

/* Encapsulation means wrapping data (variables) and methods together into a single class,
and restricting direct access to those data members using private access modifiers — allowing control via
public getter/setter methods. */

public class BrowserConfig {
    private String browserName;
    private final String username = "Admin";
    private final String password = "admin123";

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getBrowserName() {
        return browserName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}