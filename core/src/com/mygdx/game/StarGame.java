package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class StarGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	TextureRegion region;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		img = new Texture("dark.jpg");
		//region = new TextureRegion(img, 0, 0, 2048,1024 );

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.4f, 0.3f, 0.8f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		//batch.setColor(0.7f,0.2f,0.33f,0.05f);
		batch.draw(img, 0, 0,1024,512);
		//batch.setColor(0.7f,0.2f,0.33f,0.6f);
		//batch.draw(region, 10,10);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
