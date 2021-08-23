package Netflix;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecondTest {
	
	private WebDriver driver;
	RegisterPage registerPage;
	
	By h1Locator = By.tagName("h1");
	//By facebookLocator = By.tagName("span");
	By facebookLocator = By.className("fbBtnText");
	
	private String titleText = "Inicia sesión";
	private String inicioSesionfacebook = "Iniciar sesión con Facebook";

	@BeforeClass
	public void setUp() throws Exception {
		registerPage = new RegisterPage(driver);
		driver = registerPage.chromeDriverConnect();
		registerPage.start(driver);
	}

	@Test
	public void startSessionPageTest() {
		//Hacer click en Iniciar Sesión. 
		registerPage.goToLogIn();
		
		//Se valida que el titulo de la pagina haya cambiado
		String _title = registerPage.getTitle();
		
		if(!_title.equals(registerPage.title)) {
			System.out.print("Cambio el titulo" + "\n");
			
			//Se verifica que se encuentre dentro de los h1
			this.searchAllH1();
			
			//Se realiza el chequeo del texto indicado
			this.checkText(inicioSesionfacebook);
		}		
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	private void checkText(String text) {
		//Validar que se encuentre el texto “Iniciar sesión con Facebook” en el sitio
		WebElement textFacebook = registerPage.findElement(facebookLocator);
		if(registerPage.getText(textFacebook).equals(text)) {
			registerPage.capturaPantalla("test2-capture" + registerPage.getI());
			registerPage.setI();
			System.out.print("Existe el texto relacionado con el inicio de sesión con Facebook" + "\n");
		}else {
			registerPage.capturaPantalla("test2-capture" + registerPage.getI());
			registerPage.setI();
			System.out.print("No xiste el texto relacionado con el inicio de sesión con Facebook" + "\n");
		}
	}
	
	private void searchAllH1() {
		//Se realiza una busca de todos los h1 dentro del sitio y se valida que se encuentre el indicado
		List<WebElement> listH1 = registerPage.findElements(h1Locator);
		for(WebElement we:listH1) {
			if(registerPage.getText(we).equals(titleText)) {
				System.out.print("Existe el texto indicado dentro de los H1" + "\n");
			}else {
				System.out.print("No existe el texto indicado dentro de los H1" + "\n");
			}
		}
	}

}
