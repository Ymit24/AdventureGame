package com.christian.adventuregame.demo.views;

import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.View;
import com.christian.adventureengine.rendering.sprites.ISpriteType;
import com.christian.adventureengine.rendering.sprites.Sprite;
import com.christian.adventureengine.rendering.sprites.Sprites;
import com.christian.adventuregame.demo.data.Bullet;
import com.christian.adventuregame.demo.data.State;

public class BulletView extends View {

	private enum BulletSprites implements ISpriteType {
		NORMAL
	}
	
	private Sprite sprite;
	
	public BulletView() {
		Sprites.GetSpriteManager().RegisterSprite(BulletSprites.NORMAL, "bullet.png", 0.25f);
		sprite = Sprites.GetSpriteManager().GetSprite(BulletSprites.NORMAL);
	}
	
	@Override
	public void draw(IRenderer renderer) {
		for (Bullet bullet : State.world.bullets) {
			renderer.DrawWorldSprite(sprite, bullet);
		}
	}

}
