package br.com.blogdoagi.pages;

import br.com.blogdoagi.bases.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultadoPage extends BasePage {

    @FindBy(css = "h2.entry-title.ast-blog-single-element")
    List<WebElement> entryTitles;



    public ResultadoPage(WebDriver navegador) {
        super(navegador);
    }

    @Override
    public WebElement getOagiMenu() {
        return null;
    }

    public boolean certificaResultadoPage() {
        return true;
    }

    public int quantNaBusca() {
        int numberOfEntries = entryTitles.size();
        return entryTitles.size();
    }



    public Anucio40VagasPage escolhaPost() throws InterruptedException {
        entryTitles.get(0).click();
        return new Anucio40VagasPage(navegador);


    }
}
