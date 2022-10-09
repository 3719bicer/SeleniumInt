package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q1 {
    public static void main(String[] args) throws InterruptedException {

        /*...Exercise1...
        1- Create a new class under Q1 create main method
        2- Set Path
        3- Create chrome driver
        4- Maximize the window
        5- Open google home page https://www.google.com/.
        6- On the same class, Navigate to amazon home page https://www.amazon.com/
           Navigate back to google
        7- Navigate forward to amazon
        8- Refresh the page
        9- Close/Quit the browser
        10-And last step : print "All Ok" on console
        */

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.navigate().to("https://www.google.com/");
        Thread.sleep(3000);

        driver.navigate().to("https://www.amazon.com/");
        Thread.sleep(3000);

        driver.navigate().refresh();
        Thread.sleep(3000);

        driver.quit();

        System.out.println("ALL OK");


    }
}
