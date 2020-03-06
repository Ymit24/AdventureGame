package com.christian.adventuregame.demo.data;

import java.util.ArrayList;

import com.christian.adventureengine.data.Vector2;

public class World {
	public Player player;
	public ArrayList<Enemy> enemies;
	public ArrayList<Bullet> bullets;
	
	public World() {
		player = new Player(new Vector2(0,0));
		enemies = new ArrayList<Enemy>();
		bullets = new ArrayList<Bullet>();
	}
	
	public void SpawnBullet(Vector2 position, Vector2 direction, WeaponType type) {
		bullets.add(new Bullet(position, direction, type));
	}
	
	public void SpawnEnemy(Vector2 position, String id) {
		enemies.add(new Enemy(position, id));
	}
}
