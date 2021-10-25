package com.christian.adventureeditor;

import java.io.IOException;

import com.christian.adventureeditor.controllers.CameraController;
import com.christian.adventureeditor.controllers.PaintController;
import com.christian.adventureeditor.ui.MainTools;
import com.christian.adventureeditor.views.EditorView;
import com.christian.adventureeditor.views.UIView;
import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.logic.ControllerManager;
import com.christian.adventureengine.logic.GameLoop;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.core.CoreRenderer;
import com.christian.adventureengine.ui.LayoutType;
import com.christian.adventureengine.ui.VerticalPushLayout;
import com.christian.adventureengine.utils.ResourceManager;
import com.christian.adventuregame.demo.utils.TerrainUtil;
import com.christian.adventuregame.demo.utils.loaders.RegionLoaderUtil;
import com.christian.adventuregame.demo.utils.loaders.TerrainFeatureLoader;
import com.christian.adventuregame.demo.utils.loaders.TileLoaderUtil;

public class EditorBoot {
	public static void main(String[] args) throws IOException {
		IRenderer renderer = new CoreRenderer();
		renderer.Initialize("Adventure Editor", 1280, 720, false);
		renderer.CreateInput();
		renderer.CreateCamera(new Vector2(14, 14), new Box(300, 0, 980, 720));
		renderer.CreateSpriteManager();
		
		ResourceManager.Initialize(new ResourceManager());
		
		TileLoaderUtil.LoadTileTypes();
		RegionLoaderUtil.LoadRegions();
		TerrainFeatureLoader.Load();
		EditorData.layout = (VerticalPushLayout) renderer.CreateFrame("_editor_", "_main_frame_", new Box(0,30,300,720), LayoutType.VERTICAL_PUSH, false, false, false, 0).Layout;
//		EditorData.layout = renderer.CreateUILayout(new Box(0, 30, 300, 720));
		new MainTools();
		
		renderer.AddView(new EditorView());
		renderer.AddView(new UIView());

		EditorData.terrain = TerrainUtil.LoadFromFile();

		ControllerManager.AddController(new PaintController());
		ControllerManager.AddController(new CameraController());
		
		GameLoop.Initialize(new ControllerManager(), renderer);
		GameLoop.Start();
	}
}
