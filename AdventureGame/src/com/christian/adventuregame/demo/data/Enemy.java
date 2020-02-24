package com.christian.adventuregame.demo.data;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.data.WorldObject;

public class Enemy extends WorldObject {
	private float health;
	
	public Enemy(Vector2 position) {
		super(position);
	}
	
	public float GetHealth() {
		return health;
	}
	
	public void SetHealth(float health) {
		this.health = health;
	}
}
