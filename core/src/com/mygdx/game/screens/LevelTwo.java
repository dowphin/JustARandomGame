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

public class LevelTwo implements Screen{
	
	PuzzleGame game;
		
	Texture title;
	Texture center;
	public static Texture button_inactive;
	public static Texture button_active;
	Texture key;
	
	public static final double BUTTON_DIVIDER = 12;
	public static final int BUTTON_SIDE = (int) Math.round(1103 / BUTTON_DIVIDER);
	public static final int BUTTON_X = PuzzleGame.WIDTH / 2 - BUTTON_SIDE / 2;
	public static final int BUTTON_Y = PuzzleGame.HEIGHT / 2 - BUTTON_SIDE / 2;
	
	public static final int KEY_DIVIDER = 16;
	public static final int KEY_WIDTH = (int) Math.round(1554 / KEY_DIVIDER);
	public static final int KEY_HEIGHT = (int) Math.round(2560 / KEY_DIVIDER);
	public static final int KEY_X = PuzzleGame.WIDTH / 2 - KEY_WIDTH / 2 - 125;
	public static final int KEY_Y = PuzzleGame.HEIGHT / 2 - KEY_HEIGHT / 2;
	
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

	private static double LINK_DIVIDER = 2;
	private static final int LINK_WIDTH = (int) Math.round(300 / LINK_DIVIDER);
	private static final int LINK_HEIGHT = (int) Math.round(151 / LINK_DIVIDER);
	public static final int LINK_X = PuzzleGame.WIDTH / 2 - LINK_WIDTH / 2 - 350;
	public static final int LINK_Y = 200;

	private static Texture link;

	public static Texture grid_a;
	public static Texture grid_b;
	public static Texture grid_c;
	public static Texture grid_1;
	public static Texture grid_2;
	public static Texture grid_3;
	
	public LevelTwo(PuzzleGame game) {
		this.game = game;
		hints.add("Click on the button.");
		hints.add("Just click on the button.");
		hints.add("FOR THE LOVE OF CHRISTMAS JUST CLICK ON THE DUWANG BUTTON");

	}
	
	@Override
	public void show() {

		title = new Texture ("level_two.png");
		center = new Texture("level_center_green.png");
		
		button_inactive = new Texture("button_inactive.png");
		button_active = new Texture("button_active.png");
		key = new Texture("key.png");

		link = new Texture("EF.png");
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
		
		
		
		
		if (	
				Gdx.input.getX() < BUTTON_X + BUTTON_SIDE && 
				Gdx.input.getX() > BUTTON_X && 
				PuzzleGame.HEIGHT - Gdx.input.getY() < BUTTON_Y + BUTTON_SIDE && 
				PuzzleGame.HEIGHT - Gdx.input.getY() > BUTTON_Y
				
				) {
			
			game.batch.draw(button_active, BUTTON_X, BUTTON_Y, BUTTON_SIDE, BUTTON_SIDE);
			if (Gdx.input.justTouched()) {
				game.LevelTwoBeaten = true;
				game.setScreen(new LevelThree(game));
				
			}
			
		} else {
			
			game.batch.draw(button_inactive, BUTTON_X, BUTTON_Y, BUTTON_SIDE, BUTTON_SIDE);
			
		}
		
		if (	
				Gdx.input.getX() < LevelOne.ARROW_X - 375 + LevelOne.ARROW_WIDTH &&
				Gdx.input.getX() > LevelOne.ARROW_X - 375 &&
				PuzzleGame.HEIGHT - Gdx.input.getY() < LevelOne.ARROW_Y + LevelOne.ARROW_HEIGHT && 
				PuzzleGame.HEIGHT - Gdx.input.getY() > LevelOne.ARROW_Y
				
				) {
			
			game.batch.draw(LevelOne.back_active, LevelOne.ARROW_X - 375, LevelOne.ARROW_Y, LevelOne.ARROW_WIDTH, LevelOne.ARROW_HEIGHT);
			if (Gdx.input.justTouched()) {
				game.setScreen(new LevelOne(game));
			}
			
		} else {
			
			game.batch.draw(LevelOne.back_inactive, LevelOne.ARROW_X - 375, LevelOne.ARROW_Y, LevelOne.ARROW_WIDTH, LevelOne.ARROW_HEIGHT);
			
		}
		
		if (game.LevelTwoBeaten) {
			if (	
					Gdx.input.getX() < LevelOne.ARROW_X + 375 + LevelOne.ARROW_WIDTH &&
					Gdx.input.getX() > LevelOne.ARROW_X + 375 &&
					PuzzleGame.HEIGHT - Gdx.input.getY() < LevelOne.ARROW_Y + LevelOne.ARROW_HEIGHT && 
					PuzzleGame.HEIGHT - Gdx.input.getY() > LevelOne.ARROW_Y
				
					) {
			
				game.batch.draw(LevelOne.forward_active, LevelOne.ARROW_X + 375, LevelOne.ARROW_Y, LevelOne.ARROW_WIDTH, LevelOne.ARROW_HEIGHT);
				if (Gdx.input.justTouched()) {
					game.setScreen(new LevelThree(game));
				}
			} else {
			
		 			game.batch.draw(LevelOne.forward_inactive, LevelOne.ARROW_X + 375, LevelOne.ARROW_Y, LevelOne.ARROW_WIDTH, LevelOne.ARROW_HEIGHT);
				
		 	}
		}
		
		game.batch.draw(key, KEY_X, KEY_Y, KEY_WIDTH, KEY_HEIGHT); 

		if (game.showYTLink){
			game.batch.draw(link, LINK_X, LINK_Y, LINK_WIDTH, LINK_HEIGHT);
		}
		if (game.LevelNineBeaten) {
			game.batch.draw(grid_c, 0, 480, LevelTen.GRID_SIDE, LevelTen.GRID_SIDE);
			game.batch.draw(grid_3, 900, 0, LevelTen.GRID_SIDE, LevelTen.GRID_SIDE);
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
