package com.christian.adventuregame.demo.views;

import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.View;
import com.christian.adventureengine.rendering.sprites.ISpriteType;
import com.christian.adventureengine.rendering.sprites.Sprite;
import com.christian.adventureengine.rendering.sprites.Sprites;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.data.terrain.TileArchetypes;
import com.christian.adventuregame.demo.data.terrain.TileType;

public class TerrainView extends View {
	@Override
	public void draw(IRenderer renderer) {
		for (int x = 0; x < State.terrain.width; x++) {
			for (int y = 0; y < State.terrain.height; y++) {
				TileType type = TileArchetypes.Get(State.terrain.tiles[x][y].type);
				renderer.DrawWorldSprite(Sprites.GetSpriteManager().GetSprite(type.textureFilename), State.terrain.tiles[x][y]);
			}
		}
	}
}
