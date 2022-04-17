package com.mygdx.game.screens;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.PuzzleGame;

public class LevelEight implements Screen {

    PuzzleGame game;

// Every Single Variable used

    // Texture Dimensions for every level

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


    // Variables needed for the timer
    public static long START_TIME = TimeUtils.millis();
    public static int total_seconds = 0;
    public static int total_minutes = 0;
    public static int total_hours = 0;
    public static String seconds;
    public static String minutes;
    public static String hours;
    public static String total_time;
    public static float targetWidth = 100;
    public static float xTopLeft = 100;
    public static float yTopLeft = PuzzleGame.HEIGHT - 100f;

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
    public static Texture bar_full;
    public static Texture bar_1;
    public static Texture bar_2;
    public static Texture bar_3;
    public static Texture bar_4;
    public static Texture bar_5;

    private static final double BAR_DIVIDER = 8;
    private static final int BAR_WIDTH = (int) Math.round(1075 / BAR_DIVIDER);
    private static final int BAR_HEIGHT = (int) Math.round(185 / BAR_DIVIDER);
    private static final int BAR_X = PuzzleGame.WIDTH / 2 - BAR_WIDTH / 2 - 300;
    private static final int BAR_Y = PuzzleGame.HEIGHT / 2 - BAR_HEIGHT / 2 - 100;



//	Texture paused;

    public static Texture hint_inactive;
    public static Texture hint_active;

    public static Random rand = new Random();
    public static int rand_x = rand.nextInt(300) + 300;
    public static int rand_y = rand.nextInt(250) + 50;

    // bar dimensions


    public static int clicked = 0;
    public static ArrayList<Texture> bars = new ArrayList<>();

    Texture letter_box;

    private static final int LETTER_B_DIVIDER = 10;
    private static final int LETTER_B_WIDTH = (int) Math.round(372 / LETTER_B_DIVIDER);
    private static final int LETTER_B_HEIGHT = (int) Math.round(799 / LETTER_B_DIVIDER);
    private static final int LETTER_B_X = PuzzleGame.WIDTH / 2 - LETTER_B_WIDTH / 2;
    private static final int LETTER_B_Y = PuzzleGame.HEIGHT / 2 - LETTER_B_HEIGHT / 2;

    private static final String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static int box1 = 0;
    private static int box2 = 0;
    private static int box3 = 0;
    private static int box4 = 0;



    public LevelEight(PuzzleGame game){
        this.game = game;
        hints.add("Yes it is possible");
        hints.add("Click on the button");
        hints.add("Stop complaining; you have 16 milliseconds to click the button");
    }

    @Override
    public void show() {
        title = new Texture ("level_eight.png");
        cog_inactive = new Texture ("cog_inactive.png");
        cog_active = new Texture ("cog_active.png");
        center = new Texture("level_center_blue.png");
        door = new Texture("door.png");
        back_inactive = new Texture("back_button_inactive.png");
        back_active = new Texture("back_button_active.png");
        forward_inactive = new Texture("forward_button_inactive.png");
        forward_active = new Texture("forward_button_active.png");
        bar_full = new Texture("6bar_full.png");
        bar_1 = new Texture("6bar_1.png");
        bar_2 = new Texture("6bar_2.png");
        bar_3 = new Texture("6bar_3.png");
        bar_4 = new Texture("6bar_4.png");
        bar_5 = new Texture("6bar_5.png");
        letter_box = new Texture("letter_box.png");
        bars.add(title);
        bars.add(bar_1);
        bars.add(bar_2);
        bars.add(bar_3);
        bars.add(bar_4);
        bars.add(bar_5);
        bars.add(bar_full);
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
        game.batch.draw(title, MainMenuScreen.TITLE_X, MainMenuScreen.TITLE_Y, MainMenuScreen.TITLE_WIDTH, MainMenuScreen.TITLE_HEIGHT);
        game.batch.draw(center, CENTER_X, CENTER_Y, CENTER_SIDE, CENTER_SIDE);
        game.batch.draw(door, DOOR_X, DOOR_Y, DOOR_WIDTH, DOOR_HEIGHT);



        if (game.LevelEightBeaten) {
            if (
                    Gdx.input.getX() < ARROW_X + 375 + ARROW_WIDTH &&
                            Gdx.input.getX() > ARROW_X + 375 &&
                            PuzzleGame.HEIGHT - Gdx.input.getY() < ARROW_Y + ARROW_HEIGHT &&
                            PuzzleGame.HEIGHT - Gdx.input.getY() > ARROW_Y

            ) {

                game.batch.draw(forward_active, ARROW_X + 375, ARROW_Y, ARROW_WIDTH, ARROW_HEIGHT);
                if (Gdx.input.justTouched()) {
                    game.setScreen(new LevelNine(game));
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
                game.setScreen(new LevelSeven(game));
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
            }
        } else if (hint_getter < 2){
            game.batch.draw(LevelOne.hint_inactive, LevelOne.HINT_X, LevelOne.HINT_Y, LevelOne.HINT_SIDE, LevelOne.HINT_SIDE);
        }
        game.font.setColor(Color.BLACK);
        game.layout.setText(game.font, the_hint, game.font.getColor(), targetWidth, Align.center, false);
        game.font.draw(game.batch, the_hint, PuzzleGame.WIDTH / 2, 535, targetWidth, Align.center, false);

        // drawing the font


        if (
                Gdx.input.getX() < rand_x + LevelTwo.BUTTON_SIDE / 3 &&
                        Gdx.input.getX() > rand_x &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() < rand_y + LevelTwo.BUTTON_SIDE / 4 &&
                        PuzzleGame.HEIGHT - Gdx.input.getY() > rand_y

        ) {
            rand_x = rand.nextInt(300) + 300;
            rand_y = rand.nextInt(250) + 50;

            game.batch.draw(LevelTwo.button_active, rand_x, rand_y, LevelTwo.BUTTON_SIDE / 3, LevelTwo.BUTTON_SIDE / 3);
            if (Gdx.input.justTouched()) {
                clicked += 1;

            }

        } else {

            game.batch.draw(LevelTwo.button_inactive, rand_x, rand_y, LevelTwo.BUTTON_SIDE / 3, LevelTwo.BUTTON_SIDE / 3);
        }

        if (clicked == 6){
            game.LevelEightBeaten = true;
            clicked = 0;
            game.setScreen(new LevelNine(game));
        }
        if (clicked > 0) {
            game.batch.draw(bars.get(clicked), BAR_X, BAR_Y, BAR_WIDTH, BAR_HEIGHT);
        }
        if (game.LevelNineBeaten) {
            game.batch.draw(grid_c, 0, 480, LevelTen.GRID_SIDE, LevelTen.GRID_SIDE);
            game.batch.draw(grid_2, 900, 0, LevelTen.GRID_SIDE, LevelTen.GRID_SIDE);
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
