import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class myclass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "http://newtours.demoaut.com";
        String var = "";
        driver.get(baseUrl);
        var = driver.findElement(By.cssSelector("font:conains('Password:')")).getText();
        System.out.println(var);
        driver.close();
        System.exit(0);
    }
}
