import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalTime;

public class AutomationPracticeTest {
    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before test " + this.getClass().getName()); }

    public void setUp(){
        String driverPath = "/Users/ola/IdeaProjects/zadanierekrutacyjne/src/main/executables/drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver",driverPath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void firstTest() throws IOException {
        System.out.println("Dodawanie produktu do koszyka");
        openWebsite("http://automationpractice.com/index.php");
    }

    public void openWebsite(String address) throws IOException {
        driver.get(address);
        takeScreenshot(driver);
    }

    public void takeScreenshot(WebDriver driver) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenshotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File ("src/main/resources/" + LocalTime.now().getNano() + ".png");
        Files.copy(screenshotFile.toPath(), destinationFile.toPath());
    }

    public void addProductToCard(String productName) {

        driver.findElement(By.linkText(productName)).click();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product_reference")));
        driver.findElement(By.id("add_to_cart")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Proceed to checkout")));
        driver.findElement(By.linkText("Proceed to checkout")).click();
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After test " + this.getClass().getName()); }


}
