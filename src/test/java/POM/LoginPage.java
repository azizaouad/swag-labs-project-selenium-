package POM;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends Base {
    public static  void UI(){
        WebElement emailField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        Assert.assertTrue(loginButton.isDisplayed());
        Assert.assertTrue(emailField.isDisplayed());
        Assert.assertTrue(passwordField.isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("login_credentials")).isDisplayed());
    }
    public static void EnterEmail(String email){
        WebElement emailField = driver.findElement(By.id("user-name"));
        emailField.sendKeys(email);
    }
    public static void EnterPassword(String password){
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
    }
    public  static void clickOnTheLoginButton(){
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }
    public static void userSuccesToLogin(){
        String url = "https://www.saucedemo.com/inventory.html";
        String CurrentURL= driver.getCurrentUrl();
        Assert.assertTrue(CurrentURL.contains(url));
        Assert.assertTrue(driver.findElement(By.id("shopping_cart_container")).isDisplayed());
    }
    public static void userFailToLogin(){
        WebElement emailField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        Assert.assertTrue(loginButton.isDisplayed());
        Assert.assertTrue(emailField.isDisplayed());
        Assert.assertTrue(passwordField.isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("login_credentials")).isDisplayed());
        String url= props.getProperty("url");
        String CurrentURl = driver.getCurrentUrl();
        Assert.assertTrue(url.equals(CurrentURl));
    }
    public static void EmptyFieldsAssertion(){
        waitForVisibilityOfElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3/button")).isDisplayed());

    }
}
