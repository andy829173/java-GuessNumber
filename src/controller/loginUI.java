package controller;

import dao.login.implLogin;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class loginUI extends JFrame {
    private Container container = new Container();
    private JLabel lb1 = new JLabel("帳號：");
    private JLabel lb2 = new JLabel("密碼：");
    private JTextField inputUsername = new JTextField();
    private JTextField inputPassword = new JTextField();
    private JButton cancelBtn = new JButton("取消");
    private JButton loginBtn = new JButton("驗證");
    private ArrayList arrAnswer;

    loginUI(ArrayList arrAnswer) {
        init();
        this.arrAnswer = arrAnswer;
    }

    public void init() {

        // set
        this.setTitle("作弊啊～！！～～！！！！");
        this.setBounds(500, 300, 300, 180);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        container = this.getContentPane();
        container.setLayout(null);

        // setBounds
        lb1.setBounds(30, 30, 80, 30);
        lb2.setBounds(30, 60, 80, 30);
        inputUsername.setBounds(80, 30, 200, 30);
        inputPassword.setBounds(80, 60, 200, 30);
        cancelBtn.setBounds(100, 100, 80, 30);
        loginBtn.setBounds(180, 100, 80, 30);

        // add
        container.add(lb1);
        container.add(lb2);
        container.add(inputUsername);
        container.add(inputPassword);
        container.add(cancelBtn);
        container.add(loginBtn);
        // setFont

        // listener
        cancelBtn.addActionListener(e -> {
            this.dispose();
        });

        loginBtn.addActionListener(e -> {
            String username = inputUsername.getText();
            String password = inputPassword.getText();
            System.out.println();
            JFrame jFrame = new JFrame();
            boolean loginSuccess = new implLogin().query(username, password);
            if (loginSuccess) {
                JOptionPane.showMessageDialog(jFrame, arrAnswer);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(jFrame, "驗證失敗");
            }
        });
    }
}
