import org.openqa.selenium.firefox.FirefoxDriver;


public class WebdriverTest {

	public static void main(String args[]){
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://google.com");	
	}
}
