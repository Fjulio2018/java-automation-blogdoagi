package br.com.blogdoagi.tests;

import br.com.blogdoagi.pages.MenuAgiPage;
import br.com.blogdoagi.utils.config.ConfigLoader;
import br.com.blogdoagi.utils.hooks.Hooks;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import br.com.blogdoagi.pages.HomePage;

public class BlogTests extends Hooks {
    public static String indexBusca = "Vagas";

    @BeforeMethod
    public void setUp() {
        initialize();
    }


    @Test(priority = 1)
    public void validaAcessoHomePage() {
        setBrowserName("firefox");
        initialize(); // Reinitialize to apply the browser setting

        boolean acessouhomePage = new HomePage(navegador)
                .acessaHomePage()
                .certificaHomePage();

        Assert.assertTrue(acessouhomePage, "Titulo não esta em conformidade");
    }

    @Test(priority = 2)
    public void validaMenuHomePage() {
        setBrowserName("chrome");
        initialize(); // Reinitialize to apply the browser setting

        HomePage hp = new HomePage(navegador);
        hp.acessaHomePage();
        boolean acessouMenu = new MenuAgiPage(navegador)
                .certificaMenu();
        Assert.assertTrue(acessouMenu, "Menu não esta presente");
    }

    @Test(priority = 3)
    public void validaQuantPostsNaBusca() {
        setBrowserName("firefox");
        initialize(); // Reinitialize to apply the browser setting

        ConfigLoader conf = new ConfigLoader();
        int quantBuscaAtual = new HomePage(navegador)
                .acessaHomePage()
                .buscaPorMenuAgi(indexBusca)
                .quantNaBusca();
        Assert.assertEquals(quantBuscaAtual, conf.getIntProperty("quantBuscaEsperada"), "Quantidade não esta correta");
    }

    @Test(priority = 4)
    public void fluxoBuscaVagasSucesso() throws InterruptedException {
        setBrowserName("chrome");
        initialize(); // Reinitialize to apply the browser setting

        indexBusca = "40 Vagas";
        boolean acessouVagaPage = new HomePage(navegador)
                .acessaHomePage()
                .buscaPorMenuAgi(indexBusca)
                .escolhaPost()
                .validaPost();
        Assert.assertTrue(acessouVagaPage, "vaga não disponivel");
    }

    @Test(priority = 5)
    public void acessarCarreiraPage() {
        setBrowserName("firefox");
        initialize(); // Reinitialize to apply the browser setting

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
