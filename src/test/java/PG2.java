import org.openqa.selenium.By;
import  org.openqa.selenium.WebDriver;
import  org.openqa.selenium.chrome.ChromeDriver;

public  class  PG2 {
        public static void main(String[] args){
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            String baseUrl = "http://www.facebook.com";

            driver.get(baseUrl);
            String tagName = driver.findElement(By.id("email")).getTagName();
            String className = driver.findElement(By.className("inputtext")).getTagName();
            System.out.println(tagName);
            System.out.println(className);
            driver.close();
            System.exit(0);

        }
}