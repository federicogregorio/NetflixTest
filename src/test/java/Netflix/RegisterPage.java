package Netflix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends NetflixBase {
	
	String urlNetflix = "https://www.netflix.com/ar/";
	
	String title = "Netflix Argentina: Ve series online, ve películas online";
	
	By buttonLocator = By.linkText("Iniciar sesión");
	
	int i = 0;
	
	
	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void start(WebDriver driver) {
		maximize();
		visitNetflix();
		implicitWait();
	}
	
	public void visitNetflix() {
		visit(urlNetflix);
	}
	
	public void goToLogIn() {
		click(buttonLocator);
	}
	
	public int getI() {
		return this.i;
	}
	
	public void setI() {
		i++;
	}
}
