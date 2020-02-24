package com.christian.adventureengine.data;

import com.christian.adventureengine.utils.Deserializer;
import com.christian.adventureengine.utils.Serializer;

public class Vector2 implements ISerializable {
	public float x, y;
	
	public Vector2() {
		this.x = 0;
		this.y = 0;
	}
	
	public Vector2(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public static Vector2 One() {
		return new Vector2(1, 1);
	}
	
	public static Vector2 Zero() {
		return new Vector2(1, 1);
	}
	
	public Vector2(Vector2 other) {
		this.x = other.x;
		this.y = other.y;
	}

	public float Magnitude() {
		return (float)Math.sqrt(x * x + y * y);
	}
	
	public Vector2 Normalized() {
		Vector2 normalized = new Vector2(x,y);
		normalized.Normalize();
		return normalized;
	}
	
	public void Normalize() {
		float m = Magnitude();
		this.x /= m;
		this.y /= m;
	}
	
	public Vector2 Add(Vector2 other) {
		return new Vector2(x + other.x, y + other.y);
	}
	
	public Vector2 Sub(Vector2 other) {
		return new Vector2(x - other.x, y - other.y);
	}
	
	public Vector2 Mul(float scalar) {
		return new Vector2(x * scalar, y * scalar);
	}
	
	public Vector2 Div(float scalar) {
		return new Vector2(x / scalar, y / scalar);
	}
	
	@Override
	public String toString() {
		return "<" + x + "," + y + ">";
	}

	@Override
	public void Serialize(Serializer serializer) {
		serializer.WriteFloat(x);
		serializer.WriteFloat(y);
	}

	@Override
	public void Deserialize(Deserializer deserializer) {
		this.x = deserializer.ReadFloat();
		this.y = deserializer.ReadFloat();
	}
}
