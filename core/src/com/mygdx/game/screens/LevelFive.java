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

public class LevelFive implements Screen{

	PuzzleGame game;
	
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
	public static final float letterWidth = 200;
	public static float xTopLeft = LevelOne.xTopLeft;
	public static float yTopLeft = LevelOne.yTopLeft;

	private static ArrayList<String> hints = new ArrayList<String>();
	private static String the_hint = "";
	private static int hint_getter = -1;

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

	Texture one_mirror;
	Texture two_mirror;
	Texture three_mirror;
	Texture four_mirror;

	private static final double MIRROR_DIVIDER = 7;
	private static final int MIRROR_WIDTH = (int) Math.round(646 / MIRROR_DIVIDER);
	private static final int MIRROR_HEIGHT = (int) Math.round(969 / MIRROR_DIVIDER);
	private static final int MIRROR_X = PuzzleGame.WIDTH / 2 - MIRROR_WIDTH / 2;
	private static final int MIRROR_Y = PuzzleGame.HEIGHT / 2 - MIRROR_HEIGHT / 2 - 150;

	private static double LINK_DIVIDER = 2;
	private static final int LINK_WIDTH = (int) Math.round(300 / LINK_DIVIDER);
	private static final int LINK_HEIGHT = (int) Math.round(151 / LINK_DIVIDER);
	public static final int LINK_X = PuzzleGame.WIDTH / 2 - LINK_WIDTH / 2 + 206;
	public static final int LINK_Y = 305;

	private static Texture link;

	private static String comb = "";
	private static String combination = "FOOT";

	public LevelFive(PuzzleGame game) {
		this.game = game;
		hints.add("Look");
		hints.add("Pay attention to the numbers");
		hints.add("Set the letters to the first letter of the number below the box.");
	}
	
