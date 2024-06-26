package br.com.blogdoagi.pages;

import br.com.blogdoagi.bases.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarreiraPage extends BasePage {

    @FindBy(css = "h1.page-title.ast-archive-title")
    private WebElement carreiraTitle;
    @FindBy(css = "span.ast-blog-single-element.ast-taxonomy-container.cat-links.default a[rel='category tag'][href='https://blogdoagi.com.br/sua-carreira/']")
    private WebElement carreiraLink;

    public CarreiraPage(WebDriver navegador) {
        super(navegador);

    }

    @Override
    public WebElement getOagiMenu() {
        return null;
    }

    public String getCarreiraTitle() {
        return carreiraTitle.getText();
    }

    public Anucio40VagasPage acessarAnuncioVagas() {
        carreiraLink.click();
        return new Anucio40VagasPage(navegador);
    }
}
