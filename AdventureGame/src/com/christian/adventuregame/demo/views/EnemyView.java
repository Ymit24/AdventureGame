package com.christian.adventuregame.demo.views;

import java.awt.Color;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.View;
import com.christian.adventureengine.rendering.sprites.Sprites;
import com.christian.adventuregame.demo.data.Enemy;
import com.christian.adventuregame.demo.data.archetypes.EnemyType;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.data.archetypes.Archetypes;

public class EnemyView extends View {
	@Override
	public void draw(IRenderer renderer) {
		for (Enemy enemy : State.world.enemies) {
			EnemyType type = Archetypes.Enemies.Get(enemy.id);
			renderer.DrawWorldSprite(Sprites.GetSpriteManager().GetSprite(type.textureFilename), enemy);
			renderer.SetFontSize(24);
			renderer.SetColor(Color.white);
			renderer.DrawWorldText(enemy.health + "/" + type.InitialHealth, enemy.Position.Add(new Vector2(-.3f, .25f)));
		}
	}
}
