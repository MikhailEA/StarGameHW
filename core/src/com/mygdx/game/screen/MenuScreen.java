package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private SpriteBatch batch;
    private Texture img;
    OrthographicCamera camera;

    private Vector2 touch;
    private Vector2 v;
    private Vector2 pos;
    private float topBorder;
    private float rightBorder;

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        touch = new Vector2();
        v = new Vector2(0.6f,0.6f);
        pos = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.4f, 0.3f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, pos.x, pos.y);
        batch.end();
        topBorder = pos.x + img.getWidth();
        rightBorder = pos.y + img.getHeight();

        if( topBorder < Gdx.graphics.getWidth()
                && rightBorder < Gdx.graphics.getHeight()){
            pos.add(v);
        } else {
            v.set(-0.6f, -0.6f);
            pos.add(v);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT));//нажатие по кнопкам
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT));
        if(Gdx.input.isKeyPressed(Input.Keys.UP));
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN));

        if (pos.x < 0) pos.x = 0; // ограничение по экрану
        if (pos.y < 0) pos.y = 0;

    }



    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);

        System.out.println("touch.x = " + touch.x + " touch.y = " + touch.y);
        return false;
    }
}
