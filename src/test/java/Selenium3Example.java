import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Selenium3Example {
    public static void main (String[] args){
        //Create a new instance of the FirefoxDriver
        //Notice that the remainder  of the code relies on the interface.
        //not the implementation.
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //And now use this to visit Google
        driver.get("http://www.google.com");

        //Alternatively the same thing can be done I like this
        //driver.navigate().to.("http://www.google.com");

        //Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        //Enter something to search for
        element.sendKeys("Cheese!");

        //Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        //Check the title of the page
        System.out.println("Page title is : " + driver.getTitle());

        //Google's search is rendered dynamically with JavaScript.
        //Wait for the page to lad, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("CHEESE!");
            }
        });
        //Should see: "cheese!- Google Search"
        System.out.println("Page title is : " + driver.getTitle());

        //Close the browser
        List<WebElement> labels = driver.findElements(By.tagName("label"));
        List<WebElement> inputs = (List<WebElement>) ((JavascriptExecutor)driver).executeScript(
                "var labels = arguments[0], inputs = []; for (var i=0; i < labels.length; i++){" +
                        "inputs.push(document.getElementById(labels[i].getAttribute('for'))); } return inputs;", labels);
        //driver.quit();
    }
}
