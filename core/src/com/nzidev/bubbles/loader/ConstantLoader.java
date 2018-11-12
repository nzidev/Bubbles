package com.nzidev.bubbles.loader;

import com.badlogic.gdx.Gdx;

public class ConstantLoader {
    public static final float SPLASH_TIME = 0.8f;      //logo show and hide time in sec.
    public static final float LOGO_TIME = 0.4f;      //logo time in sec.

    public static float screenWidth = Gdx.graphics.getWidth();
    public static float screenHeight = Gdx.graphics.getHeight();

    public static final int CIRCLE_COUNT = 8;         //count of circles. 6 for desktop, 8 for mobile
    private static final double LEFT_PROCENT = 6.25;   //margin left in procent
    private static final double RIGHT_PROCENT = 6.25;  //margin left in procent
    public static final double PLAY_AREA_PROCENT = 70.5; //area of game in procent
    public static final float DOWN_PROCENT = 8;       //margin bottom in procent
    private static final double PLAY_AREA_HORIZONTAL_PROCENT = 100 - LEFT_PROCENT - RIGHT_PROCENT; //horizontal area in procent
    public static float circleRadius = ((screenWidth * ((float)PLAY_AREA_HORIZONTAL_PROCENT)/100)/(CIRCLE_COUNT*2));       //40 for mobile, 25 for desktop
}
