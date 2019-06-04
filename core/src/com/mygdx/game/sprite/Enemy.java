package com.mygdx.game.sprite;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.math.Rect;
import com.mygdx.game.pool.BulletPool;
import com.mygdx.game.pool.ExplosionPool;

public class Enemy extends Ship { // изменения происходят во вражеском корабле

    private MainShip mainShip;

    private enum State {DESCENT, FIGHT};

    private State state;

    private Vector2 v0 = new Vector2();
    private Vector2 dropV = new Vector2(0, -0.20f);


    public Enemy(BulletPool bulletPool, Sound bulletSound, Rect worldBounds, ExplosionPool explosionPool, MainShip mainShip) {
        this.bulletPool = bulletPool;
        this.bulletSound = bulletSound;
        this.worldBounds = worldBounds;
        this.explosionPool = explosionPool;
        this.mainShip = mainShip;
        this.v.set(v0);
        this.state = State.DESCENT;
        this.dropV = new Vector2(dropV);
        this.bulletV = new Vector2();
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        switch (state) {
            case DESCENT:
                if (getTop() <= getTop()){
                    v.set(v0);
                    state = State.FIGHT;
                } break;
            case FIGHT:
                reloadTimer += delta;
                if (reloadTimer >= reloadInterval) {
                    reloadTimer = 0f;
                    destroy();
                }
        } if (getBottom() < worldBounds.getBottom()) {
                bang();
        }
        return;
    }

    public void set(
            TextureRegion[] regions,
            Vector2 v0,
            TextureRegion bulletRegion,
            float bulletHeight,
            float bulletVY,
            int damage,
            float reloadInterval,
            float height,
            int hp
    ) {
        this.regions = regions;
        this.v0.set(v0);
        this.bulletRegion = bulletRegion;
        this.bulletHeight = bulletHeight;
        this.bulletV.set(0, bulletVY);
        this.damage = damage;
        this.reloadInterval = reloadInterval;
        this.reloadTimer = reloadInterval;
        setHeightProportion(height);
        this.hp = hp;
        this.v.set(dropV);
        this.state = State.DESCENT;
    }
}
