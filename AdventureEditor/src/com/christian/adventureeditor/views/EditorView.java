package com.christian.adventureeditor.views;

import com.christian.adventureeditor.EditorData;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.View;
import com.christian.adventureengine.rendering.sprites.ISpriteType;
import com.christian.adventureengine.rendering.sprites.Sprite;
import com.christian.adventureengine.rendering.sprites.Sprites;
import com.christian.adventuregame.demo.data.Terrain;

public class EditorView extends View {
	
	private enum EditorSpriteTypes implements ISpriteType {
		grass,
		water
	}
	
	private Sprite grassSprite;
	private Sprite waterSprite;
	
	private UIView uiView;
	
	public EditorView() {
		Sprites.GetSpriteManager().RegisterSprite(EditorSpriteTypes.grass, "grass_0.png");
		Sprites.GetSpriteManager().RegisterSprite(EditorSpriteTypes.water, "water_0.png");
		grassSprite = Sprites.GetSpriteManager().GetSprite(EditorSpriteTypes.grass);
		waterSprite = Sprites.GetSpriteManager().GetSprite(EditorSpriteTypes.water);
		
		uiView = new UIView();
	}
	
	@Override
	public void draw(IRenderer renderer) {
		if (EditorData.terrain != null) {
			Terrain terrain = EditorData.terrain;
			for (int x = 0; x < terrain.width; x++) {
				for (int y = 0; y < terrain.height; y++) {
					switch (terrain.tiles[x][y].type) {
					case grass:
						renderer.DrawWorldSprite(grassSprite, terrain.tiles[x][y]);
						break;
					case water:
						renderer.DrawWorldSprite(waterSprite, terrain.tiles[x][y]);
						break;
					}
				}
			}
		}
		uiView.draw(renderer);
	}
}
