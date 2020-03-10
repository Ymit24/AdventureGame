package com.christian.adventuregame.demo.data;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.data.WorldObject;
import com.christian.adventuregame.demo.data.archetypes.Archetypes;
import com.christian.adventuregame.demo.data.archetypes.EnemyType;

public class Enemy extends WorldObject {
	public String id;
	public float health;
	public float moveSpeed;
	
	public Vector2 wanderingTarget;
	public boolean isWandering;

	public boolean isShooting;
	
	public Enemy(Vector2 position, String id) {
		super(position);
		
		EnemyType type = Archetypes.Enemies.Get(id);

		this.id = id;
		this.health = type.InitialHealth;
		this.moveSpeed = type.MoveSpeed;
	}
}
