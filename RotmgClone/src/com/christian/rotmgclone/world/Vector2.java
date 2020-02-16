package com.christian.rotmgclone.world;

public class Vector2 {
	public float x, y;
	
	public Vector2() {
		this.x = 0;
		this.y = 0;
	}
	
	public Vector2(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "<" + x + "," + y + ">";
	}
}
