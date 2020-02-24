package com.christian.adventuregame.demo.views;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.View;
import com.christian.adventureengine.rendering.sprites.ISpriteType;
import com.christian.adventureengine.rendering.sprites.Sprite;
import com.christian.adventureengine.rendering.sprites.Sprites;

public class TerrainView extends View {

	private enum TerrainSpriteType implements ISpriteType {
		GRASS_0,
		GRASS_1
	}
	
	private Sprite terrainSprite;
	
	public TerrainView() {
		Sprites.GetSpriteManager().RegisterSprite(TerrainSpriteType.GRASS_0, "grass_0.png");
		Sprites.GetSpriteManager().RegisterSprite(TerrainSpriteType.GRASS_1, "grass_1.png");
		terrainSprite = Sprites.GetSpriteManager().GetSprite(TerrainSpriteType.GRASS_0);
	}
	
	@Override
	public void draw(IRenderer renderer) {
		for (int x = 0; x < 20; x++) {
			for (int y = 0; y < 10; y++) {
				renderer.DrawSprite(terrainSprite, new Vector2(x, y));	
			}
		}
	}
	
}
