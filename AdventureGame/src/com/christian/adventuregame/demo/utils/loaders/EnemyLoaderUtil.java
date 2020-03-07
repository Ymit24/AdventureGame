package com.christian.adventuregame.demo.utils.loaders;

import com.christian.adventureengine.rendering.sprites.Sprites;
import com.christian.adventureengine.utils.DataLoader;
import com.christian.adventureengine.utils.DataLoader.Block;
import com.christian.adventuregame.demo.data.archetypes.EnemyType;
import com.christian.adventuregame.demo.data.archetypes.Archetypes;

public class EnemyLoaderUtil {
	public static void LoadEnemyTypes() {
		Block[] blocks = DataLoader.LoadFile("enemyTypes.cdl");
		for (int i = 0; i < blocks.length; i++) {
			Block block = blocks[i];
			
			EnemyType type = new EnemyType();
			type.id = block.GetString("id");
			type.MoveSpeed = block.GetNumber("moveSpeed");
			type.InitialHealth = block.GetNumber("health");
			type.textureFilename = block.GetString("textureFilename");
			type.xpDrop = (int)block.GetNumber("xpDrop");
			Archetypes.Enemies.RegisterArchetype(type);
			
			Sprites.GetSpriteManager().RegisterSprite(type.textureFilename);
			
			System.out.println("Registered enemy " + type.id + " with texture " + type.textureFilename);
		}
	}
}
