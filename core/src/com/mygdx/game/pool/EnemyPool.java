package com.mygdx.game.pool;

import com.badlogic.gdx.audio.Sound;
import com.mygdx.game.base.SpritesPool;
import com.mygdx.game.math.Rect;
import com.mygdx.game.sprite.Enemy;
import com.mygdx.game.sprite.Explosion;
import com.mygdx.game.sprite.MainShip;

public class EnemyPool extends SpritesPool<Enemy> { // изменения происходят во вражеском пуле

    private BulletPool bulletPool;
    private Sound bulletSound;
    private Rect worldBounds;
    private ExplosionPool explosionPool;
    private MainShip mainShip;

    public EnemyPool(BulletPool bulletPool, Sound bulletSound, Rect worldBounds, ExplosionPool explosionPool, MainShip mainShip) {
        this.bulletPool = bulletPool;
        this.bulletSound = bulletSound;
        this.worldBounds = worldBounds;
        this.explosionPool = explosionPool;
        this.mainShip = mainShip;
    }

    @Override
    protected Enemy newObject() {
        return new Enemy(bulletPool, bulletSound, worldBounds, explosionPool, mainShip);
    }
}
