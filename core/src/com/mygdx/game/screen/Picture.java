package com.mygdx.game.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public class Picture extends Image { // Image

    private float stagewidth;
    private float stageheight;


    public Picture(Texture Picture, float width, float height) {
        super(new SpriteDrawable(new Sprite(Picture)));
        this.stagewidth=width;
        this.stageheight=height;
        setWidth(getWidth()-getWidth()/2);
        setHeight(getHeight()-getHeight()/2);
        setPosition(stagewidth/2-getWidth()/2,stageheight/100);

    }

    @Override
    public float getWidth() {
        return super.getWidth();
    }

    @Override
    public float getHeight() {
        return super.getHeight();
    }

    @Override
    public void setPosition(float x, float y) {
        super.setPosition(x, y);
    }

    public void position(float x, float y){

        setPosition(x,y);

    }

}