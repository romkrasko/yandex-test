package com.gmail.romkrasko;

import org.openqa.selenium.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.collections.CollectionUtils;

import static com.gmail.romkrasko.BrowserFactory.*;

public class BaseTest {

    private BrowserFactory singleton = BrowserFactory.getInstance();

    @BeforeTest
    public void setUp() {
        driver = singleton.setDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://yandex.by/");
    }

    @Test
    public void tests() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement geoMinsk = driver.findElement(By.cssSelector(".geolink__reg"));
        geoMinsk.click();
        WebElement geoInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".input__control.input__input")));
        geoInput.clear();
        geoInput.sendKeys("Франция Париж");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("lol((");
        }
        geoInput.sendKeys(Keys.ENTER);
        WebElement labelMore = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".home-link.home-link_blue_yes.home-tabs__link.home-tabs__more-switcher")));
        labelMore.click();
        String[] nameParis = new String[22];
        int i = 0;
        List<WebElement> listElementsParis = driver.findElements(By.cssSelector(".home-tabs__more-item"));
        for (WebElement element : listElementsParis) {
            nameParis[i] = element.getText();
            i++;
        }

        WebElement geoParis = driver.findElement(By.cssSelector(".geolink__reg"));
        geoParis.click();
        geoInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".input__control.input__input")));
        geoInput.clear();
        geoInput.sendKeys("Лондон");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("lol((");
        }
        geoInput.sendKeys(Keys.ENTER);
        wait = new WebDriverWait(driver, 10);
        labelMore = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".home-link.home-link_blue_yes.home-tabs__link.home-tabs__more-switcher")));
        labelMore.click();
        String[] nameLondon = new String[22];
        i = 0;
        int res = 0;
        List<WebElement> listElementsLondon = driver.findElements(By.cssSelector(".home-tabs__more-item"));
        for (WebElement element : listElementsLondon) {
            nameLondon[i] = element.getText();
            res = nameLondon[i].compareTo(nameParis[i]);
            i++;
        }
            if (res==0){System.out.println(")))");}
            else{geoParis = driver.findElement(By.cssSelector(".geolink__regdgf"));}

    }



    @AfterTest
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
