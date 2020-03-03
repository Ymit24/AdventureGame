package com.christian.adventuregame.demo.data.terrain;

import java.util.ArrayList;

public class TileArchetypes {
	private static ArrayList<TileType> types = new ArrayList<TileType>();
	public static void RegisterArchetype(TileType type) {
		types.add(type);
	}
	
	public static TileType Get(String id) {
		for (TileType type : types) {
			if (type.id.equals(id)) {
				return type;
			}
		}
		return null;
	}
	
	public static TileType[] GetAll() {
		System.out.println("Types: " +types.size());
		TileType[] tileTypes = new TileType[types.size()];
		for (int i = 0; i < tileTypes.length; i++) {
			tileTypes[i] = types.get(i);
		}
		return tileTypes;
	}
}
