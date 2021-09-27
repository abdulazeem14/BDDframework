package actions;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import Manager.PgObjManager;

public class PlaceOrder {
    //WebDriver wd;
    private PgObjManager pom;
    public PlaceOrder(WebDriver wd)
    {
        pom=new PgObjManager(wd);
    }
    public void placeOrder() {
       
        pom.getCart().placeOrder();
        
    }
    public boolean addOrderDetails(HashMap < String, String > td) {
        boolean flag=false;
        pom.getCart().pname().sendKeys(td.get("Name"));
        pom.getCart().creditcard().sendKeys(td.get("Credit Card Number"));
        if(td.get("Name").equals("")||td.get("Credit Card Number").equals("")) {
            flag=true; 
        }
        pom.getCart().purchase().click();
        return flag;
    }
    public void orderConfirmation() {
        pom.getCart().orderConformation();
    }
}
