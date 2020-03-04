package com.christian.adventureeditor.views;

import java.awt.Color;

import com.christian.adventureeditor.EditorData;
import com.christian.adventureeditor.UISkin;
import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.View;
import com.christian.adventureengine.ui.IButtonCallback;
import com.christian.adventureengine.ui.VerticalPushLayout;
import com.christian.adventureengine.ui.elements.Button;
import com.christian.adventureengine.ui.elements.Label;
import com.christian.adventureengine.ui.elements.LineBreak;
import com.christian.adventuregame.demo.data.terrain.Terrain;
import com.christian.adventuregame.demo.data.terrain.TileArchetypes;
import com.christian.adventuregame.demo.data.terrain.TileType;
import com.christian.adventuregame.demo.utils.TerrainUtil;

public class UIView extends View implements IButtonCallback {
	
	public UIView() {
		VerticalPushLayout mainLayout = EditorData.layout;
		Color uiBackground = new Color(65, 34, 68);
		Color uiForeground = new Color(233, 189, 239);
		
		mainLayout.PushElement(
			new Label(mainLayout, "terrainEditorTitle_label", "Terrain Editor")
			.SetFontSize(24).SetPadding(Vector2.One().Mul(16))
			.SetFontColor(uiForeground)
		);
		
		mainLayout.PushElement(
			new LineBreak(mainLayout, "lineBreak_1", 6)
			.SetColor(uiForeground)
		);
		
		mainLayout.PushElement(UISkin.CreateSubHeader(mainLayout, "terrainMetaData_label", "Terrain Meta Data"));
		
		mainLayout.PushElement(UISkin.CreateInputWithLabel(mainLayout, "width", "Width", "30"));
		mainLayout.PushElement(UISkin.CreateInputWithLabel(mainLayout, "height", "Height", "30"));
		
		mainLayout.PushElement(
			new LineBreak(mainLayout, "lineBreak_2", 2)
			.SetColor(uiForeground)
		);
		
		mainLayout.PushElement(UISkin.CreateInputWithLabel(mainLayout, "name", "Name", "OVERWORLD_V1"));

		mainLayout.PushElement(UISkin.CreateButton(mainLayout, "new", "New").SetCallback(this));
		
		mainLayout.PushElement(
			UISkin.CreateSplitContainer(
				mainLayout,
				"save_and_load",
				UISkin.CreateButton(mainLayout, "save", "Save").SetCallback(this),
				UISkin.CreateButton(mainLayout, "load", "Load").SetCallback(this)
			)
		);
//		mainLayout.PushElement(UISkin.CreateButton(mainLayout, "save", "Save"));
//		mainLayout.PushElement(UISkin.CreateButton(mainLayout, "load", "Load"));

		mainLayout.PushElement(
			new LineBreak(mainLayout, "lineBreak_3", 4)
			.SetColor(uiForeground)
		);
		
		mainLayout.PushElement(UISkin.CreateSubHeader(mainLayout, "terrainTools_label", "Terrain Tools"));
		
		TileType[] tileTypes = TileArchetypes.GetAll();
		for (TileType type : tileTypes) {
			Button button = UISkin.CreateButton(mainLayout, type.id, type.id);
			button.SetCallback(this);
			mainLayout.PushElement(button);
		}
		
//		mainLayout.PushElement(UISkin.CreateButton(mainLayout, "grass", "Grass"));
//		mainLayout.PushElement(UISkin.CreateButton(mainLayout, "water", "Water"));
		
		mainLayout.RecalculateHeights();
		
//		((Button)mainLayout.FindElementById("update_meta_button")).SetCallback(this);
	}
	
	@Override
	public void draw(IRenderer renderer) {
		renderer.FillBox(new Box(0,0,1280,30), new Color(250, 224, 255));
		renderer.SetColor(Color.black);
		renderer.SetFontSize(16);
		
		Vector2 modeCenter = Box.Center(new Box(0, 0, renderer.GetFontWidth("Mode") + 16, 30), new Vector2(renderer.GetFontWidth("Mode"), 16));
		Vector2 fileCenter = Box.Center(new Box(renderer.GetFontWidth("Mode") + 16 + 8, 0, renderer.GetFontWidth("File") + 12, 30), new Vector2(renderer.GetFontWidth("File"), 16));
		
		renderer.DrawScreenText("Mode", modeCenter);
		renderer.DrawScreenText("File", fileCenter);
		
		renderer.FillBox(EditorData.layout.bounds, new Color(65, 34, 68));
	}

	@Override
	public void OnButtonClicked(String id) {
		VerticalPushLayout layout = EditorData.layout;
		
		if (id.equals("new_button")) {
			String widthText = ((Label)layout.FindElementById("width_inputfield_label")).text;
			String heightText = ((Label)layout.FindElementById("height_inputfield_label")).text;
			System.out.println("Dimensions: <" + widthText + ", " + heightText + ">");
			
			EditorData.terrain = new Terrain(Integer.parseInt(widthText), Integer.parseInt(heightText));
			
		} else if (id.equals("save_button")) {
			TerrainUtil.SaveToFile(EditorData.terrain);
		} else if (id.equals("load_button")) {
			EditorData.terrain = TerrainUtil.LoadFromFile();
		} else {
			System.out.println("Clicked button: " + id.split("_")[0]);
			EditorData.paintingTileType = id.split("_")[0];
		}
	}
}
