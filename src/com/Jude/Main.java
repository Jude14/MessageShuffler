package com.Jude;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Encrypt or Decrypt Message");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Encryptor panel = new Encryptor();
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
