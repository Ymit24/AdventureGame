package com.christian.adventureeditor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.christian.adventureeditor.controllers.CameraController;
import com.christian.adventureeditor.controllers.Controls;
import com.christian.adventureeditor.controllers.TileChangeController;
import com.christian.adventureeditor.views.EditorView;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.logic.ControllerManager;
import com.christian.adventureengine.logic.GameLoop;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.core.CoreRenderer;
import com.christian.adventureengine.utils.Deserializer;
import com.christian.adventuregame.demo.data.Terrain;

public class Boot {
	public static void main(String[] args) throws IOException {
		IRenderer renderer = new CoreRenderer();
		renderer.Initialize("Adventure Editor", 800, 600);
		renderer.CreateInput();
		renderer.CreateCamera(new Vector2(8, 8), new Vector2(600,600));
		renderer.CreateSpriteManager();
		
		renderer.SetRootView(new EditorView());
		
		File file = new File("terrain.txt");
		byte[] bytes = Files.readAllBytes(file.toPath());
		
		Deserializer deserializer = new Deserializer(bytes);
		EditorData.terrain = Terrain.Deserialize(deserializer);
		
		ControllerManager.AddController(new Controls());
		ControllerManager.AddController(new TileChangeController());
		ControllerManager.AddController(new CameraController());
		
		GameLoop.Initialize(new ControllerManager(), renderer);
		GameLoop.Start();
	}
}
