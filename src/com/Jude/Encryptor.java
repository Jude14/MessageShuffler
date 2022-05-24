package com.Jude;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Encryptor extends JPanel {
    private JButton encrypt, decrypt;
    private JLabel outputLabel;
    private JPanel controlPanel;
    private JTextField textBox;

    public Encryptor() {

        Font font = new Font("Helvetica", Font.BOLD, 20);
        encrypt = new JButton("Encrypt");
        decrypt = new JButton("Decrypt");
        outputLabel = new JLabel("Please enter text below");
        EventHandler handler = new EventHandler();


        encrypt.setFont(font);
        encrypt.addActionListener(handler);
        decrypt.setFont(font);
        decrypt.addActionListener(handler);

        outputLabel.setFont(font);

        controlPanel = new JPanel();
        controlPanel.setBackground(Color.GRAY);
        controlPanel.setPreferredSize(new Dimension(400, 200));

        controlPanel.add(encrypt);
        controlPanel.add(decrypt);

        add(outputLabel);
///
        textBox = new JTextField();
        textBox.setBackground(Color.WHITE);
        textBox.setColumns(20);
        add(textBox);

        add(controlPanel);

        setPreferredSize(new Dimension(400, 200));
        setBackground(Color.GRAY);
    }

    private class EventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String str = textBox.getText();
            if(e.getSource() == encrypt) {
                String toReturn = encrypt(str);
                outputLabel.setText("Encrypted message: ");
                textBox.setText(toReturn);
            } else {
                String toReturn = decrypt(str);
                outputLabel.setText("Decrypted message: ");
                textBox.setText(toReturn);
            }
        }
    }

    public static String encrypt(String str){
        String output = "e";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)<=122 && str.charAt(i)>=97){
                int key=4;//str.charAt(0)
                int temp1 = str.charAt(i)-96; ///// 1-26
                int temp2 = (temp1 + key)%26;//key  //4-29
                output+=((char)(temp2+97));
            }
            else output+=str.charAt(i);
        }
        return output;
    }
    public static String decrypt(String str){
        String output="";
        int key = str.charAt(0)-96;
        String newStr = str.substring(1); 
        for(int i =0;i<newStr.length();i++){
            if(newStr.charAt(i)<=122 && newStr.charAt(i)>=97){
                int temp1 = newStr.charAt(i)-96;
                int temp2 = (temp1 - key - 1);
                int temp3;

                if(temp2>=0) temp3 = temp2%26;
                else temp3 = (26+temp2);

                output+=((char)(temp3+97));
            }
            else output+=newStr.charAt(i);
        }
        return output;
    }
}
