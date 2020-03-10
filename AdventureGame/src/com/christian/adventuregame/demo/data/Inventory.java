package com.christian.adventuregame.demo.data;

import com.christian.adventuregame.demo.data.archetypes.Archetypes;
import com.christian.adventuregame.demo.data.archetypes.ItemType;
import com.christian.adventuregame.demo.data.archetypes.WeaponType;

public class Inventory {
    public ItemType equippedWeaponItem;
    private WeaponType weaponType;

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

    public ItemType GetSlot(String slotId) {
        if (slotId.equals("none"))
            return null;
        if (slotId.equals("weapon")) {
            return equippedWeaponItem;
        }
        int slotIndex = Integer.parseInt(slotId);
        if (slotIndex >= 0 && slotIndex < storageItems.length) {
            return storageItems[slotIndex];
        }
        return null;
    }

    public void SetSlot(String slotId, ItemType type) {
        if (slotId.equals("none"))
            return;
        if (slotId.equals("weapon")) {
            equippedWeaponItem = type;
            return;
        }
        int slotIndex = Integer.parseInt(slotId);
        if (slotIndex >= 0 && slotIndex < storageItems.length) {
            storageItems[slotIndex] = type;
        }
    }

    public WeaponType GetWeaponType() {
        if (equippedWeaponItem != null && weaponType != null && weaponType.id.equals(equippedWeaponItem.weaponId))
            return weaponType;

        if (equippedWeaponItem == null) {
            return null;
        }

        weaponType = Archetypes.Weapons.Get(equippedWeaponItem.weaponId);
        return weaponType;
    }
}
