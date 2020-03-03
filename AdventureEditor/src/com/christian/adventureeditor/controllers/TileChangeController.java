package com.christian.adventureeditor.controllers;

import com.christian.adventureeditor.EditorData;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.input.IMouseClickListener;
import com.christian.adventureengine.input.Input;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventureengine.rendering.Camera;

public class TileChangeController extends Controller {
	@Override
	public void Update(float deltaTime) {
		if (Input.GetMouseListener().isMouseButtonDown(0)) {
			Vector2 worldPosition = Camera.GetCamera().CalculateScreenToWorld(Input.GetMouseListener().GetPosition());
			int tileX = (int) Math.floor(worldPosition.x);
			int tileY = (int) Math.floor(worldPosition.y);
			System.out.println("Clicked at tile pos: " + tileX + ", " + tileY);
			
			if (tileX < 0 || tileX >= EditorData.terrain.width || tileY < 0 || tileY >= EditorData.terrain.height)
				return;
			EditorData.terrain.tiles[tileX][tileY].type = EditorData.paintingTileType;
		}
	}
}
