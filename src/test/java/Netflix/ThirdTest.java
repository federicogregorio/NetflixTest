package Netflix;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ThirdTest {
	
	private WebDriver driver;
	RegisterPage registerPage;
	
	By usernameLocator = By.id("id_userLoginId");
	By passwordLocator = By.id("id_password"); 
	By buttonLocator = By.xpath("//*[@id=\"bxid_rememberMe_true\"]");
	By logInLocator = By.xpath("//*[@id=\"appMountPoint\"]/div/div[3]/div/div/div[1]/form/button");
	By incorrectPasswordLocator = By.xpath("//*[@id=\"appMountPoint\"]/div/div[3]/div/div/div[1]/div/div[2]");
	
	private String username = "ggregorio@gmail.com";
	private String password = "hola mundo";
  
  @BeforeClass
  public void beforeClass() {
	  registerPage = new RegisterPage(driver);
	  driver = registerPage.chromeDriverConnect();
	  registerPage.start(driver);
  }
  
  @Test
  public void loginToNetflixErrorTest() {
	//Hacer click en Iniciar Sesión. 
	registerPage.goToLogIn();
	registerPage.capturaPantalla("test3-capture" + registerPage.getI());
	registerPage.setI();
	
	//Se ingresa usuario y contraseña
	registerPage.type(username, usernameLocator);
	registerPage.type(password, passwordLocator);
	registerPage.capturaPantalla("test3-capture" + registerPage.getI());
	registerPage.setI();
	
	//Desclickear el boton Recuerdame
	Actions act =  new Actions(driver);
	act.moveToElement(registerPage.findElement(buttonLocator)).click().perform();
	registerPage.capturaPantalla("test3-capture" + registerPage.getI());
	registerPage.setI();
	
	//Se realiza el chequeo del boton Recuerdame
	this.checkSelected();
	
	//Click en el boton de iniciar sesion
	registerPage.click(logInLocator);
	
	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);	
	
	//Se realiza el chequeo de la contraseña incorrecta
	this.checkMessageError();
	
	//Se realiza el chequeo del boton Recuerdame
	this.checkSelected();
	
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  private void checkSelected() {
	  //Este metodo se encarga de realizar el chequeo del boton Recuerdame
	  WebElement we = registerPage.findElement(buttonLocator);
	  if(!we.isSelected()) {
		  System.out.print("No esta seleccionado" + "\n");
		  registerPage.capturaPantalla("test3-capture" + registerPage.getI());
		  registerPage.setI();
	  }else {
		  System.out.print("Esta seleccionado" + "\n");
		  registerPage.capturaPantalla("test3-capture" + registerPage.getI());
		  registerPage.setI();
	  }
  }
  
  private void checkMessageError() {
	  //Este metodo se encarga de verificar el mensaje de error de contraseña incorrecta, que contenga "Contraseña incorrecta"
	  WebElement incorrectPassword = registerPage.findElement(incorrectPasswordLocator);
	  String message = registerPage.getText(incorrectPassword);
	  if(message.contains("Contraseña incorrecta")) {
		  System.out.print(message + "\n");
		  registerPage.capturaPantalla("test3-capture" + registerPage.getI());
		  registerPage.setI();
	  }
  }

}
