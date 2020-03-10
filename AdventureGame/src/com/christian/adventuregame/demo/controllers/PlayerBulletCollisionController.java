package com.christian.adventuregame.demo.controllers;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventureengine.utils.Collision;
import com.christian.adventuregame.demo.data.Bullet;
import com.christian.adventuregame.demo.data.FloatTextEffect;
import com.christian.adventuregame.demo.data.State;

import java.awt.*;

public class PlayerBulletCollisionController extends Controller {
    @Override
    public void Update(float deltaTime) {
        for (int i = 0; i < State.world.bullets.size(); i++) {
            Bullet bullet = State.world.bullets.get(i);
            if (bullet.isEnemy && Collision.AABB(State.world.player.GetBox(), bullet.GetBox())) {
                State.world.bullets.remove(bullet);
                State.floatTextEffects.add(new FloatTextEffect("-" + bullet.type.damage, new Vector2(State.world.player.Position), 0.3f, 0.9f, Color.red));

                // TODO: PLAY SOUND EFFECT
                State.world.player.stats.health -= bullet.type.damage;
            }
        }
    }
}
