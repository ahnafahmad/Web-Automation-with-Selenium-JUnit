import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class Login_Form_Automation {

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }
@Test
    public void logo(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//        Actions actions = new Actions(driver);

        driver.findElement(By.className("orangehrm-login-branding"));

    }

    @Test
    public void loginSuccessful() throws InterruptedException {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("Admin");
        Thread.sleep(1000);
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("[type=submit]")).click();

    }

    @Test
    public void loginUnsuccessfullWithWrongUsername() throws InterruptedException {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("ahnaf");
        Thread.sleep(1000);

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("[type=submit]")).click();

        List<WebElement> message = driver.findElements(By.tagName("p"));
        String actualMessage = message.get(0).getText();
        String expectedMessage = "Invalid";
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void loginUnsuccessfullWithWrongPassword() throws InterruptedException {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("Admin");
        Thread.sleep(1000);

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin1234");
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("[type=submit]")).click();

        List<WebElement> message = driver.findElements(By.tagName("p"));
        String actualMessage = message.get(0).getText();
        String expectedMessage = "Invalid";
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void loginUnsuccessfullWithWrongUsernameAndPassword() throws InterruptedException {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("Ahnaf");
        Thread.sleep(1000);

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin1234");
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("[type=submit]")).click();

        List<WebElement> message = driver.findElements(By.tagName("p"));
        String actualMessage = message.get(0).getText();
        String expectedMessage = "Invalid";
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void loginUnsuccessfullWithoutUsername() throws InterruptedException {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("[type=submit]")).click();

        WebElement message = driver.findElement(By.tagName("span"));
        String actualMessage = message.getText();
        String expectedMessage = "Required";
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void loginUnsuccessfullWithoutPassword() throws InterruptedException {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("Admin");
        Thread.sleep(1000);


        driver.findElement(By.cssSelector("[type=submit]")).click();

        WebElement message = driver.findElement(By.tagName("span"));
        String actualMessage = message.getText();
        String expectedMessage = "Required";
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void loginUnsuccessfullWithoutUsernameAndPassword() throws InterruptedException {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


        driver.findElement(By.cssSelector("[type=submit]")).click();

        WebElement message = driver.findElement(By.tagName("span"));
        String actualMessage = message.getText();
        String expectedMessage = "Required";
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

        @Test
        public void forgotPassword() throws InterruptedException {
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            driver.findElement(By.className("orangehrm-login-forgot")).click();
            Thread.sleep(2000);

            WebElement resetMessage = driver.findElement(By.tagName("h6"));
            String actualMessage1 = resetMessage.getText();
            String expectedMessage1 = "Reset";
            Assert.assertTrue(actualMessage1.contains(expectedMessage1));

            driver.findElement(By.name("username")).sendKeys("Admin");
            Thread.sleep(1000);

            driver.findElement(By.cssSelector("[type=submit]")).click();

            WebElement resetSuccessfullMessage = driver.findElement(By.tagName("h6"));
            String actualMessage2 = resetSuccessfullMessage.getText();
            String expectedMessage2 = "successfully";
            Assert.assertTrue(actualMessage2.contains(expectedMessage2));

        }

    @Test
    public void forgotPasswordwithCancelButton() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(1000);

        driver.findElement(By.className("orangehrm-login-forgot")).click();
        Thread.sleep(2000);

        WebElement resetMessage = driver.findElement(By.tagName("h6"));
        String actualMessage1 = resetMessage.getText();
        String expectedMessage1 = "Reset";
        Assert.assertTrue(actualMessage1.contains(expectedMessage1));


        driver.findElement(By.cssSelector("[type=button]")).click();

        WebElement resetCancelMessage = driver.findElement(By.tagName("h5"));
        String actualMessage = resetCancelMessage.getText();
        String expectedMessage = "Login";
        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void linkedinIcon() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(1000);



        List<WebElement> linkedin = driver.findElements(By.tagName("a"));
        linkedin.get(0).click();


    }

    @Test
    public void facebookIcon() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(1000);


        List<WebElement> facebook = driver.findElements(By.tagName("a"));
        facebook.get(1).click();

    }

    @Test
    public void twetterIcon() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(1000);

        List<WebElement> Twetter = driver.findElements(By.tagName("a"));
        Twetter.get(2).click();


    }

    @Test
    public void youtubeIcon() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(1000);


        List<WebElement> youtube = driver.findElements(By.tagName("a"));
        youtube.get(3).click();

    }


}
