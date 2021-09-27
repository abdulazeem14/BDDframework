package stepDefination;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Manager.PgObjManager;
import Manager.TestManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Category {
    public WebDriver wd;
    static PgObjManager pom;
    String strCategory;
    static TestManager testmanager;
  
public Category() {
    wd=CommonSteps.getDriver();
    pom=new PgObjManager(wd);
    testmanager=new TestManager();
}
@When("^select the phones in categories'(.+)' $")
public void user_select_the_phones_in_categories(String testid){
    System.out.println("inside when");
    HashMap<String,String> testdata=testmanager.getTestcase("Category", testid);
    System.out.println(testdata+" "+testid);
    strCategory=testdata.get("Category");
    for (WebElement catergory: pom.getHomePage().getCatergory()) {
        if (catergory.getText().equals(strCategory)) {
            catergory.click();
        }
    }
    pom.getwaitOpertion().threadSleep(5000);
        
}

@And("^Products related to Phones category is displayed in PLP$")
public void products_related_to_phones_category_is_displayed_in_plp()  {
   
}

@And("^Select the Product from PLP$")
public void select_the_product_from_plp()  {
    
}

@Then("^Home page is Displayed $")
public void home_page_is_displayed(){
    
}


}
