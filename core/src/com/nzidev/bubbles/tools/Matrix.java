package com.nzidev.bubbles.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.nzidev.bubbles.loader.ConstantLoader;
import com.nzidev.bubbles.loader.LevelLoader;
import com.nzidev.bubbles.objects.Baloon;

import com.nzidev.bubbles.objects.Branch;
import com.nzidev.bubbles.states.PlayState;

import java.util.Arrays;
import java.util.Random;

import static com.nzidev.bubbles.loader.ConstantLoader.circleRadius;

public class Matrix {
    private PlayState playState;
    private byte count;
    private byte  colors,color;
    private float screenWidth, screenHeight;
    private Random random;
    private Array<Baloon> circles;
    private Array<Branch> branches;
    private float stepX, stepY,minx,miny, x, y;
    private byte lvl, dragCircle;
    private String[] branchArrayStr;
    private byte[][] branchArray;
    private float evX,evY,dragX,dragY;
    private boolean drag = false;
    public Matrix(PlayState playState,byte count,byte colors, String lvlstr) {

        this.lvl = Byte.parseByte(lvlstr);
        this.playState = playState;
        this.count = count;
        this.colors = colors;
        screenWidth =  ConstantLoader.screenWidth;
        screenHeight = ConstantLoader.screenHeight;
        random = new Random();
        branchArrayStr = LevelLoader.stonesLevel[lvl].split(";");
        branchArray = new byte[branchArrayStr.length][2];
        for(int i=1;i<branchArrayStr.length;i++)
        {
            branchArray[i][0] = Byte.decode(branchArrayStr[i].split("#")[0]);
            branchArray[i][1] = Byte.decode(branchArrayStr[i].split("#")[1]);

        }


        branches = new Array<Branch>();
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

        for(int i=1;i<branchArrayStr.length;i++)
        {
            x = minx + branchArray[i][0] * stepX;
            //x = minx + Float.parseFloat(branchArrayStr[i].split("#")[0]) * stepX;
            y = miny + branchArray[i][1] * stepY;
            this.branches.add(new Branch(x, y + circleRadius / 2));

        }

        boolean branchFlag = false;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                x = minx + i * stepX;
                y = miny + j * stepY;

                //change this code when understand how to do it witout "for"
                for(int b=1;b<branchArray.length;b++)
                {
                    if (branchArray[b][0] == i && branchArray[b][1] == j)
                    {
                        branchFlag = true;
                    }
                }

                if(!branchFlag) {
                    color = (byte) (random.nextInt(colors + 1) + 1);
                    this.circles.add(new Baloon(color, x, y, i * j));
                }
                branchFlag = false;
            }
        }
    }


    public void ClickCircle(float x, float y) {  //if player click on baloon

        evX = x;
        evY = y;
        if (Gdx.input.justTouched())
        {
            for (byte i = 0; i < circles.size; i++) {
                if (Math.pow(evX - (circles.get(i).getPosition().x + circleRadius), 2) + Math.pow(evY - (circles.get(i).getPosition().y + circleRadius), 2) <= Math.pow(circleRadius, 2)) {
                    drag = true;
                    dragCircle = i;
                    dragX = evX - circles.get(i).getPosition().x;
                    dragY = evY - circles.get(i).getPosition().y;
                    /*Gdx.app.log("Matrix", " minx  " + minx);
                    Gdx.app.log("Matrix", " dragX  " + dragX);
                    Gdx.app.log("Matrix", " dragY  " + dragY);

                    Gdx.app.log("Matrix", " circles.get(i).getPosition().x  " + circles.get(i).getPosition().x);
                    Gdx.app.log("Matrix", " getStartX  " + circles.get(i).getStartX());*/
                }
            }
        }
        if (Gdx.input.isTouched() && drag) {

            circles.get(dragCircle).circleMove(evX - dragX, evY - dragY, circles.size);

        }

     //   changed = false;
    }

    public void drawCircles(SpriteBatch sb) {

        for (int i = 0; i < circles.size; i++) {
            sb.draw(circles.get(i).getCircleSprite(), circles.get(i).getPosition().x, circles.get(i).getPosition().y, circleRadius * 2, circleRadius * 2);
        }
    }

    public void drawBranches(SpriteBatch sb) {
        for (int i = 0; i < branches.size; i++) {
            sb.draw(branches.get(i).getBranchSprite(), branches.get(i).getPosition().x,branches.get(i).getPosition().y);
        }
    }
}
