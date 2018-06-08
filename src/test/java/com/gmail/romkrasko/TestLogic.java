package com.gmail.romkrasko;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.gmail.romkrasko.BrowserFactory.*;

public class TestLogic {

    private BrowserFactory singleton = BrowserFactory.getInstance();
    private WaiterClass wait = new WaiterClass();


    public void goYandex() {
        driver = singleton.setDriver();
        driver.get("https://yandex.by/");
    }

    public void clickToGeoButton() {
        WebElement geoMinsk = driver.findElement(By.cssSelector(".geolink__reg"));
        geoMinsk.click();
    }

    public void setLocation(String location) {
        WebElement geoInput = driver.findElement(By.cssSelector(".input__control.input__input"));
        wait.WaitUntilElementIsEnable(geoInput);
        geoInput.clear();
        geoInput.sendKeys(location);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("lol((");
        }
        geoInput.sendKeys(Keys.ENTER);
    }

    public void clickMoreButton() {
        WebElement labelMore = driver.findElement(By.cssSelector(".home-link.home-link_blue_yes.home-tabs__link.home-tabs__more-switcher"));
        wait.WaitUntilElementIsEnable(labelMore);
        labelMore.click();
    }

    public String[] rememberTheContents() {
        List<WebElement> listElements = driver.findElements(By.cssSelector(".home-tabs__more-item"));
        int size = listElements.size();
        String[] names = new String[size];
        int i = 0;
        for (WebElement element : listElements) {
            names[i] = element.getText();
            i++;
        }
        return names;
    }
}
