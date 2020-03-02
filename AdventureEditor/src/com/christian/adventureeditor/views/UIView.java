package com.christian.adventureeditor.views;

import java.awt.Color;

import com.christian.adventureeditor.EditorData;
import com.christian.adventureeditor.MainLayoutState;
import com.christian.adventureeditor.ui.VerticalPushLayout;
import com.christian.adventureeditor.ui.elements.Button;
import com.christian.adventureeditor.ui.elements.Element;
import com.christian.adventureeditor.ui.elements.InputTextField;
import com.christian.adventureeditor.ui.elements.Label;
import com.christian.adventureeditor.ui.elements.LineBreak;
import com.christian.adventureeditor.ui.elements.SplitContainer;
import com.christian.adventureeditor.ui.elements.Label.Alignment;
import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.input.Input;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.View;

public class UIView extends View {
	
	public UIView() {
		EditorData.layout = VerticalPushLayout.Create(new Box(0, 30, 300, 600));
		VerticalPushLayout mainLayout = EditorData.layout;
		Color uiBackground = new Color(65, 34, 68);
		Color uiForeground = new Color(233, 189, 239);
		
		MainLayoutState mainLayoutState = new MainLayoutState();
		mainLayoutState.width = new SplitContainer(mainLayout, "width_inputlabel", new Label(mainLayout, "width_input_label", "Width"), new InputTextField(mainLayout, "width_inputfield", new Label(mainLayout, "width_inputfield_label", "30")), 0.2f);
		mainLayoutState.height = new SplitContainer(mainLayout, "height_inputlabel", new Label(mainLayout, "height_input_label", "Height"), new InputTextField(mainLayout, "height_inputfield", new Label(mainLayout, "height_inputfield_label", "30")), 0.2f);
		mainLayoutState.name = new SplitContainer(mainLayout, "name_inputlabel", new Label(mainLayout, "name_input_label", "Name"), new InputTextField(mainLayout, "name_inputfield", new Label(mainLayout, "name_input_label", "Overworld_v1")), 0.2f);
		
		((Label)mainLayoutState.width.children[0]).SetFontSize(12).SetFontColor(uiForeground).SetAlignment(Alignment.RIGHT).SetPadding(new Vector2(4, 0));
		((InputTextField)mainLayoutState.width.children[1]).SetPadding(new Vector2(8,8)).SetBorderColor(uiForeground).SetBackgroundColor(uiBackground).text.SetAlignment(Alignment.LEFT).SetFontSize(12).SetFontColor(Color.white);
		
		((Label)mainLayoutState.height.children[0]).SetFontSize(12).SetFontColor(uiForeground).SetAlignment(Alignment.RIGHT).SetPadding(new Vector2(4, 0));
		((InputTextField)mainLayoutState.height.children[1]).SetPadding(new Vector2(8,8)).SetBorderColor(uiForeground).SetBackgroundColor(uiBackground).text.SetAlignment(Alignment.LEFT).SetFontSize(12).SetFontColor(Color.white);

		((Label)mainLayoutState.name.children[0]).SetFontSize(12).SetFontColor(uiForeground).SetAlignment(Alignment.RIGHT).SetPadding(new Vector2(4, 0));
		((InputTextField)mainLayoutState.name.children[1]).SetPadding(new Vector2(8,8)).SetBorderColor(uiForeground).SetBackgroundColor(uiBackground).text.SetAlignment(Alignment.LEFT).SetFontSize(12).SetFontColor(Color.white);
		
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
		Input.GetMouseListener().AddMouseClickListener(mainLayout);
		Input.GetKeyboardListener().AddKeyListener(mainLayout);
	}
	
	@Override
	public void draw(IRenderer renderer) {
		renderer.FillBox(new Box(0,0,800,30), new Color(250, 224, 255));
		renderer.SetColor(Color.black);
		renderer.SetFontSize(16);
		
		Vector2 modeCenter = Box.Center(new Box(0, 0, renderer.GetFontWidth("Mode") + 16, 30), new Vector2(renderer.GetFontWidth("Mode"), 16));
		Vector2 fileCenter = Box.Center(new Box(renderer.GetFontWidth("Mode") + 16 + 8, 0, renderer.GetFontWidth("File") + 12, 30), new Vector2(renderer.GetFontWidth("File"), 16));
		
		renderer.DrawScreenText("Mode", modeCenter);
		renderer.DrawScreenText("File", fileCenter);
		
		renderer.FillBox(EditorData.layout.bounds, new Color(65, 34, 68));
		for (Element el : EditorData.layout.elements) {
			el.draw(renderer);
		}
	}
}
