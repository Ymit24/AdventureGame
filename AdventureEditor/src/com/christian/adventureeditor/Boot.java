package com.christian.adventureeditor;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.christian.adventureeditor.controllers.CameraController;
import com.christian.adventureeditor.controllers.Controls;
import com.christian.adventureeditor.controllers.TileChangeController;
import com.christian.adventureeditor.ui.VerticalPushLayout;
import com.christian.adventureeditor.ui.elements.Button;
import com.christian.adventureeditor.ui.elements.InputTextField;
import com.christian.adventureeditor.ui.elements.InputTextFieldAndLabel;
import com.christian.adventureeditor.ui.elements.Label;
import com.christian.adventureeditor.ui.elements.LineBreak;
import com.christian.adventureeditor.ui.elements.Label.Alignment;
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
		
		EditorData.layout = VerticalPushLayout.Create(new Box(0, 30, 300, 600));
		VerticalPushLayout mainLayout = EditorData.layout;
		Color uiBackground = new Color(65, 34, 68);
		Color uiForeground = new Color(233, 189, 239);
		
		MainLayoutState mainLayoutState = new MainLayoutState();
		mainLayoutState.width = new InputTextFieldAndLabel(mainLayout, "width_inputlabel", new Label(mainLayout, "width_input_label", "Width"), new InputTextField(mainLayout, "width_inputfield", new Label(mainLayout, "width_inputfield_label", "30")), 0.2f);
		mainLayoutState.height = new InputTextFieldAndLabel(mainLayout, "height_inputlabel", new Label(mainLayout, "height_input_label", "Height"), new InputTextField(mainLayout, "height_inputfield", new Label(mainLayout, "height_inputfield_label", "30")), 0.2f);
		mainLayoutState.name = new InputTextFieldAndLabel(mainLayout, "name_inputlabel", new Label(mainLayout, "name_input_label", "Name"), new InputTextField(mainLayout, "name_inputfield", new Label(mainLayout, "name_input_label", "Overworld_v1")), 0.2f);
		
		mainLayoutState.width.label.SetFontSize(12).SetFontColor(uiForeground).SetAlignment(Alignment.RIGHT).SetPadding(new Vector2(4, 0));
		mainLayoutState.width.input.SetPadding(new Vector2(8,8)).SetBorderColor(uiForeground).SetBackgroundColor(uiBackground).text.SetAlignment(Alignment.LEFT).SetFontSize(12).SetFontColor(Color.white);
		
		mainLayoutState.height.label.SetFontSize(12).SetFontColor(uiForeground).SetAlignment(Alignment.RIGHT).SetPadding(new Vector2(4, 0));
		mainLayoutState.height.input.SetPadding(new Vector2(8,8)).SetBorderColor(uiForeground).SetBackgroundColor(uiBackground).text.SetAlignment(Alignment.LEFT).SetFontSize(12).SetFontColor(Color.white);

		mainLayoutState.name.label.SetFontSize(12).SetFontColor(uiForeground).SetAlignment(Alignment.RIGHT).SetPadding(new Vector2(4, 0));
		mainLayoutState.name.input.SetPadding(new Vector2(8,8)).SetBorderColor(uiForeground).SetBackgroundColor(uiBackground).text.SetAlignment(Alignment.LEFT).SetFontSize(12).SetFontColor(Color.white);
		
		mainLayoutState.grass = new Button(mainLayout, "grass_button", new Label(mainLayout, "grass_label", "Grass"));
		mainLayoutState.water = new Button(mainLayout, "water_button", new Label(mainLayout, "water_label", "Water"));
		
		mainLayoutState.grass.SetPadding(new Vector2(36, 12)).SetBorderColor(uiForeground).SetBackgroundColor(uiBackground).text.SetFontSize(16).SetFontColor(uiForeground).SetPadding(Vector2.One().Mul(8));
		mainLayoutState.water.SetPadding(new Vector2(36, 12)).SetBorderColor(uiForeground).SetBackgroundColor(uiBackground).text.SetFontSize(16).SetFontColor(uiForeground).SetPadding(Vector2.One().Mul(8));
		
		mainLayout.PushElement(
			new Label(mainLayout, "terrainEditorTitle_label", "Terrain Editor")
			.SetFontSize(24).SetPadding(Vector2.One().Mul(16))
			.SetFontColor(uiForeground)
		);
		
		mainLayout.PushElement(
			new LineBreak(mainLayout, "lineBreak_1", 6)
			.SetColor(uiForeground)
		);
		
		mainLayout.PushElement(
			new Label(mainLayout, "terrainMetaData_label", "Terrain Meta Data")
			.SetFontSize(16).SetPadding(Vector2.One().Mul(12))
			.SetFontColor(uiForeground)
		);
		
		mainLayout.PushElement(mainLayoutState.width);
		mainLayout.PushElement(mainLayoutState.height);
		
		mainLayout.PushElement(
			new LineBreak(mainLayout, "lineBreak_2", 2)
			.SetColor(uiForeground)
		);
		
		mainLayout.PushElement(mainLayoutState.name);

		mainLayout.PushElement(
			new LineBreak(mainLayout, "lineBreak_3", 4)
			.SetColor(uiForeground)
		);
		
		mainLayout.PushElement(
			new Label(mainLayout, "terrainTools_label", "Terrain Tools")
			.SetFontSize(16).SetFontColor(uiForeground)
			.SetPadding(Vector2.One().Mul(12))
		);
		
		mainLayout.PushElement(mainLayoutState.grass);
		mainLayout.PushElement(mainLayoutState.water);
		
		mainLayout.RecalculateHeights();
		
