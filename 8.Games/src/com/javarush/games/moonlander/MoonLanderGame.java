package com.javarush.games.moonlander;

import com.javarush.engine.cell.*;

public class MoonLanderGame extends Game {
    public final static int WIDTH = 64;
    public final static int HEIGHT = 64;
    private Rocket rocket;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame() {
        rocket = new Rocket(WIDTH / 2, 0);
        drawScene();
    }

    private void drawScene() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                setCellColor(i, j, Color.BLACK);
            }
        }
        rocket.draw(this);
    }
}
