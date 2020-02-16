package com.christian.rotmgclone.world;

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
