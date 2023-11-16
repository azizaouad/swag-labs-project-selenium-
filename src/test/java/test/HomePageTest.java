package test;

import Base.Base;
import POM.HomePage;
import POM.LoginPage;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends Base {
    ITestResult testResult;

    @BeforeMethod()
    public void Setup() {
        launchBrowser();
        LoginPage.EnterEmail(props.getProperty("email"));
        LoginPage.EnterPassword(props.getProperty("password"));
        LoginPage.clickOnTheLoginButton();
    }

    @AfterMethod()
    public void TearDown() {
        CloseBrowser();
    }

    @Test()
    public void UIHomePage() {
        testResult = Reporter.getCurrentTestResult(); // Récupérer le résultat du test
        String testName = testResult.getMethod().getMethodName();
        System.out.println("Début du test : " + testName);
        HomePage.UIHomePage();
    }

    @Test()
    public void FilterAToZ() {
        testResult = Reporter.getCurrentTestResult(); // Récupérer le résultat du test
        String testName = testResult.getMethod().getMethodName();
        System.out.println("Début du test : " + testName);
        // les choix du filtre
        // filtrer du A To Z
        String a = "az";
        HomePage.ChoiceOfFilter(a);
        HomePage.FilterAToZ();
    }

    @Test()
    public void FilterZToA() {
        testResult = Reporter.getCurrentTestResult(); // Récupérer le résultat du test
        String testName = testResult.getMethod().getMethodName();
        System.out.println("Début du test : " + testName);
        // les choix du filtre
        // filtrer du Z To A
        String b = "za";

        HomePage.ChoiceOfFilter(b);
        HomePage.FilterZToA();
    }

    @Test()
    public void FilterFromLowToHigh() {
        testResult = Reporter.getCurrentTestResult(); // Récupérer le résultat du test
        String testName = testResult.getMethod().getMethodName();
        System.out.println("Début du test : " + testName);
        // les choix du filtre
        // filtrer du low to high ( price )
        String c = "lohi";
        HomePage.ChoiceOfFilter(c);
        HomePage.FilterFromLowToHigh();
    }

    @Test()
    public void FilterFromHighToLow() {
        testResult = Reporter.getCurrentTestResult(); // Récupérer le résultat du test
        String testName = testResult.getMethod().getMethodName();
        System.out.println("Début du test : " + testName);
        // les choix du filtre
        // filtrer du high to low ( price )
        String d = "hilo";
        HomePage.ChoiceOfFilter(d);
        HomePage.FilterFromHighToLow();
    }

    @Test()
    public void userLogout() {
        testResult = Reporter.getCurrentTestResult(); // Récupérer le résultat du test
        String testName = testResult.getMethod().getMethodName();
        System.out.println("Début du test : " + testName);
        HomePage.userLogout();
    }

}
