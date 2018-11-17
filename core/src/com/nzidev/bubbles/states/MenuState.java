package com.nzidev.bubbles.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.nzidev.bubbles.loader.ConstantLoader;
import com.nzidev.bubbles.loader.LevelLoader;
import com.nzidev.bubbles.loader.ResourseLoader;

public class MenuState extends State{
    private Sprite background;
    private TextButton buttonExit;
    private Stage stage;
    private Table table;
    private boolean playButtonClick = false;
    public MenuState(GameStateManager gsm) {
        super(gsm);
        stage = new Stage();

        Gdx.input.setInputProcessor(stage);

        table = new Table();
        table.setBounds(0,0, ConstantLoader.screenWidth, ConstantLoader.screenHeight);



        background = new Sprite(ResourseLoader.bg);


        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = ResourseLoader.skin.getDrawable("OnSound");
        textButtonStyle.down = ResourseLoader.skin.getDrawable("OffSound");
        textButtonStyle.pressedOffsetX = 1;
        textButtonStyle.pressedOffsetY = -1;
        textButtonStyle.font = ResourseLoader.font;



        buttonExit = new TextButton("VADIM", textButtonStyle);
        buttonExit.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                System.out.println("Button Pressed");
                playButtonClick = true;
            }
        });

        table.add(buttonExit).padBottom(320);
        //table.debug();
        stage.addActor(table);

    }

    @Override
    protected void handleInput() {



    }

    @Override
    public void update(float dt) {
        if(playButtonClick)
        {
            System.out.println("Button PlayState");
            gsm.set(new PlayState(gsm, LevelLoader.levels[1]));
            playButtonClick = false;
        }
    }

    @Override
    public void render(SpriteBatch sb, float runTime) {
        sb.begin();
        sb.draw(background,0,0,ConstantLoader.screenWidth,ConstantLoader.screenHeight);
        sb.end();
        stage.act(runTime);
        stage.draw();
    }

    @Override
    public void dispose() {

    }
}
