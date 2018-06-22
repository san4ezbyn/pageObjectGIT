package company;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.POTest;
import java.util.List;

public class SearchForLetter {

    public WebDriver driver;

    public SearchForLetter ( WebDriver driver ) {
        this.driver = driver;
        PageFactory.initElements ( this.driver , this );
    }

    POTest poTest = new POTest ();
    protected final static int TIME_OUT = 60;
    WebDriverWait wait;

    @FindBy(xpath = "//a[@href='#sent']")
    WebElement sentLetters;


    public HomePage clickLettersSent ( ) {
        sentLetters.click ();
        return new HomePage ( this.driver );
    }
}