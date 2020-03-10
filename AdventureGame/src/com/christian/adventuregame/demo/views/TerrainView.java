package com.christian.adventuregame.demo.views;

import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.rendering.Camera;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.View;
import com.christian.adventureengine.rendering.sprites.Sprites;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.data.archetypes.Archetypes;
import com.christian.adventuregame.demo.data.archetypes.TerrainFeatureType;
import com.christian.adventuregame.demo.data.archetypes.TileType;
import com.christian.adventuregame.demo.data.terrain.Tile;

import java.awt.*;

public class TerrainView extends View {
	public TerrainView() {
		super(1);
	}

	@Override
	public void draw(IRenderer renderer) {
		for (int x = 0; x < State.terrain.width; x++) {
			for (int y = 0; y < State.terrain.height; y++) {
				Tile tile = State.terrain.tiles[x][y];
				TileType type = Archetypes.Tiles.Get(tile.type);
				renderer.DrawWorldSprite(Sprites.GetSpriteManager().GetSprite(type.textureFilename), tile);

				if (!tile.terrainFeatureId.equals("none")) {
					TerrainFeatureType featureType = Archetypes.TerrianFeatures.Get(tile.terrainFeatureId);
					renderer.DrawWorldSprite(Sprites.GetSpriteManager().GetSprite(featureType.textureFilename), tile);
				}
			}
		}
	}
}
