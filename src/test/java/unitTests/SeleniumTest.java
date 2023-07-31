package unitTests;

   import java.time.Duration;
   import org.junit.AfterClass;
   import org.junit.Assert;
   import org.junit.BeforeClass;
   import org.junit.Test;

   import org.openqa.selenium.By;
   import org.openqa.selenium.Keys;
   import org.openqa.selenium.WebElement;
     import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    private static ChromeDriver driver;
    WebElement element;

    @BeforeClass
    public static void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     }

    @Test
    public void valid_UserCredential() {

        System.out.println("Starting test " + new Object() {
        }.getClass().getEnclosingMethod().getName());
        driver.get("https://admin-demo.nopcommerce.com/login");
        driver.findElement(By.cssSelector("input[class='email")).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.cssSelector("input[class='email")).sendKeys(Keys.DELETE);

        driver.findElement(By.cssSelector("input[class='email")).sendKeys("admin@yourstore.com");
        driver.findElement(By.cssSelector("input[class='password']")).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.cssSelector("input[class='password']")).sendKeys(Keys.DELETE);

        driver.findElement(By.cssSelector("input[class='password']")).sendKeys("admin");
        driver.findElement(By.cssSelector("div.buttons > button[type='submit']")).click();
        try {
            element = driver.findElement(By.cssSelector("ul.navbar-nav > li:nth-child(2) > a"));
        } catch (Exception e) {
            Assert.assertNotNull(element);
            System.out.println("Ending test " + new Object() {
            }.getClass().getEnclosingMethod().getName());
        }

    }
    @AfterClass
    public static void closeBrowser(){
        driver.quit();
    }
}