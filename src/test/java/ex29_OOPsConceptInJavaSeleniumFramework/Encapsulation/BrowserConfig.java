package ex29_OOPsConceptInJavaSeleniumFramework.Encapsulation;

/* Encapsulation means wrapping data (variables) and methods together into a single class,
and restricting direct access to those data members using private access modifiers — allowing control via
public getter/setter methods. */

public class BrowserConfig {
    private String browserName;
    private String driverPath;
    private final String username = "Admin";
    private final String password = "admin123";

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public void setDriverPath(String driverPath) {
        this.driverPath = driverPath;
    }

    public String getBrowserName() {
        return browserName;
    }

    public String getDriverPath() {
        return driverPath;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}