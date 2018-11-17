package com.nzidev.bubbles.objects;

import com.badlogic.gdx.Gdx;
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
    public short color;
    public int id;
    private float screenWidth, screenHeight;
    public float circle_radius;
    public enum BaloonState{
        NORMAL, GREY, BLACK, CROSS, BOOM
    }



    public Baloon(short color, float x, float y, int id) {
        super(x, y);

        this.id = id;
        circle_radius = ConstantLoader.circleRadius;
        velocity = new Vector2(0,0);
        states = BaloonState.NORMAL;
        circleSprite = ResourseLoader.colorsArray[color];
        boundsCircle = new Circle(x,y,ConstantLoader.circleRadius);
        screenWidth = ConstantLoader.screenWidth;
        screenHeight     = ConstantLoader.screenHeight;
    }

    public short getColor() {
        return color;
    }

    public void setColor(short color) {
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
    public int getId() { return id;}

    public void circleMove(float x, float y, int count){
        position.x = x;
        position.y = y;
        if (position.x - startX > circle_radius*1.5 ) {
            position.y = startY;
            //   if (position.x > startX + circle_radius*2 + (screenHeight / count))
            position.x = startX + circle_radius*2 + (screenHeight / (count*2));
        }
        if (startX - position.x > circle_radius*1.5 ) {
            position.y = startY;
            // if (position.x < startX - circle_radius*2 - (screenHeight / count))
            position.x = startX - circle_radius*2 - (screenHeight / (count*2));
        }
        if (position.y - startY > circle_radius*1.5) {
            position.x = startX;
            //  if (position.y > startY + circle_radius*2 + (screenWidth / count))
            position.y = startY + circle_radius*2 + (screenWidth / (count*2));
        }
        if (startY - position.y > circle_radius*1.5) {
            position.x = startX;
            // if (position.y < startY - circle_radius*2 - (screenWidth / count))
            position.y = startY - circle_radius*2 - (screenWidth / (count*2));
        }

        boundsCircle.setPosition(position.x,position.y);
    }

    public void setPosition(float x, float y) {
        this.position.x = x;
        this.position.y = y;
        boundsCircle.setPosition(x,y);
    }
}
