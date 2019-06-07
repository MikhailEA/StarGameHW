package com.mygdx.game.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.base.ActionListener;
import com.mygdx.game.base.BaseScreen;

import com.mygdx.game.math.Rect;
import com.mygdx.game.sprite.Background;
import com.mygdx.game.sprite.ButtonExit;
import com.mygdx.game.sprite.ButtonPlay;
import com.mygdx.game.sprite.Star;



public class MenuScreen extends BaseScreen implements ActionListener {

    private static final int STAR_COUNT = 256;

    private Game game;

    private Texture bg;
    private Background background;
    private TextureAtlas atlas;
    private Star[] starArray;

    private ButtonExit buttonExit;
    private ButtonPlay buttonPlay;

    public MenuScreen(Game game) {
        this.game = game;
    }


    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        background = new Background(new TextureRegion(bg));
        atlas = new TextureAtlas("textures/menuAtlas.tpack");
        starArray = new Star[STAR_COUNT];
        for (int i = 0; i < STAR_COUNT; i++){
            starArray[i] = new Star(atlas);
        }
        buttonExit = new ButtonExit(atlas, this);
        buttonExit.setHeightProportion(0.15f);
        buttonPlay = new ButtonPlay(atlas, this);
        buttonPlay.setHeightProportion(0.2f);

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    private void update(float delta) {
        for (Star star : starArray) {
            star.update(delta);
        }
    }

    private void draw() {
        Gdx.gl.glClearColor(0.4f, 0.3f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        for (Star star : starArray) {
            star.draw(batch);
        }
        buttonExit.draw(batch);
        buttonPlay.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        atlas.dispose();
        super.dispose();
    }

    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        for (Star star : starArray) {
            star.resize(worldBounds);
        }
        buttonExit.resize(worldBounds);
        buttonPlay.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        buttonExit.touchDown(touch, pointer);
        buttonPlay.touchDown(touch, pointer);
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        buttonExit.touchUp(touch, pointer);
        buttonPlay.touchUp(touch, pointer);
        return false;
    }

    @Override
    public void actionPerformed(Object obj) {

    }
}
