package com.christian.adventureeditor.ui;

import java.awt.Color;

import com.christian.adventureeditor.ui.elements.Element;
import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.View;

public class UIView extends View {
	@Override
	public void draw(IRenderer renderer) {
		renderer.FillBox(new Box(0,0,800,30), new Color(250, 224, 255));
		renderer.SetColor(Color.black);
		renderer.SetFontSize(16);
		
		Vector2 modeCenter = Box.Center(new Box(0, 0, renderer.GetFontWidth("Mode") + 16, 30), new Vector2(renderer.GetFontWidth("Mode"), 16));
		Vector2 fileCenter = Box.Center(new Box(renderer.GetFontWidth("Mode") + 16 + 8, 0, renderer.GetFontWidth("File") + 12, 30), new Vector2(renderer.GetFontWidth("File"), 16));
		
		renderer.DrawScreenText("Mode", modeCenter);
		renderer.DrawScreenText("File", fileCenter);
		renderer.FillBox(UI.bounds, new Color(65, 34, 68));
		for (Element el : UI.elements) {
			el.draw(renderer);
		}
	}
}
