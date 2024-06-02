package br.com.blogdoagi.tests;

import br.com.blogdoagi.bases.BasePage;
import br.com.blogdoagi.pages.HomePage;
import br.com.blogdoagi.utils.config.ConfigLoader;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import br.com.blogdoagi.utils.hooks.Hooks;

public class HomePageTests extends Hooks {
    ConfigLoader conf = new ConfigLoader();

    @BeforeMethod
    public void setUp() {
        initialize();
    }


    @Test(priority = 1, description = "Acesso a HomePage")

    public void validaAcessoHomePage() {
        setBrowserName(conf.getProperty("firefoxBrowserName"));
        initialize();
        boolean acessouhomePage = new HomePage(navegador)
                .certificaHomePage();

        Assert.assertTrue(acessouhomePage, "Titulo não esta em conformidade");
    }

    @Test(priority = 2, description = "Validação da quantidade de links de Suas Finanças na HomePage")
    public void quantlinkFinancasHomePage() {
        int qntLinkEsperado = conf.getIntProperty("qntlinkFinancaExp");
        int qntLinkAtual = new HomePage(navegador)
                .quantLinkFinancas();

        Assert.assertEquals(qntLinkAtual, qntLinkEsperado, "Quantidade de link financas não esperada");
    }


    @AfterMethod
    public void tearDown() {
        quit();
    }


}
