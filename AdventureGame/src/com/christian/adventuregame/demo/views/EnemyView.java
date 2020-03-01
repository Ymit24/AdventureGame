package com.christian.adventuregame.demo.views;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.View;
import com.christian.adventureengine.rendering.sprites.ISpriteType;
import com.christian.adventureengine.rendering.sprites.Sprite;
import com.christian.adventureengine.rendering.sprites.Sprites;
import com.christian.adventuregame.demo.data.Enemy;
import com.christian.adventuregame.demo.data.State;

public class EnemyView extends View {
	
	enum EnemySpriteType implements ISpriteType {
		blob
	}
	
	private Sprite enemySprite;
	
	public EnemyView() {
		enemySprite = Sprites.GetSpriteManager().RegisterSprite(EnemySpriteType.blob, "blob.png");
	}
	
	@Override
	public void draw(IRenderer renderer) {
		for (Enemy enemy : State.world.enemies) {
			renderer.DrawWorldSprite(enemySprite, enemy);
			renderer.DrawWorldText(enemy.health + "/10", enemy.Position.Add(new Vector2(-.3f, .25f)));
		}
	}
}
