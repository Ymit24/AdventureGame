package com.christian.adventuregame.demo.views;

import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.View;
import com.christian.adventureengine.rendering.sprites.ISpriteType;
import com.christian.adventureengine.rendering.sprites.Sprite;
import com.christian.adventureengine.rendering.sprites.Sprites;
import com.christian.adventuregame.demo.data.Inventory;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.data.archetypes.ItemType;
import com.christian.adventuregame.demo.ui.elements.InventorySlot;

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
		renderer.DrawWorldSprite(sprite, State.world.player);
	}

}
