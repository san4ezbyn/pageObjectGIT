package company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterEmailBox {

    private WebDriver driver;

    @FindBy(xpath ="//span[@class='user-account__name user-account__name_hasAccentLetter']")
    public static  WebElement userLogo;
    @FindBy(xpath="//a[@href='https://mail.yandex.by']")
    public static WebElement mailButton;

    public EnterEmailBox ( WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements ( this.driver , this );
    }
public NewLetterClick enterMailBox (){
    userLogo.click();
    mailButton.click ();
    return new NewLetterClick   (this.driver) ;
}

}
