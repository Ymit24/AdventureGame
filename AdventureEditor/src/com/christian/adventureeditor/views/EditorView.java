package com.christian.adventureeditor.views;

import com.christian.adventureeditor.EditorData;
import com.christian.adventureeditor.Terrain;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.View;
import com.christian.adventureengine.rendering.sprites.ISpriteType;
import com.christian.adventureengine.rendering.sprites.Sprite;
import com.christian.adventureengine.rendering.sprites.Sprites;

public class EditorView extends View {
	
	private enum EditorSpriteTypes implements ISpriteType {
		grass,
		water
	}
	
	private Sprite grassSprite;
	private Sprite waterSprite;
	
	public EditorView() {
		Sprites.GetSpriteManager().RegisterSprite(EditorSpriteTypes.grass, "grass.png");
		Sprites.GetSpriteManager().RegisterSprite(EditorSpriteTypes.water, "water.png");
		grassSprite = Sprites.GetSpriteManager().GetSprite(EditorSpriteTypes.grass);
		waterSprite = Sprites.GetSpriteManager().GetSprite(EditorSpriteTypes.water);
	}
	
	@Override
	public void draw(IRenderer renderer) {
		if (EditorData.terrain != null) {
			Terrain terrain = EditorData.terrain;
			for (int x = 0; x < terrain.width; x++) {
				for (int y = 0; y < terrain.height; y++) {
					switch (terrain.tiles[x][y].type) {
					case grass:
						renderer.DrawSprite(grassSprite, new Vector2(x,y));
						break;
					case water:
						renderer.DrawSprite(waterSprite, new Vector2(x,y));
						break;
					}
				}
			}
		}
	}
}
