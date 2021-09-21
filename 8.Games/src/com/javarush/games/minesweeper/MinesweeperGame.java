package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private static final String MINE = "\uD83D\uDCA3";

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
            }
        }
        countMineNeighbors();
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }

    private void countMineNeighbors() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                GameObject gameObject = gameField[y][x];
                if (!gameObject.isMine) {
                    for (GameObject neighbor : getNeighbors(gameObject)) {
                        if (neighbor.isMine) {
                            gameObject.countMineNeighbors++;
                        }
                    }
                }
            }
        }
//        Validator don't accept lambda :(
//        for (int y = 0; y < gameField.length; y++) {
//            for (int x = 0; x < gameField[y].length; x++) {
//                if (!gameField[y][x].isMine) {
//                    getNeighbors(gameField[y][x]).forEach(gameObject -> {if (gameObject.isMine) gameObject.countMineNeighbors++;});
//                }
//            }
//        }
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        openTile(x, y);
    }

    private void openTile(int x, int y) {
        GameObject gameObject = gameField[y][x];
        if (gameObject.isMine) {
            setCellValue(x, y, MINE);
            setCellColor(x, y, Color.RED);
        } else {
            setCellNumber(x, y, gameObject.countMineNeighbors);
            setCellColor(x, y, Color.GREEN);
        }
        gameObject.isOpen = true;
    }
}