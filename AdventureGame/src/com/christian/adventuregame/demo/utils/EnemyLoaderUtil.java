package com.christian.adventuregame.demo.utils;

import com.christian.adventureengine.rendering.sprites.Sprites;
import com.christian.adventureengine.utils.DataLoader;
import com.christian.adventureengine.utils.DataLoader.Block;
import com.christian.adventuregame.demo.data.EnemyArchetypes;
import com.christian.adventuregame.demo.data.EnemyType;

public class EnemyLoaderUtil {
	public static void LoadEnemyTypes() {
		Block[] blocks = DataLoader.LoadFile("enemyTypes.cdl");
		for (int i = 0; i < blocks.length; i++) {
			Block block = blocks[i];
			
			EnemyType type = new EnemyType();
			type.id = block.values[0];
			type.MoveSpeed = Float.parseFloat(block.values[1]);
			type.InitialHealth = Float.parseFloat(block.values[2]);
			type.textureFilename = block.values[3];
			EnemyArchetypes.RegisterArchetype(type);
			
			Sprites.GetSpriteManager().RegisterSprite(type.textureFilename);
			
			System.out.println("Registered enemy " + type.id + " with texture " + type.textureFilename);
		}
	}
}
