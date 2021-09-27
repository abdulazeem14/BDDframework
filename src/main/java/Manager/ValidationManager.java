package Manager;

import org.openqa.selenium.WebDriver;

import validation.OrderValidation;
import validation.SignupValidation;
import validation.ContactValidation;
import validation.LoginValidation;

public class ValidationManager {
    WebDriver wd;
    LoginValidation loginvalidation;
    ContactValidation contactvalidation;
    OrderValidation categoryvalidation;
    SignupValidation signupvalidation;

    public ValidationManager(WebDriver wd) {
        this.wd=wd;
        
    }
    public LoginValidation getLoginValidation() {
        return (loginvalidation==null)?loginvalidation=new LoginValidation(wd):loginvalidation;
        
    }
    public ContactValidation getContactValidation() {
        return (contactvalidation==null)?contactvalidation=new ContactValidation(wd):contactvalidation;
        
    }
    public OrderValidation getOrderValidation() {
        return (categoryvalidation==null)?categoryvalidation=new OrderValidation(wd):categoryvalidation;
    }
    public SignupValidation getSignupValidation() {
        return (signupvalidation==null)?signupvalidation=new SignupValidation(wd):signupvalidation;
    }
    
}
