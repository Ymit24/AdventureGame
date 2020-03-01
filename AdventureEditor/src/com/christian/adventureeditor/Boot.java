package com.christian.adventureeditor;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.christian.adventureeditor.controllers.CameraController;
import com.christian.adventureeditor.controllers.Controls;
import com.christian.adventureeditor.controllers.TileChangeController;
import com.christian.adventureeditor.ui.UI;
import com.christian.adventureeditor.ui.elements.Button;
import com.christian.adventureeditor.ui.elements.InputTextField;
import com.christian.adventureeditor.ui.elements.InputTextFieldAndLabel;
import com.christian.adventureeditor.ui.elements.Label;
import com.christian.adventureeditor.ui.elements.Label.Alignment;
import com.christian.adventureeditor.ui.elements.LineBreak;
import com.christian.adventureeditor.views.EditorView;
import com.christian.adventureengine.data.Box;
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
		renderer.CreateCamera(new Vector2(14, 14), new Vector2(800,600));
		renderer.CreateSpriteManager();
		
		renderer.SetRootView(new EditorView());
		
		UI.Create(new Box(0, 30, 300, 600));
		UI.PushElement(new Label("Terrain Editor", 24, Vector2.One().Mul(16), new Color(233, 189, 239)));
		UI.PushElement(new LineBreak(6, new Color(233, 189, 239)));
		UI.PushElement(new Label("Terrain Meta Data", 16, Vector2.One().Mul(12), new Color(233, 189, 239)));
		UI.PushElement(new InputTextFieldAndLabel(
			new Label("Width", 12, Vector2.One().Mul(4), new Color(233, 189, 239)).SetAlignment(Alignment.LEFT),
			(InputTextField)new InputTextField(
				new Label("30", 12, Vector2.One().Mul(4), new Color(233, 189, 239)).SetAlignment(Alignment.LEFT),
				Color.white,
				new Color(65, 34, 68)
			).SetPadding(Vector2.One().Mul(8)),
			0.2f
		));
		UI.PushElement(new InputTextFieldAndLabel(
			new Label("Height", 12, Vector2.One().Mul(4), new Color(233, 189, 239)).SetAlignment(Alignment.LEFT),
			(InputTextField)new InputTextField(
				new Label("30", 12, Vector2.One().Mul(4), new Color(233, 189, 239)).SetAlignment(Alignment.LEFT),
				Color.white,
				new Color(65, 34, 68)
			).SetPadding(Vector2.One().Mul(8)),
			0.2f
		));
		UI.PushElement(new LineBreak(2, new Color(233, 189, 239)));
		UI.PushElement(new InputTextFieldAndLabel(
			new Label("Name", 12, Vector2.One().Mul(4), new Color(233, 189, 239)).SetAlignment(Alignment.LEFT),
			(InputTextField)new InputTextField(
				new Label("Overworld_v1", 12, Vector2.One().Mul(4), new Color(233, 189, 239)).SetAlignment(Alignment.LEFT),
				Color.white,
				new Color(65, 34, 68)
			).SetPadding(Vector2.One().Mul(8)),
			0.2f
		));
		UI.PushElement(new LineBreak(4, new Color(233, 189, 239)));
		UI.PushElement(new Label("Terrain Tools", 16, Vector2.One().Mul(12), new Color(233, 189, 239)));
		UI.PushElement(
			new Button(
				new Label(
					"Grass",
					16,
					Vector2.One().Mul(8),
					new Color(233, 189, 239)
				),
				new Vector2(36,12)
			).SetBorderColor(new Color(233, 189, 239))
			.SetBackgroundColor(new Color(65, 34, 68))
		);
		UI.PushElement(
			new Button(
				new Label(
					"Water",
					16,
					Vector2.One().Mul(8),
					new Color(233, 189, 239)
				),
				new Vector2(36,12)
			).SetBorderColor(new Color(233, 189, 239))
			.SetBackgroundColor(new Color(65, 34, 68))
		);

		
		
		
		
		
		
		
		
		
		
		
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
