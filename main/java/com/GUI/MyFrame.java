package com.GUI;

import com.GimkitCheat.main.ConvenientMethods;
import com.GimkitCheat.main.Main;
import com.GimkitCheat.selenium.Driver;
import com.GimkitCheat.main.Answer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyFrame extends JFrame implements ActionListener, WindowListener {
    JButton button = new JButton("Go");
    JTextField textField = new JTextField();
    JTextArea linkField = new JTextArea();

    public MyFrame() {
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(1000, 300, 500, 300);
        this.setResizable(false);
        this.addWindowListener(this);

        JPanel layer = new JPanel();
        layer.setLayout(new FlowLayout(1, 15, 75));
        layer.setBounds(0, 0, 500, 300);
        layer.setVisible(true);
        layer.setBackground( new Color(40, 40, 40));

        button.addActionListener(this);
        button.setPreferredSize(new Dimension(60, 26));
        button.setFocusable(false);
        button.setBackground(new Color(168, 168, 168));

        textField.setFont(new Font("Bank Gothic", Font.BOLD, 12));
        textField.setBackground(new Color(168, 168, 168));
        textField.setText("https://www.gimkit.com/live");
        textField.setPreferredSize(new Dimension(350, 26));
        textField.setBorder(new EmptyBorder(0, 5, 0, 0));

        linkField.setPreferredSize(new Dimension(400, 75));
        linkField.setText("text");
        linkField.setFont(new Font("Bank Gothic", Font.BOLD, 16));
        linkField.setBackground(new Color(168, 168, 168));
        linkField.setBorder(null);
        linkField.setBorder(new EmptyBorder(5, 5, 5, 5));

        layer.add(button);
        layer.add(textField);
        layer.add(linkField);
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
