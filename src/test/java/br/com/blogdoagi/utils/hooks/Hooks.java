package br.com.blogdoagi.utils.hooks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import java.io.File;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Date;
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

            WebDriverManager.chromedriver().setup();
            navegador = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {

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
    protected String getScreenshotSavePath() {
        String packageName = this.getClass().getPackage().getName();
        File dir = new File(System.getProperty("user.dir")+File.separator+"screenshot"+File.separator + packageName + File.separator);
        dir.mkdirs();
        return dir.getAbsolutePath();
    }

    protected void getScreenshot() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String date = sdf.format(new Date());
        String url = navegador.getCurrentUrl().replaceAll("[\\/:*\\?\"<>\\|]", "_");
        String ext = ".png";
        String path = getScreenshotSavePath() + File.separator + date + "_" + url + ext;

        try {
            if (navegador instanceof TakesScreenshot) {
                File tmpFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
                org.openqa.selenium.io.FileHandler.copy(tmpFile, new File(path));
//                log.error("Captured Screenshot for Failure: "+path);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Assert Actual and Expected Strings
     */

    protected void assertStrings(String actual, String expected){


        try{
            Assert.assertEquals(actual, expected);
//            log.info("Actual string: [ "+actual+" ] does match with Expected string: [ "+expected+" ]");

        }catch(AssertionError e){
//            log.error("Actual string: [ "+actual+" ] does not match with Expected string: [ "+expected+" ]");
            getScreenshot();
            Assert.fail();

        }

    }

}
