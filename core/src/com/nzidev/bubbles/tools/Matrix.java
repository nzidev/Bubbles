package com.nzidev.bubbles.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.utils.Array;
import com.nzidev.bubbles.loader.ConstantLoader;
import com.nzidev.bubbles.loader.LevelLoader;
import com.nzidev.bubbles.objects.Baloon;

import com.nzidev.bubbles.states.PlayState;

import java.util.Random;

import static com.nzidev.bubbles.loader.ConstantLoader.circleRadius;

//class for working with matrix of game area, structure and logic of game area
public class Matrix {
    private PlayState playState;
    private byte count;
    private byte  colors,color;
    private float screenWidth, screenHeight;
    private Random random;
    private Array<Baloon> circles;

    private float stepX, stepY,minx,miny, x, y;
    private byte lvl, dragCircle;
    private String[] branchArrayStr;
    private byte[][] branchArray;
    private float evX,evY,dragX,dragY;
    private boolean drag,changed = false;
    private Circle playerCircle;
    public Matrix(PlayState playState,byte count,byte colors, String lvlstr) {

        this.lvl = Byte.parseByte(lvlstr);
        this.playState = playState;
        this.count = count;
        this.colors = colors;
        screenWidth =  ConstantLoader.screenWidth;
        screenHeight = ConstantLoader.screenHeight;

        playerCircle = new Circle(0, 0, circleRadius / 2); // Need object Circle for Intersector.overlaps function in Baloon.java
        random = new Random();
        branchArrayStr = LevelLoader.stonesLevel[lvl].split(";");

        branchArray = new byte[branchArrayStr.length-1][2];
        for(int i=1;i<branchArrayStr.length;i++)
        {
            branchArray[i-1][0] = Byte.decode(branchArrayStr[i].split("#")[0]);
            branchArray[i-1][1] = Byte.decode(branchArrayStr[i].split("#")[1]);

        }



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


        boolean branchFlag = false;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                x = minx + i * stepX;
                y = miny + j * stepY;

                //change this code when understand how to do it witout "for"
                for(int b=0;b<branchArray.length;b++)
                {
                    if (branchArray[b][0] == i && branchArray[b][1] == j)
                    {
                        x = minx + branchArray[i][0] * stepX;
                        //x = minx + Float.parseFloat(branchArrayStr[i].split("#")[0]) * stepX;
                        y = miny + branchArray[i][1] * stepY;

                        this.circles.add(new Baloon((short)0, x, y, count*branchArray[i][0] + branchArray[i][1], Baloon.ObjectForm.Branch));
                        branchFlag = true;
                    }
                }

                if(!branchFlag) {
                    color = (byte) (random.nextInt(colors + 1) + 1);
                    this.circles.add(new Baloon(color, x, y, count*i + j, Baloon.ObjectForm.Baloon));
                }
                branchFlag = false;
            }
        }
    }

    public void checkEqual() {
        int eqal = 1;
        int nextrowbaloon;


        for (int i = 0; i < count; i++) {

            for (int col = 0 + count * i; col < count - 1 + count * i; col++){    //col

                //if (circles.get(col).getForm() == Baloon.ObjectForm.Baloon &&(col + 1) == (count - 1 + count * i) && (circles.get(col).getColor() == circles.get(col + 1).getColor())) {
                if ((circles.get(col).getForm() == Baloon.ObjectForm.Baloon) && (circles.get(col).getColor() == circles.get(col + 1).getColor())) {
                    Gdx.app.log("Matrix", " check j " + col);
                }
            }



//
//            eqal = 1;
//            for (int j = 0 + col; j < count * count - count + col; j = j + count) {   //row
//                if (stoneEnable && col == xStone && j ==yStone )
//                {
//                    continue;
//                }
//                //  Gdx.app.log("Matrix", " check j " + j);
//                nextrowbaloon = j + count;
//                if ((j == ((count * (count - 1) + col)) - count) && (circles.get(j).getColor() == circles.get(nextrowbaloon).getColor())) { //last slot
//                    eqal++;
//                    boom.setBoom(eqal, nextrowbaloon, count, true, circles, numDragCircle, dragCircle);
//                    eqal = 1;
//                } else if (circles.get(j).getColor() == circles.get(nextrowbaloon).getColor()) {
//                    eqal++;
//                } else {
//                    boom.setBoom(eqal, j, count, true, circles, numDragCircle, dragCircle);
//                    eqal = 1;
//                }
//                if (eqal >= 3) {
//                    exposionStep = true;
//                }
//                checkRowMaybe(j, col, count);
//            }
        }
    }

    public void ClickCircle(float x, float y) {  //if player click on baloon
        evX = x;
        evY = y;
        changed = false;
        //*............Click baloon.............*//
        if (Gdx.input.justTouched())
        {
            for (byte i = 0; i < circles.size; i++) {
                if (Math.pow(evX - (circles.get(i).getPosition().x + circleRadius), 2) + Math.pow(evY - (circles.get(i).getPosition().y + circleRadius), 2) <= Math.pow(circleRadius, 2)) {
                    drag = true;
                    dragCircle = i;
                    dragX = evX - circles.get(i).getPosition().x;
                    dragY = evY - circles.get(i).getPosition().y;
                    /*Gdx.app.log("Matrix", " minx  " + minx);                   */
                }
            }
        }

        //*............Move Clicked baloon.............*/
        if (Gdx.input.isTouched() && drag) {
            circles.get(dragCircle).circleMove(evX - dragX, evY - dragY, circles.size);
            playerCircle.setPosition(circles.get(dragCircle).getPosition().x, circles.get(dragCircle).getPosition().y);
        }

        //*...........Drop off.........*/
        if (!(Gdx.input.isTouched()) && drag) {
            drag = false;
            for (int i = 0; i < circles.size; i++) {
                if (i != dragCircle && circles.get(i).overlaps(playerCircle)) {

                    circles.get(dragCircle).setPosition(circles.get(dragCircle).getStartX(), circles.get(dragCircle).getStartY());
                    playerCircle.setPosition(circles.get(dragCircle).getStartX(), circles.get(dragCircle).getStartY());
                    circles.get(i).changeBaloonColor(circles.get(dragCircle));
                    //numDragCircle = i;
                    changed = true;
                }
            }

            if (!changed) { //no change, return to start position
                circles.get(dragCircle).setPosition(circles.get(dragCircle).getStartX(), circles.get(dragCircle).getStartY());
                playerCircle.setPosition(circles.get(dragCircle).getStartX(), circles.get(dragCircle).getStartY());
            }
            checkEqual();
        }
    }

    public void drawCircles(SpriteBatch sb) {

        for (int i = 0; i < circles.size; i++) {
            sb.draw(circles.get(i).getCircleSprite(), circles.get(i).getPosition().x, circles.get(i).getPosition().y, circleRadius * 2, circleRadius * 2);
        }
    }

}
