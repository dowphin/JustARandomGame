package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.PuzzleGame;

import java.util.ArrayList;

public class LevelNine implements Screen {

    PuzzleGame game;

    public static final double CENTER_DIVIDER = 1.4;
    public static final int CENTER_SIDE = (int) Math.round(600 / CENTER_DIVIDER);
    public static final int CENTER_X = PuzzleGame.WIDTH / 2 - CENTER_SIDE / 2;
    public static final int CENTER_Y = 0;
    public static Texture grid_a;
    public static Texture grid_b;
    public static Texture grid_c;
    public static Texture grid_1;
    public static Texture grid_2;
    public static Texture grid_3;
    public static final int DOOR_DIVIDER = 20;
    public static final int DOOR_WIDTH = (int) Math.round(761 / DOOR_DIVIDER);
    public static final int DOOR_HEIGHT = (int) Math.round(1694 / DOOR_DIVIDER);
    public static final int DOOR_X = PuzzleGame.WIDTH / 2 - DOOR_WIDTH / 2;
    public static final int DOOR_Y = 0;

    public static final double BUTTON_DIVIDER = 12;
    public static final int BUTTON_SIDE = (int) Math.round(1103 / BUTTON_DIVIDER);
    public static final int BUTTON_X = PuzzleGame.WIDTH / 2 - BUTTON_SIDE / 2;
    public static final int BUTTON_Y = PuzzleGame.HEIGHT / 2 - BUTTON_SIDE / 2;

    public static final double ARROW_DIVIDER = 10;
    public static final int ARROW_WIDTH = (int) Math.round(1018 / ARROW_DIVIDER);
    public static final int ARROW_HEIGHT = (int) Math.round(676 / ARROW_DIVIDER);
    public static final int ARROW_X = PuzzleGame.WIDTH / 2 - ARROW_WIDTH / 2;
    public static final int ARROW_Y = PuzzleGame.HEIGHT / 2 - ARROW_HEIGHT / 2 - 200;

    public static final double HINT_DIVIDER = 10;
    public static final int HINT_SIDE = (int) Math.round(515 / HINT_DIVIDER);
    public static final int HINT_X = 900;
    public static final int HINT_Y = 480;

    private static final double LINK_DIVIDER = 4;
    private static final int LINK_WIDTH = (int) Math.round(1556 / LINK_DIVIDER);
    private static final int LINK_HEIGHT = (int) Math.round(281 / LINK_DIVIDER);
    private static final int LINK_X = PuzzleGame.WIDTH / 2 - LINK_WIDTH / 2;
    private static final int LINK_Y = PuzzleGame.HEIGHT / 2 - LINK_HEIGHT / 2 + 125;

    public static float targetWidth = LevelOne.targetWidth;
    public static final float letterWidth = 100;
    public static float xTopLeft = LevelOne.xTopLeft;
    public static float yTopLeft = LevelOne.yTopLeft;

    // Variables needed for the timer
    public static long START_TIME = TimeUtils.millis();
    public static int total_seconds = 0;
    public static int total_minutes = 0;
    public static int total_hours = 0;
    public static String seconds;
    public static String minutes;
    public static String hours;
    public static String total_time;

    // hints
    private static ArrayList<String> hints = new ArrayList<String>();
    private static String the_hint = "";
    private static int hint_getter = -1;

    // Declares every texture used

    public static Texture title;
    public static Texture cog_inactive;
    public static Texture cog_active;
    public static Texture center;
    public static Texture door;
    public static Texture back_inactive;
    public static Texture back_active;
    public static Texture forward_inactive;
    public static Texture forward_active;

    private static Texture button_active;
    private static Texture button_inactive;

//	Texture paused;

    public static Texture hint_inactive;
    public static Texture hint_active;

    public LevelNine (PuzzleGame game){
        this.game = game;
    }

    @Override
    public void show() {
        title = new Texture ("level_nine.png");
        cog_inactive = new Texture ("cog_inactive.png");
        cog_active = new Texture ("cog_active.png");
        center = new Texture("level_center_red.png");
        door = new Texture("door.png");
        back_inactive = new Texture("back_button_inactive.png");
        back_active = new Texture("back_button_active.png");
        forward_inactive = new Texture("forward_button_inactive.png");
        forward_active = new Texture("forward_button_active.png");
        button_active = new Texture("button_active.png");
        button_inactive = new Texture("button_inactive.png");
        hints.add("The answer isn't what it seems");
        hints.add("Trust me, it's the last thing that'll happen");
        hints.add("Win to lose, lose to win, win to win, lose to lose");
        grid_1 = new Texture("grid_1.png");
        grid_2 = new Texture("grid_2.png");
        grid_3 = new Texture("grid_3.png");
        grid_a = new Texture("grid_a.png");
        grid_b = new Texture("grid_b.png");
        grid_c = new Texture("grid_c.png");
    }

