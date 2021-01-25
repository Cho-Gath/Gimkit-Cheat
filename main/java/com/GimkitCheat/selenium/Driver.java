package com.GimkitCheat.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.io.File;

public class Driver {

    public static WebDriver driver = new FirefoxDriver();



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

    public static boolean tryLink(String link) {
        try {
            Driver.openLink(link);
            return true;
        } catch (InvalidArgumentException e) {
            return false;
        }
    }
}
