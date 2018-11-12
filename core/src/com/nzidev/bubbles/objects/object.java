package com.nzidev.bubbles.objects;

import com.badlogic.gdx.math.Vector2;
import com.nzidev.bubbles.loader.ConstantLoader;

public class object {
    private int circle_Height, circle_Width;
    private float circle_radius;
    private float startX, startY;
    private Vector2 position;

    public object(float x, float y) {

        startX = x - ConstantLoader.circleRadius;
        startY = y - ConstantLoader.circleRadius;
        position = new Vector2(x ,y );
    }
    public Vector2 getPosition() {
        return position;
    }
}
