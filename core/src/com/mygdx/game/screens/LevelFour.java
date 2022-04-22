package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.PuzzleGame;

import java.util.ArrayList;

public class LevelFour implements Screen{

	PuzzleGame game;
	public static Texture grid_a;
	public static Texture grid_b;
	public static Texture grid_c;
	public static Texture grid_1;
	public static Texture grid_2;
	public static Texture grid_3;
	Texture title;
	Texture center;
	Texture tri_button_active;
	Texture tri_button_inactive;
	Texture sq_button_active;
	Texture sq_button_inactive;
	Texture penta_button_active;
	Texture penta_button_inactive;
	Texture hexa_button_active;
	Texture hexa_button_inactive;
	Texture eyeless;
	Texture eye;
	Texture eye_active;
	
	public static long START_TIME = LevelOne.START_TIME;
	public static int total_seconds = LevelOne.total_seconds;
	public static int total_minutes = LevelOne.total_minutes;
	public static int total_hours = LevelOne.total_hours;
	public static String seconds;
	public static String minutes;
	public static String hours;
	public static String total_time;

	public static float targetWidth = LevelOne.targetWidth;
	public static float xTopLeft = LevelOne.xTopLeft;
	public static float yTopLeft = LevelOne.yTopLeft;

	private static ArrayList<String> hints = new ArrayList<String>();
	private static String the_hint = "";
	private static int hint_getter = -1;
	
	private static final double BUTTON_DIVIDER = 16;
	private static final int BUTTON_SIDE = (int) Math.round(1103 / BUTTON_DIVIDER);
	private static final int CENTERED_X = PuzzleGame.WIDTH / 2 - BUTTON_SIDE / 2;
	private static final int CENTERED_Y = PuzzleGame.HEIGHT / 2 - BUTTON_SIDE / 2;
	
	private static final String combination = "TSPH";
	private static String pressed = "";

// "bar" dimensions
	
	private static final double EYELESS_DIVIDER = 8;
	private static final int EYELESS_WIDTH = (int) Math.round(841 / EYELESS_DIVIDER);
	private static final int EYELESS_HEIGHT = (int) Math.round(572 / EYELESS_DIVIDER);
	private static final int EYELESS_X = PuzzleGame.WIDTH / 2 - EYELESS_WIDTH / 2;
	private static final int EYELESS_Y = PuzzleGame.HEIGHT / 2 - EYELESS_HEIGHT / 2 - 125;
	
	private static final double EYE_DIVIDER = 8;
	private static final int EYE_WIDTH = (int) Math.round(65 / EYE_DIVIDER);
	private static final int EYE_HEIGHT = (int) Math.round(64 / EYE_DIVIDER);
	private static int EYE_X = 470;
	private static int EYE_Y = 175;

	private static double LINK_DIVIDER = 2;
	private static final int LINK_WIDTH = (int) Math.round(300 / LINK_DIVIDER);
	private static final int LINK_HEIGHT = (int) Math.round(151 / LINK_DIVIDER);
	public static final int LINK_X = PuzzleGame.WIDTH / 2 - LINK_WIDTH / 2 - 206;
	public static final int LINK_Y = 5;

	private static Texture link;
	private static String konami = "";
	private static String code = "uuddlrlrbae";

	public LevelFour(PuzzleGame game) {
		this.game = game;
		hints.add("Pay attention to everything that's there.");
		hints.add("When I say everything, I mean everything.");
		hints.add("Notice what's different about this level from the last level.");
	}
	
	@Override
	public void show() {
		title = new Texture("level_four.png");
		center = new Texture("level_center_purple.png");
		tri_button_active = new Texture("triangle_button_active.png");
		tri_button_inactive = new Texture("triangle_button_inactive.png");
		sq_button_active = new Texture("square_button_active.png");
		sq_button_inactive = new Texture("square_button_inactive.png");
		penta_button_active = new Texture("pentagon_button_active.png");
		penta_button_inactive = new Texture("pentagon_button_inactive.png");
		hexa_button_active = new Texture("hexagon_button_active.png");
		hexa_button_inactive = new Texture("hexagon_button_inactive.png");
		eyeless = new Texture("eyeless.png");
		eye = new Texture("eye.png");
		eye_active = new Texture("eye_active.png");
		link = new Texture("LI.png");
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
			game.LevelFourBeaten = true;
		}
		if (!code.contains(konami)){
			konami = "";
		}
		
