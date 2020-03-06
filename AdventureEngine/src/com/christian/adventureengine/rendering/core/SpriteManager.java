package com.christian.adventureengine.rendering.core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.rendering.Camera;
import com.christian.adventureengine.rendering.sprites.ISpriteManager;
import com.christian.adventureengine.rendering.sprites.ISpriteType;
import com.christian.adventureengine.rendering.sprites.Sprite;

public class SpriteManager implements ISpriteManager {
	private static final String ROOT_SPRITE_PATH = "C:\\Dev\\Git\\AdventureGame\\resources\\sprites\\";
	private HashMap<ISpriteType,Sprite> sprites;
	private HashMap<String, Sprite> fileSprites;
	
	public SpriteManager() {
		sprites = new HashMap<ISpriteType, Sprite>();
		fileSprites = new HashMap<String, Sprite>();
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

	private Sprite RegisterSprite(ISpriteType type, Sprite sprite) {
		if (sprites.containsKey(type)) {
			return sprites.get(type);
		}
		
		sprites.put(type, sprite);
		return sprite;
	}

	@Override
	public Sprite RegisterSprite(String filename) {
		Sprite sprite = LoadSpriteFromFile(filename);
		sprite.PixelsToWorld = new Vector2(sprite.GetImage().getWidth(), sprite.GetImage().getHeight());
		
		if (fileSprites.containsKey(filename)) {
			return fileSprites.get(filename);
		}
		
		fileSprites.put(filename, sprite);
		return sprite;
	}

	public Sprite RegisterSprite(String filename, float worldSpace) {
		Sprite sprite = LoadSpriteFromFile(filename);
		sprite.PixelsToWorld = new Vector2(sprite.GetImage().getWidth() / worldSpace, sprite.GetImage().getHeight() /  worldSpace);

		if (fileSprites.containsKey(filename)) {
			return fileSprites.get(filename);
		}

		fileSprites.put(filename, sprite);
		return sprite;
	}
	@Override
	public Sprite RegisterSprite(ISpriteType type, String filename) {
		Sprite sprite = LoadSpriteFromFile(filename);
		sprite.PixelsToWorld = new Vector2(sprite.GetImage().getWidth(), sprite.GetImage().getHeight());
		return RegisterSprite(type, sprite);
	}
	
	@Override
	public Sprite RegisterSprite(ISpriteType type, String filename, float worldSpace) {
		Sprite sprite = LoadSpriteFromFile(filename);
		Vector2 ptw = new Vector2(sprite.GetImage().getWidth() / worldSpace, sprite.GetImage().getHeight() /  worldSpace);
		
		sprite.PixelsToWorld = ptw;
		return RegisterSprite(type, sprite);
	}
	
	@Override
	public Sprite RegisterSprite(ISpriteType type, String filename, Vector2 pixelsToWorld) {
		Sprite sprite = LoadSpriteFromFile(filename);
		sprite.PixelsToWorld = pixelsToWorld;
		return RegisterSprite(type,sprite);
	}

	@Override
	public Sprite GetSprite(ISpriteType type) {
		if (sprites.containsKey(type) == false)
			return null;
		return sprites.get(type);
	}

	@Override
	public Sprite GetSprite(String filename) {
		for (ISpriteType type : sprites.keySet()) {
			if (sprites.get(type).GetFilename().equals(filename))
				return sprites.get(type);
		}
		if (fileSprites.containsKey(filename))
			return fileSprites.get(filename);
		return null;
	}
}
