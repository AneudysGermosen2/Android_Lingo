package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class titleScreen extends ScreenAdapter {

    MyGdxGame game;
    //Camera camera;


    public titleScreen(MyGdxGame game) {
        this.game = game;
    }

    @Override
    public void show(){
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keyCode) {
                if (keyCode == Input.Keys.SPACE) {
                    //game.setScreen(new GameScreen());
                    //this is where we link the menu to the game screen
                }
                if (keyCode == Input.Keys.I) {
                    game.setScreen(new instructionScreen(game));
                    //this is where we link the menu to the game screen
                }

                return true;
            }
        });






    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, .25f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



        game.batch.begin();
        game.batch.draw(game.ins, game.instructionRect.x, game.instructionRect.y, game.instructionRect.width, game.instructionRect.height);



        if(Gdx.input.justTouched ()){
            Vector2 touchPosition = new Vector2(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
            //Rectangle touchedRect = new Rectangle(Gdx.graphics.getWidth() * .20f, Gdx.graphics.getWidth() * .20f, 1, 1);
            Rectangle touchedRect = new Rectangle(touchPosition.x, touchPosition.y, 1, 1);
            if(Intersector.overlaps(touchedRect, game.instructionRect))
            {
                game.setScreen(new instructionScreen(game));

            }

        }

        game.title.getData().setScale(7, 7);
        game.title.setColor(Color.YELLOW);
        game.title.draw(game.batch, "LINGO", Gdx.graphics.getWidth() * 0.39f, Gdx.graphics.getHeight() * 0.75f);

        game.instructions.getData().setScale(5, 5);
        game.instructions.setColor(Color.YELLOW);
        game.instructions.draw(game.batch, "Instructions", Gdx.graphics.getWidth() * .20f, Gdx.graphics.getHeight() * .65f);


        game.font.getData().setScale(5, 5);
        game.font.setColor(Color.YELLOW);
        game.font.draw(game.batch, "Press SPACE to play", Gdx.graphics.getWidth() * .20f, Gdx.graphics.getHeight() * .25f);



        game.batch.end();
    }

    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }
}
