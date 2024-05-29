package br.com.blogdoagi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static br.com.blogdoagi.utils.Constantes.Constantes.*;
import static br.com.blogdoagi.utils.hooks.Hooks.normalizarString;

public class HomePage extends BasePage {

    public HomePage(WebDriver navegador) {
        super(navegador);
    }

    @Override
    public WebElement getOagiMenu() {
        return null;
    }

    public HomePage acessaHomePage() {
        System.out.println("Metodo iniciado: acessarHomePage");
        navegador.navigate().to(URLHOMEPAGE);
        return new HomePage(navegador);
    }

    public boolean certificaHomePage() {

        String tituloEsperado = "Blog do Agi";
        String tituloAtual = navegador.getTitle();


        String stringNormalizada1 = normalizarString(tituloEsperado);
        String stringNormalizada2 = normalizarString(tituloAtual);

        System.out.println("Titulo da HP esperado:" + stringNormalizada1);
        System.out.println("Titulo da HP atual: " + stringNormalizada2);


        if (stringNormalizada2.contains(stringNormalizada1)) {
            return true;
        } else {
            return false;
        }

    }


    public CarreiraPage acesCarreiraPageMenu() {
        MenuAgiPage menu = new MenuAgiPage(navegador);
        System.out.println("Metodo iniciado: acessarCarreiraPage");
        acessaHomePage();
        Actions actions = new Actions(navegador);
        actions.moveToElement(menu.getOagiMenu()).perform();
        menu.getCarreiraItem().click();
        return new CarreiraPage(navegador);
    }

    public ResultadoPage buscaPorMenuAgi(String indexBusca){
        MenuAgiPage menu = new MenuAgiPage(navegador);
        menu.buscaPorIndex(indexBusca);
        return new ResultadoPage(navegador);
    }


}
