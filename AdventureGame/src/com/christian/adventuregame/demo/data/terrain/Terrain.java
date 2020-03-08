package com.christian.adventuregame.demo.data.terrain;

import com.christian.adventureengine.data.ISerializable;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.utils.Deserializer;
import com.christian.adventureengine.utils.Serializer;

public class Terrain implements ISerializable {
	public int width, height;
	public Tile[][] tiles;
	
	// for serialization
	private Terrain() {
		
	}
	
	public Terrain(int width, int height) {
		this.width = width;
		this.height = height;
		
		tiles = new Tile[width][height];
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				tiles[x][y] = new Tile(new Vector2(x,y), "grass", "grass_land", "none");
			}
		}
	}

	@Override
	public void Serialize(Serializer serializer) {
		serializer.WriteInt(width);
		serializer.WriteInt(height);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				tiles[x][y].Serialize(serializer);
			}
		}
	}
	
	public boolean equals(Terrain other) {
		if (width != other.width || height != other.height)
			return false;
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (tiles[x][y].type != other.tiles[x][y].type)
					return false;
			}
		}
		return true;
	}

	public static Terrain Deserialize(Deserializer deserializer) {
		Terrain terrain = new Terrain();
		terrain.width = deserializer.ReadInt();
		terrain.height = deserializer.ReadInt();
		terrain.tiles = new Tile[terrain.width][terrain.height];
		
		for (int x = 0; x < terrain.width; x++) {
			for (int y = 0; y < terrain.height; y++) {
				terrain.tiles[x][y] = Tile.Deserialize(deserializer);
			}
		}
		
		return terrain;
	}

	public void CopyFrom(Terrain other) {
		for (int x = 0; x < Math.min(width, other.width); x++) {
			for (int y = 0; y < Math.min(height, other.height); y++) {
				this.tiles[x][y] = other.tiles[x][y];
			}
		}
	}
}
