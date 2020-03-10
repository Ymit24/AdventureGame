package com.christian.adventuregame.demo.utils;

import com.christian.adventureengine.rendering.sprites.Sprites;
import com.christian.adventuregame.demo.data.Inventory;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.data.archetypes.ItemType;

public class InventoryUtil {
    public static void StartDrag(String slotId) {
        System.out.println("Starting drag on " + slotId);
        Inventory inventory = State.world.player.inventory;

        if (inventory.GetSlot(slotId) == null) {
            return;
        }

        System.out.println("Starting drag");
        State.isDragging = true;
        State.slotIdDragging = slotId;
        State.iconDragSprite = Sprites.GetSpriteManager().GetSprite(inventory.GetSlot(slotId).iconTextureFilename);
    }

    public static void StopDrag(String slotId) {
        if (State.isDragging == false)
            return;
        System.out.println("Completed drag " + slotId + " " + State.slotIdDragging);

        Inventory inventory = State.world.player.inventory;

        ItemType cache = inventory.GetSlot(slotId);
        inventory.SetSlot(slotId, inventory.GetSlot(State.slotIdDragging));
        inventory.SetSlot(State.slotIdDragging, cache);

        State.isDragging = false;
        State.slotIdDragging = "none";
        State.iconDragSprite = null;
    }
}
