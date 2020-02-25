package com.christian.adventureeditor.controllers;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.christian.adventureeditor.EditorData;
import com.christian.adventureengine.input.Input;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventureengine.utils.Serializer;

public class Controls extends Controller {

	@Override
	public void Update(float deltaTime) {
		if (Input.GetKeyboardListener().isKeyDown(KeyEvent.VK_I)) {
			Serializer serializer = new Serializer();
			EditorData.terrain.Serialize(serializer);
			
			File file = new File("terrain.txt");
			try {
				Files.write(file.toPath(), serializer.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
