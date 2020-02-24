package com.christian.adventuregame.demo.data;

import com.christian.adventureengine.data.Vector2;

public class Bullet extends WorldObject {
	public static final int SPEED = 10;
	private Vector2 direction;
	
	public Bullet(Vector2 position, Vector2 direction) {
		super(position);
		this.direction = direction;
	}
	
	public Vector2 GetDirection() {
		return this.direction;
	}
}
