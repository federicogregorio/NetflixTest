package Netflix;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class FourthTest {
	
	
	private WebDriver driver;
	RegisterPage registerPage;
	
	By emailLocator = By.id("id_email_hero_fuji");
	By buttonLocator = By.xpath("//*[@id=\"appMountPoint\"]/div/div/div/div/div/div[2]/div[1]/div[2]/form/div/div/button");
	
	String text = "signup";
	
  @Test
  public void fakeEmailTest() {
	  String emailRandom = generateString();
	  System.out.print(emailRandom + "\n");
	  registerPage.capturaPantalla("test4-capture" + registerPage.getI());
	  registerPage.setI();
	  
	  registerPage.type(emailRandom, emailLocator);
	  registerPage.capturaPantalla("test4-capture" + registerPage.getI());
	  registerPage.setI();
	  
	  registerPage.click(buttonLocator);
	  
	  driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	  
	  driver.navigate().refresh();
	  
	  String strUrl = driver.getCurrentUrl();
	  System.out.print(strUrl + "\n");
	  registerPage.capturaPantalla("test4-capture" + registerPage.getI());
	  registerPage.setI();
	  
	  if(strUrl.contains(text)) {
		  System.out.print("Contiene el texto indicado");
	  }
  }
  
  @BeforeTest
  public void beforeTest() {
	  registerPage = new RegisterPage(driver);
	  driver = registerPage.chromeDriverConnect();
	  registerPage.start(driver);
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
  
  private String generateString() { 
	  String a = RandomStringUtils.randomAlphabetic(10);
	  return a + "@gmail.com";
  }
  
 
  

}
