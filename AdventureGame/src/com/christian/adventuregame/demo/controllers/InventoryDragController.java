package com.christian.adventuregame.demo.controllers;

import com.christian.adventureengine.input.Input;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventuregame.demo.data.State;

public class InventoryDragController extends Controller {
    @Override
    public void Update(float deltaTime) {
        if (State.isDragging) {
            State.dragPosition = Input.GetMouseListener().GetPosition();

            if (Input.GetMouseListener().isMouseButtonDown(0) == false) {
                State.isDragging = false;
            }
        }
    }
}
