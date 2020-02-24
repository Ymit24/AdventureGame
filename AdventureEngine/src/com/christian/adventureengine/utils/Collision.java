package com.christian.adventureengine.utils;

import com.christian.adventureengine.data.Vector2;

public class Collision {
	public static boolean AABB(Vector2 p1, Vector2 p2, Vector2 s1, Vector2 s2) {
		return
			p2.x < p1.x + s1.x &&
			p1.x < p2.x + s2.x &&
			p1.y < p2.y + s2.y &&
			p2.y < p1.y + s1.y;
	}
}
