package validation;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import Manager.PgObjManager;

public class OrderValidation {
    SoftAssert s_assert;
    PgObjManager pom;
  static  WebDriver wd;
   static String rounded;
    public OrderValidation(WebDriver wdr) {
       wd=wdr;
       
        s_assert=new SoftAssert();
    }
    public SoftAssert Productdetailsvalidation(HashMap<String,String> td,int i) {
        pom=new PgObjManager(wd);
        s_assert.assertEquals(td.get("Product" + i + " Name"), pom.getPDP().getProductName());//productname validation
        System.out.println(td.get("Product" + i + " Name")+"======"+pom.getPDP().getProductName());
        String arr[] = pom.getPDP().getProductPrice(); //get price
        System.out.println(arr[0]);
      float pri = Float.parseFloat(td.get("Product" + i + " Price"));
      System.out.println(pri+"float");
      NumberFormat nf = NumberFormat.getNumberInstance();
      nf.setMaximumFractionDigits(0);
      System.out.println(nf);
      rounded = nf.format(pri).replaceAll("[^a-zA-Z0-9]", "");
      System.out.println("rounded"+rounded);
      s_assert.assertEquals("$" + rounded, arr[0]);//product price validation
      System.out.println(rounded+"====== "+arr[0]);
      return s_assert;
        
    }
    public SoftAssert checkCartpage(WebDriver wd) {
        s_assert.assertEquals(wd.getCurrentUrl(), "https://www.demoblaze.com/cart.html");
        return s_assert;
    }
    public SoftAssert cartItemsValidation(HashMap<String,String> td) {
        int i=1;
        while (true) {
            if(!td.containsKey("Product" + i + " Name")) {
                break;
            }
          if (td.get("Product" + i + " Name").equals("")) {
              break;

          } else {

              s_assert.assertEquals(td.containsValue(pom.getCart().title(i).getText()), true, "product name");

          }
          i++;

      }
        return s_assert;
    }
    public SoftAssert validateTotal(HashMap<String,String> td) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(0);
        float total = Float.parseFloat(td.get("Total Amount"));
        rounded = nf.format(total).replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(rounded + "==check total amt=" + pom.getCart().total().getText());
        s_assert.assertEquals(rounded, pom.getCart().total().getText(), "Total Amount");
        return s_assert;
    }
    public SoftAssert validatepaymentdetails(HashMap<String,String> td) {
        if (td.get("Name").equals("") || td.get("Credit Card Number").equals("")) {
          pom.getwaitOpertion().threadSleep(5000);
          s_assert.assertEquals(wd.switchTo().alert().getText(), "Please fill out Name and Creditcard.");
         
      } else {

          pom.getwaitOpertion().threadSleep(5000);

          String str[] = pom.getCart().orderDetails().getText().split("\\r?\\n");
          HashMap < String, String > od = new HashMap < > ();
          for (int j = 0; j < str.length; j++) {
              String[] details = str[j].split(":");
              od.put(details[0], details[1].substring(1));
              }
          DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
          LocalDateTime now = LocalDateTime.now();
          System.out.println(od.get("Name") + "==" + td.get("Name"));
          s_assert.assertEquals(od.get("Name"), td.get("Name"), "order details");
          System.out.println(od.get("Card Number") + "==" + td.get("Credit Card Number"));
          s_assert.assertEquals(od.get("Card Number"), td.get("Credit Card Number"), "credit card number");
          System.out.println(od.get("Amount") + "==" + rounded + " USD");
          s_assert.assertEquals(od.get("Amount"), rounded + " USD", "total amount");
          System.out.println();
          System.out.println(dtf.format(now));
          System.out.println(od.get("Date") + "==" + dtf.format(now).toString());
          s_assert.assertEquals(od.get("Date"), dtf.format(now).toString(), "date");
          
    }
        return s_assert;
  
    }
}
