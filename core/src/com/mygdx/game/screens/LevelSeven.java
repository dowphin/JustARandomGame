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
// THE SECRET CODE IS DEEZ
//https://www.youtube.com/watch?v=PN 4U LI EF 2Rw
import java.util.ArrayList;

public class LevelSeven implements Screen {

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

    private static final double LINK_DIVIDER = 2;
    private static final int LINK_WIDTH = (int) Math.round(1556 / LINK_DIVIDER);
    private static final int LINK_HEIGHT = (int) Math.round(281 / LINK_DIVIDER);
    private static final int LINK_X = PuzzleGame.WIDTH / 2 - LINK_WIDTH / 2;
    private static final int LINK_Y = PuzzleGame.HEIGHT / 2 - LINK_HEIGHT / 2 + 125;

    Texture letter_box;

    private static final int LETTER_B_DIVIDER = 5;
    private static final int LETTER_B_WIDTH = (int) Math.round(372 / LETTER_B_DIVIDER);
    private static final int LETTER_B_HEIGHT = (int) Math.round(799 / LETTER_B_DIVIDER);
    private static final int LETTER_B_X = PuzzleGame.WIDTH / 2 - LETTER_B_WIDTH / 2;
    private static final int LETTER_B_Y = PuzzleGame.HEIGHT / 2 - LETTER_B_HEIGHT / 2;

    private static final String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static int box1 = 0;
    private static int box2 = 0;
    private static int box3 = 0;
    private static int box4 = 0;

    public static float targetWidth = LevelOne.targetWidth;
    public static final float letterWidth = 100;
    public static float xTopLeft = LevelOne.xTopLeft;
    public static float yTopLeft = LevelOne.yTopLeft;

    private static String comb = "";
    private static String combination = "DEEZ";


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

//	Texture paused;

    public static Texture hint_inactive;
    public static Texture hint_active;

    private static Texture link;

    public LevelSeven(PuzzleGame game){
        this.game = game;
    }

    @Override
    public void show() {
        title = new Texture ("level_seven.png");
        cog_inactive = new Texture ("cog_inactive.png");
        cog_active = new Texture ("cog_active.png");
        center = new Texture("level_center_green.png");
        door = new Texture("door.png");
        back_inactive = new Texture("back_button_inactive.png");
        back_active = new Texture("back_button_active.png");
        forward_inactive = new Texture("forward_button_inactive.png");
        forward_active = new Texture("forward_button_active.png");
        link = new Texture("link_8.png");
        letter_box = new Texture("letter_box.png");
        hints.add("Button");
        hints.add("BUTTON");
        hints.add("If you pressed it, good job! Now go check the previous levels");
        grid_1 = new Texture("grid_1.png");
        grid_2 = new Texture("grid_2.png");
        grid_3 = new Texture("grid_3.png");
        grid_a = new Texture("grid_a.png");
        grid_b = new Texture("grid_b.png");
        grid_c = new Texture("grid_c.png");
    }

