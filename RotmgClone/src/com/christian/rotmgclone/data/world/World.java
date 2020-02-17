package com.christian.rotmgclone.data.world;

import java.util.ArrayList;

public class World {
	private Player player;
	private ArrayList<Enemy> enemies;
	private ArrayList<Bullet> bullets;
	
	public World() {
		player = new Player(new Vector2(0,0));
		enemies = new ArrayList<Enemy>();
		bullets = new ArrayList<Bullet>();
	}
	
	public Player GetPlayer() {
		return player;
	}
	
	public ArrayList<Enemy> GetEnemies() {
		return enemies;
	}
	
	public ArrayList<Bullet> GetBullets() {
		return bullets;
	}
}
