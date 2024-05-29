package br.com.blogdoagi.pages;

import org.openqa.selenium.*;

import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class BasePage {


    protected WebDriver navegador;
    private WebDriverWait wait;

    public BasePage(WebDriver navegador) {
        this.navegador = navegador;
        this.wait = new WebDriverWait(navegador, Duration.ofSeconds(10)); // Increased wait time to 10 seconds
        PageFactory.initElements(navegador, this);
        System.out.println("PageFactory: initialized");
    }


    public abstract WebElement getOagiMenu();
}
