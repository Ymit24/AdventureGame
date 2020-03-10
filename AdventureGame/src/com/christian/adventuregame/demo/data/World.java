package com.christian.adventuregame.demo.data;

import java.util.ArrayList;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventuregame.demo.data.archetypes.WeaponType;

public class World {
	public Player player;
	public ArrayList<Enemy> enemies;
	public ArrayList<Bullet> bullets;
	
	public World() {
		player = new Player(new Vector2(8,8));
		enemies = new ArrayList<Enemy>();
		bullets = new ArrayList<Bullet>();
	}
	
	public Bullet SpawnBullet(Vector2 position, Vector2 direction, WeaponType type) {
		Bullet bullet = new Bullet(position, direction, type);
		bullets.add(bullet);
		return bullet;
	}
	
	public void SpawnEnemy(Vector2 position, String id) {
		enemies.add(new Enemy(position, id));
	}
}
