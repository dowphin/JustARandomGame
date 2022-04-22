package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.PuzzleGame;

import java.util.ArrayList;

public class LevelTen implements Screen {

    PuzzleGame game;

    public static final double CENTER_DIVIDER = 1.4;
    public static final int CENTER_SIDE = (int) Math.round(600 / CENTER_DIVIDER);
    public static final int CENTER_X = PuzzleGame.WIDTH / 2 - CENTER_SIDE / 2;
    public static final int CENTER_Y = 0;

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

    public static final double LINK_DIVIDER = 4;
    public static final int LINK_WIDTH = (int) Math.round(1556 / LINK_DIVIDER);
    public static final int LINK_HEIGHT = (int) Math.round(281 / LINK_DIVIDER);
    public static final int LINK_X = PuzzleGame.WIDTH / 2 - LINK_WIDTH / 2;
    public static final int LINK_Y = PuzzleGame.HEIGHT / 2 - LINK_HEIGHT / 2 + 125;

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
    public static ArrayList<String> hints = new ArrayList<String>();
    public static String the_hint = "";
    public static int hint_getter = -1;

    // Declares every texture used

    public static Texture title;
    public static Texture center;
    public static Texture door;
    public static Texture back_inactive;
    public static Texture back_active;
    public static Texture forward_inactive;
    public static Texture forward_active;

//	Texture paused;

    public static Texture hint_inactive;
    public static Texture hint_active;

    public static Texture grid_a;
    public static Texture grid_b;
    public static Texture grid_c;
    public static Texture grid_1;
    public static Texture grid_2;
    public static Texture grid_3;
    public static Texture square_white;
    public static Texture square_red;
    public static Texture square_yellow;
    public static Texture square_green;
    public static Texture square_blue;
    public static Texture square_purple;

    public static double SQUARE_DIVIDER = 12;
    public static int SQUARE_SIDE = (int) Math.round(600 / SQUARE_DIVIDER);
    public static int SQUARE_X = PuzzleGame.WIDTH / 2 - SQUARE_SIDE / 2;
    public static int SQUARE_Y = PuzzleGame.HEIGHT / 2 - SQUARE_SIDE / 2;
    public static int box1 = 0;
    public static int box2 = 0;
    public static int box3 = 0;
    public static int box4 = 0;
    public static int box5 = 0;
    public static int box6 = 0;
    public static int box7 = 0;
    public static int box8 = 0;
    public static int box9 = 0;

    public static double GRID_DIVIDER = 6;
    public static int GRID_SIDE = (int) Math.round(400 / GRID_DIVIDER);
    public static int GRID_X = PuzzleGame.WIDTH / 2 - GRID_SIDE / 2;
    public static int GRID_Y = PuzzleGame.HEIGHT / 2 - GRID_SIDE / 2;

    ArrayList<Texture> colors = new ArrayList<Texture>();

    public static String combination = "";
    private static String konami = "";
    private static String code = "uuddlrlrbae";

    public LevelTen (PuzzleGame game){
        this.game = game;
    }

