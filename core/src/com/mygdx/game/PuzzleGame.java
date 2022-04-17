package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.screens.MainMenuScreen;

public class PuzzleGame extends Game {

	public static final int WIDTH = 960;
	public static final int HEIGHT = 540;
	public static SpriteBatch batch;
	public BitmapFont font;
	public GlyphLayout layout;
	public boolean LevelOneBeaten = false;
	public boolean LevelTwoBeaten = false;
	public boolean LevelThreeBeaten = false;
	public boolean LevelFourBeaten = false;
	public boolean LevelFiveBeaten = false;
	public boolean LevelSixBeaten = false;
	public boolean LevelSevenBeaten = true;
	public boolean LevelEightBeaten = true;
	public boolean LevelNineBeaten = false;
	public boolean showYTLink = false;
	public boolean showLvL8Buttons = false;

	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		layout = new GlyphLayout();
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose () {

	}
}
