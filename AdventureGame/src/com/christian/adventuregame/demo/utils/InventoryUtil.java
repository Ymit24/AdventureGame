package com.christian.adventuregame.demo.utils;

import com.christian.adventureengine.rendering.sprites.Sprites;
import com.christian.adventuregame.demo.data.Inventory;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.ui.elements.InventorySlot;

public class InventoryUtil {
    public static void StartDrag(String slotId) {
        System.out.println("Starting drag on " + slotId);
        Inventory inventory = State.world.player.inventory;

        if (slotId.equals("equippedWeaponSlot")) {
            System.out.println("Clied on weapon slot.");
        }
        else {
            int slotIndex = Integer.parseInt(slotId.substring(slotId.length() - 1));
            System.out.println("Slot " + slotIndex + " is full: " + (inventory.storageItems[slotIndex] != null));
            if (inventory.storageItems[slotIndex] == null) {
                return;
            }

            State.isDragging = true;
            State.slotIndexDragging = slotIndex;
            State.iconDragSprite = Sprites.GetSpriteManager().GetSprite(inventory.storageItems[slotIndex].iconTextureFilename);
        }
    }
}
