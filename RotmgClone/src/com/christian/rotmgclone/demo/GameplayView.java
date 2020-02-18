package com.christian.rotmgclone.demo;

import com.christian.rotmgclone.data.Vector2;
import com.christian.rotmgclone.logic.GameLoop;
import com.christian.rotmgclone.rendering.IRenderer;
import com.christian.rotmgclone.views.View;

public class GameplayView extends View {
	
	private PlayerView playerView;
	private TerrainView terrainView;
	
	public GameplayView() {
		playerView = new PlayerView();
		terrainView = new TerrainView();
	}
	
	@Override
	public void draw(IRenderer renderer) {
		terrainView.draw(renderer);
		playerView.draw(renderer);
		
		renderer.DrawText("FPS: " + GameLoop.GetAverageFPS(), new Vector2(50,50));
	}
	
}
