package com.nzidev.bubbles.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.nzidev.bubbles.loader.ConstantLoader;
import com.nzidev.bubbles.loader.ResourseLoader;

public class Baloon extends object {
    private Vector2 velocity;
    private BaloonState states;
    public Sprite circleSprite;
    private Circle boundsCircle;
    public byte color;
    public enum BaloonState{
        NORMAL, GREY, BLACK, CROSS, BOOM
    }
    public Baloon(short color, float x, float y) {
        super(x, y);


        velocity = new Vector2(0,0);
        states = BaloonState.NORMAL;
        circleSprite = ResourseLoader.colorsArray[color];
        boundsCircle = new Circle(x,y,ConstantLoader.circleRadius);
    }

    public short getColor() {
        return color;
    }

    public void setColor(byte color) {
        this.color = color;
        changeColor(color);
    }

    private void changeColor(short color) {

        switch (states) {
            case BLACK:
                this.circleSprite = ResourseLoader.circBlack;
                break;
            case CROSS:
                this.circleSprite = ResourseLoader.colorsStarArray[color];
                break;
            case GREY:
                this.circleSprite = ResourseLoader.colorsGrayArray[color];
                break;
            case NORMAL:
                this.circleSprite = ResourseLoader.colorsArray[color];
                break;
        }
    }

    public Sprite getCircleSprite() {
        return circleSprite;
    }


}