    @Override
    public void render(float delta) {
        game.font.getData().setScale(3, 3);
        ScreenUtils.clear((float) 0.149019608, (float) 0.831372549, (float) 0.760784314, 1);
        game.batch.begin();
        game.batch.draw(title, MainMenuScreen.TITLE_X, MainMenuScreen.TITLE_Y, MainMenuScreen.TITLE_WIDTH, MainMenuScreen.TITLE_HEIGHT);
        game.batch.draw(center, CENTER_X, CENTER_Y, CENTER_SIDE, CENTER_SIDE);
        game.batch.draw(door, DOOR_X, DOOR_Y, DOOR_WIDTH, DOOR_HEIGHT);

        if (game.LevelSevenBeaten) {
            if (
                    Gdx.input.getX() < ARROW_X + 375 + ARROW_WIDTH &&
                            Gdx.input.getX() > ARROW_X + 375 &&
                            PuzzleGame.HEIGHT - Gdx.input.getY() < ARROW_Y + ARROW_HEIGHT &&
                            PuzzleGame.HEIGHT - Gdx.input.getY() > ARROW_Y

            ) {

                game.batch.draw(forward_active, ARROW_X + 375, ARROW_Y, ARROW_WIDTH, ARROW_HEIGHT);
                if (Gdx.input.justTouched()) {
                    game.setScreen(new LevelEight(game));
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
                game.setScreen(new LevelSix(game));
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
                        PuzzleGame.HEIGHT - Gdx.input.getY() > LevelOne.ARROW_Y
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

        game.font.getData().setScale(2, 2);
        game.font.setColor(Color.BLACK);
        game.layout.setText(game.font, the_hint, game.font.getColor(), targetWidth, Align.center, false);
        game.font.draw(game.batch, the_hint, PuzzleGame.WIDTH / 2, 535, targetWidth, Align.center, false);

        if (!game.showLvL8Buttons) {
            if (
                    Gdx.input.getX() < LevelTwo.BUTTON_X + LevelTwo.BUTTON_SIDE &&
                            Gdx.input.getX() > LevelTwo.BUTTON_X &&
                            PuzzleGame.HEIGHT - Gdx.input.getY() < LevelTwo.BUTTON_Y + LevelTwo.BUTTON_SIDE &&
                            PuzzleGame.HEIGHT - Gdx.input.getY() > LevelTwo.BUTTON_Y

            ) {

                game.batch.draw(LevelTwo.button_active, LevelTwo.BUTTON_X, LevelTwo.BUTTON_Y, LevelTwo.BUTTON_SIDE, LevelTwo.BUTTON_SIDE);
                if (Gdx.input.justTouched()) {
                    game.showYTLink = true;

                }

            } else {

                game.batch.draw(LevelTwo.button_inactive, LevelTwo.BUTTON_X, LevelTwo.BUTTON_Y, LevelTwo.BUTTON_SIDE, LevelTwo.BUTTON_SIDE);

            }
        }


        if (game.showYTLink) {
            game.batch.draw(link, LINK_X, LINK_Y, LINK_WIDTH, LINK_HEIGHT);
        }
        if (game.showLvL8Buttons) {
            game.font.setColor(Color.WHITE);

            game.font.getData().setScale(3, 3);

            game.batch.draw(letter_box, LETTER_B_X - 150, LETTER_B_Y, LETTER_B_WIDTH, LETTER_B_HEIGHT);

            if (
                    Gdx.input.getX() < LETTER_B_X - 150 + LETTER_B_WIDTH &&
                            Gdx.input.getX() > LETTER_B_X - 150 &&
                            PuzzleGame.HEIGHT - Gdx.input.getY() < LETTER_B_Y + LETTER_B_HEIGHT &&
                            PuzzleGame.HEIGHT - Gdx.input.getY() > LETTER_B_Y
            ) {
                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                    if (box1 < 25) {
                        box1 += 1;
                    } else {
                        box1 = 0;
                    }
                }
                if (Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)) {
                    if (box1 > 0) {
                        box1 -= 1;
                    } else {
                        box1 = 25;
                    }
                }
            }


            game.layout.setText(game.font, Character.toString(alpha.charAt(box1)), game.font.getColor(), letterWidth, Align.center, false);
            game.font.draw(game.batch, Character.toString(alpha.charAt(box1)), LETTER_B_X - 150 - 16, LETTER_B_Y + 95, letterWidth, Align.center, false);

            game.batch.draw(letter_box, LETTER_B_X - 50, LETTER_B_Y, LETTER_B_WIDTH, LETTER_B_HEIGHT);

            if (
                    Gdx.input.getX() < LETTER_B_X - 50 + LETTER_B_WIDTH &&
                            Gdx.input.getX() > LETTER_B_X - 50 &&
                            PuzzleGame.HEIGHT - Gdx.input.getY() < LETTER_B_Y + LETTER_B_HEIGHT &&
                            PuzzleGame.HEIGHT - Gdx.input.getY() > LETTER_B_Y
            ) {
                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                    if (box2 < 25) {
                        box2 += 1;
                    } else {
                        box2 = 0;
                    }
                }
                if (Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)) {
                    if (box2 > 0) {
                        box2 -= 1;
                    } else {
                        box2 = 25;
                    }
                }
            }

            game.layout.setText(game.font, Character.toString(alpha.charAt(box2)), game.font.getColor(), letterWidth, Align.center, false);
            game.font.draw(game.batch, Character.toString(alpha.charAt(box2)), LETTER_B_X - 50 - 17, LETTER_B_Y + 95, letterWidth, Align.center, false);

            game.batch.draw(letter_box, LETTER_B_X + 50, LETTER_B_Y, LETTER_B_WIDTH, LETTER_B_HEIGHT);

            if (
                    Gdx.input.getX() < LETTER_B_X + 50 + LETTER_B_WIDTH &&
                            Gdx.input.getX() > LETTER_B_X + 50 &&
                            PuzzleGame.HEIGHT - Gdx.input.getY() < LETTER_B_Y + LETTER_B_HEIGHT &&
                            PuzzleGame.HEIGHT - Gdx.input.getY() > LETTER_B_Y
            ) {
                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                    if (box3 < 25) {
                        box3 += 1;
                    } else {
                        box3 = 0;
                    }
                }
                if (Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)) {
                    if (box3 > 0) {
                        box3 -= 1;
                    } else {
                        box3 = 25;
                    }
                }
            }

            game.layout.setText(game.font, Character.toString(alpha.charAt(box3)), game.font.getColor(), letterWidth, Align.center, false);
            game.font.draw(game.batch, Character.toString(alpha.charAt(box3)), LETTER_B_X + 50 - 17, LETTER_B_Y + 95, letterWidth, Align.center, false);

            game.batch.draw(letter_box, LETTER_B_X + 150, LETTER_B_Y, LETTER_B_WIDTH, LETTER_B_HEIGHT);

            if (
                    Gdx.input.getX() < LETTER_B_X + 150 + LETTER_B_WIDTH &&
                            Gdx.input.getX() > LETTER_B_X + 150 &&
                            PuzzleGame.HEIGHT - Gdx.input.getY() < LETTER_B_Y + LETTER_B_HEIGHT &&
                            PuzzleGame.HEIGHT - Gdx.input.getY() > LETTER_B_Y
            ) {
                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                    if (box4 < 25) {
                        box4 += 1;
                    } else {
                        box4 = 0;
                    }
                }
                if (Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)) {
                    if (box4 > 0) {
                        box4 -= 1;
                    } else {
                        box4 = 25;
                    }
                }
            }


            game.layout.setText(game.font, Character.toString(alpha.charAt(box4)), game.font.getColor(), letterWidth, Align.center, false);
            game.font.draw(game.batch, Character.toString(alpha.charAt(box4)), LETTER_B_X + 150 - 17, LETTER_B_Y + 95, letterWidth, Align.center, false);

            comb = Character.toString(alpha.charAt(box1)) + Character.toString(alpha.charAt(box2)) + Character.toString(alpha.charAt(box3)) + Character.toString(alpha.charAt(box4));

            if (comb.equals(combination)) {
                box1 = 0;
                box2 = 0;
                box3 = 0;
                box4 = 0;
                game.LevelSevenBeaten = true;
                game.setScreen(new LevelEight(game));
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

        game.font.getData().setScale(2, 2);
        game.font.setColor(Color.BLACK);
        game.layout.setText(game.font, the_hint, game.font.getColor(), targetWidth, Align.center, false);
        game.font.draw(game.batch, the_hint, PuzzleGame.WIDTH / 2, 535, targetWidth, Align.center, false);
        if (game.LevelNineBeaten) {
            game.batch.draw(grid_b, 0, 480, LevelTen.GRID_SIDE, LevelTen.GRID_SIDE);
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
