package controller;

import dao.implNumber;
import model.Record;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class indexNubmerUI extends JFrame {
    private String rule;
    private String msg;
    private Container container;
    private JTextArea TA1 = new JTextArea();
    private JButton startBtn = new JButton("遊戲開始");
    private JButton submitBtn = new JButton("提交");

    public indexNubmerUI() {
        init();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new indexNubmerUI().setVisible(true));
    }

    public void init() {
        this.msg = "";
        this.setTitle("又是猜數字啦！！");
        this.rule = "規則：\n" +
                " 猜一組0~9不重複之4位數字\n" +
                " →數字對、位置對為1A\n" +
                " →數字對、位置不對則為1B\n\n\n" +
                "舉例：\n" +
                " 若題目為1234，猜0123則為[3B]\n" +
                " 若猜1248，則為[2A1B]，\n" +
                " 以此類推";

        // set
        this.setBounds(150, 150, 400, 370);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        container = this.getContentPane();// 取得ContentPane容器
        container.setLayout(null);
        TA1.setText(rule);
        TA1.setEditable(false);

        // setBounds
        TA1.setBounds(50, 50, 300, 200);
        startBtn.setBounds(150, 260, 100, 30);
        submitBtn.setBounds(500, 130, 100, 30);

        // add
        container.add(TA1);
        container.add(startBtn);
        container.add(submitBtn);

        // listener
        startBtn.addActionListener(e -> {
            this.dispose();
            new guessNumberUI().setVisible(true);
        });
    }
}
