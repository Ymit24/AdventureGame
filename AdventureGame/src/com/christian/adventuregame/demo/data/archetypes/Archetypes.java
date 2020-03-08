package com.christian.adventuregame.demo.data.archetypes;

import com.christian.adventureengine.utils.Randomizer;

import java.util.ArrayList;

public class Archetypes<T extends Archetype> {
    public static Archetypes<RegionType> Regions = new Archetypes<>();
    public static Archetypes<EnemyType> Enemies = new Archetypes<>();
    public static Archetypes<TileType> Tiles = new Archetypes<>();
    public static Archetypes<WeaponType> Weapons = new Archetypes<>();
    public static Archetypes<TerrainFeatureType> TerrianFeatures = new Archetypes<>();

    private ArrayList<T> types;

    public Archetypes() {
        types = new ArrayList<>();
    }

    public void RegisterArchetype(T type) {
        types.add(type);
    }

    public T Get(String id) {
        for (T type : types) {
            if (type.id.equals(id)) {
                return type;
            }
        }
        return null;
    }

    public ArrayList<T> GetAll() {
        return types;
    }

    public T GetRandomType() {
        return types.get(Randomizer.random.nextInt(types.size()));
    }

}
