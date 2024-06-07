package br.com.blogdoagi.tests;

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
        try {
            Assert.assertTrue(acessouhomePage, "Titulo não esta em conformidade");

        }catch(AssertionError e){

            String LogError = "Erro no Titulo";

            getScreenshot(LogError);
            Assert.fail();

        }


    }

    @Test(priority = 2, description = "Validação da quantidade de links para páginas na HomePage")
    public void quantlinkFinancasHomePage() {
        int qntLinkEsperado = conf.getIntProperty("qntlinkFinancaExp");
        int qntLinkAtual = new HomePage(navegador)
                .quantLinksFinancas();
        System.out.println("Link finaca esperado: "+ qntLinkEsperado);
        System.out.println("Link finaca atual: " + qntLinkAtual);



        try {
            Assert.assertEquals(qntLinkAtual, qntLinkEsperado, "Erro qnt link de 'Suas Financas'");

        }catch(AssertionError e){

            String LogError = "Erro qnt link de 'Suas Financas'";
            System.out.println(LogError);

            getScreenshot(LogError);
            Assert.fail();

        }
    }

    @Test(priority = 2, description = "Validação da quantidade de links ler texto na HomePage")
    public void quantlinkLerTextoHomePage() {
        int qntLinkEsperado = conf.getIntProperty("qntlinkLerTextoExp");
        int qntLinkAtual = new HomePage(navegador)
                .quantLinksLerTexto();
        System.out.println("Texto esperado: "+ qntLinkEsperado);
        System.out.println("Texto atual: " + qntLinkAtual);


        try {
            Assert.assertEquals(qntLinkAtual, qntLinkEsperado, "Erro qnt link de 'ler texto'");

        }catch(AssertionError e){

            String LogError = "Erro na Qnt link de 'ler texto'";

            getScreenshot(LogError);
            Assert.fail();

        }
    }


    @AfterMethod
    public void tearDown() {
        quit();
    }


}
