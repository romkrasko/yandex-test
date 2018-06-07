package com.gmail.romkrasko;

import org.testng.annotations.*;

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

        String[] nameParis = logic.rememberTheContentsParis();

        logic.clickToGeoButton();

        logic.setLocation("Лондон");

        logic.clickMoreButton();

        String[] nameLondon = logic.rememberTheContentsLondon();

        int expectedResult = 0;
        int actualResult=logic.compareCotntents(nameLondon,nameParis);

        logic.endTestCase(expectedResult,actualResult);

    }



    @AfterTest
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
