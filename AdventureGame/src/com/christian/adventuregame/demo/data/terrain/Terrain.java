package com.christian.adventuregame.demo.data.terrain;

import com.christian.adventureengine.data.ISerializable;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.utils.Deserializer;
import com.christian.adventureengine.utils.Serializer;

public class Terrain implements ISerializable {
	public int width, height;
	public int chunkSize;

	public Chunk[] chunks;

	// for serialization
	private Terrain() {
		
	}
	
	public Terrain(int width, int height, int chunkSize) {
		this.width = width;
		this.height = height;
		this.chunkSize = chunkSize;

		assert width % chunkSize == 0;
		int hChunks = width / chunkSize;
		int vChunks = height / chunkSize;
		int totalChunks = hChunks * vChunks;

		this.chunks = new Chunk[totalChunks];
		for (int i = 0; i < totalChunks; i++) {
			System.out.println("Creating chunk with position: " + new Vector2(i % hChunks, i / hChunks));
			this.chunks[i] = new Chunk(chunkSize, new Vector2 (
				i % hChunks,
				i / hChunks
			));
		}
	}

	public Tile GetTile(int tileX, int tileY) {
		return GetTile(new Vector2(tileX, tileY));
	}

	public Tile GetTile(Vector2 tileLocation) {
//		int localX = (int)tileLocation.x % chunkSize;
//		int localY = (int)tileLocation.y % chunkSize;

		int offsetX = (int)tileLocation.x / chunkSize;
		int offsetY = (int)tileLocation.y / chunkSize;

		int chunkIndex = offsetX + (width / chunkSize) * offsetY;

		if (chunkIndex < 0 || chunkIndex >= chunks.length)
			return null;
		return chunks[chunkIndex].GetTile(tileLocation);
	}

	public boolean equals(Terrain other) {
		if (width != other.width || height != other.height)
			return false;
		for (int i = 0; i < chunks.length; i++) {
			if (!chunks[i].equals(other.chunks[i]))
				return false;
		}
		return true;
	}

	@Override
	public void Serialize(Serializer serializer) {
		System.out.println("SERIALIZING");
		serializer.WriteInt(width);
		serializer.WriteInt(height);
		serializer.WriteInt(chunkSize);

		serializer.WriteInt(chunks.length);
		for (int i = 0; i < chunks.length; i++) {
			chunks[i].Serialize(serializer);
		}
	}

	public static Terrain Deserialize(Deserializer deserializer) {
		Terrain terrain = new Terrain();
		terrain.width = deserializer.ReadInt();
		terrain.height = deserializer.ReadInt();
		terrain.chunkSize = 10;
//		terrain.chunkSize = deserializer.ReadInt();
//		System.out.println("Chunk Size:" + terrain.chunkSize);

		Tile[][] tiles = new Tile[terrain.width][terrain.height];
		for (int x = 0; x < terrain.width; x++) {
			for (int y = 0; y < terrain.height; y++) {
				tiles[x][y] = Tile.Deserialize(deserializer);
			}
		}

		int hChunks = terrain.width / terrain.chunkSize;
		int vChunks = terrain.height / terrain.chunkSize;
		int totalChunks = hChunks * vChunks;

		terrain.chunks = new Chunk[totalChunks];
		for (int i = 0; i < totalChunks; i++) {
			terrain.chunks[i] = new Chunk(terrain.chunkSize, new Vector2(
				i % hChunks,
				i / hChunks
			));

			Chunk chunk = terrain.chunks[i];
			for (int x = (int)chunk.position.x; x < (int)chunk.position.x + chunk.chunkSize; x++) {
				for (int y = (int)chunk.position.y; y < (int)chunk.position.y + chunk.chunkSize; y++) {
					chunk.tiles[x-(int)chunk.position.x][y-(int)chunk.position.y] = tiles[x][y];
				}
			}
		}

//		terrain.chunks = new Chunk[deserializer.ReadInt()];
//		for (int i = 0; i < terrain.chunks.length; i++) {
//			terrain.chunks[i] = Chunk.Deserialize(deserializer);
//		}
		
		return terrain;
	}

	public void CopyFrom(Terrain other) {
		// TODO: REIMPLEMENT THIS CHUNKS. MAYBE CONVERT TO TILE[][] THEN RECHUNK?
//		for (int x = 0; x < Math.min(width, other.width); x++) {
//			for (int y = 0; y < Math.min(height, other.height); y++) {
//				this.tiles[x][y] = other.tiles[x][y];
//			}
//		}
	}
}
