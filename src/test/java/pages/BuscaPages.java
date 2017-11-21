package pages;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuscaPages {
	static WebDriver driver;

	public BuscaPages(WebDriver driver) {
		this.driver = driver;
	}

	public void efetuarBusca(String campo) {
		WebElement nome = driver.findElement(By.name("as_word"));
		nome.sendKeys(campo);
		if (campo != null) {
			nome.sendKeys(Keys.ENTER);
		}
	}

	public void mostraElemento(int qtdeAds) {
		for (int i = 1; i <= qtdeAds; i++){
			try {
				String path = "//*[contains(@id, 'searchResults') and contains(@class, 'results')]/li["+i+"]";
				WebElement elemento = driver.findElement(By.xpath(path));
				String titulo = elemento.findElement(By.xpath(path + "//span[contains(@class, 'main-title')]")).getText();
				String preco = "R$" + elemento.findElement(By.xpath(path + "//span[contains(@class, 'price') and contains(@class, 'price-fraction')]")).getText();
				System.out.println(titulo);
				System.out.println(preco);
			} catch (Exception e) {
				System.out.println("Não foi possível encontrar elemento!!!");
			}
			System.out.println("########################################");
		}
	}
	
	public void numeroPaginacao(int num) {
		if (num > 0) {
			num += 1;
		}
		//String path = "//*[contains(@class, 'pagination__container')]//a[contains(@class, 'c')]";
		String path = "//*[contains(@id, 'results-section')]/div[2]/ul/li["+ num +"]";
		try {
			WebElement elemento = driver.findElement(By.xpath(path));
			elemento.findElement(By.xpath(path)).click();
		} catch (Exception e) {
			System.out.println("Número da página não encontrado!");
		}
	}
	
	public void tiraPrintElemento(int num) {
		//num += 1;
		try {
			String path = "//*[contains(@id, 'searchResults') and contains(@class, 'results')]/li["+num+"]";
			WebElement elemento = driver.findElement(By.xpath(path));
			//Abre link e tira print.
			elemento.findElement(By.xpath(path + "//span[contains(@class, 'main-title')]")).click();
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("./Screenshots/screenshot.png"));
		} catch (Exception e) {
			System.out.println("Elemento não encontrado!");
		}
	}
}
