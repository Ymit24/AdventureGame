package com.christian.adventureengine.data;

import com.christian.adventureengine.data.Vector2;

public class WorldObject {
	public Vector2 Position;
	public Vector2 Size;
	
	public WorldObject(Vector2 position) {
		this.Position = position;
		this.Size = Vector2.One();
	}
	
	public WorldObject(Vector2 position, Vector2 size) {
		this.Position = position;
		this.Size = size;
	}
}
