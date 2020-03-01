package com.christian.adventureengine.data;

public class Box {
	public Vector2 position;
	public Vector2 size;
	
	public Box() {
		position = Vector2.One();
		size = Vector2.One();
	}
	
	public Box(Vector2 position, Vector2 size) {
		this.position = position;
		this.size = size;
	}
	
	public float GetTop() {
		return position.y;
	}
	
	public float GetBottom() {
		return position.y + size.y;
	}
	
	public float GetLeft() {
		return position.x;
	}
	
	public float GetRight() {
		return position.x + size.x;
	}
}
