package com.christian.rotmgclone.rendering;

import com.christian.rotmgclone.data.world.Vector2;
import com.christian.rotmgclone.rendering.sprites.Sprite;
import com.christian.rotmgclone.views.View;

public interface IRenderer {
	public void Initialize();
	public void OnRender();
	
	public void CreateInput();
	public void CreateSpriteManager();
	
	public void SetRootView(View view);
	
	public void DrawSprite(Sprite sprite, Vector2 location);
}
