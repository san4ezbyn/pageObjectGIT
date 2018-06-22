package company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@name='login']")
    private static WebElement loginField;
    @FindBy(xpath = "//input[@type='password']")
    private static WebElement passwordField;
    @FindBy(xpath = "//span[@class='passport-Button-Content']")
    private static WebElement loginButtonEnter;
    @FindBy(xpath = "//span[@class='user-account__name user-account__name_hasAccentLetter']")
    public static WebElement correctUser;

    protected LoginPage ( WebDriver driver ) {
        this.driver = driver;

        PageFactory.initElements ( this.driver , this );
    }

    public String getPageTitle ( ) {
        return this.driver.getTitle ();
    }

    public EnterEmailBox login ( String Username , String Password ) {
        loginField.sendKeys ( Username );
        passwordField.sendKeys ( Password );
        loginButtonEnter.click ();
        correctUser.getText ();
        return new EnterEmailBox ( this.driver );
    }
}
