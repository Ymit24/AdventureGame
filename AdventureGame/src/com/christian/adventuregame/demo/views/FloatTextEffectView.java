package com.christian.adventuregame.demo.views;

import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.View;
import com.christian.adventuregame.demo.data.FloatTextEffect;
import com.christian.adventuregame.demo.data.State;

public class FloatTextEffectView extends View {
	@Override
	public void draw(IRenderer renderer) {
		for (FloatTextEffect effect : State.floatTextEffects) {
			renderer.SetFontSize(28);
			renderer.SetColor(effect.color);
			renderer.DrawWorldText(effect.text, effect.worldLocation);
		}
	}
}
