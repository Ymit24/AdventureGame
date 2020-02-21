package com.christian.adventureeditor;

import com.christian.adventureengine.data.Vector2;

public class Tile {
	public enum TileType {
		grass, water
	}
	
	public Vector2 position;
	public TileType type;
	
	public Tile(Vector2 position, TileType type) {
		this.position = position;
		this.type = type;
	}
}
