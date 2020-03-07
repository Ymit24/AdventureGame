package com.christian.adventuregame.demo.controllers;

import com.christian.adventureengine.audio.AudioPlayer;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventureengine.utils.Collision;
import com.christian.adventuregame.demo.data.*;
import com.christian.adventuregame.demo.data.archetypes.Archetypes;

import java.awt.*;

public class BulletEnemyCollisionController extends Controller {
	@Override
	public void Update(float deltaTime) {
		for (int enemyIndex = 0; enemyIndex < State.world.enemies.size(); enemyIndex++) {
			Enemy enemy = State.world.enemies.get(enemyIndex);
			for (int bulletIndex = 0; bulletIndex < State.world.bullets.size(); bulletIndex++) {
				Bullet bullet = State.world.bullets.get(bulletIndex);
				if (Collision.AABB(enemy.Position, bullet.Position, enemy.Size, bullet.Size)) {
					State.world.bullets.remove(bullet);
					State.floatTextEffects.add(new FloatTextEffect("-" + State.world.player.weaponType.damage, new Vector2(enemy.Position), 0.3f, 0.9f, Color.red));
					AudioPlayer.Play("hit.wav");
					enemy.health -= State.world.player.weaponType.damage;
					
					if (enemy.health <= 0)
					{
						State.world.enemies.remove(enemy);
						int xpGain = Archetypes.Enemies.Get(enemy.id).xpDrop;
						State.world.player.stats.GainXp(xpGain);
						State.floatTextEffects.add(new FloatTextEffect("+" + xpGain, new Vector2(State.world.player.Position), 1.5f, 0.75f, Color.blue));
					}
				}
			}
		}
	}
}
