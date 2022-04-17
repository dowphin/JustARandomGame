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

public class LevelSix<DesktopLauncher> implements Screen {

    private static int BUTTON_SIDE = LevelTwo.BUTTON_SIDE / 4;
    private static int BUTTON_X = 30_0;
    private static int BUTTON_Y = 9_0;

    Texture title;
    Texture center;
    public static Texture grid_a;
    public static Texture grid_b;
    public static Texture grid_c;
    public static Texture grid_1;
    public static Texture grid_2;
    public static Texture grid_3;

    public static long START_TIME = LevelOne.START_TIME;
    public static int total_seconds = LevelOne.total_seconds;
    public static int total_minutes = LevelOne.total_minutes;
    public static int total_hours = LevelOne.total_hours;
    public static String seconds;
    public static String minutes;
    public static String hours;
    public static String total_time;

    public static float targetWidth = LevelOne.targetWidth;
    public static final float letterWidth = 10_0;
    public static float xTopLeft = LevelOne.xTopLeft;
    public static float yTopLeft = LevelOne.yTopLeft;

    private static ArrayList<String> hints = new ArrayList<String>();
    private static String the_hint = "";
    private static int hint_getter = -1;

    PuzzleGame game;

    public LevelSix(PuzzleGame game){
        this.game = game;
    }

