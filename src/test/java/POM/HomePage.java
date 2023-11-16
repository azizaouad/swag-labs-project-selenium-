package POM;

import Base.Base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomePage extends Base {
    public static void UIHomePage() {
        Assert.assertTrue(driver.findElement(By.id("shopping_cart_container")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("react-burger-menu-btn")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("inventory_item_name")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("inventory_item_price")).isDisplayed());

    }

    public static void ChoiceOfFilter(String val) {
        Select select = new Select(driver.findElement(By.className("product_sort_container")));
        select.selectByValue(val);
    }

    public static void FilterAToZ() {
        List<WebElement> Names = driver.findElements(By.className("inventory_item_name"));

        for (int i = 0; i < Names.size() - 1; i++) {
            String NameOne = Names.get(i).getText().toUpperCase();
            String NameTwo = Names.get(i + 1).getText().toUpperCase();

            int result = NameOne.compareTo(NameTwo);
            boolean bol = result < 0;
            Assert.assertTrue(bol);
            // System.out.println(bol);

            // if (result < 0) {
            // System.out.println(NameOne + " comes before " + NameTwo);
            // } else if (result > 0) {
            // System.out.println(NameOne + " comes after " + NameTwo);
            // } else {
            // System.out.println(NameOne + " is equal to " + NameTwo);
            // }
        }
    }

    public static void FilterZToA() {
        List<WebElement> Names = driver.findElements(By.className("inventory_item_name"));

        for (int i = 0; i < Names.size() - 1; i++) {
            String NameOne = Names.get(i).getText().toUpperCase();
            String NameTwo = Names.get(i + 1).getText().toUpperCase();

            int result = NameOne.compareTo(NameTwo);
            boolean bol = result > 0;
            Assert.assertTrue(bol);
        }
    }

    public static void FilterFromLowToHigh() {
        List<WebElement> price = driver.findElements(By.className("inventory_item_price"));

        for (int i = 0; i < price.size() - 1; i++) {
            double priceOne = Double.parseDouble(price.get(i).getText().replace("$", ""));
            double priceTwo = Double.parseDouble(price.get(i + 1).getText().replace("$", ""));
            boolean bol = priceOne <= priceTwo;
            // System.out.println(priceOne + "<" + priceTwo);

            Assert.assertTrue(bol, "Les prix ne sont pas dans l'ordre croissant");
        }

    }

    public static void FilterFromHighToLow() {
        List<WebElement> price = driver.findElements(By.className("inventory_item_price"));

        for (int i = 0; i < price.size() - 1; i++) {
            double priceOne = Double.parseDouble(price.get(i).getText().replace("$", ""));
            double priceTwo = Double.parseDouble(price.get(i + 1).getText().replace("$", ""));
            boolean bol = priceTwo <= priceOne;
            // System.out.println(priceOne + ">" + priceTwo);

            Assert.assertTrue(bol, "Les prix ne sont pas dans l'ordre décroissant");
        }

    }

    public static void userLogout() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();

    }
}
