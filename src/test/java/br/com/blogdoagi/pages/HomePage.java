package br.com.blogdoagi.pages;

import br.com.blogdoagi.bases.BasePage;
import br.com.blogdoagi.utils.config.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static br.com.blogdoagi.utils.hooks.Hooks.normalizarString;

public class HomePage extends BasePage {

    public HomePage(WebDriver navegador) {
        super(navegador);
    }

    @FindBy(css = "div.uagb-post__text > span.uagb-post__taxonomy.highlighted > a[href*=\"produtos\"] ")
    private WebElement linkProdutoPage;
    @FindBy(css = "article.uagb-post__inner-wrap .uagb-post__taxonomy a")
    private List<WebElement> linksSuasFinancasPage;
    @FindBy(css = "article.uagb-post__inner-wrap .uagb-post__cta a")
    private List<WebElement> linkslerTextoLinks ;

    WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));




    @Override
    public WebElement getOagiMenu() {
        return null;
    }

    public HomePage acessaHomePage() {
        ConfigLoader conf = new ConfigLoader();

        navegador.navigate().to(conf.getProperty("URL_HOMEPAGE"));
        return new HomePage(navegador);
    }

    public boolean certificaHomePage() {
        acessaHomePage();

        String tituloEsperado = "Blog do Agi";
        String tituloAtual = navegador.getTitle();


        String stringNormalizada1 = normalizarString(tituloEsperado);
        String stringNormalizada2 = normalizarString(tituloAtual);


        if (stringNormalizada2.contains(stringNormalizada1)) {
            return true;
        } else {
            return false;
        }

    }


    public CarreiraPage acesCarreiraPageMenu() {
        MenuAgiPage menu = new MenuAgiPage(navegador);
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

    public int quantLinksFinancas(){

        acessaHomePage();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("article.uagb-post__inner-wrap .uagb-post__taxonomy a")));
        return linksSuasFinancasPage.size();



    }

    public int quantLinksLerTexto(){

        acessaHomePage();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("article.uagb-post__inner-wrap .uagb-post__cta a")));
        return linkslerTextoLinks.size();



    }


}
