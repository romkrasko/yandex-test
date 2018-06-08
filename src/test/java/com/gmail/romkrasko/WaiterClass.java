package com.gmail.romkrasko;

import org.openqa.selenium.*;

public class WaiterClass {

    public void WaitUntilElementIsEnable(WebElement element) {
        long startTime = System.currentTimeMillis();
        while (true) {
            if (System.currentTimeMillis() - startTime > 10000) {
                System.out.println("Time out(");
                break;
            }
            try {
                System.out.println(element.isEnabled());
                break;

            }catch (NoSuchElementException e) {}
            catch (StaleElementReferenceException e){
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("lol((");
            }
        }
    }
}
