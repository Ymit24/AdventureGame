package com.christian.adventureeditor;

import java.awt.Color;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.ui.VerticalPushLayout;
import com.christian.adventureengine.ui.elements.Button;
import com.christian.adventureengine.ui.elements.Element;
import com.christian.adventureengine.ui.elements.InputTextField;
import com.christian.adventureengine.ui.elements.Label;
import com.christian.adventureengine.ui.elements.Label.Alignment;
import com.christian.adventureengine.ui.elements.SplitContainer;

public class UISkin {
	private static Color uiBackground = new Color(65, 34, 68);
	private static Color uiForeground = new Color(233, 189, 239);
	public static Label CreateSubHeader(VerticalPushLayout layout, String id, String text) {
		return new Label(layout, id, text)
			.SetFontSize(16).SetPadding(Vector2.One().Mul(12))
			.SetFontColor(uiForeground); 
	}

	public static SplitContainer CreateSplitContainer(VerticalPushLayout layout, String baseId, Element left, Element right) {
		SplitContainer container = new SplitContainer(
			layout,
			baseId + "_splitcontainer",
			left,
			right,
			0.5f
		);
		return container;
	}
	
	public static SplitContainer CreateInputWithLabel(VerticalPushLayout layout, String baseId, String labelText, String placeholderText) {
		SplitContainer container = new SplitContainer(
			layout,
			baseId + "_inputlabel",
			new Label(
					layout,
				baseId + "_input_label",
				labelText
			),
			new InputTextField(
					layout,
				baseId + "_inputfield",
				new Label(
						layout,
					baseId + "_inputfield_label",
					placeholderText
				)
			),
			0.2f
		);
		((Label)container.children[0]).SetFontSize(12).SetFontColor(uiForeground).SetAlignment(Alignment.RIGHT).SetPadding(new Vector2(4, 0));
		((InputTextField)container.children[1]).SetPadding(new Vector2(8,8)).SetBorderColor(uiForeground).SetBackgroundColor(uiBackground).text.SetAlignment(Alignment.LEFT).SetFontSize(12).SetFontColor(Color.white);
		return container;
	}
	
	public static Button CreateButton(VerticalPushLayout layout, String baseId, String text) {
		Button button = new Button(
			layout,
			baseId + "_button",
			new Label(
				layout,
				baseId + "_label",
				text
			)
		)
		.SetPadding(new Vector2(36, 12))
		.SetBorderColor(uiForeground)
		.SetBackgroundColor(uiBackground);
		
		button.text.SetFontSize(16)
			.SetFontColor(uiForeground)
			.SetPadding(Vector2.One().Mul(8));
		return button;
	}
}