//		mainLayout.PushElement(new Label("Terrain Editor", 24, Vector2.One().Mul(16), new Color(233, 189, 239)));
//		mainLayout.PushElement(new LineBreak(6, new Color(233, 189, 239)));
//		mainLayout.PushElement(new Label("Terrain Meta Data", 16, Vector2.One().Mul(12), new Color(233, 189, 239)));
//		mainLayout.PushElement(new InputTextFieldAndLabel(
//			new Label("Width", 12, Vector2.One().Mul(4), new Color(233, 189, 239)).SetAlignment(Alignment.LEFT),
//			(InputTextField)new InputTextField(
//				new Label("30", 12, Vector2.One().Mul(4), new Color(233, 189, 239)).SetAlignment(Alignment.LEFT),
//				Color.white,
//				new Color(65, 34, 68)
//			).SetPadding(Vector2.One().Mul(8)),
//			0.2f
//		));
//		mainLayout.PushElement(new InputTextFieldAndLabel(
//			new Label("Height", 12, Vector2.One().Mul(4), new Color(233, 189, 239)).SetAlignment(Alignment.LEFT),
//			(InputTextField)new InputTextField(
//				new Label("30", 12, Vector2.One().Mul(4), new Color(233, 189, 239)).SetAlignment(Alignment.LEFT),
//				Color.white,
//				new Color(65, 34, 68)
//			).SetPadding(Vector2.One().Mul(8)),
//			0.2f
//		));
//		mainLayout.PushElement(new LineBreak(2, new Color(233, 189, 239)));
//		mainLayout.PushElement(new InputTextFieldAndLabel(
//			new Label("Name", 12, Vector2.One().Mul(4), new Color(233, 189, 239)).SetAlignment(Alignment.LEFT),
//			(InputTextField)new InputTextField(
//				new Label("Overworld_v1", 12, Vector2.One().Mul(4), new Color(233, 189, 239)).SetAlignment(Alignment.LEFT),
//				Color.white,
//				new Color(65, 34, 68)
//			).SetPadding(Vector2.One().Mul(8)),
//			0.2f
//		));
//		mainLayout.PushElement(new LineBreak(4, new Color(233, 189, 239)));
//		mainLayout.PushElement(new Label("Terrain Tools", 16, Vector2.One().Mul(12), new Color(233, 189, 239)));
//		mainLayout.PushElement(
//			new Button(
//				new Label(
//					"Grass",
//					16,
//					Vector2.One().Mul(8),
//					new Color(233, 189, 239)
//				),
//				new Vector2(36,12)
//			).SetBorderColor(new Color(233, 189, 239))
//			.SetBackgroundColor(new Color(65, 34, 68))
//		);
//		mainLayout.PushElement(
//			new Button(
//				new Label(
//					"Water",
//					16,
//					Vector2.One().Mul(8),
//					new Color(233, 189, 239)
//				),
//				new Vector2(36,12)
//			).SetBorderColor(new Color(233, 189, 239))
//			.SetBackgroundColor(new Color(65, 34, 68))
//		);

		
		
		
		
		
		
		
		
		
		
		
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