    @Override
    public void show() {
        title = new Texture("level_six.png");
        center = new Texture("level_center_purple.png");
        hints.add("Buttons");
        hints.add("You might have to think outside the box");
        hints.add("That means the answer isn't inside the box");
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
        ScreenUtils.clear((float) 0.149019608, (float) 0.831372549, (float) 0.760784314, 1);
        game.batch.begin();

        if (
                Gdx.input.getX() < LevelOne.ARROW_X - 37_5 + LevelOne.ARROW_WIDTH &&
                        Gdx.input.getX() > LevelOne.ARROW_X - 37_5 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < LevelOne.ARROW_Y + LevelOne.ARROW_HEIGHT &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > LevelOne.ARROW_Y

        ) {

            game.batch.draw(LevelOne.back_active, LevelOne.ARROW_X - 37_5, LevelOne.ARROW_Y, LevelOne.ARROW_WIDTH, LevelOne.ARROW_HEIGHT);
            if (Gdx.input.justTouched()) {
                game.setScreen(new LevelFive(game));
            }

        } else {

            game.batch.draw(LevelOne.back_inactive, LevelOne.ARROW_X - 37_5, LevelOne.ARROW_Y, LevelOne.ARROW_WIDTH, LevelOne.ARROW_HEIGHT);

        }

        if (game.LevelSixBeaten) {
            if (
                    Gdx.input.getX() < LevelOne.ARROW_X + 37_5 + LevelOne.ARROW_WIDTH &&
                            Gdx.input.getX() > LevelOne.ARROW_X + 37_5 &&
                            PuzzleGame.HEIGHT - Gdx.input.getY() < LevelOne.ARROW_Y + LevelOne.ARROW_HEIGHT &&
                            PuzzleGame.HEIGHT - Gdx.input.getY() > LevelOne.ARROW_Y

            ) {

                game.batch.draw(LevelOne.forward_active, LevelOne.ARROW_X + 37_5, LevelOne.ARROW_Y, LevelOne.ARROW_WIDTH, LevelOne.ARROW_HEIGHT);
                if (Gdx.input.justTouched()) {
                    game.setScreen(new LevelSeven(game));
                }
            } else {

                game.batch.draw(LevelOne.forward_inactive, LevelOne.ARROW_X + 37_5, LevelOne.ARROW_Y, LevelOne.ARROW_WIDTH, LevelOne.ARROW_HEIGHT);

            }
        }
        game.batch.draw(center, LevelOne.CENTER_X, LevelOne.CENTER_Y, LevelOne.CENTER_SIDE, LevelOne.CENTER_SIDE);

        if (
                Gdx.input.getX() < BUTTON_X + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X, BUTTON_Y, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X, BUTTON_Y, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 25 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 25 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 25, BUTTON_Y, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 25, BUTTON_Y, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 50 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 50 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 50, BUTTON_Y, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 50, BUTTON_Y, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 75 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 75 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 75, BUTTON_Y, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 75, BUTTON_Y, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 100 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 100 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 100, BUTTON_Y, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 100, BUTTON_Y, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 125 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 125 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 125, BUTTON_Y, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 125, BUTTON_Y, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 150 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 150 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 150, BUTTON_Y, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 150, BUTTON_Y, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 175 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 175 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 175, BUTTON_Y, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 175, BUTTON_Y, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 200 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 200 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 200, BUTTON_Y, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 200, BUTTON_Y, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 225 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 225 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 225, BUTTON_Y, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 225, BUTTON_Y, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 250 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 250 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 250, BUTTON_Y, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 250, BUTTON_Y, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 275 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 275 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 275, BUTTON_Y, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 275, BUTTON_Y, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 300 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 300 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 300, BUTTON_Y, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 300, BUTTON_Y, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 325 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 325 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 325, BUTTON_Y, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 325, BUTTON_Y, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 50 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 100
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X, BUTTON_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X, BUTTON_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 25 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 25 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 50 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 100
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 25, BUTTON_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 25, BUTTON_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 50 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 50 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 50 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 100
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 50, BUTTON_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 50, BUTTON_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 75 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 75 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 50 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 100
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 75, BUTTON_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 75, BUTTON_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 100 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 100 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 50 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 100
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 100, BUTTON_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 100, BUTTON_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 125 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 125 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 50 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 100
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 125, BUTTON_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 125, BUTTON_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 150 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 150 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 50 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 100
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 150, BUTTON_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 150, BUTTON_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 175 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 175 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 50 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 100
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 175, BUTTON_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 175, BUTTON_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 200 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 200 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 50 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 100
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 200, BUTTON_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 200, BUTTON_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 225 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 225 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 50 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 100
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 225, BUTTON_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 225, BUTTON_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 250 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 250 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 50 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 100
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 250, BUTTON_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 250, BUTTON_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 275 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 275 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 50 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 100
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 275, BUTTON_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 275, BUTTON_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 300 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 300 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 50 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 100
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 300, BUTTON_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 300, BUTTON_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 325 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 325 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 50 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 100
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 325, BUTTON_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 325, BUTTON_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 100 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 200
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X, BUTTON_Y + 100, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X, BUTTON_Y + 100, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 25 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 25 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 100 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 200
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 25, BUTTON_Y + 100, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 25, BUTTON_Y + 100, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 50 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 50 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 100 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 200
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 50, BUTTON_Y + 100, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 50, BUTTON_Y + 100, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 75 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 75 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 100 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 200
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 75, BUTTON_Y + 100, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 75, BUTTON_Y + 100, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 100 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 100 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 100 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 200
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 100, BUTTON_Y + 100, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 100, BUTTON_Y + 100, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 125 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 125 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 100 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 200
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 125, BUTTON_Y + 100, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 125, BUTTON_Y + 100, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 150 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 150 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 100 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 200
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 150, BUTTON_Y + 100, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 150, BUTTON_Y + 100, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 175 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 175 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 100 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 200
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 175, BUTTON_Y + 100, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 175, BUTTON_Y + 100, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 200 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 200 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 100 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 200
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 200, BUTTON_Y + 100, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 200, BUTTON_Y + 100, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 225 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 225 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 100 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 200
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 225, BUTTON_Y + 100, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 225, BUTTON_Y + 100, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 250 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 250 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 100 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 200
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 250, BUTTON_Y + 100, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 250, BUTTON_Y + 100, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 275 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 275 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 100 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 200
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 275, BUTTON_Y + 100, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 275, BUTTON_Y + 100, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 300 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 300 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 100 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 200
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 300, BUTTON_Y + 100, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 300, BUTTON_Y + 100, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 325 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 325 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 100 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 200
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 325, BUTTON_Y + 100, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 325, BUTTON_Y + 100, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 150 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 300
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X, BUTTON_Y + 150, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X, BUTTON_Y + 150, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 25 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 25 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 150 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 300
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 25, BUTTON_Y + 150, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 25, BUTTON_Y + 150, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 50 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 50 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 150 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 300
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 50, BUTTON_Y + 150, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 50, BUTTON_Y + 150, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 75 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 75 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 150 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 300
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 75, BUTTON_Y + 150, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 75, BUTTON_Y + 150, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 100 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 100 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 150 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 300
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 100, BUTTON_Y + 150, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 100, BUTTON_Y + 150, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 125 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 125 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 150 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 300
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 125, BUTTON_Y + 150, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 125, BUTTON_Y + 150, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 150 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 150 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 150 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 300
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 150, BUTTON_Y + 150, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 150, BUTTON_Y + 150, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 175 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 175 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 150 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 300
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 175, BUTTON_Y + 150, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 175, BUTTON_Y + 150, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 200 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 200 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 150 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 300
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 200, BUTTON_Y + 150, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 200, BUTTON_Y + 150, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 225 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 225 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 150 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 300
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 225, BUTTON_Y + 150, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 225, BUTTON_Y + 150, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 250 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 250 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 150 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 300
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 250, BUTTON_Y + 150, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 250, BUTTON_Y + 150, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 275 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 275 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 150 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 300
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 275, BUTTON_Y + 150, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 275, BUTTON_Y + 150, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 300 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 300 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 150 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 300
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 300, BUTTON_Y + 150, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 300, BUTTON_Y + 150, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 325 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 325 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 150 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 300
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 325, BUTTON_Y + 150, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 325, BUTTON_Y + 150, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 200 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 200
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X, BUTTON_Y + 200, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X, BUTTON_Y + 200, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 25 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 25 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 200 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 200
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 25, BUTTON_Y + 200, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 25, BUTTON_Y + 200, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 50 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 50 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 200 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 200
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 50, BUTTON_Y + 200, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 50, BUTTON_Y + 200, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 75 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 75 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 200 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 200
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 75, BUTTON_Y + 200, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 75, BUTTON_Y + 200, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 100 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 100 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 200 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 200
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 100, BUTTON_Y + 200, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 100, BUTTON_Y + 200, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 125 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 125 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 200 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 200
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 125, BUTTON_Y + 200, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 125, BUTTON_Y + 200, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 150 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 150 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 200 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 200
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 150, BUTTON_Y + 200, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 150, BUTTON_Y + 200, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 175 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 175 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 200 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 200
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 175, BUTTON_Y + 200, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 175, BUTTON_Y + 200, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 200 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 200 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 200 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 200
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 200, BUTTON_Y + 200, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 200, BUTTON_Y + 200, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 225 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 225 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 200 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 200
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 225, BUTTON_Y + 200, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 225, BUTTON_Y + 200, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 250 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 250 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 200 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 200
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 250, BUTTON_Y + 200, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 250, BUTTON_Y + 200, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 275 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 275 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 200 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 200
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 275, BUTTON_Y + 200, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 275, BUTTON_Y + 200, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 300 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 300 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 200 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 200
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 300, BUTTON_Y + 200, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 300, BUTTON_Y + 200, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 325 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 325 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 200 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 200
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 325, BUTTON_Y + 200, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 325, BUTTON_Y + 200, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 250 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 250
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X, BUTTON_Y + 250, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X, BUTTON_Y + 250, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 25 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 25 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 250 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 250
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 25, BUTTON_Y + 250, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 25, BUTTON_Y + 250, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 50 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 50 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 250 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 250
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 50, BUTTON_Y + 250, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 50, BUTTON_Y + 250, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 75 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 75 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 250 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 250
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 75, BUTTON_Y + 250, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 75, BUTTON_Y + 250, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 100 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 100 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 250 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 250
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 100, BUTTON_Y + 250, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 100, BUTTON_Y + 250, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 125 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 125 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 250 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 250
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 125, BUTTON_Y + 250, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 125, BUTTON_Y + 250, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 150 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 150 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 250 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 250
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 150, BUTTON_Y + 250, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 150, BUTTON_Y + 250, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 175 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 175 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 250 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 250
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 175, BUTTON_Y + 250, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 175, BUTTON_Y + 250, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 200 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 200 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 250 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 250
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 200, BUTTON_Y + 250, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 200, BUTTON_Y + 250, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 225 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 225 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 250 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 250
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 225, BUTTON_Y + 250, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 225, BUTTON_Y + 250, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 250 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 250 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 250 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 250
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 250, BUTTON_Y + 250, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 250, BUTTON_Y + 250, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 275 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 275 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 250 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 250
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 275, BUTTON_Y + 250, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 275, BUTTON_Y + 250, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 300 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 300 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 250 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 250
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 300, BUTTON_Y + 250, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 300, BUTTON_Y + 250, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 325 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 325 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 250 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 250
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 325, BUTTON_Y + 250, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 325, BUTTON_Y + 250, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 300 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 300
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X, BUTTON_Y + 300, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X, BUTTON_Y + 300, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 25 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 25 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 300 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 300
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 25, BUTTON_Y + 300, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 25, BUTTON_Y + 300, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 50 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 50 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 300 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 300
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 50, BUTTON_Y + 300, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 50, BUTTON_Y + 300, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 75 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 75 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 300 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 300
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 75, BUTTON_Y + 300, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 75, BUTTON_Y + 300, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 100 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 100 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 300 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 300
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 100, BUTTON_Y + 300, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 100, BUTTON_Y + 300, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 125 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 125 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 300 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 300
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 125, BUTTON_Y + 300, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 125, BUTTON_Y + 300, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 150 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 150 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 300 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 300
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 150, BUTTON_Y + 300, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 150, BUTTON_Y + 300, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 175 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 175 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 300 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 300
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 175, BUTTON_Y + 300, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 175, BUTTON_Y + 300, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 200 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 200 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 300 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 300
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 200, BUTTON_Y + 300, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 200, BUTTON_Y + 300, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 225 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 225 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 300 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 300
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 225, BUTTON_Y + 300, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 225, BUTTON_Y + 300, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 250 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 250 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 300 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 300
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 250, BUTTON_Y + 300, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 250, BUTTON_Y + 300, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 275 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 275 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 300 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 300
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 275, BUTTON_Y + 300, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 275, BUTTON_Y + 300, BUTTON_SIDE, BUTTON_SIDE);
        }


