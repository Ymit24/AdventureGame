package com.christian.rotmgclone.data.world;

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

	public float Magnitude() {
		return (float)Math.sqrt(x * x + y * y);
	}
	
	public Vector2 Normalized() {
		Vector2 normalized = new Vector2(x,y);
		normalized.Normalize();
		return normalized;
	}
	
	public void Normalize() {
		float m = Magnitude();
		this.x /= m;
		this.y /= m;
	}
	
	@Override
	public String toString() {
		return "<" + x + "," + y + ">";
	}
}
