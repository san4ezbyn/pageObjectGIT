package company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewLetterClick {

    private WebDriver driver;

    @FindBy(xpath="//a[@class='mail-ComposeButton js-left-col-toolbar-compose']")
    private static  WebElement newLetterButton;
    public NewLetterClick ( WebDriver driver ){
        this.driver=driver;
        PageFactory.initElements ( this.driver, this );
    }
    public WriteNewLetter clickNewLetterButton ()  {
        new WebDriverWait (driver, 20).until( ExpectedConditions.visibilityOf(newLetterButton)).click ();
        return new WriteNewLetter ( this.driver );
    }
}
