package com.mygdx.game.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.base.ScaledTouchUpButton;
import com.mygdx.game.math.Rect;
import com.mygdx.game.screen.MenuScreen;

import java.awt.event.ActionListener;

public class ButtonExit extends ScaledTouchUpButton {

    public ButtonExit(TextureAtlas atlas, MenuScreen actionListener) {
        super(atlas.findRegion("btExit"), actionListener, 0.5f);
        setHeightProportion(0.18f);
    }

    @Override
    public void resize(Rect worldBounds) {
        setLeft(worldBounds.getLeft() + 0.03f);
        setBottom(worldBounds.getBottom() + 0.03f);
    }

    @Override
    public void actionPerformed(Object obj) {

    }
}
