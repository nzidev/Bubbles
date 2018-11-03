package com.nzidev.bubbles.tools;

import aurelienribon.tweenengine.TweenAccessor;

public class ValueAccesor implements TweenAccessor<Value>{
    @Override
    public int getValues(Value target, int tweenType, float[] returnValues) {
        returnValues[0] = target.getVal();
        return 1;
    }

    @Override
    public void setValues(Value target, int tweenType, float[] newValues) {
        target.setVal(newValues[0]);
    }
}
