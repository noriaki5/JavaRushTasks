package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame() {
        createNewNumber();
        createNewNumber();
    }

    private void drawScene() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                setCellColoredNumber(i, j, gameField[j][i]);
            }
        }
    }

    private void createNewNumber() {
        int x,y;
        do {
            x = getRandomNumber(SIDE);
            y = getRandomNumber(SIDE);
        } while (gameField[x][y] != 0);

        int newNumber = getRandomNumber(10);
        if (newNumber == 9) {
            gameField[x][y] = 4;
        } else {
            gameField[x][y] = 2;
        }
    }

    private Color getColorByValue(int value) {
        if (value == 2) {
            return Color.PINK;
        } else if (value == 4) {
            return Color.PURPLE;
        } else if (value == 8) {
            return Color.BLUE;
        } else if (value == 16) {
            return Color.CYAN;
        } else if (value == 32) {
            return Color.DARKGREEN;
        } else if (value == 64) {
            return Color.GREEN;
        } else if (value == 128) {
            return Color.ORANGE;
        } else if (value == 256) {
            return Color.PEACHPUFF;
        } else if (value == 512) {
            return Color.ORANGERED;
        } else if (value == 1024) {
            return Color.DEEPPINK;
        } else if (value == 2048) {
            return Color.HOTPINK;
        }
        return Color.WHITE;
    }

    private void setCellColoredNumber(int x, int y, int value) {
        if (value == 0) {
            setCellValueEx(x, y, getColorByValue(value), "");
        } else {
            setCellValueEx(x, y, getColorByValue(value), String.valueOf(value));
        }

    }

    private boolean compressRow(int[] row) {
        int insertPosition = 0;
        boolean result = false;
        for (int i = 0; i < row.length; i++) {
            if (row[i] > 0) {
                if (i != insertPosition) {
                    row[insertPosition] = row[i];
                    row[i] = 0;
                    result = true;
                }
                insertPosition++;
            }
        }
        return result;
    }

    private boolean mergeRow(int[] row) {
        boolean result = false;
        for (int i = 0; i < row.length - 1; i++) {
            if (row[i] == row[i + 1] && row[i] != 0) {
                row[i] = row[i] * 2;
                row[i + 1] = 0;
                result = true;
                i++;
            }
        }
        return result;
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.LEFT) {
            moveLeft();
        } else if (key == Key.UP) {
            moveUp();
        } else if (key == Key.RIGHT) {
            moveRight();
        } else if (key == Key.DOWN) {
            moveDown();
        }
    }

    private void moveLeft() {

    }

    private void moveUp() {

    }

    private void moveRight() {

    }

    private void moveDown() {

    }
}
