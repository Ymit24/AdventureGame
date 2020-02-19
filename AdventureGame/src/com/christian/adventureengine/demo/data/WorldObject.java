package com.christian.adventureengine.demo.data;

import com.christian.adventureengine.data.Vector2;

public class WorldObject {
	private Vector2 position;
	
	public WorldObject(Vector2 position) {
		this.position = position;
	}
	
	public Vector2 GetPosition() {
		return position;
	}
	
	public void SetPosition(Vector2 position) {
		this.position = position;
	}
}
