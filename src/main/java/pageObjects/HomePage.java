package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Manager.PgObjManager;
import common.Basecls;

public class HomePage extends Basecls {
    WebDriver wd;
    String cat = null;
    int index;
    By homebtn = By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a");
    By contactbtn = By.xpath("//*[@id=\"navbarExample\"]/ul/li[2]/a");
    By aboutusbtn = By.xpath("//*[@id=\"navbarExample\"]/ul/li[8]");
    By cartbtn = By.xpath("//*[@id=\"cartur\"]");
    By loginbtn = By.xpath("//*[@id=\"login2\"]");
    By logoutbtn = By.xpath("//*[@id='logout2']");
    By addTOCartbtn=By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");
    By signupbtn = By.xpath("//*[@id=\"signin2\"]");
    By lUsernametxt = By.xpath("//*[@id=\"loginusername\"]");
    By lPasswordtxt = By.xpath("//*[@id=\"loginpassword\"]");
    By lClosebtn = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[1]");
    By xCloseicn = By.xpath("//*[@id='logInModal']/div/div/div[1]/button/span");
    By lLoginbtn = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");
    By welcomeuserlbl = By.xpath("//*[@id=\"nameofuser\"]");
    By categorylst = By.xpath("//*[@id='itemc']");
    By plplst = By.xpath("//*[@id='tbodyid']/child::*/child::div/div/h4/a");
    By sUsernametxt = By.xpath("//*[@id=\"sign-username\"]");
    By sPasswordtxt = By.xpath("//*[@id=\"sign-password\"]");
    By sClosebtn = By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[1]");
    By sSignupbtn = By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");
    By cEmailbtn = By.xpath("//*[@id='recipient-email']");
    By cContactnametxt = By.xpath("//*[@id='recipient-name']");
    By cMessagetxt = By.xpath("//*[@id='message-text']");
    By cSendmsgbtn = By.xpath("//*[@id='exampleModal']/div/div/div[3]/button[2]");


    public HomePage(WebDriver wd) {

        this.wd = wd;
    }
    public WebElement home() {
        return wd.findElement(homebtn);
    }
    public WebElement contact() {
        return wd.findElement(contactbtn);
    }
    public WebElement aboutus() {
        return wd.findElement(aboutusbtn);
    }
    public WebElement cart() {
        return wd.findElement(cartbtn);
    }
    public WebElement login() {
        return wd.findElement(loginbtn);
    }
    public WebElement signup() {
        return wd.findElement(signupbtn);
    }
    public WebElement Lusername() {
        return wd.findElement(lUsernametxt);
    }
    public WebElement Lpassword() {
        return wd.findElement(lPasswordtxt);
    }
    public WebElement Lclose() {
        return wd.findElement(lClosebtn);
    }
    public WebElement Llogin() {
        return wd.findElement(lLoginbtn);
    }
    public WebElement Welcomeuser() {
        return wd.findElement(welcomeuserlbl);
    }
    public List < WebElement > categoryLst() {
        return wd.findElements(categorylst);
    }

    public List < WebElement > plp() {

        return wd.findElements(plplst);
    }

    public WebElement Susername() {
        return wd.findElement(sUsernametxt);
    }
    public WebElement Spassword() {
        return wd.findElement(sPasswordtxt);
    }
    public WebElement Sclose() {
        return wd.findElement(sClosebtn);
    }
    public WebElement Ssignup() {
        return wd.findElement(sSignupbtn);
    }

    public WebElement cEmail() {
        return wd.findElement(cEmailbtn);
    }
    public WebElement cContact() {
        return wd.findElement(cContactnametxt);
    }
    public WebElement CMessage() {
        return wd.findElement(cMessagetxt);
    }
    public WebElement cSendMessage() {
        return wd.findElement(cSendmsgbtn);
    }
    public WebElement logOut() {
        return wd.findElement(logoutbtn);
    }
    public WebElement xclose() {
        return wd.findElement(xCloseicn);
    }
    public WebElement addToCartbtn() {
        return wd.findElement(addTOCartbtn);
    }

    public void navigatetoLogin() {
        System.out.println("navigateto login");
        login().click();
    }
    public void login(String username, String pass) {

        Lusername().sendKeys(username);
        Lpassword().sendKeys(pass);

        Llogin().click();

    }

    public void logout() {
        logOut().click();
    }
    public String getUserName() {
        return Welcomeuser().getText();

    }
    public By getlogoutxpath() {
        return logoutbtn;
    }

    public void NavigatetoContact() {
        contact().click();
    }
    public void EnterContactDetails(String ContactEmail, String ContactName, String Message) {
        cEmail().sendKeys(ContactEmail);

        cContact().sendKeys(ContactName);

        CMessage().sendKeys(Message);

    }
    public void SendMessage() {
        cSendMessage().click();

    }
    public List < WebElement > getCatergory() {
        return categoryLst();
    }

    public List < WebElement > getPLP() {
        return plp();
    }
    public void Navigatetocart() {
        cart().click();
    }


    public void Navigatetosignup() {
        signup().click();
    }

    public void SignupCredentials(String username, String password) {
        Susername().sendKeys(username);
        Spassword().sendKeys(password);
    }
    public void clickSingnup() {
        Ssignup().click();
    }
    public void NavigatetoPDP(String productname) {
        
        for(WebElement we:plp()) {
            if(we.getText().equals(productname)) {
                we.click();
                break;
            }
        }
    }
    public void addToCart(WebDriver wd,PgObjManager pom)
    {
        addToCartbtn().click();
        pom.getwaitOpertion().threadSleep(2000);
        pom.getalert().alertaccept(wd);
        home().click();
        pom.getwaitOpertion().threadSleep(2000);
        
        
        
    }


}