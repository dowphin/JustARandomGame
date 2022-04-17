package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.PuzzleGame;
import java.lang.Math;

public class MainMenuScreen implements Screen{
	
	public static final float EXIT_DIVIDER = 6;
	public static final int PIC_WIDTH = 1000;
	public static final int PIC_HEIGHT = 400;
	public static final int EXIT_BUTTON_WIDTH = (int) Math.round(PIC_WIDTH / EXIT_DIVIDER);
	public static final int EXIT_BUTTON_HEIGHT = (int) Math.round(PIC_HEIGHT / EXIT_DIVIDER);
	public static final float EXIT_BUTTON_X = (PuzzleGame.WIDTH / 2 - EXIT_BUTTON_WIDTH / 2);
	public static final float EXIT_BUTTON_Y = (PuzzleGame.HEIGHT / 2 - EXIT_BUTTON_HEIGHT / 2) - 150;
	public static final double PLAY_DIVIDER = 4.6;
	public static final int PLAY_BUTTON_WIDTH = (int) Math.round(PIC_WIDTH / PLAY_DIVIDER);
	public static final int PLAY_BUTTON_HEIGHT = (int) Math.round(PIC_HEIGHT / PLAY_DIVIDER);
	public static final float PLAY_BUTTON_X = PuzzleGame.WIDTH / 2 - PLAY_BUTTON_WIDTH / 2;
	public static final float PLAY_BUTTON_Y = (PuzzleGame.HEIGHT / 2 - PLAY_BUTTON_HEIGHT / 2) - 8;
	public static final double OPTION_DIVIDER = 6;
	public static final int OPTION_BUTTON_WIDTH = (int) Math.round(PIC_WIDTH / OPTION_DIVIDER);
	public static final int OPTION_BUTTON_HEIGHT = (int) Math.round(PIC_HEIGHT / OPTION_DIVIDER);
	public static final float OPTION_BUTTON_X = PuzzleGame.WIDTH / 2 - OPTION_BUTTON_WIDTH / 2 - 325;
	public static final float OPTION_BUTTON_Y = (PuzzleGame.HEIGHT / 2 - OPTION_BUTTON_HEIGHT / 2) - 150;
	public static final double TITLE_DIVIDER = 4;
	public static final int TITLE_WIDTH = (int) Math.round(2559 / TITLE_DIVIDER);
	public static final int TITLE_HEIGHT = (int) Math.round(853 / TITLE_DIVIDER);
	public static final float TITLE_X = PuzzleGame.WIDTH / 2 - TITLE_WIDTH / 2;
	public static final float TITLE_Y = PuzzleGame.HEIGHT / 2 - TITLE_HEIGHT / 2 + 200;
	
	PuzzleGame game;
	
	Texture exit_button_inactive;
	Texture exit_button_active;
	Texture play_button_inactive;
	Texture play_button_active;
	Texture option_button_inactive;
	Texture option_button_active;
	Texture title;
	
	public MainMenuScreen (PuzzleGame game) {
		this.game = game;
		
	}
	
	@Override
	public void show() {
		exit_button_inactive = new Texture(Gdx.files.internal("exit_button_inactive.png"));
		exit_button_active = new Texture("exit_button_active.png");
		play_button_inactive = new Texture("play_button_inactive.png");
		play_button_active = new Texture("play_button_active.png");
		option_button_inactive = new Texture("option_button_inactive.png");
		option_button_active = new Texture("option_button_active.png");
		title = new Texture("title.png");
	}

	@Override
	public void render(float delta) {

		ScreenUtils.clear((float) 0.149019608, (float) 0.831372549, (float) 0.760784314, 1);
		game.batch.begin();
		if (	
				Gdx.input.getX() < EXIT_BUTTON_X + EXIT_BUTTON_WIDTH && 
				Gdx.input.getX() > EXIT_BUTTON_X && 
				PuzzleGame.HEIGHT - Gdx.input.getY() < EXIT_BUTTON_Y + EXIT_BUTTON_HEIGHT && 
				PuzzleGame.HEIGHT - Gdx.input.getY() > EXIT_BUTTON_Y
				
				) {
			
			game.batch.draw(exit_button_active, EXIT_BUTTON_X, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
			if (Gdx.input.justTouched()) {
				Gdx.app.exit();
			}
			
		} else {
			
			game.batch.draw(exit_button_inactive, EXIT_BUTTON_X, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
			
		}
		
		if (	
				Gdx.input.getX() < PLAY_BUTTON_X + PLAY_BUTTON_WIDTH && 
				Gdx.input.getX() > PLAY_BUTTON_X && 
				PuzzleGame.HEIGHT - Gdx.input.getY() < PLAY_BUTTON_Y + PLAY_BUTTON_HEIGHT && 
				PuzzleGame.HEIGHT - Gdx.input.getY() > PLAY_BUTTON_Y
				
				) {
			
			game.batch.draw(play_button_active, PLAY_BUTTON_X, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
			if (Gdx.input.justTouched()) {
				 game.setScreen(new LevelOne(game));
			}
			
		} else {
			
			game.batch.draw(play_button_inactive, PLAY_BUTTON_X, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
			
		}
		
		if (	
				Gdx.input.getX() < PLAY_BUTTON_X + PLAY_BUTTON_WIDTH && 
				Gdx.input.getX() > PLAY_BUTTON_X && 
				PuzzleGame.HEIGHT - Gdx.input.getY() < PLAY_BUTTON_Y + PLAY_BUTTON_HEIGHT && 
				PuzzleGame.HEIGHT - Gdx.input.getY() > PLAY_BUTTON_Y
				
				) {
			game.batch.draw(play_button_active, PLAY_BUTTON_X, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
			
		} else {
			
			game.batch.draw(play_button_inactive, PLAY_BUTTON_X, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
			
		}
		

		game.batch.draw(title, TITLE_X, TITLE_Y, TITLE_WIDTH, TITLE_HEIGHT);
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
		game.batch.dispose();
	}

}