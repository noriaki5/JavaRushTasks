package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];
    private boolean isGameStopped = false;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                gameField[i][j] = 0;
            }
        }
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
        if (getMaxTileValue() == 2048) {
            win();
            return;
        }
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
        if (isGameStopped) {
            if (key == Key.SPACE) {
                isGameStopped = false;
                createGame();
                drawScene();
            }
            return;
        }
        if (!canUserMove()) {
            gameOver();
            return;
        }
        if (key == Key.LEFT) {
            moveLeft();
            drawScene();
        } else if (key == Key.UP) {
            moveUp();
            drawScene();
        } else if (key == Key.RIGHT) {
            moveRight();
            drawScene();
        } else if (key == Key.DOWN) {
            moveDown();
            drawScene();
        }
    }

    private void moveLeft() {
        boolean moveDone = false;
        for (int i = 0; i < SIDE; i++) {
            moveDone = moveDone | compressRow(gameField[i]);
            moveDone = moveDone | mergeRow(gameField[i]);
            moveDone = moveDone | compressRow(gameField[i]);
        }
        if (moveDone) {
            createNewNumber();
        }
    }

    private void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    private void moveRight() {
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void rotateClockwise() {
        int[][] matrix = new int[SIDE][SIDE];
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                matrix[j][SIDE - 1 - i] = gameField[i][j];
            }
        }
        gameField = matrix;
    }

    private int getMaxTileValue() {
        int max = 0;
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (max < gameField[i][j]) {
                    max = gameField[i][j];
                }
            }
        }
        return max;
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.GOLDENROD, "YOU WIN!", Color.AQUA, 75);
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.RED, "GAME OVER!", Color.BLACK, 75);
    }

    private boolean canUserMove() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (gameField[i][j] == 0) {
                    return true;
                } else if (i < SIDE -1 && gameField[i][j] == gameField[i + 1][j]) {
                    return true;
                } else if (j < SIDE -1 && gameField[i][j] == gameField[i][j + 1]) {
                    return true;
                }
            }
        }

        return false;
    }
}
