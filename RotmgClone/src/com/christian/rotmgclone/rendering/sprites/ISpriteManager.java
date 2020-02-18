package com.christian.rotmgclone.rendering.sprites;

public interface ISpriteManager {
	public void RegisterSprite(ISpriteType type, Sprite sprite);
	public void RegisterSprite(ISpriteType type, String filename);
	
	public Sprite GetSprite(ISpriteType type);
}
