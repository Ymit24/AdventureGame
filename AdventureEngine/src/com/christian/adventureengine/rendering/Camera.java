package com.christian.adventureengine.rendering;

import com.christian.adventureengine.data.Vector2;

public class Camera {
	private static Camera camera;
	private Vector2 pixelsPerWorldUnit;
	private Vector2 worldSpace;
	private Vector2 position;
	
	public static Camera GetCamera() {
		return camera;
	}
	
	public Camera(Vector2 pixelsPerWorldUnit, Vector2 worldSpace) {
		this.pixelsPerWorldUnit = pixelsPerWorldUnit;
		this.position = new Vector2();
		this.worldSpace = worldSpace;
		
		Camera.camera = this;
	}
	
	public Vector2 GetPixelsPerWorldUnit() {
		return pixelsPerWorldUnit;
	}
	
	public Vector2 GetPosition() {
		return this.position;
	}
	
	public Vector2 GetWorldSpace() {
		return this.worldSpace;
	}
	
	public Vector2 GetCenterPosition() {
		return position.Add(worldSpace.Div(2));
	}
	
	public void SetPosition(Vector2 position) {
		this.position = position;
	}

	public Vector2 CalculateWorldToScreen(Vector2 worldLocation) {
		Vector2 pixelLocation = new Vector2(
			(worldLocation.x-position.x) * pixelsPerWorldUnit.x,
			(worldLocation.y-position.y) * pixelsPerWorldUnit.y
		);
		return pixelLocation;
//		return pixelLocation.Sub(position);
	}
	
	// might need to check
	public Vector2 CalculateScreenToWorld(Vector2 pixelLocation) {
		Vector2 worldLocation = new Vector2(pixelLocation);
		worldLocation.x /= pixelsPerWorldUnit.x;
		worldLocation.y /= pixelsPerWorldUnit.y;
		
		return worldLocation.Add(position);
	}
}
