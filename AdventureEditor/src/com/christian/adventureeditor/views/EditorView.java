package com.christian.adventureeditor.views;

import com.christian.adventureeditor.EditorData;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.View;
import com.christian.adventureengine.rendering.sprites.ISpriteType;
import com.christian.adventureengine.rendering.sprites.Sprite;
import com.christian.adventureengine.rendering.sprites.Sprites;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.data.terrain.Terrain;
import com.christian.adventuregame.demo.data.terrain.TileArchetypes;
import com.christian.adventuregame.demo.data.terrain.TileType;

public class EditorView extends View {
	
	private UIView uiView;
	
	public EditorView() {
		uiView = new UIView();
	}
	
	@Override
	public void draw(IRenderer renderer) {
		if (EditorData.terrain != null) {
			Terrain terrain = EditorData.terrain;
			for (int x = 0; x < terrain.width; x++) {
				for (int y = 0; y < terrain.height; y++) {
					TileType type = TileArchetypes.Get(terrain.tiles[x][y].type);
					renderer.DrawWorldSprite(Sprites.GetSpriteManager().GetSprite(type.textureFilename), terrain.tiles[x][y]);
				}
			}
		}
		uiView.draw(renderer);
	}
}
