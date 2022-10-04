package Day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q02_TekrarTesti {
    public static void main(String[] args) throws InterruptedException {

        /*
        1. Yeni bir class olusturun (TekrarTesti)
        2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın (verify),
           eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        3. Sayfa URL’sinin “youtube” içerip içermediğini (contains) doğrulayın,
           içermiyorsa doğru URL’yi yazdırın.
        4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        5. Youtube sayfasina geri donun
        6. Sayfayi yenileyin
        7. Amazon sayfasina donun
        8. Sayfayi tamsayfa yapin
        9. Ardından sayfa başlığının “Amazon” içerip içermediğini (contains) doğrulayın,
           Yoksa doğru başlığı(Actual Title) yazdırın.
        10.Sayfa URL’sinin https://www.amazon.com/ olup olmadığını doğrulayın,
           degilse doğru URL’yi yazdırın
        11.Sayfayi kapatin
         */

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //1-
        driver.navigate().to("https://www.youtube.com/");

        //2-
        String expectedTıtle = "youtube";
        String expectedUrl = "youtube";

        String actualTitle = driver.getTitle();
        String actualUrl = driver.getCurrentUrl();

        if (driver.getTitle().contains(expectedTıtle)){
            System.out.println("https://www.youtube.com/ web'ni basligi : " +
                    expectedTıtle + " ifadesini içermektedir.");
        } else {
            System.out.println("Test FAILED");
            System.out.println("https://www.youtube.com/ web'ni basligi : " +
                    expectedTıtle + " ifadesini ICERMEMEKTEDİR.");
            System.out.println("Dogru baslık : " + actualTitle + " OLMALIDIR");
        }

        //3-
        if (driver.getCurrentUrl().contains(expectedUrl)){
            System.out.println("https://www.youtube.com/ web'in URL'si : " +
                    expectedUrl + " ifadesini içermektedir.");
        } else {
            System.out.println("Test FAILED");
            System.out.println("https://www.youtube.com/ web'in URL'si : " +
                    expectedUrl + " ifadesini ICERMEMEKTEDİR.");
            System.out.println("Dogru baslık : " + actualUrl + "OLMALIDIR");
        }

        //4-
        driver.navigate().to("https://www.amazon.com/");
        driver.navigate().back();
        Thread.sleep(3000);

        //5-
        driver.navigate().back(); //Youtube'a geri dönüldü.
        Thread.sleep(3000);

        //6-
        driver.navigate().refresh(); //sayfa yenilendi.
        Thread.sleep(3000);

        //7-
        driver.navigate().to("https://www.amazon.com/");
        //Amazon'a geri dönüldü.
        // back() methodu kullanılmadı cünkü chrome bos tarayıcı safası acıyor.
        Thread.sleep(3000);

        //8-
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        Thread.sleep(3000);

        //9-
        String expectedTıtle2 = "Amazon";
        String expectedUrl2 = "https://www.amazon.com/";

        String actualTitle2 = driver.getTitle();
        String actualUrl2 = driver.getCurrentUrl();

        if (driver.getTitle().contains(expectedTıtle2)){
            System.out.println("https://www.amazon.com/ web'ni basligi : " +
                    expectedTıtle2 + " ifadesini içermektedir.");
        } else {
            System.out.println("Test FAILED");
            System.out.println("https://www.amazon.com/ web'ni basligi : " +
                    expectedTıtle2 + " ifadesini ICERMEMEKTEDİR.");
            System.out.println("Actual Title : " + actualTitle2 + " OLMALIDIR");
        }

        //3-
        if (driver.getCurrentUrl().contains(expectedUrl2)){
            System.out.println("https://www.amazon.com/ web'in URL'si : " +
                    expectedUrl2 + " ifadesini içermektedir.");
        } else {
            System.out.println("Test FAILED");
            System.out.println("https://www.amazon.com/ web'in URL'si : " +
                    expectedUrl2 + " ifadesini ICERMEMEKTEDİR.");
            System.out.println("Dogru baslık : " + actualUrl2 + "OLMALIDIR");
        }

        driver.quit();
    }
}
