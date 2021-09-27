package actions;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import Manager.PgObjManager;

public class SignupAction {
    WebDriver wd;
    PgObjManager pom;
    public SignupAction(WebDriver wd)
    {
        this.wd=wd;
        pom=new PgObjManager(wd);
    }
public void performLogin(HashMap<String,String> td) {
    String username = td.get("Username");
    String password = td.get("Password");
    pom.getwaitOpertion().performImplicitWait(wd);
    pom.getHomePage();
    pom.getHomePage().Navigatetosignup();
    pom.getHomePage().SignupCredentials(username, password);
    pom.getHomePage().clickSingnup();
}

}
