package com.GimkitCheat.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    public static WebDriver driver = new ChromeDriver();

    public static void openLink(String link) {
        driver.get(link);
    }

    public static String findText(String xpath) {
        String s = driver.findElement(By.xpath(xpath)).getText();
        return s;
    }

    public static void click(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public static void close() {
        driver.close();
    }
}
