package com.christian.adventuregame.demo.utils.loaders;

import com.christian.adventureengine.rendering.sprites.Sprites;
import com.christian.adventureengine.utils.DataLoader;
import com.christian.adventureengine.utils.DataLoader.Block;
import com.christian.adventuregame.demo.data.archetypes.Archetype;
import com.christian.adventuregame.demo.data.archetypes.Archetypes;
import com.christian.adventuregame.demo.data.archetypes.RegionType;
import com.christian.adventuregame.demo.data.archetypes.TerrainFeatureType;

public class TerrainFeatureLoader {
    public static void Load() {
        Block[] blocks = DataLoader.LoadFile("terrainFeatures.cdl");
        for (int i = 0; i < blocks.length; i++) {
            DataLoader.Block block = blocks[i];

            TerrainFeatureType type = new TerrainFeatureType();
            type.id = block.GetString("id");
            type.name = block.GetString("name");
            type.textureFilename = block.GetString("textureFilename");
            type.hasCollision = block.GetBoolean("collision");

            Sprites.GetSpriteManager().RegisterSprite(type.textureFilename);
            Archetypes.TerrianFeatures.RegisterArchetype(type);

            System.out.println("Registered terrain feature of type " + type.id);
        }
    }
}
