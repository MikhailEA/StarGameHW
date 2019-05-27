package com.mygdx.game.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.base.Sprite;
import com.mygdx.game.math.Rect;


public class BadLogic extends Sprite {

    private static final float LEN = 0.005f;

    private Vector2 v;
    private Vector2 touch;
    private Vector2 buf;

    public BadLogic(TextureRegion region) {
        super(region);
        regions[frame].getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        v = new Vector2();
        touch = new Vector2();
        buf = new Vector2();
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        buf.set(touch);
        if (buf.sub(pos).len() <= LEN) {
            pos.set(touch);
        } else {
            pos.add(v);
        }
    }

    @Override
    public void resize(Rect wordBounds) {
        setHeightProportion(0.5f);
        setHeightProportion(0.3f);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        this.touch = touch;
        v.set(touch.cpy().sub(pos)).setLength(LEN);
        return false;
    }
}