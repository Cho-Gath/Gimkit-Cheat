package com.GimkitCheat.main;

import com.GimkitCheat.selenium.XPathOf;
import com.GimkitCheat.selenium.Driver;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.StaleElementReferenceException;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;

public class Main {

    static HashMap<String, List> StartProcess(){
        File f = new File("stuff\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", f.getAbsolutePath());

        System.out.print("Copy and Paste the link: ");
        Scanner scanner = new Scanner(System.in);
        String link = scanner.next();
        boolean goodlink = false;
        do {
            try {
                Driver.openLink(link);
                goodlink = true;
            } catch (InvalidArgumentException e) {
                System.out.println("Something went wrong... maybe put in an actual fucking link!");
                System.out.print("Link pls: ");
                link = scanner.next();
            }
        } while(!goodlink);

        HashMap<String, List> map = FileStuff.read();
        if(map == null) {
            return new HashMap();
        } else {
            return map;
        }
    }

    public static void main(String[] args) {
        HashMap<String, List> answers = StartProcess();
        String question;
        boolean alreadyAnswered = false;
        boolean repeat = true;
        while(repeat) {
            try {
                while (repeat) {
                    //Finding the question
                    question = Driver.findText(XPathOf.question);
                    System.out.println("Question: " + question);
                    //Answering if question is recognized
                    for (String key : answers.keySet()) {
                        if (key.equals(question)) {
                            System.out.println("answer is known\n");
                            boolean found = false;
                            while (!found)
                                try {
                                    answers = Answer.correctly(answers, question);
                                    found = true;
                                    alreadyAnswered = true;
                                } catch (StaleElementReferenceException e) {
                                    ConvenientMethods.sleep(100);
                                }
                            break;
                        }
                    }
                    if (!alreadyAnswered) {
                        HashMap newMap = Answer.guessAnswer(answers, question);
                        if(newMap.equals(new HashMap())) {
                            System.out.println("but we made it here and continued");
                            alreadyAnswered = false;
                            continue;
                        } else {
                            answers = newMap;
                        }
                    }
                    alreadyAnswered = false;
                    System.out.println("bottom of loop\n");
                }
            } catch(Exception e) {
                ConvenientMethods.sleep(100);
                //System.out.println("there was an error");
                alreadyAnswered = false;
            }
        }

    }

}


