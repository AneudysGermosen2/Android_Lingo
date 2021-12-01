package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;

public class instructionScreen extends ScreenAdapter {
    MyGdxGame game;



    public instructionScreen(MyGdxGame game) {
        this.game = game;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, .25f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();


        game.instructions.getData().setScale(5, 5);
        game.instructions.setColor(Color.YELLOW);
        game.instructions.draw(game.batch, "you can guess up to 5 words", Gdx.graphics.getWidth() * .05f, Gdx.graphics.getHeight() * .65f);
        game.instructions.draw(game.batch, "the letters in your guess will", Gdx.graphics.getWidth() * .05f, Gdx.graphics.getHeight() * .55f);
        game.instructions.draw(game.batch, "be colored green if they match", Gdx.graphics.getWidth() * .05f, Gdx.graphics.getHeight() * .45f);
        game.instructions.draw(game.batch, "the placement of the actual word,", Gdx.graphics.getWidth() * .03f, Gdx.graphics.getHeight() * .35f);
        game.instructions.draw(game.batch, "yellow if the are just contained,", Gdx.graphics.getWidth() * .05f, Gdx.graphics.getHeight() * .25f);
        game.instructions.draw(game.batch, "red if the letter doest exist in the word", Gdx.graphics.getWidth() * .05f, Gdx.graphics.getHeight() * .15f);





        game.batch.end();
    }




}
