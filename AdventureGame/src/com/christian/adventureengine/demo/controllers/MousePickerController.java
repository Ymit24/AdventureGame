package com.christian.adventureengine.demo.controllers;

import com.christian.adventureengine.input.Input;
import com.christian.adventureengine.logic.Controller;

public class MousePickerController extends Controller {
	@Override
	public void Update(float deltaTime) {
		if (Input.GetMouseListener().isMouseButtonDown(0)) {
			System.out.println("Clicked at " + Input.GetMouseListener().GetPosition().toString());
		}
	}
}
