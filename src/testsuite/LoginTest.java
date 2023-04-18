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
    public void setup(){
        openBrowser(baseUrl);
    }

//1. UserShouldLoginSuccessfullyWithValidCredentials





@Test
    public void UserShouldLoginSuccessfullyWithValidCredentials() {
    //* Enter “tomsmith” username
    driver.findElement(By.id("username")).sendKeys("tomsmith");

//* Enter “SuperSecretPassword!” password
    driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

//* Click on ‘LOGIN’ button

    driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();

////* Verify the text “Secure Area”
    String expectedMessage = "Secure Area";
    WebElement actualTextElement = driver.findElement(By.xpath("//h2[contains(text(),' Secure Area')]"));
    String actualMessage = actualTextElement.getText();
    Assert.assertEquals(" Secure Area message is not displayed ", expectedMessage, actualMessage);

}

//    2. verifyTheUsernameErrorMessage



//  * Verify the error message “Your username
//    is invalid!”


    @Test
    public void verifyTheUsernameErrorMessage(){

       // * Enter “tomsmith1” username
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
//            * Enter “SuperSecretPassword!” password

        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //  * Click on ‘LOGIN’ button

        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        // * Verify the error message “Your username is invalid!”

        String expectedMessage = "Your username is invalid!";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@id='flash']")) ;
        String actualMessage=actualTextElement.getText();
        boolean trueMessage = actualMessage.contains(expectedMessage);
        Assert.assertTrue(trueMessage);






    }


//3. verifyThePasswordErrorMessage




@Test
public void verifyThePasswordErrorMessage(){
    //* Enter “tomsmith” username

    driver.findElement(By.id("username")).sendKeys("tomsmith");

    //* Enter “SuperSecretPassword” password
    driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");

    //  * Click on ‘LOGIN’ button

    driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();



    String expectedMessage = "Your password is invalid!";
    WebElement actualTextElement = driver.findElement(By.xpath("//div[contains(text(),'Your password is invalid!')]"));
    String actualMessage = actualTextElement.getText();
    boolean trueMessage = actualMessage.contains(expectedMessage);
    Assert.assertTrue(trueMessage);


}



    @After
    public void tearDown(){
        closeBrowser();
    }

}




