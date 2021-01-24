package com.GUI;

import com.GimkitCheat.main.ConvenientMethods;
import com.GimkitCheat.main.Main;
import com.GimkitCheat.selenium.Driver;
import com.GimkitCheat.main.Answer;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements ActionListener, WindowListener {
    JPanel answerPanel = new JPanel();
    JButton button = new JButton("Go");
    JTextField textField = new JTextField();

    JPanel titlePanel = new JPanel();
    JLabel title = new JLabel();

    JTextArea link = new JTextArea("Share this program using this link:\nhttps://cho-gath.github.io/Gimkit-Cheat-Website/");

    public MyFrame() {
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(1000, 300, 500, 300);
        this.setResizable(false);
        this.addWindowListener(this);

        JPanel layer = new JPanel();
        layer.setLayout(new FlowLayout(1, 30, 20));
        layer.setBounds(0, 0, 500, 300);
        layer.setVisible(true);
        layer.setBackground( new Color(40, 40, 40));

        //Title stuff

        title.setFont(new Font("Helvetica", Font.BOLD, 22));
        title.setBackground(new Color(168, 168, 168));
        title.setText("Gimkit Cheat");

        titlePanel.setFont(new Font("Helvetica", Font.BOLD, 30 ));
        titlePanel.setLayout(new FlowLayout());
        titlePanel.setPreferredSize(new Dimension(400, 40));
        titlePanel.setBackground(new Color(168 ,168,168));

        titlePanel.add(title);

        //Answering textfeild and button

        button.addActionListener(this);
        button.setPreferredSize(new Dimension(60, 26));
        button.setFocusable(false);
        button.setBackground(new Color(168, 168, 168));
        button.setBorder(BorderFactory.createLineBorder(Color.white, 2));

        textField.setBackground(new Color(168, 168, 168));
        textField.setText("https://www.gimkit.com/live");
        textField.setPreferredSize(new Dimension(350, 26));
        Border border = BorderFactory.createLineBorder(Color.white, 2);
        Border margin = new EmptyBorder(0, 20, 0, 0);
        textField.setBorder(new CompoundBorder(border, margin));

        answerPanel.setPreferredSize(new Dimension(400, 30));
        answerPanel.setFont(new Font("Helvetica", Font.BOLD, 45));
        answerPanel.setLayout(new BorderLayout());

        answerPanel.add(button, BorderLayout.WEST);
        answerPanel.add(textField, BorderLayout.EAST);

        //Bottom text (but actually bottom text not just a meme)

        link.setPreferredSize(new Dimension(400, 75));
        link.setBackground(new Color(168, 168, 168));
        link.setBorder(new EmptyBorder(5, 5, 5, 5));
        link.setFont(new Font("Bank Gothic", Font.BOLD, 16));
        link.setEditable(false);


        //puting everything together

        layer.add(titlePanel);
        layer.add(answerPanel);
        layer.add(link);
        this.add(layer);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == button) {
            Main.buttonClicked = true;
            Main.goodLink = Driver.tryLink(textField.getText());

            if(Main.goodLink) {
                button.setEnabled(false);
                new SwingWorker() {

                    @Override
                    protected Object doInBackground() throws Exception {
                        Answer.AnswerLoop();
                        return null;
                    }
                }.execute();
            } else {

            }
        }
    }

    //Window activity


    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        if(Main.goodLink) {
            boolean complete = false;
            Main.repeat = false;
            while (!complete) {
                if (Main.finished) {
                    Driver.driver.quit();
                    System.exit(0);
                } else {
                    ConvenientMethods.sleep(50);
                }
            }
        } else {
            if(Main.buttonClicked) {
                Driver.driver.quit();
                System.exit(0);
            } else {
                System.exit(0);
            }
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
