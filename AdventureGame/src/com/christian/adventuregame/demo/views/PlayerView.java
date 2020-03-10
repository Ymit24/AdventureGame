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
	public PlayerView() {
		super(4);
		Sprites.GetSpriteManager().RegisterSprite("player_idle.png");
	}
	
	@Override
	public void draw(IRenderer renderer) {
		renderer.DrawWorldSprite(Sprites.GetSpriteManager().GetSprite("player_idle.png"), State.world.player);
	}

}
