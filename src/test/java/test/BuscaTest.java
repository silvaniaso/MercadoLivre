package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.BuscaPages;

public class BuscaTest {
	
	static WebDriver driver;
	static BuscaPages buscaPages;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.mercadolivre.com.br");
		buscaPages = new BuscaPages(driver);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}

	@Test
	public void test() {
		//Informar o item que deseja buscar no Mercado Livre
		String itemPesquisa = "Samsung s8";
		buscaPages.efetuarBusca(itemPesquisa);
		//informar a quantidade de anuncios que deseja retornar com t�tulo e pre�o
		int qtdeAds = 5;
		buscaPages.mostraElemento(qtdeAds);
		//informar qual a pagina�ao que deseja acessar
		int pagina = 2;
		buscaPages.numeroPaginacao(pagina);
		//qual elemento da busca tirar print (neste caso irei pegar o penultimo. A premissa � saber quantos elementos retornam na pesquisa).
		//A inten��o de colocar pelo numero do elemento, � que, se necess�rio incluir um List e fazer dinamico, a estrutura esta pronta e n�o precisa de manuten��o.
		int numElemento = 49; 
		buscaPages.tiraPrintElemento(numElemento);
	}

}