		ScreenUtils.clear((float) 0.149019608, (float) 0.831372549, (float) 0.760784314, 1);		
		game.batch.begin();
		game.batch.draw(title, MainMenuScreen.TITLE_X, MainMenuScreen.TITLE_Y, MainMenuScreen.TITLE_WIDTH, MainMenuScreen.TITLE_HEIGHT);
		game.batch.draw(center, LevelOne.CENTER_X, LevelOne.CENTER_Y, LevelOne.CENTER_SIDE, LevelOne.CENTER_SIDE);
		game.batch.draw(LevelOne.door, LevelOne.DOOR_X, LevelOne.DOOR_Y, LevelOne.DOOR_WIDTH, LevelOne.DOOR_HEIGHT);

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
		game.font.draw(game.batch, the_hint, PuzzleGame.WIDTH / 2, 530, targetWidth, Align.center, false);

		
		if (	
				Gdx.input.getX() < CENTERED_X + 50 + BUTTON_SIDE &&
				Gdx.input.getX() > CENTERED_X + 50 &&
				PuzzleGame.HEIGHT - Gdx.input.getY() < CENTERED_Y + 50 + BUTTON_SIDE &&
				PuzzleGame.HEIGHT - Gdx.input.getY() > CENTERED_Y + 50
				
				) {
			
			game.batch.draw(tri_button_active, CENTERED_X + 50, CENTERED_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
			if (Gdx.input.justTouched()) {
				pressed = pressed.concat("T");
				System.out.print(pressed + "\n");
				if (!combination.substring(0, pressed.length()).contains(pressed)) {
					pressed = "";
				} else if (combination.equals(pressed)) {
					System.out.print("yay");
				}
			}
			
		} else {
			
			game.batch.draw(tri_button_inactive, CENTERED_X + 50, CENTERED_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
			
		}
		
		if (	
				Gdx.input.getX() < CENTERED_X - 50 + BUTTON_SIDE &&
				Gdx.input.getX() > CENTERED_X - 50 &&
				PuzzleGame.HEIGHT - Gdx.input.getY() < CENTERED_Y + 50 + BUTTON_SIDE &&
				PuzzleGame.HEIGHT - Gdx.input.getY() > CENTERED_Y + 50
				
				) {
			
			game.batch.draw(sq_button_active, CENTERED_X - 50, CENTERED_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
			if (Gdx.input.justTouched()) {
				pressed = pressed.concat("S");
				System.out.print(pressed + "\n");
				if (!combination.substring(0, pressed.length()).contains(pressed)) {
					pressed = "";
				} else if (combination.equals(pressed)) {
					System.out.print("yay");
				}
			}
			
		} else {
			
			game.batch.draw(sq_button_inactive, CENTERED_X - 50, CENTERED_Y + 50, BUTTON_SIDE, BUTTON_SIDE);
			
		}
		
		if (	
				Gdx.input.getX() < CENTERED_X + 50 + BUTTON_SIDE &&
				Gdx.input.getX() > CENTERED_X + 50 &&
				PuzzleGame.HEIGHT - Gdx.input.getY() < CENTERED_Y - 50 + BUTTON_SIDE &&
				PuzzleGame.HEIGHT - Gdx.input.getY() > CENTERED_Y - 50
				
				) {
			
			game.batch.draw(penta_button_active, CENTERED_X + 50, CENTERED_Y - 50, BUTTON_SIDE, BUTTON_SIDE);
			if (Gdx.input.justTouched()) {
				pressed = pressed.concat("P");
				System.out.print(pressed + "\n");
				if (!combination.substring(0, pressed.length()).contains(pressed)) {
					pressed = "";
				} else if (combination.equals(pressed)) {
					System.out.print("yay");
				}
			}
			
		} else {
			
			game.batch.draw(penta_button_inactive, CENTERED_X + 50, CENTERED_Y - 50, BUTTON_SIDE, BUTTON_SIDE);
			
		}
		
		if (	
				Gdx.input.getX() < CENTERED_X - 50 + BUTTON_SIDE &&
				Gdx.input.getX() > CENTERED_X - 50 &&
				PuzzleGame.HEIGHT - Gdx.input.getY() < CENTERED_Y - 50 + BUTTON_SIDE &&
				PuzzleGame.HEIGHT - Gdx.input.getY() > CENTERED_Y - 50
				
				) {
			
			game.batch.draw(hexa_button_active, CENTERED_X - 50, CENTERED_Y - 50, BUTTON_SIDE, BUTTON_SIDE);
			if (Gdx.input.justTouched()) {
				pressed = pressed.concat("H");
				if (!combination.substring(0, pressed.length()).contains(pressed)) {
					pressed = "";
				} else if (combination.equals(pressed)) {
					pressed = "";
					game.LevelThreeBeaten = false;
					game.setScreen(new LevelThree(game));
				}
			}
			
		} else {
			
			game.batch.draw(hexa_button_inactive, CENTERED_X - 50, CENTERED_Y - 50, BUTTON_SIDE, BUTTON_SIDE);
			
		}
		
		if (	
				Gdx.input.getX() < LevelOne.ARROW_X - 375 + LevelOne.ARROW_WIDTH &&
				Gdx.input.getX() > LevelOne.ARROW_X - 375 &&
				PuzzleGame.HEIGHT - Gdx.input.getY() < LevelOne.ARROW_Y + LevelOne.ARROW_HEIGHT && 
				PuzzleGame.HEIGHT - Gdx.input.getY() > LevelOne.ARROW_Y
				
				) {
			
			game.batch.draw(LevelOne.back_active, LevelOne.ARROW_X - 375, LevelOne.ARROW_Y, LevelOne.ARROW_WIDTH, LevelOne.ARROW_HEIGHT);
			if (Gdx.input.justTouched()) {
				game.setScreen(new LevelThree(game));
			}
			
		} else {
			
			game.batch.draw(LevelOne.back_inactive, LevelOne.ARROW_X - 375, LevelOne.ARROW_Y, LevelOne.ARROW_WIDTH, LevelOne.ARROW_HEIGHT);
			
		}
		
		if (game.LevelFourBeaten) {
			if (	
					Gdx.input.getX() < LevelOne.ARROW_X + 375 + LevelOne.ARROW_WIDTH &&
					Gdx.input.getX() > LevelOne.ARROW_X + 375 &&
					PuzzleGame.HEIGHT - Gdx.input.getY() < LevelOne.ARROW_Y + LevelOne.ARROW_HEIGHT && 
					PuzzleGame.HEIGHT - Gdx.input.getY() > LevelOne.ARROW_Y
				
					) {
			
				game.batch.draw(LevelOne.forward_active, LevelOne.ARROW_X + 375, LevelOne.ARROW_Y, LevelOne.ARROW_WIDTH, LevelOne.ARROW_HEIGHT);
				if (Gdx.input.justTouched()) {
					game.setScreen(new LevelFive(game));
				}
			} else {
			
		 			game.batch.draw(LevelOne.forward_inactive, LevelOne.ARROW_X + 375, LevelOne.ARROW_Y, LevelOne.ARROW_WIDTH, LevelOne.ARROW_HEIGHT);
				
		 	}
		}
		

		if (
				Gdx.input.getX() < EYE_X + EYE_WIDTH &&
				Gdx.input.getX() > EYE_X &&
				PuzzleGame.HEIGHT - Gdx.input.getY() < EYE_Y + EYE_HEIGHT &&
				PuzzleGame.HEIGHT - Gdx.input.getY() > EYE_Y
				) {
			game.batch.draw(eye_active, EYE_X, EYE_Y, EYE_WIDTH, EYE_HEIGHT);
			if (Gdx.input.justTouched()) {
				game.LevelFourBeaten = true;
				game.setScreen(new LevelFive(game));
			}
		} else {
			game.batch.draw(eye, EYE_X, EYE_Y, EYE_WIDTH, EYE_HEIGHT);
		}
		game.batch.draw(eyeless, EYELESS_X, EYELESS_Y, EYELESS_WIDTH, EYELESS_HEIGHT);

		if (game.showYTLink){
			game.batch.draw(link, LINK_X, LINK_Y, LINK_WIDTH, LINK_HEIGHT);
		}
		if (game.LevelNineBeaten) {
			game.batch.draw(grid_a, 0, 480, LevelTen.GRID_SIDE, LevelTen.GRID_SIDE);
			game.batch.draw(grid_2, 900, 0, LevelTen.GRID_SIDE, LevelTen.GRID_SIDE);
		}
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
// x [938, 951]
// y [782, 800]		
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
