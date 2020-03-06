package com.christian.adventuregame.demo.data;

import com.christian.adventureengine.data.Vector2;

import java.awt.*;

public class FloatTextEffect {
	public String text;
	public Vector2 worldLocation;
	public float remainingSeconds;
	public float height;
	public Color color;
	public float speed;
	
	public FloatTextEffect(String text, Vector2 worldLocation, float life, float height, Color color) {
		this.text = text;
		this.worldLocation = worldLocation;
		this.remainingSeconds = life;
		this.height = height;
		this.color = color;

		this.speed = height / life;
	}
}
