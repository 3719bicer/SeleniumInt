package Day03_webElement_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_LinkText {
    public static void main(String[] args) throws InterruptedException {

        /*
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");

        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");

        WebElement customerServiceElementi=driver.findElement(By.linkText("Customer Service"));
        customerServiceElementi.click();

        Thread.sleep(3000);
        driver.close();

         */

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");

        WebElement customerServiceElement = driver.findElement(By.linkText("Customer Service"));
        customerServiceElement.click();
        Thread.sleep(3000);
        driver.quit();
    }
}
