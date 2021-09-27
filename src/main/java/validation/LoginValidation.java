package validation;

import static org.testng.Assert.fail;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Manager.PgObjManager;
import constant.Constant;

public class LoginValidation {
PgObjManager pom;
WebDriver wd;
public LoginValidation(WebDriver wd) {
    this.wd=wd;
    pom=new PgObjManager(wd);
}
public void loginvalidation(HashMap<String,String> td) {
    
    String strUserName = td.get("UserName");
    String Function = td.get("Function");
    String AlertMessage = td.get("AlertMessage");
    if (Function.equals("logout")) {
        pom.getwaitOpertion().performExplicit(wd, pom.getHomePage().getlogoutxpath());
        pom.getHomePage().logout();
        Assert.assertNotEquals(pom.getHomePage().getUserName(), strUserName,"user able to logout as expected");
        
    }
    if (Function.equals("")) {
      
        WebDriverWait w = new WebDriverWait(wd, 5);
        try {

            if (w.until(ExpectedConditions.alertIsPresent()) != null) {
                System.out.println(wd.switchTo().alert().getText()+"  ================  "+AlertMessage);
                Assert.assertEquals(wd.switchTo().alert().getText(), AlertMessage);
                pom.getalert().alertaccept(wd);
            }
        } catch (Exception E) {
            Assert.assertEquals(pom.getHomePage().getUserName(), "Welcome " + strUserName);
           
        }
    
}
}
public void validateUsername(HashMap<String,String> td)
{
    String strUserName=td.get("UserName");
    pom.getwaitOpertion().threadSleep(5000);
    System.out.println(pom.getHomePage().getUserName());
    if(pom.getHomePage().getUserName().equals("Welcome "+strUserName)) {
        System.out.println("username is displayed");
    }
    else{
        fail("username is not displayed");
    }
}
public void validateHomepage(WebDriver wd)
{
    if(Constant.getHomepageUrl().equals(wd.getCurrentUrl()))
    {
        System.out.println("HomePage is Dispalyed");
    }
    else
    {
        fail("Home page is not Loaded");
    }
}
public void validateErrorMsg(WebDriver wd) {
    WebDriverWait w = new WebDriverWait(wd, 5);
    if (w.until(ExpectedConditions.alertIsPresent()) != null) {
       System.out.println(wd.switchTo().alert().getText());
        pom.getalert().alertaccept(wd);
    }
    else {
        fail("Error message is not displayed");
    }
}
}
