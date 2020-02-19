package com.christian.adventureengine.demo.views;

import com.christian.adventureengine.demo.data.Data;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.View;
import com.christian.adventureengine.rendering.sprites.ISpriteType;
import com.christian.adventureengine.rendering.sprites.Sprite;
import com.christian.adventureengine.rendering.sprites.Sprites;

public class PlayerView extends View {

	private enum PlayerSprites implements ISpriteType {
		IDLE,
		WALK_0,
		WALK_1
	}
	
	private Sprite sprite;
	
	public PlayerView() {
		Sprites.GetSpriteManager().RegisterSprite(PlayerSprites.IDLE, "player_idle.png");
		
		sprite = Sprites.GetSpriteManager().GetSprite(PlayerSprites.IDLE);
	}
	
	@Override
	public void draw(IRenderer renderer) {
		renderer.DrawSprite(sprite, Data.world.GetPlayer().GetPosition());
	}

}
