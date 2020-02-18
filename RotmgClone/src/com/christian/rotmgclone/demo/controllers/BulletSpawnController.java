package com.christian.rotmgclone.demo.controllers;

import java.awt.event.KeyEvent;

import com.christian.rotmgclone.data.Vector2;
import com.christian.rotmgclone.demo.data.Data;
import com.christian.rotmgclone.input.Input;
import com.christian.rotmgclone.logic.Controller;

public class BulletSpawnController extends Controller {
	@Override
	public void Update(float deltaTime) {
		if (Input.GetKeyboardListener().isKeyDown(KeyEvent.VK_SPACE)) {
			Data.world.SpawnBullet(new Vector2(Data.world.GetPlayer().GetPosition()), new Vector2(1,0));
		}
	}
}
