package com.christian.adventureeditor.views;

import com.christian.adventureeditor.EditorData;
import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.rendering.Camera;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.View;
import com.christian.adventureengine.rendering.sprites.Sprites;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.data.archetypes.*;
import com.christian.adventuregame.demo.data.terrain.Terrain;
import com.christian.adventuregame.demo.views.TerrainView;

import java.awt.*;

public class EditorView extends View {

	public EditorView() {
		super(1000);
	}

	public static Color hex2Rgb(String colorStr) {
		return new Color(
				Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
				Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
				Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
	}

	@Override
	public void draw(IRenderer renderer) {
		if (EditorData.terrain != null) {
			Terrain terrain = EditorData.terrain;
			for (int x = 0; x < terrain.width; x++) {
				for (int y = 0; y < terrain.height; y++) {
					TileType type = Archetypes.Tiles.Get(terrain.tiles[x][y].type);
					renderer.DrawWorldSprite(Sprites.GetSpriteManager().GetSprite(type.textureFilename), terrain.tiles[x][y]);

					if (EditorData.state.equals(EditorData.EditorState.Region)) {
						RegionType regionType = Archetypes.Regions.Get(terrain.tiles[x][y].regionId);
						Color regionColor = Color.decode("#" + regionType.editorHexColor);
						regionColor = new Color(regionColor.getRed(), regionColor.getGreen(), regionColor.getBlue(), 50);
						renderer.FillBox(
								new Box(
										Camera.GetCamera().CalculateWorldToScreen(terrain.tiles[x][y].Position),
										Camera.GetCamera().GetPixelsPerWorldUnit()
								),
								regionColor
						);
					} else if (EditorData.state.equals(EditorData.EditorState.Features) && !terrain.tiles[x][y].terrainFeatureId.equals("none")) {
						TerrainFeatureType featureType = Archetypes.TerrianFeatures.Get(terrain.tiles[x][y].terrainFeatureId);
						renderer.DrawWorldSprite(Sprites.GetSpriteManager().GetSprite(featureType.textureFilename), terrain.tiles[x][y]);
					}
				}
			}
		}

		renderer.SetFontSize(24);
		renderer.SetColor(Color.black);
		String m = "PPWU: " + Camera.GetCamera().GetPixelsPerWorldUnit();
		renderer.DrawScreenText(m, new Vector2(renderer.GetDisplayWidth()-renderer.GetFontWidth(m), 40));
	}
}
