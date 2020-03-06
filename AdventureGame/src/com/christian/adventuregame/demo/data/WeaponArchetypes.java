package com.christian.adventuregame.demo.data;

import java.util.ArrayList;

public class WeaponArchetypes {
    private static ArrayList<WeaponType> types = new ArrayList<>();
    public static void RegisterArchetype(WeaponType type) { types.add(type); }

    public static WeaponType Get(String id) {
        for (WeaponType type : types) {
            if (type.id.equals(id)) {
                return type;
            }
        }
        return null;
    }

    public static WeaponType[] GetAll() {
        WeaponType[] weaponTypes = new WeaponType[types.size()];
        for (int i = 0; i < weaponTypes.length; i++) {
            weaponTypes[i] = types.get(i);
        }
        return weaponTypes;
    }
}
