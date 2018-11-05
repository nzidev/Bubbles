package com.nzidev.bubbles.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nzidev.bubbles.states.GameStateManager;
import com.nzidev.bubbles.states.MenuState;

public class GameScreen implements Screen {
    private GameStateManager gsm;
    private SpriteBatch batch;
    private float runTime = 0;
    public GameScreen() {
        batch = new SpriteBatch();
        gsm = new GameStateManager();

        gsm.push(new MenuState(gsm));
    }

    @Override
    public void show() {
        Gdx.app.log("gamescreen", "SHOW Screen!!!");
    }

    @Override
    public void render(float delta) {
        runTime += delta;
        Gdx.gl.glClearColor(1, 1, 1, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch, runTime);


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

        gsm.pop();
    }
}