    @Override
    public void render(float delta) {
        game.font.getData().setScale(2, 2);
// variables for timer text


        ScreenUtils.clear((float) 0.149019608, (float) 0.831372549, (float) 0.760784314, 1);
        game.batch.begin();
        game.batch.draw(title, MainMenuScreen.TITLE_X, MainMenuScreen.TITLE_Y, MainMenuScreen.TITLE_WIDTH, MainMenuScreen.TITLE_HEIGHT);
        game.batch.draw(center, CENTER_X, CENTER_Y, CENTER_SIDE, CENTER_SIDE);
        game.batch.draw(door, DOOR_X, DOOR_Y, DOOR_WIDTH, DOOR_HEIGHT);

        if (game.LevelNineBeaten) {
            if (
                    Gdx.input.getX() < ARROW_X + 375 + ARROW_WIDTH &&
                            Gdx.input.getX() > ARROW_X + 375 &&
                            PuzzleGame.HEIGHT - Gdx.input.getY() < ARROW_Y + ARROW_HEIGHT &&
                            PuzzleGame.HEIGHT - Gdx.input.getY() > ARROW_Y

            ) {

                game.batch.draw(forward_active, ARROW_X + 375, ARROW_Y, ARROW_WIDTH, ARROW_HEIGHT);
                if (Gdx.input.justTouched()) {
                    game.setScreen(new LevelTen(game));
                }
            } else {

                game.batch.draw(forward_inactive, ARROW_X + 375, ARROW_Y, ARROW_WIDTH, ARROW_HEIGHT);

            }
        }

        if (
                Gdx.input.getX() < LevelOne.ARROW_X - 375 + LevelOne.ARROW_WIDTH &&
                        Gdx.input.getX() > LevelOne.ARROW_X - 375 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < LevelOne.ARROW_Y + LevelOne.ARROW_HEIGHT &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > LevelOne.ARROW_Y

        ) {

            game.batch.draw(LevelOne.back_active, LevelOne.ARROW_X - 375, LevelOne.ARROW_Y, LevelOne.ARROW_WIDTH, LevelOne.ARROW_HEIGHT);
            if (Gdx.input.justTouched()) {
                game.setScreen(new LevelEight(game));
                if (game.showYTLink) {
                    game.showLvL8Buttons = true;
                }
            }

        } else {

            game.batch.draw(LevelOne.back_inactive, LevelOne.ARROW_X - 375, LevelOne.ARROW_Y, LevelOne.ARROW_WIDTH, LevelOne.ARROW_HEIGHT);

        }


        if (
                Gdx.input.getX() < LevelOne.HINT_X + LevelOne.HINT_SIDE &&
                        Gdx.input.getX() > LevelOne.HINT_X &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < LevelOne.HINT_Y + LevelOne.HINT_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > LevelOne.HINT_Y && hint_getter < 2
        ) {
            game.batch.draw(LevelOne.hint_active, LevelOne.HINT_X, LevelOne.HINT_Y, LevelOne.HINT_SIDE, LevelOne.HINT_SIDE);
            if (Gdx.input.justTouched()){
                if (hint_getter < 2){
                    hint_getter += 1;
                }
                the_hint = hints.get(hint_getter);
                game.LevelNineBeaten = true;
            }
        } else if (hint_getter < 2){
            game.batch.draw(LevelOne.hint_inactive, LevelOne.HINT_X, LevelOne.HINT_Y, LevelOne.HINT_SIDE, LevelOne.HINT_SIDE);
        }
        game.font.setColor(Color.BLACK);
        game.layout.setText(game.font, the_hint, game.font.getColor(), targetWidth, Align.center, false);
        game.font.draw(game.batch, the_hint, PuzzleGame.WIDTH / 2, 535, targetWidth, Align.center, false);
        if (
                Gdx.input.getX() < LevelTwo.BUTTON_X + 100 + LevelTwo.BUTTON_SIDE &&
                        Gdx.input.getX() > LevelTwo.BUTTON_X + 100 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < LevelTwo.BUTTON_Y + LevelTwo.BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > LevelTwo.BUTTON_Y

        ) {

            game.batch.draw(LevelTwo.button_active, LevelTwo.BUTTON_X + 100, LevelTwo.BUTTON_Y, LevelTwo.BUTTON_SIDE, LevelTwo.BUTTON_SIDE);
            if (Gdx.input.justTouched()) {

            }

        } else {

            game.batch.draw(LevelTwo.button_inactive, LevelTwo.BUTTON_X + 100, LevelTwo.BUTTON_Y, LevelTwo.BUTTON_SIDE, LevelTwo.BUTTON_SIDE);

        }

// left button

        if (
                Gdx.input.getX() < LevelTwo.BUTTON_X - 100 + LevelTwo.BUTTON_SIDE &&
                        Gdx.input.getX() > LevelTwo.BUTTON_X - 100 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < LevelTwo.BUTTON_Y + LevelTwo.BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > LevelTwo.BUTTON_Y

        ) {

            game.batch.draw(LevelTwo.button_active, LevelTwo.BUTTON_X - 100, LevelTwo.BUTTON_Y, LevelTwo.BUTTON_SIDE, LevelTwo.BUTTON_SIDE);

            if (Gdx.input.justTouched()) {

            }


        } else {

            game.batch.draw(LevelTwo.button_inactive, LevelTwo.BUTTON_X - 100, LevelTwo.BUTTON_Y, LevelTwo.BUTTON_SIDE, LevelTwo.BUTTON_SIDE);

        }
        if (game.LevelNineBeaten) {
            game.batch.draw(grid_a, 0, 480, LevelTen.GRID_SIDE, LevelTen.GRID_SIDE);
            game.batch.draw(grid_1, 900, 0, LevelTen.GRID_SIDE, LevelTen.GRID_SIDE);
        }
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
