package com.christian.adventureeditor.controllers;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.christian.adventureeditor.EditorData;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.input.Input;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventureengine.ui.elements.Button;
import com.christian.adventureengine.ui.elements.SplitContainer;
import com.christian.adventureengine.utils.Serializer;
import com.christian.adventuregame.demo.utils.TerrainUtil;

public class Controls extends Controller {

	@Override
	public void Update(float deltaTime) {
		if (Input.GetKeyboardListener().isKeyDown(KeyEvent.VK_I)) {
			TerrainUtil.SaveToFile(EditorData.terrain);
		}
	}
}
