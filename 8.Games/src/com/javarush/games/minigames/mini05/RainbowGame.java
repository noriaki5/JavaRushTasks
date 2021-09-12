package com.javarush.games.minigames.mini05;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Color;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Цвета радуги
*/

public class RainbowGame extends Game {

    @Override
    public void initialize() {
        List<Color> colorList = new ArrayList<>();
        Collections.addAll(colorList, Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.INDIGO, Color.VIOLET);
        //Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.INDIGO, Color.VIOLET};
        setScreenSize(10, 7);
        for (int i = 0; i < getScreenHeight(); i++) {
            for (int j = 0; j < getScreenWidth(); j++) {
                System.out.println(i+" "+j);
                setCellColor(j,i, colorList.get(i));
            }
        }
    }
}
