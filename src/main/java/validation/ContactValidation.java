package validation;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import Manager.PgObjManager;

public class ContactValidation {
    WebDriver wd;
    SoftAssert assertion;
    PgObjManager pom;
    public ContactValidation(WebDriver wd) {
        this.wd=wd;
        pom=new PgObjManager(wd);
    }
    
public SoftAssert validateContact(HashMap<String,String> td) {
    assertion=new SoftAssert();
    String ContactEmail = td.get("ContactEmail");
  String ContactName = td.get("ContactName");
 String Message = td.get("Message");
    if (ContactEmail.equals("") || ContactName.equals("") || Message.equals("")) {
        assertion.assertEquals(wd.switchTo().alert().getText(), "input field is empty", "User can send a message if input field is empty");
  } else {
      assertion.assertEquals(wd.switchTo().alert().getText().toString(), "Thanks for the message!!");
      
  }
    return assertion;
    
}
}
