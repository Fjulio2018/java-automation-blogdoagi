package br.com.blogdoagi.tests;

import br.com.blogdoagi.pages.MenuAgiPage;
import br.com.blogdoagi.pages.ResultadoPage;
import br.com.blogdoagi.utils.hooks.Hooks;

import org.testng.Assert;
import org.testng.annotations.Test;
import br.com.blogdoagi.pages.HomePage;

import static br.com.blogdoagi.utils.Constantes.Constantes.*;


public class BlogTests extends Hooks {

    public static String indexBusca = "Vagas";


    @Test(priority = 1)
    public void validaAcessoHomePage() {
        boolean acessouhomePage = new HomePage(navegador)
                .acessaHomePage()
                .certificaHomePage();

        Assert.assertTrue(acessouhomePage, "Titulo não esta em conformidade");

    }

    @Test(priority = 2)
    public void validaMenuHomePage() {
        boolean acessouMenu = new MenuAgiPage(navegador)
                .certificaMenu();
        Assert.assertTrue(acessouMenu, "Menu não esta presente");

    }


    @Test(priority = 3)
    public void validaQuantPostsNaBusca() {


        int quantBuscaAtual = new HomePage(navegador)
                .acessaHomePage()
                .buscaPorMenuAgi(indexBusca)
                .quantNaBusca();

        Assert.assertEquals(quantBuscaAtual, QUANTBUSCAESPERADA, "Quantidade não esta correta");


    }

    @Test(priority = 4)
    public void fluxoBuscaVagasSucesso() throws InterruptedException {
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
        String tituloEsperado = "Carreira";
        String tituloAtual = new HomePage(navegador)
                .acessaHomePage()
                .acesCarreiraPageMenu()
                .getCarreiraTitle();

        Assert.assertEquals(tituloAtual, tituloEsperado, "Titulo diferente do esperado");


    }


}