    @Override
    public void show() {
        title = new Texture ("level_ten.png");
        center = new Texture("level_center_rainbow.png");
        door = new Texture("door.png");
        back_inactive = new Texture("back_button_inactive.png");
        back_active = new Texture("back_button_active.png");
        forward_inactive = new Texture("forward_button_inactive.png");
        forward_active = new Texture("forward_button_active.png");
        grid_1 = new Texture("grid_1.png");
        grid_2 = new Texture("grid_2.png");
        grid_3 = new Texture("grid_3.png");
        grid_a = new Texture("grid_a.png");
        grid_b = new Texture("grid_b.png");
        grid_c = new Texture("grid_c.png");
        square_white = new Texture("level_center_white.png");
        square_red = new Texture("level_center_red.png");
        square_yellow = new Texture("level_center_yellow.png");
        square_green = new Texture("level_center_green.png");
        square_blue = new Texture("level_center_blue.png");
        square_purple = new Texture("level_center_purple.png");
        hints.add("Coordinates.");
        hints.add("The previous levels have changed.");
        hints.add("What do the colors remind you of?");

        colors.add(square_white);
        colors.add(square_red);
        colors.add(square_yellow);
        colors.add(square_green);
        colors.add(square_blue);
        colors.add(square_purple);
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            konami += "u";
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
            konami += "d";
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            konami += "l";
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
            konami += "r";
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.B)){
            konami += "b";
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.A)){
            konami += "a";
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            konami += "e";
        }
        if (konami.equals(code)){
            game.setScreen(new WinScreen(game));
        }
        if (!code.contains(konami)){
            konami = "";
        }

        ScreenUtils.clear((float) 0.149019608, (float) 0.831372549, (float) 0.760784314, 1);
        game.batch.begin();
        game.batch.draw(title, MainMenuScreen.TITLE_X, MainMenuScreen.TITLE_Y, MainMenuScreen.TITLE_WIDTH, MainMenuScreen.TITLE_HEIGHT);
        game.batch.draw(center, CENTER_X, CENTER_Y, CENTER_SIDE, CENTER_SIDE);
        game.batch.draw(door, DOOR_X, DOOR_Y, DOOR_WIDTH, DOOR_HEIGHT);

        if (
                Gdx.input.getX() < LevelOne.ARROW_X - 375 + LevelOne.ARROW_WIDTH &&
                        Gdx.input.getX() > LevelOne.ARROW_X - 375 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < LevelOne.ARROW_Y + LevelOne.ARROW_HEIGHT &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > LevelOne.ARROW_Y

        ) {

            game.batch.draw(LevelOne.back_active, LevelOne.ARROW_X - 375, LevelOne.ARROW_Y, LevelOne.ARROW_WIDTH, LevelOne.ARROW_HEIGHT);
            if (Gdx.input.justTouched()) {
                game.setScreen(new LevelNine(game));
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
                        PuzzleGame.HEIGHT - Gdx.input.getY() > LevelOne.HINT_Y
        ) {
            game.batch.draw(LevelOne.hint_active, LevelOne.HINT_X, LevelOne.HINT_Y, LevelOne.HINT_SIDE, LevelOne.HINT_SIDE);
            if (Gdx.input.justTouched()) {
                if (hint_getter < 2) {
                    hint_getter += 1;
                }
                the_hint = hints.get(hint_getter);
            }
        } else {
            game.batch.draw(LevelOne.hint_inactive, LevelOne.HINT_X, LevelOne.HINT_Y, LevelOne.HINT_SIDE, LevelOne.HINT_SIDE);
        }
        game.font.setColor(Color.BLACK);
        game.layout.setText(game.font, the_hint, game.font.getColor(), targetWidth, Align.center, false);
        game.font.draw(game.batch, the_hint, PuzzleGame.WIDTH / 2, 530, targetWidth, Align.center, false);

        game.batch.draw(colors.get(box1), SQUARE_X - 100, SQUARE_Y + 100, (float) SQUARE_SIDE, (float) SQUARE_SIDE);
        if (
                Gdx.input.getX() < SQUARE_X - 100 + SQUARE_SIDE &&
                        Gdx.input.getX() > SQUARE_X - 100 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < SQUARE_Y + 100 + SQUARE_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > SQUARE_Y + 100
        ) {
            if (Gdx.input.justTouched()) {
                if (box1 < 5) {
                    box1 += 1;
                } else {
                    box1 = 0;
                }
            }
        }
        game.batch.draw(colors.get(box2), SQUARE_X, SQUARE_Y + 100, (float) SQUARE_SIDE, (float) SQUARE_SIDE);
        if (
                Gdx.input.getX() < SQUARE_X + SQUARE_SIDE &&
                        Gdx.input.getX() > SQUARE_X &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < SQUARE_Y + 100 + SQUARE_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > SQUARE_Y + 100
        ) {
            if (Gdx.input.justTouched()) {
                if (box2 < 5) {
                    box2 += 1;
                } else {
                    box2 = 0;
                }
            }
        }
        game.batch.draw(colors.get(box3), SQUARE_X + 100, SQUARE_Y + 100, (float) SQUARE_SIDE, (float) SQUARE_SIDE);
        if (
                Gdx.input.getX() < SQUARE_X + 100 + SQUARE_SIDE &&
                        Gdx.input.getX() > SQUARE_X + 100 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < SQUARE_Y + 100 + SQUARE_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > SQUARE_Y + 100
        ) {
            if (Gdx.input.justTouched()) {
                if (box3 < 5) {
                    box3 += 1;
                } else {
                    box3 = 0;
                }
            }
        }
        game.batch.draw(colors.get(box4), SQUARE_X - 100, SQUARE_Y, (float) SQUARE_SIDE, (float) SQUARE_SIDE);
        if (
                Gdx.input.getX() < SQUARE_X - 100 + SQUARE_SIDE &&
                        Gdx.input.getX() > SQUARE_X - 100 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < SQUARE_Y + SQUARE_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > SQUARE_Y
        ) {
            if (Gdx.input.justTouched()) {
                if (box4 < 5) {
                    box4 += 1;
                } else {
                    box4 = 0;
                }
            }
        }
        game.batch.draw(colors.get(box5), SQUARE_X, SQUARE_Y, (float) SQUARE_SIDE, (float) SQUARE_SIDE);
        if (
                Gdx.input.getX() < SQUARE_X + SQUARE_SIDE &&
                        Gdx.input.getX() > SQUARE_X &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < SQUARE_Y + SQUARE_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > SQUARE_Y
        ) {
            if (Gdx.input.justTouched()) {
                if (box5 < 5) {
                    box5 += 1;
                } else {
                    box5 = 0;
                }
            }
        }
        game.batch.draw(colors.get(box6), SQUARE_X + 100, SQUARE_Y, (float) SQUARE_SIDE, (float) SQUARE_SIDE);
            if (
                    Gdx.input.getX() < SQUARE_X + 100 + SQUARE_SIDE &&
                            Gdx.input.getX() > SQUARE_X + 100 &&
                            PuzzleGame.HEIGHT - Gdx.input.getY() < SQUARE_Y + SQUARE_SIDE &&
                            PuzzleGame.HEIGHT - Gdx.input.getY() > SQUARE_Y
            ) {
                if (Gdx.input.justTouched()) {
                    if (box6 < 5) {
                        box6 += 1;
                    } else {
                        box6 = 0;
                    }
                }
            }
        game.batch.draw(colors.get(box7), SQUARE_X - 100, SQUARE_Y - 100, (float) SQUARE_SIDE, (float) SQUARE_SIDE);
        if (
                Gdx.input.getX() < SQUARE_X - 100 + SQUARE_SIDE &&
                        Gdx.input.getX() > SQUARE_X - 100 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < SQUARE_Y - 100 + SQUARE_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > SQUARE_Y - 100
        ) {
            if (Gdx.input.justTouched()) {
                if (box7 < 5) {
                    box7 += 1;
                } else {
                    box7 = 0;
                }
            }
        }
        game.batch.draw(colors.get(box8), SQUARE_X, SQUARE_Y - 100, (float) SQUARE_SIDE, (float) SQUARE_SIDE);
        if (
                Gdx.input.getX() < SQUARE_X + SQUARE_SIDE &&
                        Gdx.input.getX() > SQUARE_X &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < SQUARE_Y - 100 + SQUARE_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > SQUARE_Y - 100
        ) {
            if (Gdx.input.justTouched()) {
                if (box8 < 5) {
                    box8 += 1;
                } else {
                    box8 = 0;
                }
            }
        }
        game.batch.draw(colors.get(box9), SQUARE_X + 100, SQUARE_Y - 100, (float) SQUARE_SIDE, (float) SQUARE_SIDE);
        if (
                Gdx.input.getX() < SQUARE_X + 100 + SQUARE_SIDE &&
                        Gdx.input.getX() > SQUARE_X + 100 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < SQUARE_Y - 100 + SQUARE_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > SQUARE_Y - 100
        ) {
            if (Gdx.input.justTouched()) {
                if (box9 < 5) {
                    box9 += 1;
                } else {
                    box9 = 0;
                }
            }
        }

        combination = Integer.toString(box1) + Integer.toString(box2) + Integer.toString(box3) + Integer.toString(box4) + Integer.toString(box5) + Integer.toString(box6) + Integer.toString(box7) + Integer.toString(box8) + Integer.toString(box9);
        if (combination.equals("155234143")){
            game.setScreen(new WinScreen(game));
        }
        game.batch.draw(grid_1, GRID_X - 100, GRID_Y + 150, GRID_SIDE, GRID_SIDE);
        game.batch.draw(grid_2, GRID_X, GRID_Y + 150, GRID_SIDE, GRID_SIDE);
        game.batch.draw(grid_3, GRID_X + 100, GRID_Y + 150, GRID_SIDE, GRID_SIDE);
        game.batch.draw(grid_a, GRID_X - 150, GRID_Y + 100, GRID_SIDE, GRID_SIDE);
        game.batch.draw(grid_b, GRID_X - 150, GRID_Y, GRID_SIDE, GRID_SIDE);
        game.batch.draw(grid_c, GRID_X - 150, GRID_Y - 100, GRID_SIDE, GRID_SIDE);

        if (
                Gdx.input.getX() < LevelOne.X_X + LevelOne.X_SIDE &&
                        Gdx.input.getX() > LevelOne.X_X &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < LevelOne.X_Y + LevelOne.X_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > LevelOne.X_Y
        ){
            game.batch.draw(LevelOne.x_button_active, LevelOne.X_X, LevelOne.X_Y, LevelOne.X_SIDE, LevelOne.X_SIDE);
            if (Gdx.input.justTouched()){
                game.setScreen(new MainMenuScreen(game));
                game.LevelOneBeaten = false;
                game.LevelTwoBeaten = false;
                game.LevelThreeBeaten = false;
                game.LevelFourBeaten = false;
                game.LevelFiveBeaten = false;
                game.LevelSixBeaten = false;
                game.LevelSevenBeaten = false;
                game.LevelEightBeaten = false;
                game.LevelNineBeaten = false;
                game.showYTLink = false;
                game.showLvL8Buttons = false;
            }

        } else{
            game.batch.draw(LevelOne.x_button_inactive, LevelOne.X_X, LevelOne.X_Y, LevelOne.X_SIDE, LevelOne.X_SIDE);
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
