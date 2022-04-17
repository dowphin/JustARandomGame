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
import java.util.Arrays;

public class LevelOne implements Screen{

    PuzzleGame game;

// Every Single Variable used

    // Texture Dimensions for every level

    public static final double COG_DIVIDER = 4;
    public static final int COG_WIDTH = (int) Math.round(142 / COG_DIVIDER);
    public static final int COG_HEIGHT = (int) Math.round(139 / COG_DIVIDER);
    public static final int COG_X = 1840;
    public static final int COG_Y = 1000;

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


    // Variables needed for the timer
    public static long START_TIME = TimeUtils.millis();
    public static int total_seconds = 0;
    public static int total_minutes = 0;
    public static int total_hours = 0;
    public static String seconds;
    public static String minutes;
    public static String hours;
    public static String total_time;
    public static float targetWidth = 50;
    public static float xTopLeft = 50;
    public static float yTopLeft = PuzzleGame.HEIGHT - 50f;

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

    public static Texture grid_a;
    public static Texture grid_b;
    public static Texture grid_c;
    public static Texture grid_1;
    public static Texture grid_2;
    public static Texture grid_3;

//	Texture paused;


// 	Button Texture
    public static Texture button_inactive;
    public static Texture button_active;
// Hint Texture

    public static Texture hint_inactive;
    public static Texture hint_active;

    public LevelOne (PuzzleGame game) {

        this.game = game;
        hints.add("Move your mouse around.");
        hints.add("Locate the door.");
        hints.add("It's centered at the bottom of the screen.");

    }

    private static double LINK_DIVIDER = 2;
    private static final int LINK_WIDTH = (int) Math.round(300 / LINK_DIVIDER);
    private static final int LINK_HEIGHT = (int) Math.round(151 / LINK_DIVIDER);
    public static final int LINK_X = PuzzleGame.WIDTH / 2 - LINK_WIDTH / 2 + 176;
    public static final int LINK_Y = 250;

    private static Texture link;

    @Override
    public void show() {

// Defines every texture used
        title = new Texture ("level_one.png");
        cog_inactive = new Texture ("cog_inactive.png");
        cog_active = new Texture ("cog_active.png");
        center = new Texture("level_center_yellow.png");
        door = new Texture("door.png");
        back_inactive = new Texture("back_button_inactive.png");
        back_active = new Texture("back_button_active.png");
        forward_inactive = new Texture("forward_button_inactive.png");
        forward_active = new Texture("forward_button_active.png");

        hint_inactive = new Texture("hint_inactive.png");
        hint_active = new Texture("hint_active.png");

        link = new Texture("4U.png");

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

        if (
                Gdx.input.getX() < DOOR_X + DOOR_WIDTH &&
                        Gdx.input.getX() > DOOR_X &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < DOOR_Y + DOOR_HEIGHT + 20&&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > DOOR_Y + 20

        ) {

            game.batch.draw(door, DOOR_X, DOOR_Y, DOOR_WIDTH, DOOR_HEIGHT);
            if (Gdx.input.justTouched()) {
                game.LevelOneBeaten = true;
                game.setScreen(new LevelTwo(game));
            }
        }


        if (game.LevelOneBeaten) {
            if (
                    Gdx.input.getX() < ARROW_X + 375 + ARROW_WIDTH &&
                            Gdx.input.getX() > ARROW_X + 375 &&
                            PuzzleGame.HEIGHT - Gdx.input.getY() < ARROW_Y + ARROW_HEIGHT + 20 &&
                            PuzzleGame.HEIGHT - Gdx.input.getY() > ARROW_Y + 20

            ) {

                game.batch.draw(forward_active, ARROW_X + 375, ARROW_Y, ARROW_WIDTH, ARROW_HEIGHT);
                if (Gdx.input.justTouched()) {
                    game.setScreen(new LevelTwo(game));
                }
            } else {

                game.batch.draw(forward_inactive, ARROW_X + 375, ARROW_Y, ARROW_WIDTH, ARROW_HEIGHT);

            }
        }

        if (
                Gdx.input.getX() < HINT_X + HINT_SIDE &&
                Gdx.input.getX() > HINT_X &&
                PuzzleGame.HEIGHT - Gdx.input.getY() < HINT_Y + HINT_SIDE + 20 &&
                PuzzleGame.HEIGHT - Gdx.input.getY() > HINT_Y + 20 && hint_getter < 2
        ) {
            game.batch.draw(hint_active, HINT_X, HINT_Y, HINT_SIDE, HINT_SIDE);
            if (Gdx.input.justTouched()){
                if (hint_getter < 2){
                    hint_getter += 1;
                }
                the_hint = hints.get(hint_getter);
            }
        } else if (hint_getter < 2){
            game.batch.draw(hint_inactive, HINT_X, HINT_Y, HINT_SIDE, HINT_SIDE);
        }
        game.font.setColor(Color.BLACK);
        game.layout.setText(game.font, the_hint, game.font.getColor(), targetWidth, Align.center, false);
        game.font.draw(game.batch, the_hint, PuzzleGame.WIDTH / 2, 535, targetWidth, Align.center, false);


        // drawing the font


        if (game.showYTLink){
            game.batch.draw(link, LINK_X, LINK_Y, LINK_WIDTH, LINK_HEIGHT);
        }

        if (game.LevelNineBeaten) {
            game.batch.draw(grid_b, 0, 480, LevelTen.GRID_SIDE, LevelTen.GRID_SIDE);
            game.batch.draw(grid_1, 900, 0, LevelTen.GRID_SIDE, LevelTen.GRID_SIDE);
        }
        game.batch.end();



    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
        game.batch.dispose();

    }

}
