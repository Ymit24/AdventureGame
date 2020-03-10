package com.christian.adventuregame.demo.views;

import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.View;
import com.christian.adventureengine.rendering.sprites.ISpriteType;
import com.christian.adventureengine.rendering.sprites.Sprite;
import com.christian.adventureengine.rendering.sprites.Sprites;
import com.christian.adventureengine.utils.Randomizer;
import com.christian.adventuregame.demo.data.Bullet;
import com.christian.adventuregame.demo.data.State;

public class BulletView extends View {
	public BulletView() {
		super(3);
	}

	@Override
	public void draw(IRenderer renderer) {
		for (Bullet bullet : State.world.bullets) {
			renderer.DrawWorldSprite(Sprites.GetSpriteManager().GetSprite(bullet.type.textureFilename), bullet);
		}
	}

}
