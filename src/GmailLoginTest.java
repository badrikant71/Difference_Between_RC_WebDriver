import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
  * Class name: GmailLoginTest.java
  * Selenium RC 
  **/

public class GmailLoginTest extends SeleneseTestCase {
               
public void setUp() throws Exception {
                super.setUp(); 
                selenium = new DefaultSelenium("localhost", 4444, "*chrome", " https://mail.google.com/mail/");
                selenium.start();
}

public void testGmailLoginTest() throws Exception {

                selenium.open("https://mail.google.com/mail/");

                /* Verify Google mail login page header bar */
                selenium.isElementPresent("xpath=//div[@class='google-header-bar']");
               
                /* Verify Sign in box and labels and text fields. */
                selenium.isElementPresent("xpath=//div[@class='signin-box']");
               
                /* Verify the User Name label. */
                String userName = selenium.getText("xpath=//strong[@class='email-label']");
                assertEquals(userName, "Username");

                /* Verify the Password label */
                String password = selenium.getText("xpath=//strong[@class='passwd-label']");
                assertEquals(password, "Password");

                /* Verify if Username and Password text fields is available then enter the valid username and password.*/
                if(selenium.isElementPresent("xpath=//input[@id='Email']")) {
                                selenium.type("xpath=//input[@id='Email']", "dummy@gmail.com");
                }             
                if(selenium.isElementPresent("xpath=//input[@id='Passwd']")) {
                                selenium.type("xpath=//input[@id='Passwd']", "dummy@r007");
                }
               
                /* Click on "Sign in" button. */
                selenium.click("xpath=//input[@id='signIn']"); 
                selenium.waitForPageToLoad("60000");
               
                /* Verify Login user. */
                String loginUserName = selenium.getText("xpath=//span[@id='gbi4t']");
                assertEquals(loginUserName , "Badrikant Soni");

                /* Write a email and send it to own gmail id */
                selenium.click("xpath=//div[@role='navigation']//div[@class='z0']//div");
                pause(7000);

                /* Enter email address. */
                selenium.type("xpath=//textarea[@name='to']", "badrikant71@gmail.com");
               
                /* Enter Subject. */
                selenium.type("xpath=//input[@name='subject']", "Auto Email");

                /* Enter body text. */
                selenium.type("xpath=//body[@class='editable  LW-yrriRe']", "Hello Selenium User !!!!!!!!!! :) ");

                /* Click "Send" button. */
                selenium.click("xpath=//div[@class='dW E']//div[@class='dX Cq J-Jw']//div");
                pause(7000);

                /* Verify the send email into send item box. */
                selenium.click("link=Sent Mail");
                pause(10000);

                /* Verify email id whever you used for testing :) */
                String sentItemEmail = selenium.getText("xpath=//tr[@id=':1vc']//td[4]//span[@email='badrikant71@gmail.com']");
                assertEquals(sentItemEmail, "Badrikant Soni");

                /* Sign Out the gmail. */
                selenium.click("xpath=//span[@id='gbi4t']");
                pause(2000);
                selenium.click("link=Sign out");
                pause(10000);

                /* After Sign out verify the Google mail login page */
                selenium.isElementPresent("xpath=//div[@class='google-header-bar']");
               
}

public void tearDown() throws Exception {
                selenium.stop();
                super.tearDown();
}

}
