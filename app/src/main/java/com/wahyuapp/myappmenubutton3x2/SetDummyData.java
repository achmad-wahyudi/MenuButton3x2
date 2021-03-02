package com.wahyuapp.myappmenubutton3x2;

import com.wahyuapp.myappmenubutton3x2.model.DataMenuMain;

import java.util.ArrayList;

public class SetDummyData {

    public static ArrayList<DataMenuMain> SetDataMenuMain(int limitMenu) {
        ArrayList<DataMenuMain> dataMenuMainList = new ArrayList<>();

        if (limitMenu == 0) {
            dataMenuMainList.addAll(SetDataMenuMainAll());
        } else {
            int number = 1;
            for (DataMenuMain dataMenuMain : SetDataMenuMainAll()) {
                if (number < limitMenu) {
                    dataMenuMainList.add(dataMenuMain);
                } else {
                    break;
                }
                number++;
            }

            if (SetDataMenuMainAll().size() >= limitMenu) {
                dataMenuMainList.add(new DataMenuMain("99", "More", "1"));
            }
        }

        return dataMenuMainList;
    }

    private static ArrayList<DataMenuMain> SetDataMenuMainAll() {
        ArrayList<DataMenuMain> dataMenuMainList = new ArrayList<>();

        dataMenuMainList.add(new DataMenuMain("1", "Radio Presenter", "1"));
        dataMenuMainList.add(new DataMenuMain("2", "Customer Service", "1"));
        dataMenuMainList.add(new DataMenuMain("3", "Coach", "1"));
        dataMenuMainList.add(new DataMenuMain("4", "IT Support", "1"));
        dataMenuMainList.add(new DataMenuMain("5", "Firefighter", "1"));
        dataMenuMainList.add(new DataMenuMain("6", "Pilot", "1"));
        dataMenuMainList.add(new DataMenuMain("7", "Police", "1"));
        dataMenuMainList.add(new DataMenuMain("8", "Designer", "1"));
        dataMenuMainList.add(new DataMenuMain("9", "Eating Salad", "1"));
        dataMenuMainList.add(new DataMenuMain("10", "Eating IceCream", "1"));
        dataMenuMainList.add(new DataMenuMain("11", "Surfing", "1"));
        dataMenuMainList.add(new DataMenuMain("12", "Fornite", "1"));

        return dataMenuMainList;
    }

}