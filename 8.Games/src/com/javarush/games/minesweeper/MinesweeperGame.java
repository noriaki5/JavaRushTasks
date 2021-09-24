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
    private static final String FLAG = "\uD83D\uDEA9";
    private int countFlags;
    private boolean isGameStopped;
    private int countClosedTiles = SIDE * SIDE;

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
        countFlags = countMinesOnField;
        isGameStopped = false;
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

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }

    private void openTile(int x, int y) {
        GameObject gameObject = gameField[y][x];
        if (gameObject.isOpen || gameObject.isFlag || isGameStopped) return;
        gameObject.isOpen = true;
        if (gameObject.isMine) {
            setCellValueEx(x, y, Color.RED, MINE);
            gameOver();
        } else {
            setCellColor(x, y, Color.GREEN);
            if (gameObject.countMineNeighbors == 0) {
                setCellValue(x, y, "");
                for (GameObject neighbor : getNeighbors(gameObject)) {
                    openTile(neighbor.x, neighbor.y);
                }
            } else {
                setCellNumber(x, y, gameObject.countMineNeighbors);
            }
            countClosedTiles--;
            if (countClosedTiles == countMinesOnField) win();
        }
    }

    private void markTile(int x, int y) {
        if (isGameStopped) return;
        GameObject gameObject = gameField[y][x];
        if (gameObject.isOpen) return;
        if (countFlags == 0 && !gameObject.isFlag) return;
        if (gameObject.isFlag) {
            countFlags++;
            gameObject.isFlag = false;
            setCellColor(x, y, Color.ORANGE);
            setCellValue(x, y, "");
        } else {
            countFlags--;
            gameObject.isFlag = true;
            setCellColor(x, y, Color.RED);
            setCellValue(x, y, FLAG);
        }
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.AQUAMARINE, "Game over!", Color.BLACK, 40);
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.GOLD, "You win!", Color.BLACK, 40);
    }
}