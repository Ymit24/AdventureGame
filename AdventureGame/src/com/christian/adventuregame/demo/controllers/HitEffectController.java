package com.christian.adventuregame.demo.controllers;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventuregame.demo.data.HitEffect;
import com.christian.adventuregame.demo.data.State;

public class HitEffectController extends Controller {
	@Override
	public void Update(float deltaTime) {
		for (int i = 0; i < State.hitEffects.size(); i++) {
			HitEffect effect = State.hitEffects.get(i);
			effect.worldLocation = effect.worldLocation.Add(new Vector2(0,-1).Mul(deltaTime * 3));
			effect.remainingSeconds -= deltaTime;
			if (effect.remainingSeconds <= 0) {
				State.hitEffects.remove(i);
			}
		}
	}
}
