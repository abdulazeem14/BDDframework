package stepDefination;

import org.openqa.selenium.WebDriver;

import common.Basecls;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class CommonSteps extends Basecls {
public static  WebDriver wd;
@Before(order=0)
public void setup()
{
    getsetup();
   
}
@Given("^User is on a landing page$")
public void navigateToStore()  {
    getNavigate();
    
    
}
public  void getsetup() {
    wd=initializeDriver("Chrome");
}
public void getNavigate() {
   Navigatetosite(wd);
}

public static  WebDriver getDriver()

{
System.out.println("getwebdriver"+wd);
    return wd;
}
@After(order=0)
public void teardown()
{
    wd.quit();
}



}
