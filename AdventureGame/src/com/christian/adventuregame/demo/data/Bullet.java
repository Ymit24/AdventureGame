package com.christian.adventuregame.demo.data;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.data.WorldObject;

public class Bullet extends WorldObject {
	public static final int SPEED = 7;
	private Vector2 direction;
	private Vector2 normalDirection;

	public Vector2 normal;
	public Vector2 straightPos;
	public float timer;

	public WeaponType type;

	public Bullet(Vector2 position, Vector2 direction, WeaponType type) {
		super(position, new Vector2(0.25f, 0.25f));
		this.direction = direction;
		this.type = type;

		straightPos = new Vector2(position);

		float angle = (float)(Math.atan2(direction.y, direction.x));
		float norm = (float)(angle + Math.PI / 2.0);
		this.timer = 0;

		normal = new Vector2(
			(float)Math.cos(norm),
			(float)Math.sin(norm)
		);
	}

	public void OffsetWave() {
		this.timer += (float)Math.PI / 1.0;
		System.out.println("Timer: " + timer + " sine: " + (Math.sin(timer * 20)));
	}
	
	public Vector2 GetDirection() {
		return this.direction;
	}
}
