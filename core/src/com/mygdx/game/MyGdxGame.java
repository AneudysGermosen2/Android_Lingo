package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.particles.influencers.SpawnInfluencer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;
//just pushed from a mac

public class MyGdxGame extends Game {
	//testttttting
	//GameScreen gameScreen;
	public static Random rand = new Random();
	SpriteBatch batch;
	SpriteBatch instructionBatch;
	ShapeRenderer shapeRenderer;

	BitmapFont font;
	BitmapFont title;
	BitmapFont instructions;

	//Camera camera;
	public Texture ins;
	Rectangle instructionRect;

	@Override
	public void create() {
		//gameScreen = new GameScreen();
		//setScreen(gameScreen);
		batch = new SpriteBatch();
		ins = new Texture("instruction.png");
		//
		shapeRenderer = new ShapeRenderer();
		font = new BitmapFont();
		title = new BitmapFont();
		instructions = new BitmapFont();
		setScreen(new titleScreen(this));
		//setScreen(new instructionScreen());
		instructionRect = new Rectangle(Gdx.graphics.getWidth() * .20f,
				Gdx.graphics.getHeight() * .65f, ins.getWidth(), ins.getHeight());

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
