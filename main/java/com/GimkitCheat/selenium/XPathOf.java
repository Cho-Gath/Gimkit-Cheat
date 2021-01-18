package com.GimkitCheat.selenium;

import java.util.Arrays;
import java.util.List;

public class XPathOf {
    //ANSWERING XPATH STUFF
    public static String question = "/html/body/div[1]/div/div/div[2]/div[1]/div/div/div[2]/div/div/div[1]/div/div/div/div/span";

    public static List<String> AnswerButtons() {
        return Arrays.asList(
                "/html/body/div[1]/div/div/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div[1]/div", //top left button
                "/html/body/div[1]/div/div/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div[2]/div", //top right button
                "/html/body/div[1]/div/div/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div[3]/div", //bottom left button
                "/html/body/div[1]/div/div/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div[4]/div"  //bottom right button
        );
    }

    public static String moneyResult = "/html/body/div[1]/div/div/div[2]/div[1]/div/div/div[2]/div/div/div/div[1]/div/div/div/div";

    //AFTER ANSWERING QUESTION STUFF
    public static String continueAfterCorrect = "/html/body/div[1]/div/div/div[2]/div[1]/div/div/div[2]/div/div/div/div[2]/span[2]/div/div/div";

    public static String showCorrectAnswer = "/html/body/div[1]/div/div/div[2]/div[1]/div/div/div[2]/div/div/div/div[2]/span[1]/div";
    public static String correctAnswerLocation = "/html/body/div[1]/div/div/div[2]/div[1]/div/div/div[2]/div/div/div/div[1]/div/div[3]/div/div/div/span";
    public static String continueAfterWrongAnswer = "/html/body/div[1]/div/div/div[2]/div[1]/div/div/div[2]/div/div/div/div[2]/span/div";
}
