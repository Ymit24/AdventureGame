package com.christian.adventuregame.demo.controllers;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.input.IMouseClickListener;
import com.christian.adventureengine.input.Input;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventuregame.demo.data.State;

public class InventoryDragController extends Controller implements IMouseClickListener {

    public InventoryDragController() {
        Input.GetMouseListener().AddMouseClickListener(this);
    }

    @Override
    public void Update(float deltaTime) {
        if (State.isDragging) {
            State.dragPosition = Input.GetMouseListener().GetPosition();
        }
    }

    @Override
    public boolean OnClick(Vector2 screenLocation, int button, boolean isDown) {
        if (State.isDragging && button == 0 && isDown == false) {
            State.isDragging = false;
        }
        return false;
    }
}
