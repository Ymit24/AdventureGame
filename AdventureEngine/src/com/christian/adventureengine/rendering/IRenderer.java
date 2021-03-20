package com.christian.adventureengine.rendering;

import java.awt.Color;
import java.util.ArrayList;

import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.data.WorldObject;
import com.christian.adventureengine.rendering.sprites.Sprite;
import com.christian.adventureengine.ui.VerticalPushLayout;

public interface IRenderer {
	public void Initialize(String windowTitle, int width, int height, boolean isFullscreen);
	public void OnRender();
	
	public int GetDisplayWidth();
	public int GetDisplayHeight();
	
	public void CreateInput();
	public void CreateSpriteManager();
	public void CreateCamera(Vector2 worldSpaceView);
	public void CreateCamera(Vector2 worldSpaceView, Box screenSpace);
	public VerticalPushLayout CreateUILayout(Box bounds);

	public void AddView(View view);
	public void RemoveView(View view);

	public ArrayList<VerticalPushLayout> GetLayouts();
	public int GetUILayer();

	public void SetFontSize(int size);
	public void SetColor(Color color);
	public void SetFontFamily(String family);
	public void SetFontFamily(String family, int size);
	
	public int GetFontWidth(String message);
	
	public void DrawWorldText(String message, Vector2 location);
	public void DrawWorldSprite(Sprite sprite, WorldObject object);
	public void DrawWorldSprite(Sprite sprite, Vector2 location, Vector2 size);

	public void DrawScreenText(String message, Vector2 screenLocation);
	public void DrawScreenSprite(Sprite sprite, Vector2 screenLocation);
	public void DrawScreenSprite(Sprite sprite, Box screenBounds);
	
	public void FillBox(Box box, Color color);
}
