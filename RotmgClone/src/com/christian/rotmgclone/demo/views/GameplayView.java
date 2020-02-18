package com.christian.rotmgclone.demo.views;

import com.christian.rotmgclone.data.Vector2;
import com.christian.rotmgclone.logic.GameLoop;
import com.christian.rotmgclone.rendering.IRenderer;
import com.christian.rotmgclone.views.View;

public class GameplayView extends View {
	
	private PlayerView playerView;
	private TerrainView terrainView;
	private BulletView bulletView;
	
	public GameplayView() {
		playerView = new PlayerView();
		terrainView = new TerrainView();
		bulletView = new BulletView();
	}
	
	@Override
	public void draw(IRenderer renderer) {
		terrainView.draw(renderer);
		playerView.draw(renderer);
		bulletView.draw(renderer);
		
		renderer.DrawText("FPS: " + GameLoop.GetAverageFPS(), new Vector2(50,50));
	}
	
}
