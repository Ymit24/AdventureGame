package com.christian.adventureengine.demo.views;

import com.christian.adventureengine.demo.data.Bullet;
import com.christian.adventureengine.demo.data.Data;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.View;
import com.christian.adventureengine.rendering.sprites.ISpriteType;
import com.christian.adventureengine.rendering.sprites.Sprite;
import com.christian.adventureengine.rendering.sprites.Sprites;

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
		for (Bullet bullet : Data.world.GetBullets()) {
			renderer.DrawSprite(sprite, bullet.GetPosition());
		}
	}

}
