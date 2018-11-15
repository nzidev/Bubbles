package com.nzidev.bubbles.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.nzidev.bubbles.loader.ResourseLoader;

public class Branch extends object {
    public Sprite branchSprite;
    public Branch(float x, float y) {
        super(x, y);

        branchSprite = ResourseLoader.branch;
    }

    public Sprite getBranchSprite() {
        return branchSprite;
    }
}
