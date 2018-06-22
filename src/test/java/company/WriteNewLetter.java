package company;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WriteNewLetter {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='mail-Compose-Field-Input']/div[@name='to']")
    private WebElement fieldToWhome;
    @FindBy(xpath = "//input[@class='mail-Compose-Field-Input-Controller js-compose-field js-editor-tabfocus-prev']")
    private WebElement fieldTopic;
    @FindBy(xpath = "//textarea[@dir='ltr']")
    private WebElement letterText;
    @FindBy(xpath = "//button[@class='nb-button _nb-action-button _init js-send-button ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']")
    private WebElement sendLetterButton;
    @FindBy(xpath = "//span[contains (text(), 'Сохранить и перейти')]")
    private WebElement closePopUp;

    public WriteNewLetter ( WebDriver driver ) {
        this.driver = driver;
        PageFactory.initElements ( this.driver , this );
    }

    public SearchForLetter sendNewLetter ( String RECEIVER , String TOPIC , String TEXT ) {

        new WebDriverWait ( driver , 15 ).until ( ExpectedConditions.visibilityOf ( fieldToWhome ) ).sendKeys ( RECEIVER );
        new WebDriverWait ( driver , 15 ).until ( ExpectedConditions.visibilityOf ( fieldTopic ) ).sendKeys ( TOPIC );
        new WebDriverWait ( driver , 15 ).until ( ExpectedConditions.visibilityOf ( letterText ) ).sendKeys ( TEXT );
        new WebDriverWait ( driver , 15 ).until ( ExpectedConditions.visibilityOf ( sendLetterButton ) ).click ();

        try {
                    new WebDriverWait ( driver , 15 ).until ( ExpectedConditions.visibilityOf ( closePopUp ) ).submit ();
        }
        catch (TimeoutException toe) {
            System.out.println ("NO POP UP WINDOW");
        }
        return new SearchForLetter ( this.driver );
    }
}
