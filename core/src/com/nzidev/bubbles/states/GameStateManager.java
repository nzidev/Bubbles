package com.nzidev.bubbles.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class GameStateManager {
    public Stack<State> states;
    public Mode gameMode;

    public enum Mode{
        STEP,TIME,GAMEOVER,LEVEL,UNLIM, WIN
    }
    public GameStateManager (){
        states = new Stack<State>();
    }

    public void push(State state){
        states.push(state);

    }

    public void pop(){
        states.pop().dispose();
    }


    public Mode getGameMode() {
        return gameMode;
    }

    public void setGameMode(Mode gameMode) {
        this.gameMode = gameMode;
    }

    public void set(State state){
        states.pop().dispose();
        states.push(state);
    }

    public void update(float dt){
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb, float runTime){
        states.peek().render(sb, runTime);
    }
}
