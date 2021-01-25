package com.GimkitCheat.main;

import com.GUI.MyFrame;

import java.io.File;

public class Main {


    public static boolean buttonClicked = false;
    public static boolean goodLink = false;
    public static boolean repeat = true;
    public static boolean finished = false;

    public static void main(String[] args) {
        File f = new File("stuff\\geckodriver.exe");
        System.setProperty("webdriver.gecko.driver", f.getAbsolutePath());
        new MyFrame();
    }

}


