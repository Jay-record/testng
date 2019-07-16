import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class testng {
    WebDriver webDriver;

    @BeforeTest
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        /*System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();*/
    }

    @Test
    public void testLogin () {
        webDriver.navigate().to("https://www.seidor.es/content/seidorweb/es.html");
        String S = webDriver.getTitle();
        Assert.assertEquals(webDriver.getTitle(), S);
        takeScreenShotTest(webDriver,S);


    }

   /* @AfterTest
    public void tearDown () {webDriver.quit();

    }*/
    public static void takeScreenShotTest(WebDriver webDriver, String imageName) {
// Directory that will keep saved pictures
        File directory = new File("C:\\captureSelenium\\");
        try {
            if (directory.isDirectory()) {
//Take a picture.
                File imagen = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
//Mueve el archivo a la carga especificada con el respectivo nombre
                FileUtils.copyFile(imagen, new File(directory.getAbsolutePath() + "\\" + imageName
                        +".png"));
            } else {
//Se lanza la excepción cuando no encuentre el directorio
                throw new IOException("ERROR : La ruta especificada no es un directorio!");
            }
        } catch (IOException e) {
//Impresión de Excepciones
            e.printStackTrace();
        }
    }

    /*private void pause(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/
}

/*    Common and useful notes
    //Make click in register or login
//(0) es register
//(1) es log in
    List<WebElement> registerlink = webDriver.findElements(By.className("liOffcanvas"));
registerlink.get(0).click();
//Enter URL
        webDriver.get("https://www.linktest.com");
//To change to another tab
        Set<String> tab_handles = webDriver.getWindowHandles();
        int number_of_tabs = tab_handles.size();
        int new_tab_index = number_of_tabs-1;
        webDriver.switchTo().window(tab_handles.toArray()[new_tab_index].toString());
//Save URL from page where you are located
        String urlsite = webDriver.getCurrentUrl();
//Save variables/page elements
        WebElement nameInput = webDriver.findElement(By. name ("firstName"));
        WebElement nameInput = webDriver.findElement(By. className ("firstName"));
        WebElement nameInput = webDriver.findElement(By. id ("firstName"));
        WebElement nameInput = webDriver.findElement(By. partialLinkText ("firstName"));
        webDriver.findElement(By. tagName ("firstName"));
//Save page elements with tags not included in selenium, as title etc...
        WebElement sitePR = webDriver.findElement(By.xpath("//*[@title='titulo']"));
        sitePR.click();
//Assign a value to an input
        nameInput.sendKeys(“Juez”);
//Empty value of an imput
        inputStock.clear();
//Obtain the value of an imput
        WebElement mailRegister = webDriver.findElement(By.className("mailtext"));
        String valorEmailInput = mailRegister.getAttribute("value");
        rpassInput.submit();
//To allow to click an element althought it´s hidden
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", checkterm);
        JavascriptExecutor scroll = (JavascriptExecutor) webDriver;
        WebElement elemento = webDriver.findElement(By. id ("mailbox"));
        scroll.executeScript("arguments[0].scrollIntoView();", elemento);
// Accept alert messages
        webDriver.switchTo().alert().accept();
//Make click inside a pop-up
        WebElement popup = webDriver.findElement(By.id("newsletter-modal-container"));
        popup.findElement(By.id("cboxClose")).click();
//Country flag dropdown
        webDriver.findElement(By.className("flag-container")).findElement(By.cssSelector("[data-country-c
        ode='" + "ru" + "']")).click();
//Change window
        String mainWindowsHandle = webDriver.getWindowHandle();
        Set<String> handles = webDriver.getWindowHandles();
        for(String handle : handles) {
        webDriver.switchTo().window(handle); // volviendo a cada ventana en bucle
        if(webDriver.getTitle().equals("titulomolon")){
        String secondWindowsHandle = handle;
        }
//Make double click
        Actions action2 = new Actions(webDriver);
        WebElement elementdoubleclick2=webDriver.findElement(By.id(chooseprod2[indSite]));
        action2.doubleClick(elementdoubleclick2).perform();
//To realize mouse hover
        Actions action = new Actions(webDriver);
        WebElement we =
        webDriver.findElement(By.xpath("//div[@id='shadow-container']/div/nav/ul/li/div/div"));//catálogo
        en el header
        action.moveToElement(we).perform();
        new
        Select(webDriver.findElement(By.name("countrySelector-language"))).selectByVisibleText("Catalán")
        ;
        webDriver.findElement(By.id("js-countrySelector-button")).click();
        Select drpRegionNumber = new Select(webDriver.findElement(By.id("addressRegion")));
        drpRegionNumber.selectByIndex(1);
//Save URL from page where you are located
        String urlsite = webDriver.getCurrentUrl(); */