package com.christian.adventuregame.demo.data;

import com.christian.adventuregame.demo.data.archetypes.Archetypes;
import com.christian.adventuregame.demo.data.archetypes.ItemType;
import com.christian.adventuregame.demo.data.archetypes.WeaponType;

public class Inventory {
    public ItemType[] storageItems;

    public Inventory(int storageSlots) {
        storageItems = new ItemType[storageSlots];
    }

    public boolean HasItem(String itemId) {
        for (ItemType type : storageItems) {
            if (type.id.equals(itemId))
                return true;
        }
        return false;
    }

    public ItemType GetSlot(int slotIndex) {
        if (slotIndex == -1)
            return null;
        if (slotIndex >= 0 && slotIndex < storageItems.length) {
            return storageItems[slotIndex];
        }
        return null;
    }

    public void SetSlot(int slotIndex, ItemType type) {
        if (slotIndex == -1)
            return;
        if (slotIndex >= 0 && slotIndex < storageItems.length) {
            storageItems[slotIndex] = type;
        }
    }

    public ItemType GetWeapon() {
        return storageItems[0];
    }

    public WeaponType GetWeaponType() {
        return Archetypes.Weapons.Get(storageItems[0].weaponId);
    }
}
