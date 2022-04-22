package com.mygdx.game.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.PuzzleGame;

public class WinScreen implements Screen {

    PuzzleGame game;

    private static double WIN_DIVIDER = 6;
    private static int WIN_WIDTH = (int) Math.round(2559 / WIN_DIVIDER);
    private static int WIN_HEIGHT = (int) Math.round(853 / WIN_DIVIDER);
    private static int WIN_X = PuzzleGame.WIDTH / 2 - WIN_WIDTH / 2;
    private static int WIN_Y = PuzzleGame.HEIGHT / 2 - WIN_HEIGHT / 2;

    private static double YEA_DIVIDER = 10;
    private static int YEA_WIDTH = (int) Math.round(2559 / YEA_DIVIDER);
    private static int YEA_HEIGHT = (int) Math.round(853 / YEA_DIVIDER);
    private static int YEA_X = PuzzleGame.WIDTH / 2 - YEA_WIDTH / 2;
    private static int YEA_Y = PuzzleGame.HEIGHT / 2 - YEA_HEIGHT / 2 - 100;

    private static Texture win;
    private static Texture yea;

    public WinScreen (PuzzleGame game){
        this.game = game;
    }

    @Override
    public void show() {
        win = new Texture("you_win.png");
        yea = new Texture("yea.png");
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear((float) 0.149019608, (float) 0.831372549, (float) 0.760784314, 1);
        game.batch.begin();
        game.batch.draw(win, WIN_X, WIN_Y, WIN_WIDTH, WIN_HEIGHT);
        game.batch.draw(yea, YEA_X, YEA_Y, YEA_WIDTH, YEA_HEIGHT);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
