package test;

import Base.Base;
import POM.HomePage;
import POM.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends Base {
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
        HomePage.UIHomePage();
    }

    @Test()
    public void FilterAToZ() {
        // les choix du filtre
        // filtrer du A To Z
        String a = "az";
        // filtrer du Z To A
        String b = "za";
        // filtrer du low to high ( price )
        String c = "lohi";
        // filtrer du high to low ( price )
        String d = "hilo";
        HomePage.ChoiceOfFilter(a);
        HomePage.FilterAToZ();
    }

    @Test()
    public void FilterZToA() {
        // les choix du filtre
        // filtrer du A To Z
        String a = "az";
        // filtrer du Z To A
        String b = "za";
        // filtrer du low to high ( price )
        String c = "lohi";
        // filtrer du high to low ( price )
        String d = "hilo";
        HomePage.ChoiceOfFilter(b);
        HomePage.FilterZToA();
    }

    @Test()
    public void FilterFromLowToHigh() {
        // les choix du filtre
        // filtrer du A To Z
        String a = "az";
        // filtrer du Z To A
        String b = "za";
        // filtrer du low to high ( price )
        String c = "lohi";
        // filtrer du high to low ( price )
        String d = "hilo";
        HomePage.ChoiceOfFilter(c);
        HomePage.FilterFromLowToHigh();
    }

    @Test()
    public void FilterFromHighToLow() {
        // les choix du filtre
        // filtrer du A To Z
        String a = "az";
        // filtrer du Z To A
        String b = "za";
        // filtrer du low to high ( price )
        String c = "lohi";
        // filtrer du high to low ( price )
        String d = "hilo";
        HomePage.ChoiceOfFilter(d);
        HomePage.FilterFromHighToLow();
    }

    @Test()
    public void userLogout() {
        HomePage.userLogout();
    }

}
