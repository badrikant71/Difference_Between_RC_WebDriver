import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestBase;

public class SeleniumRemoteControlCode extends SeleneseTestBase{
    @BeforeMethod
	public void setUp() throws Exception {
        selenium = new DefaultSelenium("localhost", 4444, "*chrome", "https://www.google.co.in/");
        selenium.start();
    }

    @Test
    public void testSeleniumRemoteControlCode() throws Exception {
        selenium.open("/");
        selenium.type("id=gbqfq", "Selenium 2.0");
        selenium.isElementPresent("id=gbqfba");
        selenium.click("id=gbqfba");    
    }
    
    @AfterMethod
	public void tearDown() throws Exception {
        selenium.stop();
        
    }
}