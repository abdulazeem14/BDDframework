package stepDefination;

import static org.testng.Assert.fail;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import Manager.PgObjManager;
import Manager.TestManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Contact {
    PgObjManager pom;
    WebDriver wd;
    String strContactEmail,strContactName,strMessage;    
    static TestManager testmanager;
    public Contact()
    {
     wd=CommonSteps.getDriver();
     pom=new PgObjManager(wd);
     testmanager=new TestManager();
    }
    @When("^Click the Contact option from Top Nav$")
    public void click_the_contact_option_from_top_nav(){
        pom.getHomePage().NavigatetoContact();
    }
    
    @And("^Enter the Contact Email, Contact Name and Message field '(.+)'$")
    public void enter_the_contact_email_contact_name_and_message_field_(String testid){
        HashMap<String,String> testdata=testmanager.getTestcase("Contact", testid);
        strContactEmail=testdata.get("ContactEmail");
        strContactEmail=testdata.get("ContactName");
        strMessage=testdata.get("Message");
        pom.getwaitOpertion().performImplicitWait(wd);
        pom.getHomePage().EnterContactDetails(strContactEmail, strContactName, strMessage);
        pom.getHomePage().SendMessage();
    }
    
    @Then("^Message sent Acknowledgement Message is displayed$")
    public void message_sent_acknowledgement_message_is_displayed(){
        pom.getwaitOpertion().threadSleep(5000);
        if (strContactEmail.equals("") || strContactName.equals("") || strMessage.equals("")) {
           fail( "User can send a message if input field is empty");
        }
           else {
            pom.getalert().alertaccept(wd);
           
        }
       
    }

    

}
