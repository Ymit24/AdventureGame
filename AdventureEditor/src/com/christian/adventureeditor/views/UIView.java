package com.christian.adventureeditor.views;

import java.awt.Color;

import com.christian.adventureeditor.EditorData;
import com.christian.adventureeditor.UISkin;
import com.christian.adventureeditor.ui.MetaDataTools;
import com.christian.adventureeditor.ui.RegionTools;
import com.christian.adventureeditor.ui.TerrainTools;
import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.View;
import com.christian.adventureengine.ui.IButtonCallback;
import com.christian.adventureengine.ui.VerticalPushLayout;
import com.christian.adventureengine.ui.elements.*;
import com.christian.adventuregame.demo.data.archetypes.RegionType;

public class UIView extends View {
	public UIView() {
		super(1000);
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
}
