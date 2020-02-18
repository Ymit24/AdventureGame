package com.christian.rotmgclone.demo.views;

import com.christian.rotmgclone.data.Vector2;
import com.christian.rotmgclone.rendering.IRenderer;
import com.christian.rotmgclone.rendering.sprites.ISpriteType;
import com.christian.rotmgclone.rendering.sprites.Sprite;
import com.christian.rotmgclone.rendering.sprites.Sprites;
import com.christian.rotmgclone.views.View;

public class TerrainView extends View {

	private enum TerrainSpriteType implements ISpriteType {
		GRASS
	}
	
	private Sprite terrainSprite;
	
	public TerrainView() {
		Sprites.GetSpriteManager().RegisterSprite(TerrainSpriteType.GRASS, "grass_0.png");
		terrainSprite = Sprites.GetSpriteManager().GetSprite(TerrainSpriteType.GRASS);
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
