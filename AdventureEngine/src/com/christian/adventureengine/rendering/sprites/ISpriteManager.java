package com.christian.adventureengine.rendering.sprites;

import com.christian.adventureengine.data.Vector2;

public interface ISpriteManager {
	public void RegisterSprite(ISpriteType type, String filename);
	public void RegisterSprite(ISpriteType type, String filename, float worldSpace);
	public void RegisterSprite(ISpriteType type, String filename, Vector2 pixelsToWorld);
	
	public Sprite GetSprite(ISpriteType type);
}
