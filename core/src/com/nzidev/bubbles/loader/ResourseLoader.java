package com.nzidev.bubbles.loader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class ResourseLoader {
    private static TextureAtlas atlas;
    public static Sprite logo, bg, bgplay,bgLvl, info, gameType, exit, win, settings ;
    public static Sprite circBlue, circBlue2, circGreen,circPurple, circRed, circYellow;
    public static Sprite circBlueGrey, circBlue2Grey, circGreenGrey, circPurpleGrey, circRedGrey, circYellowGrey, circBlueStar,circBlue2Star, circGreenStar, circPurpleStar;
    public static Sprite circRedStar, circYellowStar, circBlack;

    public static Sprite plybtn, progressStart, soundOn, soundOff, Score, HighScore, StepImg, TimeImg, boom1, boom2, boom3, soulOfBaloon;

    public static Sprite flash1;
    public static Sprite flash2;
    public static Sprite flash3;
    public static Animation boomAnimation;
    public static Animation flashBaloonAnimation;
    public static Animation[] flashArray = new Animation[7];
    public static BitmapFont font, shadow, whiteFont;

    public static Sprite[] colorsArray = new Sprite[7];
    public static Sprite[] colorsGrayArray = new Sprite[7];
    public static Sprite[] colorsStarArray = new Sprite[7];
    private static Preferences preferences;

    public static Skin skin;

    public static void load() {
        preferences = Gdx.app.getPreferences("BubbleBoom");
        if (!preferences.contains("highScore")) {
            preferences.putInteger("highScore", 0);
        }

        atlas = new TextureAtlas(Gdx.files.internal("Texture/Texture.pack"), true);

        skin = new Skin(atlas);

        logo = new Sprite(atlas.findRegion("Info"));
        logo.flip(false, true);
        bg = new Sprite(atlas.findRegion("BackgroundMain"));
        bg.flip(false, true);
        plybtn = new Sprite(atlas.findRegion("OnSound"));
        plybtn.flip(false, true);
        soundOn = new Sprite(atlas.findRegion("OnSound"));
        soundOn.flip(false, true);

        bgplay = new Sprite(atlas.findRegion("BackgroundGame"));
        bgplay.flip(false, true);


        font = new BitmapFont(Gdx.files.internal("fonts/text.fnt"));
        font.getData().setScale(0.5F, 0.6F);

       /* settings = new Sprite(atlas.findRegion("Settings"));
        settings.flip(false, true);
        info = new Sprite(atlas.findRegion("Info"));
        info.flip(false, true);
        gameType = new Sprite(atlas.findRegion("typeGame"));
        gameType.flip(false, true);
        exit = new Sprite(atlas.findRegion("exit"));
        exit.flip(false, true);
        win = new Sprite(atlas.findRegion("win"));
        win.flip(false, true);
        progressStart = new Sprite(atlas.findRegion("progressStart"));
        progressStart.flip(false, true);
        soundOn = new Sprite(atlas.findRegion("OnSound"));
        soundOn.flip(false, true);
        soundOff = new Sprite(atlas.findRegion("OffSound"));
        soundOff.flip(false, true);
        HighScore = new Sprite(atlas.findRegion("HighScore"));
        HighScore.flip(false, true);
        Score = new Sprite(atlas.findRegion("Score"));
        Score.flip(false, true);
        TimeImg = new Sprite(atlas.findRegion("Time"));
        TimeImg.flip(false, true);
        StepImg = new Sprite(atlas.findRegion("Time"));
        StepImg.flip(false, true);



        bgLvl = new Sprite(atlas.findRegion("LVL"));
        bgLvl.flip(false, true);
        circBlue = new Sprite(atlas.findRegion("BaloonBlue"));
        circBlue.flip(false, true);
        circBlue2 = new Sprite(atlas.findRegion("BaloonLightBlue"));
        circBlue2.flip(false, true);
        circGreen = new Sprite(atlas.findRegion("BaloonGreen"));
        circGreen.flip(false, true);
        circPurple = new Sprite(atlas.findRegion("BaloonPurple"));
        circPurple.flip(false, true);
        circRed = new Sprite(atlas.findRegion("BaloonRed"));
        circRed.flip(false, true);
        circYellow = new Sprite(atlas.findRegion("BaloonOrange"));
        circYellow.flip(false, true);
        circBlueGrey = new Sprite(atlas.findRegion("BaloonBlueDark"));
        circBlueGrey.flip(false, true);
        circBlue2Grey = new Sprite(atlas.findRegion("BaloonLightBlueDark"));
        circBlue2Grey.flip(false, true);
        circGreenGrey = new Sprite(atlas.findRegion("BaloonGreenDark"));
        circGreenGrey.flip(false, true);
        circPurpleGrey = new Sprite(atlas.findRegion("BaloonPurpleDark"));
        circPurpleGrey.flip(false, true);
        circRedGrey = new Sprite(atlas.findRegion("BaloonRedDark"));
        circRedGrey.flip(false, true);
        circYellowGrey = new Sprite(atlas.findRegion("BaloonOrangeDark"));
        circYellowGrey.flip(false, true);
        circBlueStar = new Sprite(atlas.findRegion("BaloonBlueStar"));
        circBlueStar.flip(false, true);
        circBlue2Star = new Sprite(atlas.findRegion("BaloonLightBlueStar"));
        circBlue2Star.flip(false, true);
        circGreenStar = new Sprite(atlas.findRegion("BaloonGreenStar"));
        circGreenStar.flip(false, true);
        circPurpleStar = new Sprite(atlas.findRegion("BaloonPurpleStar"));
        circPurpleStar.flip(false, true);
        circRedStar = new Sprite(atlas.findRegion("BaloonRedStar"));
        circRedStar.flip(false, true);
        circYellowStar = new Sprite(atlas.findRegion("BaloonOrangeStar"));
        circYellowStar.flip(false, true);
        circBlack = new Sprite(atlas.findRegion("BaloonBlack"));
        circBlack.flip(false, true);
        colorsArray[0] = new Sprite(circBlack);
        colorsArray[1] = new Sprite(circBlue);
        colorsArray[2] = new Sprite(circBlue2);
        colorsArray[3] = new Sprite(circGreen);
        colorsArray[4] = new Sprite(circPurple);
        colorsArray[5] = new Sprite(circRed);
        colorsArray[6] = new Sprite(circYellow);
        colorsGrayArray[0] = new Sprite(circBlack);
        colorsGrayArray[1] = new Sprite(circBlueGrey);
        colorsGrayArray[2] = new Sprite(circBlue2Grey);
        colorsGrayArray[3] = new Sprite(circGreenGrey);
        colorsGrayArray[4] = new Sprite(circPurpleGrey);
        colorsGrayArray[5] = new Sprite(circRedGrey);
        colorsGrayArray[6] = new Sprite(circYellowGrey);
        colorsStarArray[0] = new Sprite(circBlack);
        colorsStarArray[1] = new Sprite(circBlueStar);
        colorsStarArray[2] = new Sprite(circBlue2Star);
        colorsStarArray[3] = new Sprite(circGreenStar);
        colorsStarArray[4] = new Sprite(circPurpleStar);
        colorsStarArray[5] = new Sprite(circRedStar);
        colorsStarArray[6] = new Sprite(circYellowStar);
        flash1 = new Sprite(atlas.findRegion("BaloonBlueDark1"));
        flash1.flip(false, true);
        flash2 = new Sprite(atlas.findRegion("BaloonBlueDark2"));
        flash2.flip(false, true);
        flash3 = new Sprite(atlas.findRegion("BaloonBlueDark3"));
        flash3.flip(false, true);
        soulOfBaloon = new Sprite(atlas.findRegion("boom2"));
        soulOfBaloon.flip(false, true);
        TextureRegion[] flash = new TextureRegion[]{flash1, flash2, flash3};
        flashBaloonAnimation = new Animation(0.06F, flash);
        flashBaloonAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        float dta = 0.06F;
        flashArray[0] = new Animation(0.01F, flash);
        flashArray[1] = new Animation(0.06F, flash);
        flashArray[2] = new Animation(0.1F, flash);
        flashArray[3] = new Animation(0.3F, flash);
        flashArray[4] = new Animation(0.5F, flash);
        flashArray[5] = new Animation(0.7F, flash);
        flashArray[6] = new Animation(1.0F, flash);
        flashArray[0].setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        flashArray[1].setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        flashArray[2].setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        flashArray[3].setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        flashArray[4].setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        flashArray[5].setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        flashArray[6].setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        font = new BitmapFont(Gdx.files.internal("fonts/text.fnt"));
        font.getData().setScale(0.5F, 0.6F);
        whiteFont = new BitmapFont(Gdx.files.internal("fonts/whitetext.fnt"));
        shadow = new BitmapFont(Gdx.files.internal("fonts/shadow.fnt"));
        shadow.getData().setScale(0.7F, 0.7F);
        */

    }

    public static void dispose(){
        atlas.dispose();


    }
}