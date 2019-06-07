package com.mygdx.game.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.base.ScaledTouchUpButton;
import com.mygdx.game.math.Rect;
import com.mygdx.game.screen.GameScreen;
import com.mygdx.game.screen.MenuScreen;

import java.awt.event.ActionListener;


public class ButtonPlay extends ScaledTouchUpButton {

    private Game game;

    public ButtonPlay(TextureAtlas atlas, MenuScreen actionListener) {
        super(atlas.findRegion("btPlay"), actionListener, 0.5f);
        setHeightProportion(0.2f);
    }

    @Override
    public void resize(Rect worldBounds) {
        setRight(worldBounds.getRight() - 0.03f);
        setBottom(worldBounds.getBottom() + 0.03f);
    }

    @Override
    public void actionPerformed(Object obj) {

    }
}
