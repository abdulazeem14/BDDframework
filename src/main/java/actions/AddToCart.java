package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Manager.PgObjManager;
import common.Basecls;

public class AddToCart{
    WebDriver wd;
    PgObjManager pom;
    public AddToCart(WebDriver wd)
    {
        this.wd=wd;
    }
    public void navigatetopdp(String strProductName) {
        pom=new PgObjManager(wd);
        pom.getwaitOpertion().performImplicitWait(wd);
        pom.getHomePage().NavigatetoPDP(strProductName);
    }
    public void addTOCart() {
       
        pom.getHomePage().addToCart(wd, pom); 
    }
    public void selectCategories(PgObjManager pom,String category) {
        for (WebElement categories: pom.getHomePage().getCatergory()) {
            if (categories.getText().equals(category)) {
                categories.click();
                
            }
    }
    }

}
