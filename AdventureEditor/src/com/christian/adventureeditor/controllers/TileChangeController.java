package com.christian.adventureeditor.controllers;

import com.christian.adventureeditor.EditorData;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.input.IMouseClickListener;
import com.christian.adventureengine.input.Input;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventureengine.rendering.Camera;
import com.christian.adventuregame.demo.data.Tile.TileType;

public class TileChangeController extends Controller implements IMouseClickListener {
	
	public TileChangeController() {
		Input.GetMouseListener().AddMouseClickListener(this);
	}
	
	@Override
	public void OnClick(Vector2 screenLocation, int button) {
		if (button != 0) {
			return;
		}
		
		Vector2 worldPosition = Camera.GetCamera().CalculateScreenToWorld(screenLocation);
		int tileX = (int) Math.floor(worldPosition.x);
		int tileY = (int) Math.floor(worldPosition.y);
		System.out.println("Clicked at tile pos: " + tileX + ", " + tileY);
		
		if (tileX < 0 || tileX >= EditorData.terrain.width || tileY < 0 || tileY >= EditorData.terrain.height)
			return;
		EditorData.terrain.tiles[tileX][tileY].type = TileType.water;
	}
	
	@Override
	public void Update(float deltaTime) {
//		if (Input.GetMouseListener().isMouseButtonDown(0)) {
//		}
	}
}
