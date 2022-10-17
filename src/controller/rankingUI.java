package controller;

import javax.swing.*;
import java.awt.*;

public class rankingUI extends JFrame {
    private Container container = new Container();
    private JTextArea jTextArea = new JTextArea();
    private JScrollPane jScrollPane = new JScrollPane(jTextArea);

    rankingUI() {
        initComponent();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new rankingUI().setVisible(true));
    }

    public void initComponent() {

        // set
        this.setBounds(800, 160, 250, 700);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("排行榜");
        container = this.getContentPane();
        container.setLayout(null);
        jTextArea.setEditable(false);

        // setBounds
        jTextArea.setBounds(0, 0, 250, 700);

        // add
        container.add(jTextArea);
    }
}
