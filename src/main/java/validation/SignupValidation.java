package validation;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import Manager.PgObjManager;

public class SignupValidation {
    SoftAssert s_assert;
    PgObjManager pom;
  static  WebDriver wd;
   static String rounded;
    public SignupValidation(WebDriver wdr) {
       wd=wdr;
        s_assert=new SoftAssert();
    }
    public SoftAssert performSignupValidation(HashMap<String,String> td) {
        String username = td.get("Username");
        String password = td.get("Password");
        if (!username.contains("@")) {
            s_assert.assertEquals(pom.getalert().alertGettext(wd), "Invalid username.", "Invalid email Error");
        }
        if (username.contains("@") && password.length() < 8) {
            s_assert.assertEquals(pom.getalert().alertGettext(wd), "passsword is not strong.", "password is not strong but new user creted");
        }
        if (username.contains("@")) {
            s_assert.assertEquals(pom.getalert().alertGettext(wd), "Sign up successful.");
            pom.getalert().alertaccept(wd);
        }
        return s_assert;
    }
}
