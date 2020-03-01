package com.christian.adventuregame.demo.data;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.data.WorldObject;

public class Enemy extends WorldObject {
	public float health;
	
	public static final float MOVE_SPEED = 1.25f;
	
	public Vector2 wanderingTarget;
	public boolean isWandering;
	
	public Enemy(Vector2 position) {
		super(position);
	}
}
