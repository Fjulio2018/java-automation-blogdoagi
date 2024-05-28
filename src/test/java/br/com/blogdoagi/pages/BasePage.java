package br.com.blogdoagi.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    @FindBy(css = "#menu-item-3713 > a > span.menu-text")
    private WebElement oagiMenu;
    @FindBy(css = "a[href='https://blogdoagi.com.br/sua-carreira/']")
    private WebElement carreiraItem;
    @FindBy(css = ".site-logo-img a.custom-logo-link img.custom-logo")
    private WebElement siteLogo;
    @FindBy(css = ".ast-search-icon")
    private WebElement lupaField;
    @FindBy(css = "#search-field.search-field")
    private WebElement searchField;
    @FindBy(css = ".search-submit")
    private WebElement searchSubmitButton;

    protected WebDriver navegador;
    private WebDriverWait wait;

    public BasePage(WebDriver navegador) {
        this.navegador = navegador;
        this.wait = new WebDriverWait(navegador, Duration.ofSeconds(10)); // Increased wait time to 10 seconds
        PageFactory.initElements(navegador, this);
        System.out.println("PageFactory: initialized");
    }

    public WebElement getOagiMenu() {
        wait.until(ExpectedConditions.visibilityOf(oagiMenu));
        return oagiMenu;
    }

    public WebElement getCarreiraItem() {
        wait.until(ExpectedConditions.visibilityOf(carreiraItem));
        return carreiraItem;
    }

    public WebElement getSiteLogo() {
        wait.until(ExpectedConditions.visibilityOf(siteLogo));
        return siteLogo;
    }

    public WebElement getSearchField() {
        wait.until(ExpectedConditions.visibilityOf(searchField));
        return searchField;
    }

    public WebElement getSearchSubmitButton() {
        wait.until(ExpectedConditions.visibilityOf(searchSubmitButton));
        return searchSubmitButton;
    }


    public boolean certificaMenu() {
        System.out.println("Method started: certificaMenu");
        wait.until(ExpectedConditions.visibilityOf(siteLogo));
        wait.until(ExpectedConditions.visibilityOf(oagiMenu));
        return siteLogo.isDisplayed() && oagiMenu.isDisplayed();
    }


    public ResultadoPage buscaPorIndex(String index) {
        System.out.println("Method started: buscaPorIndex");
        lupaField.click();
        System.out.println("Abriu o campo");
        searchField.sendKeys(index);
        searchField.sendKeys(Keys.ENTER);
        return new ResultadoPage(navegador);
    }
}
