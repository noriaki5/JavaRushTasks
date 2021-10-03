package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<GameObject> snakeParts = new ArrayList<>();
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    public boolean isAlive = true;
    private Direction direction = Direction.LEFT;

    public Snake(int x, int y) {

        for (int i = 0; i < 3; i++) {
            snakeParts.add(new GameObject(x+i, y));
        }
    }

    public void draw(Game game) {
        Color snakeColor = isAlive ? Color.GREEN : Color.RED;
        for (int i = 0; i < snakeParts.size(); i++) {
            game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, (i == 0) ? HEAD_SIGN : BODY_SIGN, snakeColor, 75);
        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void move() {
        GameObject newHead = createNewHead();
        if (newHead.x < 0 || newHead.x >= SnakeGame.WIDTH || newHead.y < 0 || newHead.y >= SnakeGame.HEIGHT) {
            isAlive = false;
            return;
        } else {
            snakeParts.add(0, newHead);
        }
        removeTail();
    }

    public GameObject createNewHead() {
        GameObject snakeHead = snakeParts.get(0);
        GameObject newSnakeHead = null;
        switch (direction) {
            case UP :
                newSnakeHead = new GameObject(snakeHead.x, snakeHead.y - 1);
                break;
            case RIGHT :
                newSnakeHead = new GameObject(snakeHead.x + 1, snakeHead.y);
                break;
            case DOWN :
                newSnakeHead = new GameObject(snakeHead.x, snakeHead.y + 1);
                break;
            case LEFT :
                newSnakeHead = new GameObject(snakeHead.x - 1, snakeHead.y);
                break;
        }
        return newSnakeHead;
    }

    public void removeTail() {
        snakeParts.remove(snakeParts.size() - 1);
    }
}