	@Override
	public void show() {
		title = new Texture("level_five.png");
		center = new Texture("level_center_red.png");
		letter_box = new Texture("letter_box.png");
		one_mirror = new Texture("written_1.png");
		two_mirror = new Texture("written_2.png");
		three_mirror = new Texture("written_3.png");
		four_mirror = new Texture("written_4.png");
		link = new Texture("2Rw.png");
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
		game.batch.draw(center, LevelOne.CENTER_X, LevelOne.CENTER_Y, LevelOne.CENTER_SIDE, LevelOne.CENTER_SIDE);
		game.batch.draw(LevelOne.door, LevelOne.DOOR_X, LevelOne.DOOR_Y, LevelOne.DOOR_WIDTH, LevelOne.DOOR_HEIGHT);

		if (
				Gdx.input.getX() < LevelOne.ARROW_X - 375 + LevelOne.ARROW_WIDTH &&
						Gdx.input.getX() > LevelOne.ARROW_X - 375 &&
						PuzzleGame.HEIGHT - Gdx.input.getY() < LevelOne.ARROW_Y + LevelOne.ARROW_HEIGHT &&
						PuzzleGame.HEIGHT - Gdx.input.getY() > LevelOne.ARROW_Y

		) {

			game.batch.draw(LevelOne.back_active, LevelOne.ARROW_X - 375, LevelOne.ARROW_Y, LevelOne.ARROW_WIDTH, LevelOne.ARROW_HEIGHT);
			if (Gdx.input.justTouched()) {
				game.setScreen(new LevelFour(game));
			}

		} else {

			game.batch.draw(LevelOne.back_inactive, LevelOne.ARROW_X - 375, LevelOne.ARROW_Y, LevelOne.ARROW_WIDTH, LevelOne.ARROW_HEIGHT);

		}

		if (game.LevelFiveBeaten) {
			if (
					Gdx.input.getX() < LevelOne.ARROW_X + 375 + LevelOne.ARROW_WIDTH &&
							Gdx.input.getX() > LevelOne.ARROW_X + 375 &&
							PuzzleGame.HEIGHT - Gdx.input.getY() < LevelOne.ARROW_Y + LevelOne.ARROW_HEIGHT &&
							PuzzleGame.HEIGHT - Gdx.input.getY() > LevelOne.ARROW_Y

			) {

				game.batch.draw(LevelOne.forward_active, LevelOne.ARROW_X + 375, LevelOne.ARROW_Y, LevelOne.ARROW_WIDTH, LevelOne.ARROW_HEIGHT);
				if (Gdx.input.justTouched()) {
					game.setScreen(new LevelSix(game));
				}
			} else {

				game.batch.draw(LevelOne.forward_inactive, LevelOne.ARROW_X + 375, LevelOne.ARROW_Y, LevelOne.ARROW_WIDTH, LevelOne.ARROW_HEIGHT);

			}
		}

		game.font.setColor(Color.WHITE);

		game.font.getData().setScale(3, 3);


		game.batch.draw(letter_box, LETTER_B_X - 150, LETTER_B_Y, LETTER_B_WIDTH, LETTER_B_HEIGHT);

		if (
				Gdx.input.getX() < LETTER_B_X - 150 + LETTER_B_WIDTH &&
				Gdx.input.getX() > LETTER_B_X - 150 &&
				PuzzleGame.HEIGHT - Gdx.input.getY() < LETTER_B_Y + LETTER_B_HEIGHT &&
				PuzzleGame.HEIGHT - Gdx.input.getY() > LETTER_B_Y
		){
			if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
				if (box1 < 25) {
					box1 += 1;
				}  else{
					box1 = 0;
				}
			}
			if (Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)){
				if (box1 > 0) {
					box1 -= 1;
				} else{
					box1 = 25;
				}
			}
		}

		game.layout.setText(game.font, Character.toString(alpha.charAt(box1)), game.font.getColor(), letterWidth, Align.center, false);
		game.font.draw(game.batch, Character.toString(alpha.charAt(box1)), LETTER_B_X - 150 - 65, LETTER_B_Y + 95, letterWidth, Align.center, false);

		game.batch.draw(letter_box, LETTER_B_X - 50, LETTER_B_Y, LETTER_B_WIDTH, LETTER_B_HEIGHT);

		if (
				Gdx.input.getX() < LETTER_B_X - 50 + LETTER_B_WIDTH &&
						Gdx.input.getX() > LETTER_B_X - 50 &&
						PuzzleGame.HEIGHT - Gdx.input.getY() < LETTER_B_Y + LETTER_B_HEIGHT &&
						PuzzleGame.HEIGHT - Gdx.input.getY() > LETTER_B_Y
		){
			if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
				if (box2 < 25) {
					box2 += 1;
				}  else{
					box2 = 0;
				}
			}
			if (Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)){
				if (box2 > 0) {
					box2 -= 1;
				} else{
					box2 = 25;
				}
			}
		}

		game.layout.setText(game.font, Character.toString(alpha.charAt(box2)), game.font.getColor(), letterWidth, Align.center, false);
		game.font.draw(game.batch, Character.toString(alpha.charAt(box2)), LETTER_B_X - 50 - 65, LETTER_B_Y + 95, letterWidth, Align.center, false);

		game.batch.draw(letter_box, LETTER_B_X + 50, LETTER_B_Y, LETTER_B_WIDTH, LETTER_B_HEIGHT);

		if (
				Gdx.input.getX() < LETTER_B_X + 50 + LETTER_B_WIDTH &&
						Gdx.input.getX() > LETTER_B_X + 50 &&
						PuzzleGame.HEIGHT - Gdx.input.getY() < LETTER_B_Y + LETTER_B_HEIGHT &&
						PuzzleGame.HEIGHT - Gdx.input.getY() > LETTER_B_Y
		){
			if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
				if (box3 < 25) {
					box3 += 1;
				}  else{
					box3 = 0;
				}
			}
			if (Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)){
				if (box3 > 0) {
					box3 -= 1;
				} else{
					box3 = 25;
				}
			}
		}

		game.layout.setText(game.font, Character.toString(alpha.charAt(box3)), game.font.getColor(), letterWidth, Align.center, false);
		game.font.draw(game.batch, Character.toString(alpha.charAt(box3)), LETTER_B_X + 50 - 65, LETTER_B_Y + 95, letterWidth, Align.center, false);

		game.batch.draw(letter_box, LETTER_B_X + 150, LETTER_B_Y, LETTER_B_WIDTH, LETTER_B_HEIGHT);

		if (
				Gdx.input.getX() < LETTER_B_X + 150 + LETTER_B_WIDTH &&
						Gdx.input.getX() > LETTER_B_X + 150 &&
						PuzzleGame.HEIGHT - Gdx.input.getY() < LETTER_B_Y + LETTER_B_HEIGHT &&
						PuzzleGame.HEIGHT - Gdx.input.getY() > LETTER_B_Y
		){
			if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
				if (box4 < 25) {
					box4 += 1;
				}  else{
					box4 = 0;
				}
			}
			if (Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)){
				if (box4 > 0) {
					box4 -= 1;
				} else{
					box4 = 25;
				}
			}
		}



		game.layout.setText(game.font, Character.toString(alpha.charAt(box4)), game.font.getColor(), letterWidth, Align.center, false);
		game.font.draw(game.batch, Character.toString(alpha.charAt(box4)), LETTER_B_X + 150 - 65, LETTER_B_Y + 95, letterWidth, Align.center, false);

		comb = Character.toString(alpha.charAt(box1)) + Character.toString(alpha.charAt(box2)) + Character.toString(alpha.charAt(box3)) + Character.toString(alpha.charAt(box4));

		if (comb.equals(combination)){
			box1 = 0;
			box2 = 0;
			box3 = 0;
			box4 = 0;
			game.LevelFiveBeaten = true;
			game.setScreen(new LevelSix(game));
		}

		game.batch.draw(one_mirror, MIRROR_X + 50, MIRROR_Y, MIRROR_WIDTH, MIRROR_HEIGHT);
		game.batch.draw(one_mirror, MIRROR_X - 50, MIRROR_Y, MIRROR_WIDTH, MIRROR_HEIGHT);
		game.batch.draw(four_mirror, MIRROR_X - 150, MIRROR_Y, MIRROR_WIDTH, MIRROR_HEIGHT);
		game.batch.draw(two_mirror, MIRROR_X + 150, MIRROR_Y, MIRROR_WIDTH, MIRROR_HEIGHT);


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

		if (game.showYTLink){
			game.batch.draw(link, LINK_X, LINK_Y, LINK_WIDTH, LINK_HEIGHT);
		}
		if (game.LevelNineBeaten) {
			game.batch.draw(grid_c, 0, 480, LevelTen.GRID_SIDE, LevelTen.GRID_SIDE);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
