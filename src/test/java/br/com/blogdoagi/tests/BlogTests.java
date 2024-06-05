package br.com.blogdoagi.tests;

import br.com.blogdoagi.pages.MenuAgiPage;
import br.com.blogdoagi.utils.config.ConfigLoader;
import br.com.blogdoagi.utils.hooks.Hooks;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import br.com.blogdoagi.pages.HomePage;


public class BlogTests extends Hooks {
    public static String indexBusca = "Vagas";
    ConfigLoader conf = new ConfigLoader();

    @BeforeMethod
    public void setUp() {
        initialize();
    }


    @Test(priority = 2, description = "Validacao do Menu Agi")
    public void validaMenuHomePage() {
        setBrowserName(conf.getProperty("chromeBrowserName"));
        initialize();

        HomePage hp = new HomePage(navegador);
        hp.acessaHomePage();
        boolean acessouMenu = new MenuAgiPage(navegador)
                .certificaMenu();
        Assert.assertTrue(acessouMenu, "Menu não esta presente");
    }

    @Test(priority = 3, description = "Validar quantidade de post em uma busca")
    public void validaQuantPostsNaBusca() {
        setBrowserName(conf.getProperty("firefoxBrowserName"));
        initialize();


        int quantBuscaAtual = new HomePage(navegador)
                .acessaHomePage()
                .buscaPorMenuAgi(indexBusca)
                .quantNaBusca();
        Assert.assertEquals(quantBuscaAtual, conf.getIntProperty("quantBuscaEsperada"), "Quantidade não esta correta");
    }

    @Test(priority = 4, description = "Valida fluxo de busca de vagas")
    public void fluxoBuscaVagasSucesso() throws InterruptedException {
        setBrowserName(conf.getProperty("chromeBrowserName"));
        initialize();

        indexBusca = "40 Vagas";
        boolean acessouVagaPage = new HomePage(navegador)
                .acessaHomePage()
                .buscaPorMenuAgi(indexBusca)
                .escolhaPost()
                .validaPost();
        Assert.assertTrue(acessouVagaPage, "vagas não disponiveis");
    }

    @Test(priority = 5, description = "Valida acesso para pagina Carreira pelo menu")
    public void acessarCarreiraPage() {

        String tituloEsperado = "Carreira";
        String tituloAtual = new HomePage(navegador)
                .acessaHomePage()
                .acesCarreiraPageMenu()
                .getCarreiraTitle();
        Assert.assertEquals(tituloAtual, tituloEsperado, "Titulo diferente do esperado");
    }

    @AfterMethod
    public void tearDown() {
        quit();
    }
}
