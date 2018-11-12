package com.nzidev.bubbles.tools;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.nzidev.bubbles.loader.ConstantLoader;
import com.nzidev.bubbles.objects.Baloon;

import com.nzidev.bubbles.states.PlayState;

import java.util.Random;

import static com.nzidev.bubbles.loader.ConstantLoader.circleRadius;

public class Matrix {
    private PlayState playState;
    private byte count;
    private byte  colors,color;
    private float screenWidth, screenHeight;
    private Random random;
    private Array<Baloon> circles;
    private float stepX, stepY,minx,miny, x, y;


    public Matrix(PlayState playState,byte count,byte colors) {
        this.playState = playState;
        this.count = count;
        this.colors = colors;
        screenWidth =  ConstantLoader.screenWidth;
        screenHeight = ConstantLoader.screenHeight;
        random = new Random();

        circles = new Array<Baloon>();
        stepX = (float) (circleRadius*2);
        stepY = (float) (circleRadius * 2.5);

        //find first circle to start printing on workplace
        if ((count & 1) == 0){ // count even
            minx = (float) (screenWidth/2) - ((count/2) * stepX)  + circleRadius;
            miny = (float) (((screenHeight * (ConstantLoader.PLAY_AREA_PROCENT / 100))/2) - ((count/2) * stepY)) + circleRadius + (screenHeight * (ConstantLoader.DOWN_PROCENT / 100)) ;
        }
        else {                  //count odd
            minx = (float) (screenWidth / 2) - ((count / 2) * stepX);
            miny = (float) (((screenHeight * (ConstantLoader.PLAY_AREA_PROCENT / 100)) / 2) - ((count / 2) * stepY)) + (screenHeight * (ConstantLoader.DOWN_PROCENT / 100));
        }

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                x = minx + i * stepX;
                y = miny + j * stepY;
                color = (byte) (random.nextInt(colors + 1) + 1);
                this.circles.add(new Baloon(color, x, y));
            }
        }
    }

    public void drawCircles(SpriteBatch sb, float runTime) {

        for (int i = 0; i < circles.size; i++) {
            sb.draw(circles.get(i).getCircleSprite(), circles.get(i).getPosition().x, circles.get(i).getPosition().y, circleRadius * 2, circleRadius * 2);
        }
    }
}
