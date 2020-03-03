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
}
