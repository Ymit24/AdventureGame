package com.christian.adventuregame.demo.utils.loaders;

import com.christian.adventureengine.rendering.sprites.Sprites;
import com.christian.adventureengine.utils.DataLoader;
import com.christian.adventuregame.demo.data.archetypes.Archetypes;
import com.christian.adventuregame.demo.data.archetypes.ItemType;
import com.christian.adventuregame.demo.data.archetypes.WeaponType;

public class ItemLoader {
    public static void Load() {
        DataLoader.Block[] blocks = DataLoader.LoadFile("items.cdl");
        for (DataLoader.Block block : blocks) {
            ItemType type = new ItemType();
            type.id = block.GetString("id");
            type.name = block.GetString("name");
            type.iconTextureFilename= block.GetString("iconTextureFilename");
            type.weaponId = block.GetString("weaponId");
            System.out.println("Registered item " + type.name);
            Archetypes.Items.RegisterArchetype(type);

            Sprites.GetSpriteManager().RegisterSprite(type.iconTextureFilename, 1);
        }
    }
}
