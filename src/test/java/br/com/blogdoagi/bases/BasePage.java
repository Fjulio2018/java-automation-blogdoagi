package br.com.blogdoagi.bases;

import org.openqa.selenium.*;

import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class BasePage {


    protected WebDriver navegador;


    public BasePage(WebDriver navegador) {

        this.navegador = navegador;
        PageFactory.initElements(navegador, this);

    }


    public abstract WebElement getOagiMenu();
}
