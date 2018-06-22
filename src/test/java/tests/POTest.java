package tests;

import company.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

import static java.lang.System.*;

public class POTest {

    private static final String Username     = "ivanivanovbyn";
    private static final String Password     = "borisov18";
    private              String RECEIVER     = "zzz@tut.by";
    public               String TOPIC        = String.format ( "PO-№- %s" , new Random ().nextInt ( 100 ) );
    private              String TEXT         = "IN VINO VERITAS\nHOMO HOMINI LUPUS EST\nOMNIA MEA MECUM PORTO.\n";
    private static final String LOGIN_MATCH  = "Авторизация";
    private static final String CORRECT_USER = "ivanivanovbyn";


    @FindBy(xpath = "//span[@class='mail-MessageSnippet-Item mail-MessageSnippet-Item_subjectWrapper js-message-snippet-subject']")
    private List <WebElement> listOfLetters;


    private WebDriver     driver;
    private WebDriverWait wait;

    @BeforeClass
    private void init ( ) {
        setProperty ( "webdriver.chrome.driver" , "C:\\Program Files\\ChromeDriver\\chromedriver.exe" );
        driver = new ChromeDriver ();
        driver.manage ().window ().maximize ();
    }


    @Test
    public void launchPage ( ) {
        System.out.println ( "TOPIC1 -" + TOPIC );
        StartPage startPage = new StartPage ( driver );
        startPage.openPage ();
        LoginPage loginPage = startPage.intype ();
        System.out.println ( "PAGE IS " + loginPage.getPageTitle () );
        Assert.assertEquals ( LOGIN_MATCH , loginPage.getPageTitle () );
        EnterEmailBox enterEmailBox = loginPage.login ( Username , Password );
        System.out.println ( loginPage.correctUser.getText () );
        Assert.assertEquals ( CORRECT_USER , loginPage.correctUser.getText () );
        NewLetterClick  newLetterClick  = enterEmailBox.enterMailBox ();
        WriteNewLetter  writeNewLetter  = newLetterClick.clickNewLetterButton ();
        SearchForLetter searchForLetter = writeNewLetter.sendNewLetter ( RECEIVER , TOPIC , TEXT );
        HomePage        homePage        = searchForLetter.clickLettersSent ();
        System.out.println ( "TOPIC2 -" + TOPIC );

        List <WebElement> mailList = driver.findElements ( By.xpath ( "//span[@class='mail-MessageSnippet-Item mail-MessageSnippet-Item_subjectWrapper js-message-snippet-subject']" ) );
        for (WebElement element : mailList) {
            String elementText = element.getText ().trim ();
            if (TOPIC.equals ( elementText )) {
                wait.until ( ExpectedConditions.textToBePresentInElement ( element , TOPIC ) );
                System.out.println ( "elementText-2 - " + elementText );
                element.click ();
            }
        }
    }

    @AfterTest
    public void tearDown ( ) {
        driver.close ();
    }
}



