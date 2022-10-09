package Day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q02_TekrarTesti {
    public static void main(String[] args) throws InterruptedException {


        //1. Yeni bir class olusturun (TekrarTesti)
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        //2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın (verify),
        //  eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.

        driver.get("https://www.youtube.com/");

        String expectedTitle = "youtube";


        String actualTitle=driver.getTitle();

        if (driver.getTitle().contains("youtube")) {
            System.out.println("https://www.youtube.com/ title' ı : " +
                    expectedTitle + "ifadesini içermektedir.");
        }else {
            System.out.println("Test Failed");
            System.out.println("https://www.youtube.com/ title' ı : " +
                    expectedTitle + "ifadesini İÇERMEMEKTEDİR.");
            System.out.println("Actual Title :" + actualTitle );
        }

        //3. Sayfa URL’sinin “youtube” içerip içermediğini (contains) doğrulayın,
        //   içermiyorsa doğru URL’yi yazdırın.

        String expectedUrl = "youtube";

        String actualUrl=driver.getCurrentUrl();
        if (driver.getCurrentUrl().contains("youtube")) {
            System.out.println("https://www.youtube.com/ URL' sı : " +
                    expectedUrl + "ifadesini içermektedir.");
        }else {
            System.out.println("Test Failed");
            System.out.println("https://www.youtube.com/ URL' sı : " +
                    expectedUrl + "ifadesini İÇERMEMEKTEDİR.");
            System.out.println("Actual URL :" + actualUrl );
        }

        // 4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");
        Thread.sleep(3000);

        // 5. Youtube sayfasina geri donun
        driver.navigate().back();
        Thread.sleep(3000);

        // 6. Sayfayi yenileyin
        driver.navigate().refresh();
        Thread.sleep(3000);

        // 7. Amazon sayfasina donun
        driver.navigate().forward();
        Thread.sleep(3000);

        // 8. Sayfayi tamsayfa yapin
        driver.manage().window().fullscreen();
        Thread.sleep(3000);

        // 9. Ardından sayfa başlığının “Amazon” içerip içermediğini (contains) doğrulayın,
        //   Yoksa doğru başlığı(Actual Title) yazdırın.

        String expectedTitle2 = "Amazon";
        String actualTitle2=driver.getTitle();

        if (driver.getTitle().contains("Amazon")) {
            System.out.println("https://www.amazon.com/ title' ı : " +
                    expectedTitle2 + "ifadesini içermektedir.");
        }else {
            System.out.println("Test Failed");
            System.out.println("https://www.amazon.com/ title' ı : " +
                    expectedTitle2 + "ifadesini İÇERMEMEKTEDİR.");
            System.out.println("Actual Title :" + actualTitle2 );
        }
        Thread.sleep(3000);

        // 10.Sayfa URL’sinin https://www.amazon.com/ olup olmadığını doğrulayın,
        //   degilse doğru URL’yi yazdırın

        String expectedUrl2 = "https://www.amazon.com/";
        String actualUrl2=driver.getTitle();

        if (driver.getTitle().contains("https://www.amazon.com/")) {
            System.out.println("https://www.amazon.com/ title' ı : " +
                    expectedUrl2 + "ifadesini içermektedir.");
        }else {
            System.out.println("Test Failed");
            System.out.println("https://www.amazon.com/ title' ı : " +
                    expectedUrl2 + "ifadesini İÇERMEMEKTEDİR.");
            System.out.println("Actual Title :" + actualUrl2 );
        }
        Thread.sleep(3000);

        driver.close();

        String originalWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("https://www.youtube.com/");

        driver.switchTo().window(originalWindow);
        driver.navigate().to("https://www.facebook.com/");


        // 11.Sayfayi kapatin
        driver.quit();

    }
}
