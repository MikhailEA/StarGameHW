package com.mygdx.game.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.base.ScaledTouchUpButton;
import com.mygdx.game.screen.GameScreen;

import java.awt.event.ActionListener;


public class ButtonNewGame extends ScaledTouchUpButton {

    private Game game;

    public ButtonNewGame(TextureAtlas atlas, GameScreen actionListener) {
        super(atlas.findRegion("button_new_game"), actionListener, 0.5f);
        setHeightProportion(0.18f);
        setBottom(0.009f);
    }

    @Override
    public void action() {

    }
}
