package stepDefination;

import java.text.NumberFormat;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import Manager.PgObjManager;
import Manager.TestManager;
import common.Basecls;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class PlaceOrder extends Basecls{
    static WebDriver wd;
    static PgObjManager pom;
    static TestManager testmanager;
  
    public PlaceOrder() {
        wd=CommonSteps.getDriver();
        testmanager=new TestManager();
        pom = new PgObjManager(wd);
      //  addproduct = new AddProduct(wd);
    }
    @When("^select the product from PLP page'(.+)'$")
    public void select_the_product_from_plp_page_(String testcaseId) {
        System.out.println("inside select product");
        pom.getwaitOpertion().threadSleep(5000);
        HashMap<String,String> testdata=testmanager.getTestcase("Cart", testcaseId);
        System.out.println(testdata);
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(0);
        int i = 1;
        while (i <= 3) {
            if (testdata.get("Product" + i + " Name").equals("")) {
                break;
            } 
            else {
                
               // addproduct.navigateToPDP(testdata.get("Product" + i + " Name"), testdata.get("Product" + i + " Amount"));
                i++;
            }

        }
        
    }
    @And("^Navigated to the PDP page$")
    public void navigated_to_the_pdp_page()  {
      
    }

    @And("^Product is added to cart$")
    public void product_is_added_to_cart()  {
      //  pom.getwaitOpertion().threadSleep(5000);
      //  addproduct.addToCart();
    }

    @And("^Navigate to cart page$")
    public void navigate_to_cart_page() {
        pom.getwaitOpertion().threadSleep(5000);
        pom.getHomePage().cart().click();
        
    }

    @And("^Place order and Enter User Details and Payment Details$")
    public void place_order_and_enter_user_details_and_payment_details()  {
        pom.getwaitOpertion().threadSleep(5000);
       // pom.getCart().placeOrder().click();
        pom.getwaitOpertion().threadSleep(5000);
        pom.getCart().pname().sendKeys("test data");
        pom.getCart().creditcard().sendKeys("4111111111111233333");
        pom.getCart().purchase().click();
       
    }
    @Then("^Order Confirmation$")
    public void order_confirmation()  {
        System.out.println("order confirmation");
       
    }



}
