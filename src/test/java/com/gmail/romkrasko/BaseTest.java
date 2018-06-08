package com.gmail.romkrasko;

import org.testng.annotations.*;
import org.testng.Assert;

import static com.gmail.romkrasko.BrowserFactory.*;

public class BaseTest{

    private TestLogic logic = new TestLogic();

    @BeforeTest
    public void setUp() {
        logic.goYandex();
    }

    @Test
    public void tests() {
        logic.clickToGeoButton();

        logic.setLocation("Франция Париж");

        logic.clickMoreButton();

        String[] nameParis = logic.rememberTheContents();

        logic.clickToGeoButton();

        logic.setLocation("Лондон");

        logic.clickMoreButton();

        String[] nameLondon = logic.rememberTheContents();

        Assert.assertEquals(nameLondon,nameParis);

    }



    @AfterTest
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
