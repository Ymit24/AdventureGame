package com.christian.adventuregame.demo.controllers;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.input.IMouseScrollListener;
import com.christian.adventureengine.input.Input;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventureengine.rendering.Camera;

public class ZoomController implements IMouseScrollListener {

    public ZoomController () {
        Input.GetMouseListener().AddMouseScrollListener(this);
    }

    @Override
    public void OnScroll(int delta) {
        Camera.GetCamera().CenterZoom(Camera.GetCamera().GetWorldSpace().Add(Vector2.One().Mul(delta)));
    }
}
