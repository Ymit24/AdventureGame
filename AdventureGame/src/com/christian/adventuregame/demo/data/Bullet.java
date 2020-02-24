package com.christian.adventuregame.demo.data;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.data.WorldObject;

public class Bullet extends WorldObject {
	public static final int SPEED = 10;
	private Vector2 direction;
	
	public Bullet(Vector2 position, Vector2 direction) {
		super(position, new Vector2(0.25f, 0.25f));
		this.direction = direction;
	}
	
	public Vector2 GetDirection() {
		return this.direction;
	}
}
