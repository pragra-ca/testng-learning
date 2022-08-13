import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

public class SelDemoTest {
    private WebDriver driver;
    Actions actions;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/atin/Downloads/chromedriver");
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.get("https://zoom.us/");
    }

    @Test(enabled = false)
    public void testName() throws InterruptedException {
        driver.get("https://zoom.us/");
        System.out.println(driver.getPageSource());
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[@id='signupfree']/a"));
        actions.keyDown(Keys.COMMAND).click(element).build().perform();
        Thread.sleep(5000);
        String currentWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String window: windowHandles) {
            if(!window.equals(currentWindow)){
                driver.switchTo().window(window);
            }
        }
        Thread.sleep(5000);
        driver.switchTo().window(currentWindow);
    }

    @Test(enabled = false)
    public void targetLocators() throws InterruptedException {
        driver.get("https://zoom.us/");
        ((JavascriptExecutor) driver).executeScript("prompt('Hello how ar you')");
        Thread.sleep(5000);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("I am doing good");
        System.out.println(alert.getText());
        alert.dismiss();

    }


    @Test(enabled = false)
    public void iframeTest() throws InterruptedException {
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_frameborder");
        Thread.sleep(5000);
        WebElement frame = driver.findElement(By.xpath("//*[@id=\"iframeResult\"]"));
        driver.switchTo().frame(frame);

        WebElement element = driver.findElement(By.xpath("/html/body/h2"));
        Assert.assertEquals(element.getText(), "Remove the Iframe Border");
    }


    @Test(enabled = false)
    public void frameAnother() throws InterruptedException, MalformedURLException {
        driver.get("https://www.w3schools.com/html/html_iframe.asp");
//        WebElement frame = driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/iframe"));
//        driver.switchTo().frame(frame);
//        driver.findElement(By.xpath("//*[@id=\"pagetop\"]/div[2]/a[1]")).click();
//        Thread.sleep(10000);
//
//        driver.switchTo().parentFrame();
        driver.findElement(By.xpath("//a[@title='Video Tutorials']")).click();
        Thread.sleep(5000);
        driver.navigate().back();
        Thread.sleep(5000);
        driver.navigate().forward();
        Thread.sleep(5000);
        driver.navigate().refresh();
        Thread.sleep(5000);
        driver.navigate().to(new URL("https://pragra.io"));

    }

    @Test(enabled = false)
    public void optionTest() throws InterruptedException {
        driver.get("https://zoom.us/pricing");
        Set<Cookie> cookies = driver.manage().getCookies();
        cookies.forEach(System.out::println);
        Cookie zm_currency = driver.manage().getCookieNamed("_zm_currency");
        driver.manage().deleteCookieNamed("_zm_currency");
        driver.manage().deleteAllCookies();
        Thread.sleep(5000);
        driver.manage().addCookie(new Cookie("_zm_currency","USD"));

        driver.navigate().refresh();



    }

    @Test(enabled = false)
    public void windowTest() throws InterruptedException {
        driver.get("https://pragra.io");

        WebElement subscriptionForm = driver.findElement(By.tagName("form"));
        WebElement email = driver.findElement(By.id("email"));

        email.sendKeys("atin@pragra.io", Keys.TAB);

        Thread.sleep(3000);
        email.clear();

        System.out.println(email.getTagName());

        System.out.println(email.getAttribute("placeholder"));



    }


    @Test(enabled = false)
    public void webElementDemo() throws InterruptedException, IOException {
        driver.get("https://pragra.io/courses/front-end-course");
        WebElement element = driver.findElement(By.xpath("//input[@type='checkbox']"));
        if (!element.isSelected()) {
            System.out.println("NOT CHECKED");
            element.click();
        }

        WebElement message = driver.findElement(By.id("message"));
        //((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none'", message);
        Thread.sleep(5000);
        if(!message.isDisplayed()){
            System.out.println("ITS NOT DISPLAYED ON SCREEN");
        }
        if(!message.isEnabled()) {
            System.out.println("Its disabled");
        }
        System.out.println(message.getLocation());
        System.out.println(message.getSize());
        System.out.println(message.getRect());
        System.out.println(message.getCssValue("padding-right"));

        WebElement form = driver.findElement(By.tagName("form"));
        File file = form.getScreenshotAs(OutputType.FILE);

        Files.copy(file.toPath(), Paths.get("form.png"));


    }

    @AfterSuite
    public void tearDown() throws InterruptedException {

        Thread.sleep(10000);
        driver.quit();
    }

    @Test(enabled = false)
    public void actionTest() {

        WebElement solutions = driver.findElement(By.id("btnSolutions"));
        WebElement goverment = driver.findElement(By.xpath("//a[@role='menuitem']/h3[text()='Government']"));

        ((JavascriptExecutor) driver).executeScript("scroll(0,10000)");
        actions.moveToElement(solutions,100,0).pause(3000).moveToElement(goverment).click().build().perform();

    }

    @Test(enabled = false)
    public void clickOnHoldyTest(){
        WebElement signupfree = driver.findElement(By.id("signupfree"));
        actions.moveToElement(signupfree).contextClick().build().perform();

    }

    @Test
    public void keyDownTest(){
        WebElement signupfree = driver.findElement(By.id("signupfree"));
        actions.keyDown(Keys.COMMAND).pause(3000).click(signupfree).build().perform();
    }

    @Test(enabled = false)
    public void dragNDrop( ){
        driver.get("https://jqueryui.com/droppable/");
        WebElement frame = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(frame);
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(draggable,droppable).build().perform();

    }

    @Test
    public void contentMenu() throws InterruptedException {
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        WebElement menu = driver.findElement(By.xpath("//span[.='right click me']"));

        actions.moveToElement(menu).contextClick().build().perform();

        driver.findElement(By.xpath("//ul[@class='context-menu-list context-menu-root']/li[5]")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().dismiss();

    }


}
