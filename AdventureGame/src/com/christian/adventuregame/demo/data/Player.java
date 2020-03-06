package com.christian.adventuregame.demo.data;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.data.WorldObject;

public class Player extends WorldObject {
//	public static final float SECONDS_PER_SHOT = 0.075f;
	public static final float SECONDS_PER_SHOT = 0.1f;
	public float ShootingTimer;

	public WeaponType weaponType;

	public Player(Vector2 position) {
		super(position);
		ShootingTimer = 0;
	}
	
}
