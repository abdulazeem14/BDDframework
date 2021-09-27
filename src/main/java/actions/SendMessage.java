package actions;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import Manager.PgObjManager;

public class SendMessage {
    PgObjManager pom;
    public SendMessage(WebDriver wd) {
        pom=new PgObjManager(wd);
    }
    public void enterContactDetails(HashMap < String, String > td) {
        String ContactEmail = td.get("ContactEmail");
        String ContactName = td.get("ContactName");
        String Message = td.get("Message");
        pom.getHomePage().EnterContactDetails(ContactEmail, ContactName, Message);
    }

}
