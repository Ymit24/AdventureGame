package com.christian.adventuregame.demo.views;

import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.rendering.Camera;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.View;
import com.christian.adventureengine.rendering.sprites.Sprites;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.data.archetypes.Archetypes;
import com.christian.adventuregame.demo.data.archetypes.TileType;

import java.awt.*;

public class TerrainView extends View {
	@Override
	public void draw(IRenderer renderer) {
		for (int x = 0; x < State.terrain.width; x++) {
			for (int y = 0; y < State.terrain.height; y++) {
				TileType type = Archetypes.Tiles.Get(State.terrain.tiles[x][y].type);
				renderer.DrawWorldSprite(Sprites.GetSpriteManager().GetSprite(type.textureFilename), State.terrain.tiles[x][y]);

				renderer.SetFontSize(12);
				renderer.SetColor(Color.black);

				Vector2 pos = Box.Center(
					new Box(
						State.terrain.tiles[x][y].Position,
						Vector2.One()
					),
					Camera.GetCamera().ConvertPixelToWorldUnit(
						new Vector2(
							renderer.GetFontWidth(State.terrain.tiles[x][y].regionId),
							12
						)
					)
				);

				renderer.DrawWorldText(State.terrain.tiles[x][y].regionId, pos);
			}
		}
	}
}
