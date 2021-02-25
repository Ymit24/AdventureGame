package com.christian.adventuregame.demo.utils;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.rendering.sprites.Sprites;
import com.christian.adventuregame.demo.data.Inventory;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.data.archetypes.ItemType;

public class InventoryUtil {
    public static void StartDrag(int slotIndex) {
        System.out.println("Starting drag on " + slotIndex);
        Inventory inventory = State.world.player.inventory;

        if (inventory.GetSlot(slotIndex) == null) {
            return;
        }

        System.out.println("Starting drag");
        State.isDragging = true;
        State.dragPosition = Vector2.Zero();
        State.slotIdDragging = slotIndex;
        State.iconDragSprite = Sprites.GetSpriteManager().GetSprite(inventory.GetSlot(slotIndex).iconTextureFilename);
    }

    public static void StopDrag(int slotIndex) {
        if (State.isDragging == false)
            return;
        System.out.println("Completed drag " + slotIndex + " " + State.slotIdDragging);

        Inventory inventory = State.world.player.inventory;

        ItemType cache = inventory.GetSlot(slotIndex);
        inventory.SetSlot(slotIndex, inventory.GetSlot(State.slotIdDragging));
        inventory.SetSlot(State.slotIdDragging, cache);

        State.isDragging = false;
        State.slotIdDragging = -1;
        State.iconDragSprite = null;
    }
}
