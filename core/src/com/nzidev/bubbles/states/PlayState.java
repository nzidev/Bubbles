package com.nzidev.bubbles.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.nzidev.bubbles.loader.ConstantLoader;
import com.nzidev.bubbles.loader.ResourseLoader;
import com.nzidev.bubbles.tools.Matrix;

public class PlayState extends State {
    Vector3 touchPos;
    private Sprite backgroundplay;
    private Matrix matrix;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, ConstantLoader.screenWidth, ConstantLoader.screenHeight);
        touchPos = new Vector3();
        Gdx.input.setCatchBackKey(true);
        backgroundplay = new Sprite(ResourseLoader.bgplay);
        matrix = new Matrix(this, (byte)8, (byte)3);
    }

    @Override
    protected void handleInput() {
        touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
        camera.unproject(touchPos);
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb, float runTime) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.disableBlending();
        sb.draw(backgroundplay, 0,0, ConstantLoader.screenWidth, ConstantLoader.screenHeight);
        sb.enableBlending();
        matrix.drawCircles(sb, runTime);
        sb.end();
    }

    @Override
    public void dispose() {
        gsm.set(new MenuState(gsm));
    }
}
