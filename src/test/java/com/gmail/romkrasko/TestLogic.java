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
        String[] names = new String[22];
        int i = 0;
        List<WebElement> listElements = driver.findElements(By.cssSelector(".home-tabs__more-item"));
        for (WebElement element : listElements) {
            names[i] = element.getText();
            i++;
        }
        return names;
    }

    public int compareCotntents(String[] nameLondon, String[] nameParis) {
        int res = 1;
        for (int i = 0; i < nameLondon.length-1; i++) {
            res = nameLondon[i].compareTo(nameParis[i]);
            if (res == 1) {
                break;
            }
        }
        return res;
    }
    public void endTestCase(int exRes,int actRes){
        if (exRes == actRes){
            System.out.println("Success");
        }else{
            System.out.println("Failed(");
            WebElement rrr = driver.findElement(By.cssSelector(".dhsdffhdythdtyh"));
        }

    }
}
