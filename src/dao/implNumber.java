package dao;

import model.Record;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static model.Global.r;

public class implNumber implements numberDao {
//    public static void main(String[] args) {
//    }

    public implNumber() {
    }

    @Override
    public ArrayList create() {
        ArrayList<Integer> list = new ArrayList<>();
        while (list.size() < 4) {
            Integer number = r.nextInt(10);
            if (list.indexOf(number) != -1) {
                continue;
            } else {
                list.add(number);
            }
        }
        return list;
    }

    @Override
    public boolean checkNumber(ArrayList arrGuess) {
        int a = 0;
        int b = 0;
        boolean duplicates = false;
        for (int i = 0; i < arrGuess.size(); i++) {
            for (int j = 0; j < arrGuess.size(); j++) {
                if (i == j) {
                    continue;
                } else {
                    if (arrGuess.get(i) == arrGuess.get(j)) {
                        duplicates = true;
                    }
                }
            }
        }
        return duplicates;
    }

    @Override
    public ArrayList compare(ArrayList arrAnswer, ArrayList arrGuess) {
        int a = 0;
        int b = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arrGuess.size(); i++) {
            int index = arrAnswer.indexOf(arrGuess.get(i));
            if (index != -1) {
                if (index == i) {
                    a += 1;
                } else {
                    b += 1;
                }
            }
        }
        list.add(a);
        list.add(b);
        return list;
    }

    @Override
    public void upgrade(Record r) {
        Connection connect = DBConnect.getDB();
        String query = "INSERT INTO record(name,answer,count,time) VALUES(?,?,?,?)";

        try {
            PreparedStatement ps = connect.prepareStatement(query);
            ps.setString(1, r.getName());
            ps.setString(2, r.getAnswer());
            ps.setInt(3, r.getCount());
            ps.setLong(4, r.getTime());

            ps.executeUpdate();
            System.out.println("新增成功");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void read() {
        String ranking = "";
        Connection connect = DBConnect.getDB();
        String query = "SELECT * FROM record";

        try {
            PreparedStatement ps = connect.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

            }
            System.out.println(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

