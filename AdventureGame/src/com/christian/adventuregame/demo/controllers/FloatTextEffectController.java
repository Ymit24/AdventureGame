package com.christian.adventuregame.demo.controllers;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventuregame.demo.data.FloatTextEffect;
import com.christian.adventuregame.demo.data.State;

public class FloatTextEffectController extends Controller {
	@Override
	public void Update(float deltaTime) {
		for (int i = 0; i < State.floatTextEffects.size(); i++) {
			FloatTextEffect effect = State.floatTextEffects.get(i);
			effect.worldLocation = effect.worldLocation.Add(new Vector2(0,-1).Mul(deltaTime * effect.speed));
			effect.remainingSeconds -= deltaTime;
			if (effect.remainingSeconds <= 0) {
				State.floatTextEffects.remove(i);
			}
		}
	}
}
