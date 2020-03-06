package com.christian.adventureengine.rendering.sprites;

import com.christian.adventureengine.data.Vector2;

public interface ISpriteManager {
	public Sprite RegisterSprite(String filename);
	public Sprite RegisterSprite(String filename, float worldSpace);
	public Sprite RegisterSprite(ISpriteType type, String filename);
	public Sprite RegisterSprite(ISpriteType type, String filename, float worldSpace);
	public Sprite RegisterSprite(ISpriteType type, String filename, Vector2 pixelsToWorld);
	
	public Sprite GetSprite(ISpriteType type);
	public Sprite GetSprite(String filename);
}
