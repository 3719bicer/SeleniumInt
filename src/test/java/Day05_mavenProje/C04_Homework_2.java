package Day05_mavenProje;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
public class C04_Homework_2 {
    @Test
    public void Test_isItemInTheBasket() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

        // 2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        Thread.sleep(3000);

        // 3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        Thread.sleep(3000);

        // 4. Login tusuna basin
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        Thread.sleep(3000);

        // 5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement firstProduct=driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        String productName =firstProduct.getText();
        System.out.println("ProductName : " + productName);
        firstProduct.click();
        Thread.sleep(3000);

        // 6. Add to Cart butonuna basin.
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(3000);

        // 7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();
        Thread.sleep(3000);

        // 8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement productInTheBasket = driver.findElement(By.xpath("//div[text()='"+ productName +"']"));
        Assert.assertTrue(productInTheBasket.isDisplayed());
        Thread.sleep(3000);

        /*
        2.YÖNTEM
        boolean isProdcutInTheBasket = driver.getPageSource().contains(productName);
        Assert.assertTrue(isProdcutInTheBasket);
        //Assert sinifindaki methodlar actual ile expected degerleri karsilatirir ve sonuca gore test gecti ya da kaldi der.
        */

        // 9. Sayfayi kapatin
        driver.quit();






    }
}
