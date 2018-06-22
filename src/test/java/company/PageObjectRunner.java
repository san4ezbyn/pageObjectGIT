package company;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageObjectRunner {


    public void WebDriverRunner ( ) {
        //List of xml suites to be considered for test execution
        List <XmlSuite> suites = new ArrayList <XmlSuite> ();
        //List of classes to be considered for test execution
        List <XmlClass> classes = new ArrayList <XmlClass> ();

        Map <String, String> suiteParams = new HashMap <String, String> ();
        Map <String, String> testParams  = new HashMap <String, String> ();

        //Defines a simple xml suite with a name
        XmlSuite suite = new XmlSuite ();
        suite.setName ( "SuitePO" );
        //Defining suite level params and their values
        suiteParams.put ( "suite-param-one" , "Suite Param One" );
        suiteParams.put ( "suite-param-two" , "Suite Param Two" );
        //Setting the params to the suite
        suite.setParameters ( suiteParams );

        //Defines a xml test for a suite and with a said name
        XmlTest test = new XmlTest ( suite );
        test.setName ( "LogIn" );

        //Defining test level params and their values
        testParams.put ( "test-param-one" , "Param One" );
        testParams.put ( "test-param-two" , "Param Two" );
        //Setting the test level params
        test.setParameters ( testParams );

        //A single xml class to be considered for execution
        XmlClass myclass = new XmlClass ( "tests.POTest" );
        classes.add ( myclass );
        //Sets the list of classes to be considered for execution
        //for a test
        test.setXmlClasses ( classes );

        //Adds a single suite to the list suites
        suites.add ( suite );

        //Defining a testng instance
        TestNG tng = new TestNG ();
        //Sets the List of xml suites to be considered for execution
        tng.setXmlSuites ( suites );
        //Runs the configured testng tests.
        tng.run ();
    }

    public static void main ( String[] args ) {
        PageObjectRunner por = new PageObjectRunner ();
        por.WebDriverRunner ();


    }
}


