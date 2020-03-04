package com.christian.adventuregame.demo.views;

import java.awt.Color;

import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.logic.GameLoop;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.View;

public class GameplayView extends View {

	private PlayerView playerView;
	private TerrainView terrainView;
	private BulletView bulletView;
	private EnemyView enemyView;
	private HitEffectView hitEffectView;

	public GameplayView() {
		playerView = new PlayerView();
		terrainView = new TerrainView();
		bulletView = new BulletView();
		enemyView = new EnemyView();
		hitEffectView = new HitEffectView();
	}

	@Override
	public void draw(IRenderer renderer) {
		terrainView.draw(renderer);
		enemyView.draw(renderer);
		playerView.draw(renderer);
		bulletView.draw(renderer);
		hitEffectView.draw(renderer);

		renderer.SetColor(Color.white);
		String fpsText = "FPS: " + GameLoop.GetAverageFPS();
		renderer.SetFontSize(24);
		renderer.DrawScreenText(fpsText, new Vector2(renderer.GetDisplayWidth() - renderer.GetFontWidth(fpsText), 0));
	}

}
