package com.christian.adventuregame.demo.data;

import com.christian.adventureengine.data.Vector2;

public class HitEffect {
	public String text;
	public Vector2 worldLocation;
	public float remainingSeconds;
	
	public HitEffect(String text, Vector2 worldLocation, float life) {
		this.text = text;
		this.worldLocation = worldLocation;
		this.remainingSeconds = life;
	}
}
