package com.christian.rotmgclone.demo.data;

import com.christian.rotmgclone.data.Vector2;

public class Bullet extends WorldObject {
	private Vector2 direction;
	
	public Bullet(Vector2 position, Vector2 direction) {
		super(position);
		this.direction = direction;
	}
	
	public Vector2 GetDirection() {
		return this.direction;
	}
}
