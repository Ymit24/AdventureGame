package com.christian.adventureengine.rendering;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.data.WorldObject;
import com.christian.adventureengine.rendering.sprites.Sprite;

public interface IRenderer {
	public void Initialize(String windowTitle, int width, int height);
	public void OnRender();
	
	public int GetDisplayWidth();
	public int GetDisplayHeight();
	
	public void CreateInput();
	public void CreateSpriteManager();
	public void CreateCamera(Vector2 worldSpaceView);
	public void CreateCamera(Vector2 worldSpaceView, Vector2 screenSpace);
	
	public void SetRootView(View view);

	public void DrawWorldText(String message, Vector2 location);
	public void DrawWorldSprite(Sprite sprite, WorldObject object);

	public void DrawScreenText(String message, Vector2 screenLocation);
	public void DrawScreenSprite(Sprite sprite, Vector2 screenLocation);
}
