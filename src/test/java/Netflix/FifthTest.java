package Netflix;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class FifthTest {
	
	private WebDriver driver;
	RegisterPage registerPage;
	
  @Test(dataProvider = "dp")
  public void printTagsTest(String a) {
	  By h1Locator = By.tagName(a);
	  List<WebElement> listH1 = registerPage.findElements(h1Locator);	  
	  if(listH1.size() == 0) {
		  System.out.print("No se encuentran elementos con esta etiqueta." + "\n");
	  }else {
		  for(WebElement we:listH1) {
			  System.out.print(registerPage.getText(we) + "\n" );
		  }
		  System.out.print(listH1.size() + "\n");
	  }
	  registerPage.capturaPantalla("test5-capture" + registerPage.getI());
	  registerPage.setI();
  }

  @DataProvider
  public Object[][] dp() {
	  return new Object[][] {{"input"}};
  }
  @BeforeClass
  public void beforeClass() {
	  registerPage = new RegisterPage(driver);
	  driver = registerPage.chromeDriverConnect();
	  registerPage.start(driver);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
