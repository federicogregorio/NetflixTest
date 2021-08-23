package Netflix;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class FirstTest {
	
	private WebDriver driver;
	RegisterPage registerPage;
	
	
 @BeforeClass
  public void beforeClass() {
	  registerPage = new RegisterPage(driver);
	  driver = registerPage.chromeDriverConnect();
	  registerPage.start(driver);
  }
 
  @Test
  public void validarTituloTest() {
	  //Se valida que el titulo del sitio sea el correcto
	  String _title = registerPage.getTitle();
	  assertEquals(registerPage.title, _title);
	  System.out.print(_title + "\n");
	  registerPage.capturaPantalla("test1-capture" + registerPage.getI());
  }
 

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
