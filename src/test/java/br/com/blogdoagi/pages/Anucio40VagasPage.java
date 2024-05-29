package br.com.blogdoagi.pages;

import br.com.blogdoagi.bases.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Anucio40VagasPage extends BasePage {


    @FindBy(css = "h1.entry-title")
    WebElement anuncioTitle;
    @FindBy(css = "a[href*='https://agibank.gupy.io']")
    WebElement goupyagibankLink;


    public Anucio40VagasPage(WebDriver navegador) {
        super(navegador);

    }

    @Override
    public WebElement getOagiMenu() {
        return null;
    }

    public boolean validaPost() {
        System.out.println("Metodo iniciado: getAnuncioTitle");

        if (anuncioTitle.isDisplayed() && goupyagibankLink.isDisplayed()) {
            return true;

        } else {
            return false;

        }


    }


}

