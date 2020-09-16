package Homework08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homework08 {

    public static class Window extends JFrame {

        public Window() {
            setTitle("Проверка");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setBounds(700,250,600,900);
            JTextField field = new JTextField();
            add(field);
            

            field.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Было написано " + field.getText());
                    field.setText(null);
                 }
            });
            setVisible(true);
            JButton[] jbs = new JButton[5];
            setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
            for (int i = 0; i < 5; i++) {


                jbs[i] = new JButton("Вариант " + i);
                jbs[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println(((JButton)e.getSource()).getText() + " выбран");
                    }
                });
                jbs[i].setAlignmentX(CENTER_ALIGNMENT);
                add(jbs[i]);

            }
            setVisible(true);

            



        }


    }

    public static class MainClass {
        public static void main(String[] args) {

            Window window = new Window();
        }
    }
}
