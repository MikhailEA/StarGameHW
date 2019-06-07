package com.mygdx.game.base;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.screen.MenuScreen;

public abstract class ScaledTouchUpButton extends Sprite {

    private static final float PRESS_SCALE = 0.9f;
    private int pointer;
    private boolean pressed;
    private ActionListener actionListener;

    public ScaledTouchUpButton(TextureRegion region, ActionListener actionListener, float v) {
        super(region);
        this.actionListener = actionListener;
    }



    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        if (pressed || !isMe(touch)) {
            return false;
        }
        this.pointer = pointer;
        this.scale = PRESS_SCALE;
        this.pressed = true;
        return false;

    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        if (this.pointer != pointer || !pressed) {
            return false;
        }
        if (isMe(touch)) {
            actionListener.actionPerformed(this);

        }
        pressed = false;
        scale = 1f;
        return false;
    }

    @Override
    public void actionPerformed(Object obj) {

    }
}
