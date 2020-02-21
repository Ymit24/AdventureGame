package com.christian.adventureengine.rendering;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.rendering.sprites.Sprite;

public interface IRenderer {
	public void Initialize(String windowTitle, int width, int height);
	public void OnRender();
	
	public void CreateInput();
	public void CreateSpriteManager();
	public void CreateCamera(Vector2 worldSpaceView);
	
	public void SetRootView(View view);
	
	public void DrawSprite(Sprite sprite, Vector2 location);
	public void DrawText(String message, Vector2 location);
}
