package stepDefination;

import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import Manager.ActionManager;
import Manager.PgObjManager;
import Manager.TestManager;
import Manager.ValidationManager;
import common.Basecls;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login extends Basecls{
   public static WebDriver wd;
   static PgObjManager pom;
   static ActionManager actionmanager;
   static ValidationManager validationmng;
   static TestManager testmanager;
  static HashMap<String,String> testdata;
   
   public Login() {
       wd=CommonSteps.getDriver();
       System.out.println("webdriver"+wd);
       actionmanager=new ActionManager(wd);
       validationmng=new ValidationManager(wd);
       testmanager=new TestManager();
       
       
   }
    @When("^User enter username and password '(.+)'$")
    public void user_login_to_the_application_by_entering_valid_username_and_password_(String testcaseId) {
        testdata=testmanager.getTestcase("Login", testcaseId);
        System.out.println(testdata);
        actionmanager=new ActionManager(wd);
        actionmanager.getLoginAction().performLogin(testdata);
    }
    @And("^Username is displayed$")
    public  void checkUsername() {
       validationmng.getLoginValidation().validateUsername(testdata);
    }
      
    @Then("^Home page is Displayed$")
    public void home_page_is_Displayed() {
      validationmng.getLoginValidation().validateHomepage(wd);
        wd.close();
       
    }
 
   
    @Then("^Error Message Should be displayed$")
    public void error_Message_Should_be_displayed() {
        validationmng.getLoginValidation().validateErrorMsg(wd);
        wd.close();
    }

    @And("^Press the Logout button$")
    public void logOutOperation() {
       
       actionmanager.getLoginAction().performLogout();
        
    }

    @Then("^User is Logout Successfully$")
    public void afterLogout(){
       validationmng.getLoginValidation().loginvalidation(testdata);
       wd.close();
    }
   
}