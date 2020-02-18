package com.christian.rotmgclone.demo.views;

import com.christian.rotmgclone.demo.data.Bullet;
import com.christian.rotmgclone.demo.data.Data;
import com.christian.rotmgclone.rendering.IRenderer;
import com.christian.rotmgclone.rendering.sprites.ISpriteType;
import com.christian.rotmgclone.rendering.sprites.Sprite;
import com.christian.rotmgclone.rendering.sprites.Sprites;
import com.christian.rotmgclone.views.View;

public class BulletView extends View {

	private enum BulletSprites implements ISpriteType {
		NORMAL
	}
	
	private Sprite sprite;
	
	public BulletView() {
		Sprites.GetSpriteManager().RegisterSprite(BulletSprites.NORMAL, "bullet.png");
		sprite = Sprites.GetSpriteManager().GetSprite(BulletSprites.NORMAL);
	}
	
	@Override
	public void draw(IRenderer renderer) {
		for (Bullet bullet : Data.world.GetBullets()) {
			renderer.DrawSprite(sprite, bullet.GetPosition());
		}
	}

}
