package com.christian.adventureeditor;

import java.io.IOException;

import com.christian.adventureeditor.controllers.CameraController;
import com.christian.adventureeditor.controllers.TileChangeController;
import com.christian.adventureeditor.views.EditorView;
import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.logic.ControllerManager;
import com.christian.adventureengine.logic.GameLoop;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.core.CoreRenderer;
import com.christian.adventuregame.demo.utils.TerrainUtil;
import com.christian.adventuregame.demo.utils.TileLoaderUtil;

public class Boot {
	public static void main(String[] args) throws IOException {
		IRenderer renderer = new CoreRenderer();
		renderer.Initialize("Adventure Editor", 800, 600);
		renderer.CreateInput();
		renderer.CreateCamera(new Vector2(14, 14), new Vector2(800,600));
		renderer.CreateSpriteManager();
		
		TileLoaderUtil.LoadTileTypes();
		EditorData.layout = renderer.CreateUILayout(new Box(0, 30, 300, 600));
		
		renderer.SetRootView(new EditorView());
		
		EditorData.terrain = TerrainUtil.LoadFromFile();
		
//		ControllerManager.AddController(new Controls());
		ControllerManager.AddController(new TileChangeController());
		ControllerManager.AddController(new CameraController());
		
		GameLoop.Initialize(new ControllerManager(), renderer);
		GameLoop.Start();
	}
}
