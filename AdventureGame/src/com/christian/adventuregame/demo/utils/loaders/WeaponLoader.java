package com.christian.adventuregame.demo.utils.loaders;

import com.christian.adventureengine.rendering.sprites.Sprites;
import com.christian.adventureengine.utils.DataLoader;
import com.christian.adventureengine.utils.DataLoader.Block;
import com.christian.adventuregame.demo.data.WeaponArchetypes;
import com.christian.adventuregame.demo.data.WeaponType;


public class WeaponLoader {
    public static void LoadWeapons() {
        Block[] blocks = DataLoader.LoadFile("weapons.cdl");
        for (Block block : blocks) {
            WeaponType type = new WeaponType();
            type.id = block.GetString("id");
            type.textureFilename = block.GetString("textureFilename");
            type.projectileEmitter = block.GetString("projectileEmitter");
            type.projectileBehavior = block.GetString("projectileBehavior");
            type.firingRate = block.GetNumber("firingRate");
            type.damage = block.GetNumber("damage");

            WeaponArchetypes.RegisterArchetype(type);

            Sprites.GetSpriteManager().RegisterSprite(type.textureFilename, 0.25f);
        }
    }
}
