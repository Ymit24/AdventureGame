package com.christian.adventuregame.demo.data;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.data.WorldObject;

public class Enemy extends WorldObject {
	public String id;
	public float health;
	public float moveSpeed;
	
	public Vector2 wanderingTarget;
	public boolean isWandering;
	
	public Enemy(Vector2 position, String id) {
		super(position);
		
		EnemyType type = EnemyArchetypes.Get(id);
		System.out.println(type);
		
		this.id = id;
		this.health = type.InitialHealth;
		this.moveSpeed = type.MoveSpeed;
	}
}
