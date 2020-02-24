package com.christian.adventuregame.demo.views;

import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.View;
import com.christian.adventureengine.rendering.sprites.ISpriteType;
import com.christian.adventureengine.rendering.sprites.Sprite;
import com.christian.adventureengine.rendering.sprites.Sprites;
import com.christian.adventuregame.demo.data.State;

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
		for (int x = 0; x < State.terrain.width; x++) {
			for (int y = 0; y < State.terrain.height; y++) {
				renderer.DrawWorldSprite(terrainSprite, State.terrain.tiles[x][y]);
			}
		}
	}
	
}
