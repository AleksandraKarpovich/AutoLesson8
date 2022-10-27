package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckLuckyButtonTest {

    private WebDriver driver;
    private final String LINK_APP = "https://www.google.com/";
    private static final String LUCKY_BUTTON = "//input[@value='Мне повезёт!']";

    @BeforeClass
    public void setupBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);

    }

    @Test
    public void verifyLuckyButtonTest(){
        driver.get(LINK_APP);
        boolean isLuckyButton = driver.findElement(By.xpath(LUCKY_BUTTON)).isDisplayed();
        Assert.assertFalse(isLuckyButton, "Ошибка: Кнопка [Мне повезет!] не найдена");

    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
