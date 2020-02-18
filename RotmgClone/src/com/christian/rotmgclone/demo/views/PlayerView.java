package com.christian.rotmgclone.demo.views;

import com.christian.rotmgclone.demo.data.Data;
import com.christian.rotmgclone.rendering.IRenderer;
import com.christian.rotmgclone.rendering.sprites.ISpriteType;
import com.christian.rotmgclone.rendering.sprites.Sprite;
import com.christian.rotmgclone.rendering.sprites.Sprites;
import com.christian.rotmgclone.views.View;

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
