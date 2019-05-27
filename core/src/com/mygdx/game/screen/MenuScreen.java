package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.base.BaseScreen;

import com.mygdx.game.math.Rect;
import com.mygdx.game.sprite.Background;
import com.mygdx.game.sprite.BadLogic;


public class MenuScreen extends BaseScreen {


    private Texture bg;
    private Texture badLogicTexture;
    private Background background;
    private BadLogic badLogic;

    @Override
    public void show() {
        super.show();
        bg = new Texture("dark.jpg");
        background = new Background(new TextureRegion(bg));
        badLogicTexture = new Texture("Batman_Arkham_Knight.jpg");
        badLogic = new BadLogic(new TextureRegion(badLogicTexture));
    }

    private void update(float delta) {
        badLogic.update(delta);
    }

    private void draw() {
        Gdx.gl.glClearColor(0.4f, 0.3f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        badLogic.draw(batch);
        batch.end();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        badLogic.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        badLogic.touchDown(touch, pointer);
        return false;
    }
}