        if (
                Gdx.input.getX() < BUTTON_X + 300 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 300 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 300 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 300
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 300, BUTTON_Y + 300, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 300, BUTTON_Y + 300, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 325 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 325 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 300 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 300
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 325, BUTTON_Y + 300, BUTTON_SIDE, BUTTON_SIDE);
        } else{
            game.batch.draw(LevelTwo.button_inactive, BUTTON_X + 325, BUTTON_Y + 300, BUTTON_SIDE, BUTTON_SIDE);
        }

        if (
                Gdx.input.getX() < BUTTON_X + 515 + BUTTON_SIDE &&
                        Gdx.input.getX() > BUTTON_X + 515 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + 318 + BUTTON_SIDE &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y + 318
        ){
            game.batch.draw(LevelTwo.button_active, BUTTON_X + 515, BUTTON_Y + 318, 40, 40);
            if (Gdx.input.justTouched()){
                game.LevelSixBeaten = true;
                game.setScreen(new LevelSeven(game));
            }
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
            }
        } else if (hint_getter < 2){
            game.batch.draw(LevelOne.hint_inactive, LevelOne.HINT_X, LevelOne.HINT_Y, LevelOne.HINT_SIDE, LevelOne.HINT_SIDE);
        }

        game.font.setColor(Color.BLACK);
        game.layout.setText(game.font, the_hint, game.font.getColor(), targetWidth, Align.center, false);
        game.font.draw(game.batch, the_hint, PuzzleGame.WIDTH / 2, 535, targetWidth, Align.center, false);

        game.batch.draw(title, MainMenuScreen.TITLE_X, MainMenuScreen.TITLE_Y, MainMenuScreen.TITLE_WIDTH, MainMenuScreen.TITLE_HEIGHT);
        game.batch.draw(LevelOne.door, LevelOne.DOOR_X, LevelOne.DOOR_Y, LevelOne.DOOR_WIDTH, LevelOne.DOOR_HEIGHT);
        if (game.LevelNineBeaten) {
            game.batch.draw(grid_a, 0, 480, LevelTen.GRID_SIDE, LevelTen.GRID_SIDE);
            game.batch.draw(grid_3, 900, 0, LevelTen.GRID_SIDE, LevelTen.GRID_SIDE);
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
