package com.kodilla.rps;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGui {
    String playerDecision;
    public GameGui(){
        GameBoxWithGui.run();

        JFrame frame = new JFrame();
        JButton b1 = new JButton("ROCK");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerDecision = "1";
                System.out.println(playerDecision);
            }
        });
        JButton b2 = new JButton("PAPER");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerDecision = "2";
                System.out.println(playerDecision);
            }
        });
        JButton b3 = new JButton("SCISSORS");
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerDecision = "3";
                System.out.println(playerDecision);
            }
        });
        JButton b4 = new JButton("LIZARD");
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerDecision = "4";
                System.out.println(playerDecision);
            }
        });
        JButton b5 = new JButton("SPOCK");
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerDecision = "5";
                System.out.println(playerDecision);
            }
        });

        JButton bx = new JButton("FINISH");
        bx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerDecision = "x";
                System.out.println(playerDecision);
            }
        });
        JButton bn = new JButton("RESTART");
        bn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerDecision = "n";
                System.out.println(playerDecision);
            }
        });

        b1.setBounds(30,100,100, 40);
        b2.setBounds(30,150,100, 40);
        b3.setBounds(30,200,100, 40);
        b4.setBounds(30,250,100, 40);
        b5.setBounds(30,300,100, 40);

        bx.setBounds(200,100,100, 40);
        bn.setBounds(200,150,100, 40);

        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5);
        frame.add(bx);
        frame.add(bn);

        frame.setLayout(null);
        frame.setSize(400,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
