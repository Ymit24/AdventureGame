package com.christian.adventuregame.demo.utils;

import com.christian.adventureengine.rendering.sprites.Sprites;
import com.christian.adventureengine.utils.DataLoader;
import com.christian.adventureengine.utils.DataLoader.Block;
import com.christian.adventuregame.demo.data.terrain.TileArchetypes;
import com.christian.adventuregame.demo.data.terrain.TileType;

public class TileLoaderUtil {
	public static void LoadTileTypes() {
		Block[] blocks = DataLoader.LoadFile("tileTypes.cdl");
		for (int i = 0; i < blocks.length; i++) {
			Block block = blocks[i];
			
			TileType type = new TileType();
			type.id = block.values[0];
			type.textureFilename = block.values[1];
			TileArchetypes.RegisterArchetype(type);
			
			Sprites.GetSpriteManager().RegisterSprite(type.textureFilename);
			
			System.out.println("Registered " + type.id + " with texture " + type.textureFilename);
		}
	}
}
