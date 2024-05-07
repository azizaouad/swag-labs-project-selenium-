package test;

import Base.Base;

import POM.LoginPage;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends Base {
    ITestResult testResult;

    @BeforeMethod()
    public void setup() {
        launchBrowser();


        
    }

    @AfterMethod()
    public void tearDown() {
        CloseBrowser();

    }

    @Test()
    public void UItest() {

        testResult = Reporter.getCurrentTestResult(); // Récupérer le résultat du test
        String testName = testResult.getMethod().getMethodName();
        System.out.println("Début du test : " + testName);
        LoginPage.UI();
        // System.out.println("le site Web a été ouvert avec succès");
        // WebElement DropDown =
        // driver.findElement(By.name("fields[programming_language]"));
        // Select select = new Select(DropDown);
        // select.selectByValue("Java");
        // driver.findElement(By.xpath("//input[@value='Join the mailing
        // list']")).click();
        // WebElement source = driver.findElement(By.id("column-a"));
        // WebElement destination = driver.findElement(By.id("column-b"));
        // Actions action = new Actions(driver);
        // action.dragAndDrop(source,destination);
        // action.clickAndHold(source).moveToElement(destination).release().build().perform();

        // driver.findElement(By.xpath("//*[@id=\"checkbox\"]/input")).click();
    }

    @Test
    public void SuccesTologin() {
        testResult = Reporter.getCurrentTestResult(); // Récupérer le résultat du test
        String testName = testResult.getMethod().getMethodName();
        System.out.println("Début du test : " + testName);
        LoginPage.EnterEmail(props.getProperty("email"));
        LoginPage.EnterPassword(props.getProperty("password"));
        LoginPage.clickOnTheLoginButton();
        LoginPage.userSuccesToLogin();
    }

    @Test
    public void FailTologin() {
        testResult = Reporter.getCurrentTestResult(); // Récupérer le résultat du test
        String testName = testResult.getMethod().getMethodName();
        System.out.println("Début du test : " + testName);
        LoginPage.EnterEmail(props.getProperty("wrongemail"));
        LoginPage.EnterPassword(props.getProperty("wrongpassword"));
        LoginPage.clickOnTheLoginButton();
        LoginPage.userFailToLogin();
    }

    @Test
    public void EmptyFields() {
        testResult = Reporter.getCurrentTestResult(); // Récupérer le résultat du test
        String testName = testResult.getMethod().getMethodName();
        System.out.println("Début du test : " + testName);
        LoginPage.EnterEmail("");
        LoginPage.EnterPassword("");
        LoginPage.clickOnTheLoginButton();
        LoginPage.EmptyFieldsAssertion();
    }

}
