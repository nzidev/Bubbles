package com.nzidev.bubbles.objects;

import com.badlogic.gdx.math.Vector2;
import com.nzidev.bubbles.loader.ConstantLoader;

public class object {
    public int circle_Height, circle_Width;
    public float circle_radius;
    public float startX, startY;
    public Vector2 position;

    public float getStartX() {
        return startX;
    }

    public float getStartY() {
        return startY;
    }

    public object(float x, float y) {

        startX = x;// - ConstantLoader.circleRadius;
        startY = y;// - ConstantLoader.circleRadius;
        position = new Vector2(x ,y );
    }
    public Vector2 getPosition() {
        return position;
    }
}
