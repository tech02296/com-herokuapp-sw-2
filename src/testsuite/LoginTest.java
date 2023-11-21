package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before

    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test

    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //find the username field

        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("tomsmith");

        // find the password field and type the password

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        // find the login button and click on it

        driver.findElement(By.xpath("//button[@class='radius']")).click();

        String expectedText = "Secure Area";

        // find the actual text element and get the text from the element

        WebElement actualTextElement = driver.findElement(By.xpath("//h2"));
        String actualText = actualTextElement.getText();
    }

    @Test

    public void verifyTheUsernameErrorMessage(){
        // find the username field and type on it

        WebElement usernameField = driver.findElement(By.name("username"));
                usernameField.sendKeys("tomsmith1");

        // find the password field and type the password on it

        driver.findElement(By.name("SuperSecretPassword!"));

        // find the login button and click on it

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String expectedText = "Your username is invalid!";

        // find the actual text result

        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='flash error'"));
        String actualText = actualTextElement.getText();

        // verify the actual and expected text

        Assert.assertEquals("Your username is invalid!",expectedText,actualText);

    }
    @Test

    public void verifyThePasswordErrorMessage() {
        // find the username field and type on it

        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("tomsmith");

        // find the password field and type on it

        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");

        // find the login button and click on it

        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));

        String expectedText = "Your password is invalid!";

        // find the actual text element and get the text

        WebElement actualTextElement = driver.findElement(By.xpath("div[@class='flash error'"));
        String actualText = actualTextElement.getText();

        // verify expected and actual text result

        Assert.assertEquals("Your password is invalid!", "expectedText,actualText");
    }
    @After

    public void tearDown(){
        closeBrowser();

    }


}


