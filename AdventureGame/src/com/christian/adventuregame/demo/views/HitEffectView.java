package com.christian.adventuregame.demo.views;

import java.awt.Color;

import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.View;
import com.christian.adventuregame.demo.data.HitEffect;
import com.christian.adventuregame.demo.data.State;

public class HitEffectView extends View {
	@Override
	public void draw(IRenderer renderer) {
		for (HitEffect effect : State.hitEffects) {
			renderer.SetFontSize(24);
			renderer.SetColor(Color.red);
			renderer.DrawWorldText(effect.text, effect.worldLocation);
		}
	}
}
