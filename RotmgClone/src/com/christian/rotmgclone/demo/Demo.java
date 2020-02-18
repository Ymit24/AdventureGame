package com.christian.rotmgclone.demo;

import java.awt.event.KeyEvent;

import com.christian.rotmgclone.data.Vector2;
import com.christian.rotmgclone.demo.data.Data;
import com.christian.rotmgclone.demo.data.Enemy;
import com.christian.rotmgclone.demo.data.Player;
import com.christian.rotmgclone.demo.data.World;
import com.christian.rotmgclone.input.Input;
import com.christian.rotmgclone.logic.GameLoop;
import com.christian.rotmgclone.logic.IUpdater;
import com.christian.rotmgclone.rendering.IRenderer;
import com.christian.rotmgclone.rendering.core.CoreRenderer;

public class Demo implements IUpdater {
	public static void main(String[] args) {
		new Demo();
	}
	
	public Demo() {
		Data.world = new World();
		World world = Data.world;
		world.GetEnemies().add(new Enemy(new Vector2(10, 10)));
		
		IRenderer renderer = new CoreRenderer();
		renderer.Initialize();
		renderer.CreateInput();
		renderer.CreateSpriteManager();

		GameplayView view = new GameplayView();
		renderer.SetRootView(view);
		
		GameLoop.Initialize(this, renderer);
		GameLoop.Start();
	}
	
	private float timer = 0;
	
	@Override
	public void OnUpdate(float deltaTime) {
		timer += deltaTime;
		Player player = Data.world.GetPlayer();
		Vector2 pos = player.GetPosition();
		float speed = 48;
		if (Input.GetKeyboardListener().isKeyDown(KeyEvent.VK_SHIFT)) {
			speed = 640;
		}
		
		Vector2 direction = new Vector2();
		
		if (Input.GetKeyboardListener().isKeyDown(KeyEvent.VK_W)) {
			direction.y -= 1;
		}
		if (Input.GetKeyboardListener().isKeyDown(KeyEvent.VK_S)) {
			direction.y += 1;
		}
		if (Input.GetKeyboardListener().isKeyDown(KeyEvent.VK_A)) {
			direction.x -= 1;
		}
		if (Input.GetKeyboardListener().isKeyDown(KeyEvent.VK_D)) {
			direction.x += 1;
		}
		
		direction.Normalize();
		direction.Multiply(speed);
		if (direction.Magnitude() > 0)
		{
			pos.Add(direction.Multiply(deltaTime));
			player.SetPosition(pos);		
		}
		
		if (timer > 1)
		{
			timer -= 1;
			System.out.println("Player pos: " + player.GetPosition().toString());
		}
	}
}
