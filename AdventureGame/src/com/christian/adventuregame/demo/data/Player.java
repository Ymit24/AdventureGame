package com.christian.adventuregame.demo.data;

import com.christian.adventureengine.data.Vector2;

public class Player extends WorldObject {
	public static final float SECONDS_PER_SHOT = 0.075f;
	public float ShootingTimer;

	public Player(Vector2 position) {
		super(position);
		ShootingTimer = 0;
	}
	
}
