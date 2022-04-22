package com.mygdx.game.screens;

import java.util.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.PuzzleGame;

public class LevelThree implements Screen{
	
	PuzzleGame game;
	
	Texture title;
	Texture center;
	
	Texture bar_empty;
	Texture bar_1;
	Texture bar_2;
	Texture bar_3;
	Texture bar_4;
	Texture bar_full;
	Texture PN;
	
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

// combination to the button presses
	
	private static String combination = "12112";
	private static String pressed = "";

// bar dimensions	

	private static final double BAR_DIVIDER = 12;
	private static final int BAR_WIDTH = (int) Math.round(2560 / BAR_DIVIDER);
	private static final int BAR_HEIGHT = (int) Math.round(520 / BAR_DIVIDER);
	private static final int BAR_X = PuzzleGame.WIDTH / 2 - BAR_WIDTH / 2;
	private static final int BAR_Y = PuzzleGame.HEIGHT / 2 - BAR_HEIGHT / 2 - 100;

	// idek anymore
	private static double LINK_DIVIDER = 2;
	private static final int LINK_WIDTH = (int) Math.round(300 / LINK_DIVIDER);
	private static final int LINK_HEIGHT = (int) Math.round(151 / LINK_DIVIDER);
	public static final int LINK_X = PuzzleGame.WIDTH / 2 - LINK_WIDTH / 2;
	public static final int LINK_Y = 25_0;
	
	public static ArrayList<Texture> bars = new ArrayList<Texture>(5);

	private static ArrayList<String> hints = new ArrayList<String>();
	private static String the_hint = "";
	private static int hint_getter = -1;

	public static Texture grid_a;
	public static Texture grid_b;
	public static Texture grid_c;
	public static Texture grid_1;
	public static Texture grid_2;
	public static Texture grid_3;
	private static String konami = "";
	private static String code = "uuddlrlrbae";

	public LevelThree(PuzzleGame game) {

		this.game = game;
		hints.add("Use the arrows.");
		hints.add("The answer is in another level.");
		hints.add("Hit the buttons in the order shown in Level Two.");
		hints.add("Alternatively, you could just hit random buttons.");
	}
	
	@Override
	public void show() {
		
		title = new Texture ("level_three.png");
		center = new Texture ("level_center_blue.png");
		PN = new Texture("PN.png");
		
		bar_empty = new Texture("bar_empty.png");
		bar_1 = new Texture("bar_1.png");
		bar_2 = new Texture("bar_2.png");
		bar_3 = new Texture("bar_3.png");
		bar_4 = new Texture("bar_4.png");
		bar_full = new Texture("bar_full.png");
		
		bars.add(bar_empty);
		bars.add(bar_1);
		bars.add(bar_2);
		bars.add(bar_3);
		bars.add(bar_4);
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
			game.LevelThreeBeaten = true;
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
						PuzzleGame.HEIGHT - Gdx.input.getY() > LevelOne.HINT_Y && hint_getter < 3
		) {
			game.batch.draw(LevelOne.hint_active, LevelOne.HINT_X, LevelOne.HINT_Y, LevelOne.HINT_SIDE, LevelOne.HINT_SIDE);
			if (Gdx.input.justTouched()){
				if (hint_getter < 3){
					hint_getter += 1;
				}
				the_hint = hints.get(hint_getter);
			}
		} else if (hint_getter < 3){
			game.batch.draw(LevelOne.hint_inactive, LevelOne.HINT_X, LevelOne.HINT_Y, LevelOne.HINT_SIDE, LevelOne.HINT_SIDE);
		}

		game.font.setColor(Color.BLACK);
		game.layout.setText(game.font, the_hint, game.font.getColor(), targetWidth, Align.center, false);
		game.font.draw(game.batch, the_hint, PuzzleGame.WIDTH / 2, 530, targetWidth, Align.center, false);



		

// right button		
		
