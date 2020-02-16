package com.christian.rotmgclone.simulation;

import java.util.ArrayList;

import com.christian.rotmgclone.logic.GameLoop;
import com.christian.rotmgclone.logic.IUpdater;
import com.christian.rotmgclone.rendering.IRenderer;
import com.christian.rotmgclone.rendering.cpu.CPURenderer;
import com.christian.rotmgclone.world.Enemy;
import com.christian.rotmgclone.world.Player;
import com.christian.rotmgclone.world.Vector2;
import com.christian.rotmgclone.world.World;

public class ConsoleSimulation implements IUpdater {
	public static void main(String[] args) {
		new ConsoleSimulation();
	}
	
	private World world;
	public ConsoleSimulation() {
		world = new World();
		world.GetEnemies().add(new Enemy(new Vector2(10, 10)));
		
		IRenderer renderer = new CPURenderer();
		renderer.Initialize();
		
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
	
	private static void ListEnemyData(ArrayList<Enemy> enemies) {
		System.out.println("There are " + enemies.size() + " enemies:");
		for (int i = 0; i < enemies.size(); i++) {
			Enemy e = enemies.get(i);
			System.out.println("\tPosition <"+e.GetPosition().x + "," + e.GetPosition().y+">");
		}
	}

	private float timer = 0;
	
	@Override
	public void OnUpdate(float deltaTime) {
//		System.out.println("DT: " + deltaTime);
		timer += deltaTime;
		Player player = world.GetPlayer();
		Vector2 pos = player.GetPosition();
		player.SetPosition(new Vector2(pos.x + deltaTime, pos.y + deltaTime));
		
		if (timer > 1)
		{
			timer -= 1;
			System.out.println("Player pos: " + player.GetPosition().toString());
		}
	}
}
