package Day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverGetMothodları {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        System.out.println(driver.getWindowHandle());
        //bize acılan browser'ın handle degerini dondurur.
        //CDwindow-82195E2039BC26D8301574C61B23E44B
        //CDwindow-548E8D482ADB54869D6D11403F974355

        System.out.println(driver.getWindowHandles());
        //[CDwindow-B8848DDA8DEB886D10B8335D37CAFD25]

        /*
        Eger testimiz sırasında birdan fazla window acılırsa
        acılan tüm window'ların window handle degerlerini bir set olarak dondurur
        window'lar arası gecisi bu handle degerleri ile yaparız.
         */

        driver.get("https://www.amazon.com");
        System.out.println(driver.getPageSource());

        driver.quit();
    }
}
