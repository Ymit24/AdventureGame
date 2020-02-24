package com.christian.adventureeditor;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.data.WorldObject;

public class Tile extends WorldObject {
	public enum TileType {
		grass, water
	}
	
	public TileType type;
	
	public Tile(Vector2 position, TileType type) {
		super(position);
		this.type = type;
	}
}
