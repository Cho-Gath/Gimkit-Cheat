package com.GimkitCheat.main;

import com.GUI.MyFrame;
import com.GimkitCheat.selenium.XPathOf;
import com.GimkitCheat.selenium.Driver;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.StaleElementReferenceException;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static boolean buttonClicked = false;
    public static boolean goodLink = false;
    public static boolean repeat = true;
    public static boolean finished = false;

    public static void main(String[] args) {
        new MyFrame();
    }

}


