package com.christian.adventureeditor.controllers;

import com.christian.adventureeditor.EditorData;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.input.IMouseClickListener;
import com.christian.adventureengine.input.Input;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventureengine.rendering.Camera;

public class PaintController extends Controller implements IMouseClickListener {
	public PaintController() {
		Input.GetMouseListener().AddMouseClickListener(this);
	}

	private boolean isPainting = false;

	@Override
	public boolean OnClick(Vector2 screenLocation, int button, boolean isDown) {
		if (button == 0) {
			isPainting = isDown;
			return true;
		}
		return false;
	}

	@Override
	public void Update(float deltaTime) {
		if (!isPainting) return;

		Vector2 worldPosition = Camera.GetCamera().CalculateScreenToWorld(Input.GetMouseListener().GetPosition());
		int tileX = (int) Math.floor(worldPosition.x);
		int tileY = (int) Math.floor(worldPosition.y);

		if (tileX < 0 || tileX >= EditorData.terrain.width || tileY < 0 || tileY >= EditorData.terrain.height)
			return;
		switch (EditorData.state) {
			case MetaData:
			{
				break;
			}
			case Terrain:
			{
				EditorData.terrain.tiles[tileX][tileY].type = EditorData.paintingTileType;
				break;
			}
			case Region:
			{
				EditorData.terrain.tiles[tileX][tileY].regionId = EditorData.paintingRegionType;
				break;
			}
		}
	}
}
