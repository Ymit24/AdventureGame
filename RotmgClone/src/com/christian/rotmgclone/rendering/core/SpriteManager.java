package com.christian.rotmgclone.rendering.core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.christian.rotmgclone.rendering.sprites.ISpriteManager;
import com.christian.rotmgclone.rendering.sprites.ISpriteType;
import com.christian.rotmgclone.rendering.sprites.Sprite;

public class SpriteManager implements ISpriteManager {
	private static final String ROOT_SPRITE_PATH = "res/sprites/";
	private HashMap<ISpriteType,Sprite> sprites;
	
	public SpriteManager() {
		sprites = new HashMap<ISpriteType, Sprite>();
	}
	
	private Sprite LoadSpriteFromFile(String filename) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(ROOT_SPRITE_PATH + filename));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return new Sprite(filename, image);
	}

	@Override
	public void RegisterSprite(ISpriteType type, Sprite sprite) {
		if (sprites.containsKey(type)) {
			return;
		}
		
		sprites.put(type, sprite);
	}

	@Override
	public void RegisterSprite(ISpriteType type, String filename) {
		RegisterSprite(type, LoadSpriteFromFile(filename));
	}

	@Override
	public Sprite GetSprite(ISpriteType type) {
		if (sprites.containsKey(type) == false)
			return null;
		return sprites.get(type);
	}

}
