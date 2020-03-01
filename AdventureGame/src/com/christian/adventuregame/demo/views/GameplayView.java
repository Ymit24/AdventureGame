package com.christian.adventuregame.demo.views;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.logic.GameLoop;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.View;

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
		
		renderer.DrawWorldText("FPS: " + GameLoop.GetAverageFPS(), new Vector2(0.25f,1));
	}
	
}
