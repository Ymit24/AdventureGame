package com.christian.adventuregame.demo.utils.loaders;

import com.christian.adventureengine.utils.DataLoader;
import com.christian.adventureengine.utils.DataLoader.Block;
import com.christian.adventuregame.demo.data.archetypes.Archetypes;
import com.christian.adventuregame.demo.data.archetypes.RegionType;

public class RegionLoaderUtil {
    public static void LoadRegions() {
        Block[] blocks = DataLoader.LoadFile("regions.cdl");
        for (int i = 0; i < blocks.length; i++) {
            Block block = blocks[i];

            RegionType type = new RegionType();
            type.id = block.GetString("id");
            type.name = block.GetString("name");
            type.editorHexColor = block.GetString("editorHexColor");
            type.enemyIds = block.GetString("enemies").split(",");
            for (String id : type.enemyIds) {
                System.out.println("\tLoaded enemy type: " + id);
            }
            Archetypes.Regions.RegisterArchetype(type);

            System.out.println("Registered region " + type.id + " color: " + type.editorHexColor);
        }
    }
}
