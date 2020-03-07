package com.christian.adventuregame.demo.utils.loaders;

import com.christian.adventureengine.rendering.sprites.Sprites;
import com.christian.adventureengine.utils.DataLoader;
import com.christian.adventureengine.utils.DataLoader.Block;
import com.christian.adventuregame.demo.data.archetypes.Archetypes;
import com.christian.adventuregame.demo.data.archetypes.TileType;

public class TileLoaderUtil {
	public static void LoadTileTypes() {
		Block[] blocks = DataLoader.LoadFile("tileTypes.cdl");
		for (int i = 0; i < blocks.length; i++) {
			Block block = blocks[i];
			
			TileType type = new TileType();
			type.id = block.GetString("id");
			type.textureFilename = block.GetString("textureFilename");
			Archetypes.Tiles.RegisterArchetype(type);
			
			Sprites.GetSpriteManager().RegisterSprite(type.textureFilename);
			
			System.out.println("Registered tile " + type.id + " with texture " + type.textureFilename);
		}
	}
}
