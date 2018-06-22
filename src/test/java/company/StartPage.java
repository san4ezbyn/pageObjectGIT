package company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class StartPage {

   private static final String URL = "https://passport.yandex.by/";
    private WebDriver driver;

    public StartPage ( WebDriver driver ) {
        this.driver = driver;
        PageFactory.initElements ( this.driver , this );
    }

    public void openPage ( ) {
        this.driver.get (URL);
    }

    public LoginPage intype ( ) {
        System.out.println ("WELCOME TO MY PO PROJECT!");
        return new LoginPage ( this.driver );
    }
}
