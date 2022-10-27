package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckLetterGoogleTest {
    private WebDriver driver;
    private final String LINK_APP = "https://www.google.com/";
    private static final String SEARCH_FIELD = "//input[@class='gLFyf gsfi']";
    private static final String ACCEPT_ALL_BUTTON = "//button[@id='L2AGLb']";
    private static final String NYAN_TEXT = "nyan cat";
    private static final String GOOGLE = "//td[position()>=2 and position()<12]";
    private static final int EXPECTED_COUNT = 10;

    @BeforeClass
    public void setupBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-notifications");
        driver = new ChromeDriver(chromeOptions);
    }

    @Test
    public void checkLetterGoogleTest(){
        driver.get(LINK_APP);
        driver.findElement(By.xpath(ACCEPT_ALL_BUTTON)).click();
        driver.findElement(By.xpath(SEARCH_FIELD)).click();
        driver.findElement(By.xpath(SEARCH_FIELD)).sendKeys(NYAN_TEXT);
        driver.findElement(By.xpath(SEARCH_FIELD)).sendKeys(Keys.ENTER);
        int actualCount =  driver.findElements(By.xpath(GOOGLE)).size();
        System.out.println(actualCount);
        Assert.assertEquals(actualCount, EXPECTED_COUNT);
    }
    @AfterClass
    public void closeBrowser(){
       driver.quit();
    }
}
