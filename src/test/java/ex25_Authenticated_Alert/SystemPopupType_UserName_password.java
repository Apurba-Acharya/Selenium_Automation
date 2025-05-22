package ex25_Authenticated_Alert;

import org.openqa.selenium.edge.EdgeDriver;

public class SystemPopupType_UserName_password {
    public static void main(String[] args) {
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        //formate is: https://userame:password@the-internet.herokuapp.com/basic_auth
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    }
}
