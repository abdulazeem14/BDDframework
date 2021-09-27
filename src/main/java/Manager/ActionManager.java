package Manager;

import org.openqa.selenium.WebDriver;

import actions.AddToCart;
import actions.LoginAction;
import actions.PlaceOrder;
import actions.SendMessage;
import actions.SignupAction;

public class ActionManager {
    private static WebDriver wd;
    private  AddToCart addtocart;
    private  PlaceOrder placeorder;
    private  SendMessage sendmessage;
    private LoginAction loginaction;
    private SignupAction signupaction;
    
    public ActionManager(WebDriver wdr)
    {
        wd=wdr;
    }
    public AddToCart getCartAction() {
        return (addtocart==null)? addtocart=new AddToCart(wd) : addtocart;
    }
    public PlaceOrder getOrderAction() {
        return (placeorder==null)? placeorder=new PlaceOrder(wd):placeorder;
    }
    public SendMessage getContactAction() {
        return (sendmessage==null)?sendmessage=new SendMessage(wd):sendmessage;
    }
    public LoginAction getLoginAction() {
        return (loginaction==null)?loginaction=new LoginAction(wd):loginaction;
    }
    public SignupAction getSignupAction() {
        return (signupaction==null)?signupaction=new SignupAction(wd):signupaction;
    }
    

}
