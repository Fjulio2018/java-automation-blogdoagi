package br.com.blogdoagi.pages;

import br.com.blogdoagi.bases.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.*;

public class MenuAgiPage extends BasePage {
    protected WebDriver navegador;
    private WebDriverWait wait;

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

    public MenuAgiPage(WebDriver navegador) {

        super(navegador);
        this.wait = new WebDriverWait(navegador, Duration.ofSeconds(10));

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

    public WebElement getLupaField() {
        wait.until(ExpectedConditions.visibilityOf(lupaField));
        return lupaField;
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
        wait.until(ExpectedConditions.visibilityOf(siteLogo));
        wait.until(ExpectedConditions.visibilityOf(oagiMenu));
        return siteLogo.isDisplayed() && oagiMenu.isDisplayed();
    }
    public ResultadoPage buscaPorIndex(String index) {
        lupaField.click();
        searchField.sendKeys(index);
        searchField.sendKeys(Keys.ENTER);
        return new ResultadoPage(navegador);
    }
}
