package br.com.blogdoagi.utils.hooks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.text.Normalizer;
import java.util.concurrent.TimeUnit;

public class Hooks {
    protected WebDriver navegador;
    protected static String browserName = "chrome";

    public static void setBrowserName(String browserName) {
        Hooks.browserName = browserName;
    }

    public void initialize() {

        if (navegador != null) {
            navegador.quit();
        }

        if (browserName.equalsIgnoreCase("chrome")) {
            System.out.println("Inicializando Browser: " + browserName);
            WebDriverManager.chromedriver().setup();
            navegador = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.out.println("Inicializando Browser: " + browserName);
            WebDriverManager.firefoxdriver().setup();
            navegador = new FirefoxDriver();
        }

        navegador.manage().window().maximize();
        navegador.manage().deleteAllCookies();
        navegador.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

    }

    public void quit() {
        if (navegador != null) {
            navegador.quit();
            navegador = null;
        }
    }

    public void close() {
        if (navegador != null) {
            navegador.close();
            navegador = null;
        }
    }

    public static String normalizarString(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
}
