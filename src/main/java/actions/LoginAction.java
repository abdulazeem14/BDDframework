package actions;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import Manager.PgObjManager;

public class LoginAction {
  public static  WebDriver wd;
   public static PgObjManager pom;
    public LoginAction(WebDriver wdr)
    {
        wd=wdr;
        pom=new PgObjManager(wd);
       
    }
public void performLogin(HashMap<String,String> testdata) {
    String Username = testdata.get("UserName");
    String Password = testdata.get("Password");
    String TestId = testdata.get("Test Id");
    System.out.println(Username);
    
    pom.getwaitOpertion().performImplicitWait(wd);
   // pom.getReport().CreateTestCase(TestId);
    pom.getHomePage().navigatetoLogin();
    pom.getHomePage().login(Username, Password);
}
public void performLogout() {
    pom.getwaitOpertion().performExplicit(wd, pom.getHomePage().getlogoutxpath());
    pom.getHomePage().logout();
}
}
