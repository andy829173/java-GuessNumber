package controller;

import dao.implNumber;
import model.Record;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class guessNumberUI extends JFrame {
    long startTime = System.nanoTime();
    private Integer count = 0;
    private String msg = "[已出題]\n計算結果： ";
    private Container container = new Container();
    private JTextArea output_ta = new JTextArea(msg);
    private JTextField input_n1 = new JTextField(10);
    private JTextField input_n2 = new JTextField(10);
    private JTextField input_n3 = new JTextField(10);
    private JTextField input_n4 = new JTextField(10);
    private JLabel hint = new JLabel();
    private JButton submitBtn = new JButton("提交");
    private JButton exitBtn = new JButton("離開");
    private JButton cheatBtn = new JButton("偷看答案");
    public ArrayList arrAnswer;


    public guessNumberUI() {
        this.arrAnswer = new implNumber().create();
        init();

    }

//    public static void main(String[] args) {
//        EventQueue.invokeLater(() -> new guessNumberUI().setVisible(true));
//    }

    public void init() {
        System.out.println(arrAnswer);

        // set
        this.setBounds(400, 200, 500, 500);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        container = this.getContentPane();// 取得ContenPane容器
        container.setLayout(null);// 不使用佈局,即用相對位置來自行排列UI
        output_ta.setEditable(false);

        // setBounds
        output_ta.setBounds(20, 20, 250, 430);
        input_n1.setBounds(280, 50, 50, 50);
        input_n2.setBounds(330, 50, 50, 50);
        input_n3.setBounds(380, 50, 50, 50);
        input_n4.setBounds(430, 50, 50, 50);
        hint.setBounds(300, 20, 200, 30);
        submitBtn.setBounds(380, 110, 80, 30);
        cheatBtn.setBounds(300, 400, 80, 30);
        exitBtn.setBounds(380, 400, 80, 30);


        // setFont
        input_n1.setFont(new Font("Courier", Font.BOLD, 50));
        input_n2.setFont(new Font("Courier", Font.BOLD, 50));
        input_n3.setFont(new Font("Courier", Font.BOLD, 50));
        input_n4.setFont(new Font("Courier", Font.BOLD, 50));

        // add
        container.add(output_ta);
        container.add(input_n1);
        container.add(input_n2);
        container.add(input_n3);
        container.add(input_n4);
        container.add(hint);
        container.add(submitBtn);
        container.add(cheatBtn);
        container.add(exitBtn);

        // listener
        submitBtn.addActionListener(e -> {
            count += 1;
            Integer n1 = Integer.parseInt(input_n1.getText());
            Integer n2 = Integer.parseInt(input_n2.getText());
            Integer n3 = Integer.parseInt(input_n3.getText());
            Integer n4 = Integer.parseInt(input_n4.getText());
            ArrayList<Integer> arrGuess = new ArrayList<>();
            arrGuess.add(n1);
            arrGuess.add(n2);
            arrGuess.add(n3);
            arrGuess.add(n4);

            input_n1.setText("");
            input_n2.setText("");
            input_n3.setText("");
            input_n4.setText("");

            // submit
            if (new implNumber().checkNumber(arrGuess)) {
                msg = msg + "\n[" + n1 + "," + n2 + "," + n3 + "," + n4 + "] = " + "\t數字重複";
                output_ta.setText(msg);

            } else {
                ArrayList<Integer> x = new implNumber().compare(arrAnswer, arrGuess);
                msg = msg + "\n[" + n1 + "," + n2 + "," + n3 + "," + n4 + "] => \tA: " + x.get(0) + " B: " + x.get(1);
                output_ta.setText(msg);
                if (x.get(0) == 4) {
                    // time
                    long engTime = System.nanoTime();
                    long elapsedTime = engTime - startTime;
                    long convertTime = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);

                    // name
                    String name = JOptionPane.showInputDialog(container, "恭喜答對！總共猜" +
                            count + "次，花費" +
                            convertTime + "秒，\n請輸入姓名", null);

                    // answer
                    String answer = "";
                    for (int i = 0; i < arrAnswer.size(); i++) {
                        answer = answer + arrAnswer.get(i);
                    }

                    // msg
                    msg = msg + "\n恭喜答對！！ 總共猜" + count + "次";
                    output_ta.setText(msg);

                    // Record
                    Record record = new Record(name, answer, count, convertTime);
                    new implNumber().upgrade(record);
                    this.dispose();
                    new indexNubmerUI().setVisible(true);
                    System.out.println(convertTime + "seconds");
                }
            }
        });
        exitBtn.addActionListener(e -> {
            System.exit(1);
        });
        cheatBtn.addActionListener(e -> {
            new loginUI(arrAnswer).setVisible(true);

        });
    }
}
