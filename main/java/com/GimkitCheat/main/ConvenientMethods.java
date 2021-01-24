package com.GimkitCheat.main;

import com.GimkitCheat.selenium.Driver;
import org.openqa.selenium.InvalidArgumentException;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ConvenientMethods {
    public static void sleep(int x) {
        try {
            Thread.sleep(x);
        } catch(InterruptedException e) {}
    }


    public static HashMap<String, List> StartProcess(){
        File f = new File("stuff\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", f.getAbsolutePath());

        HashMap<String, List> map = FileStuff.read();
        if(map == null) {
            return new HashMap();
        } else {
            return map;
        }
    }
}
