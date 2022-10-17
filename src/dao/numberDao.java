package dao;

import model.Record;

import java.util.ArrayList;
import java.util.List;

public interface numberDao {

    public ArrayList create();

    public boolean checkNumber(ArrayList arrGuess);

    public ArrayList compare(ArrayList arrAnswer, ArrayList arrGuess);

    public void upgrade(Record r);

    public void read();
}
