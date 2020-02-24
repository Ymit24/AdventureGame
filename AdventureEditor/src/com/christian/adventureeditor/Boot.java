package com.christian.adventureeditor;

import com.christian.adventureeditor.controllers.CameraController;
import com.christian.adventureeditor.controllers.TileChangeController;
import com.christian.adventureeditor.views.EditorView;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.logic.ControllerManager;
import com.christian.adventureengine.logic.GameLoop;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.core.CoreRenderer;
import com.christian.adventuregame.demo.data.Terrain;

public class Boot {
	public static void main(String[] args) {
		IRenderer renderer = new CoreRenderer();
		renderer.Initialize("Adventure Editor", 800, 600);
		renderer.CreateInput();
		renderer.CreateCamera(new Vector2(8, 8), new Vector2(600,600));
		renderer.CreateSpriteManager();
		
		EditorData.terrain = new Terrain(8, 8);
		
		renderer.SetRootView(new EditorView());
		
		ControllerManager.AddController(new TileChangeController());
		ControllerManager.AddController(new CameraController());
		
		GameLoop.Initialize(new ControllerManager(), renderer);
		GameLoop.Start();
	}
}