		if (	
				Gdx.input.getX() < LevelTwo.BUTTON_X + 100 + LevelTwo.BUTTON_SIDE &&
				Gdx.input.getX() > LevelTwo.BUTTON_X + 100 &&
				PuzzleGame.HEIGHT - Gdx.input.getY() < LevelTwo.BUTTON_Y + LevelTwo.BUTTON_SIDE && 
				PuzzleGame.HEIGHT - Gdx.input.getY() > LevelTwo.BUTTON_Y
				
				) {
			
			game.batch.draw(LevelTwo.button_active, LevelTwo.BUTTON_X + 100, LevelTwo.BUTTON_Y, LevelTwo.BUTTON_SIDE, LevelTwo.BUTTON_SIDE);
			if (Gdx.input.justTouched()) {
				pressed = pressed.concat("2");
				if (!combination.substring(0, pressed.length()).contains(pressed)) {
					pressed = "";
				} else if (combination.equals(pressed)) {
					pressed = "";
					game.LevelThreeBeaten = true;
					game.setScreen(new LevelFour(game));
				}
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
				pressed = pressed.concat("1");
				if (!combination.substring(0, pressed.length()).contains(pressed)) {
					pressed = "";
				} else if (combination.equals(pressed)) {
					System.out.print("Congrats! You found a completely useless line of code!");
				}
			}
			
			
		} else {
			
			game.batch.draw(LevelTwo.button_inactive, LevelTwo.BUTTON_X - 100, LevelTwo.BUTTON_Y, LevelTwo.BUTTON_SIDE, LevelTwo.BUTTON_SIDE);
			
		}
		
		if (	
				Gdx.input.getX() < LevelOne.ARROW_X - 375 + LevelOne.ARROW_WIDTH &&
				Gdx.input.getX() > LevelOne.ARROW_X - 375 &&
				PuzzleGame.HEIGHT - Gdx.input.getY() < LevelOne.ARROW_Y + LevelOne.ARROW_HEIGHT && 
				PuzzleGame.HEIGHT - Gdx.input.getY() > LevelOne.ARROW_Y
				
				) {
			
			game.batch.draw(LevelOne.back_active, LevelOne.ARROW_X - 375, LevelOne.ARROW_Y, LevelOne.ARROW_WIDTH, LevelOne.ARROW_HEIGHT);
			if (Gdx.input.justTouched()) {
				game.setScreen(new LevelTwo(game));
			}
			
		} else {
			
			game.batch.draw(LevelOne.back_inactive, LevelOne.ARROW_X - 375, LevelOne.ARROW_Y, LevelOne.ARROW_WIDTH, LevelOne.ARROW_HEIGHT);
			
		}
		
		if (game.LevelThreeBeaten) {
			if (	
					Gdx.input.getX() < LevelOne.ARROW_X + 375 + LevelOne.ARROW_WIDTH &&
					Gdx.input.getX() > LevelOne.ARROW_X + 375 &&
					PuzzleGame.HEIGHT - Gdx.input.getY() < LevelOne.ARROW_Y + LevelOne.ARROW_HEIGHT && 
					PuzzleGame.HEIGHT - Gdx.input.getY() > LevelOne.ARROW_Y
				
					) {
			
				game.batch.draw(LevelOne.forward_active, LevelOne.ARROW_X + 375, LevelOne.ARROW_Y, LevelOne.ARROW_WIDTH, LevelOne.ARROW_HEIGHT);
				if (Gdx.input.justTouched()) {
					game.setScreen(new LevelFour(game));
				}
			} else {
			
		 			game.batch.draw(LevelOne.forward_inactive, LevelOne.ARROW_X + 375, LevelOne.ARROW_Y, LevelOne.ARROW_WIDTH, LevelOne.ARROW_HEIGHT);
				
		 	}
		}
		
		game.batch.draw(bars.get(pressed.length()), BAR_X, BAR_Y, BAR_WIDTH, BAR_HEIGHT);

		if (game.showYTLink){
			game.batch.draw(PN, LINK_X, LINK_Y, LINK_WIDTH, LINK_HEIGHT);
		}
		if (game.LevelNineBeaten) {
			game.batch.draw(grid_b, 0, 480, LevelTen.GRID_SIDE, LevelTen.GRID_SIDE);
			game.batch.draw(grid_3, 900, 0, LevelTen.GRID_SIDE, LevelTen.GRID_SIDE);
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
		game.batch.dispose();
		
	}

}
