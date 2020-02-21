package com.christian.adventureeditor;

import com.christian.adventureeditor.Tile.TileType;
import com.christian.adventureengine.data.Vector2;

public class Terrain {
	public int width, height;
	public Tile[][] tiles;
	
	public Terrain(int width, int height) {
		this.width = width;
		this.height = height;
		
		tiles = new Tile[width][height];
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				tiles[x][y] = new Tile(new Vector2(x,y), TileType.grass);
			}
		}
	}
}
