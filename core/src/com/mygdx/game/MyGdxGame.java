package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;
//just pushed from a mac

public class MyGdxGame extends Game {
	//testttttting
	//GameScreen gameScreen;
	public static Random rand = new Random();
	SpriteBatch batch;
	ShapeRenderer shapeRenderer;
	BitmapFont font;

	@Override
	public void create() {
		//gameScreen = new GameScreen();
		//setScreen(gameScreen);
		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		font = new BitmapFont();
		setScreen(new titleScreen(this));
	}

	@Override
	public void render() {
		super.render();

	}

	@Override
	public void dispose() {
		super.dispose();
	}
}
