package com.christian.adventuregame.demo.data;

import java.util.ArrayList;

import com.christian.adventureengine.utils.Randomizer;

public class EnemyArchetypes {
	private static ArrayList<EnemyType> types = new ArrayList<>();
	public static void RegisterArchetype(EnemyType type) {
		types.add(type);
	}
	
	public static EnemyType Get(String id) {
		for (EnemyType type : types) {
			if (type.id.equals(id)) {
				return type;
			}
		}
		return null;
	}
	
	public static EnemyType[] GetAll() {
		EnemyType[] enemyTypes = new EnemyType[types.size()];
		for (int i = 0; i < enemyTypes.length; i++) {
			enemyTypes[i] = types.get(i);
		}
		return enemyTypes;
	}
	
	public static EnemyType GetRandomType() {
		return types.get(Randomizer.random.nextInt(types.size()));
	}
}
