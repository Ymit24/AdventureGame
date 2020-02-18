package com.christian.rotmgclone.simulation;

import java.awt.event.KeyEvent;

import com.christian.rotmgclone.data.world.Data;
import com.christian.rotmgclone.data.world.Enemy;
import com.christian.rotmgclone.data.world.Player;
import com.christian.rotmgclone.data.world.Vector2;
import com.christian.rotmgclone.data.world.World;
import com.christian.rotmgclone.input.Input;
import com.christian.rotmgclone.logic.GameLoop;
import com.christian.rotmgclone.logic.IUpdater;
import com.christian.rotmgclone.rendering.IRenderer;
import com.christian.rotmgclone.rendering.core.CoreRenderer;

public class ConsoleSimulation implements IUpdater {
	public static void main(String[] args) {
		new ConsoleSimulation();
	}
	
	public ConsoleSimulation() {
		Data.world = new World();
		World world = Data.world;
		world.GetEnemies().add(new Enemy(new Vector2(10, 10)));
		
		IRenderer renderer = new CoreRenderer();
		renderer.Initialize();
		renderer.CreateInput();
		renderer.CreateSpriteManager();
		
		PlayerView view = new PlayerView();
		renderer.SetRootView(view);
		
		GameLoop loop = new GameLoop(this, renderer);
		loop.Start();
		System.out.println("end of main.");
//		while (true) {
//			// update
//			Player player = world.GetPlayer();
//			Vector2 pos = player.GetPosition();
//			player.SetPosition(new Vector2(pos.x + 1, pos.y + 1));
//			
//			//render
//			
//			try {
//				Thread.sleep(20);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
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
//		player.SetPosition(new Vector2(pos.x + (speed * deltaTime), pos.y + (speed * deltaTime)));
		
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
