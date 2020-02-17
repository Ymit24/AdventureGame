package com.christian.rotmgclone.simulation;

import java.util.ArrayList;

import com.christian.rotmgclone.data.world.Data;
import com.christian.rotmgclone.data.world.Enemy;
import com.christian.rotmgclone.data.world.Player;
import com.christian.rotmgclone.data.world.Vector2;
import com.christian.rotmgclone.data.world.World;
import com.christian.rotmgclone.logic.GameLoop;
import com.christian.rotmgclone.logic.IUpdater;
import com.christian.rotmgclone.rendering.IRenderer;
import com.christian.rotmgclone.rendering.cpu.CPURenderer;

public class ConsoleSimulation implements IUpdater {
	public static void main(String[] args) {
		new ConsoleSimulation();
	}
	
	public ConsoleSimulation() {
		Data.world = new World();
		World world = Data.world;
		world.GetEnemies().add(new Enemy(new Vector2(10, 10)));
		
		IRenderer renderer = new CPURenderer();
		renderer.Initialize();
		
		GameLoop loop = new GameLoop(this, renderer);
		loop.Start();
		System.out.println("end of main.");
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
		Player player = Data.world.GetPlayer();
		Vector2 pos = player.GetPosition();
		float speed = 48;
		player.SetPosition(new Vector2(pos.x + (speed * deltaTime), pos.y + (speed * deltaTime)));
		
		if (timer > 1)
		{
			timer -= 1;
			System.out.println("Player pos: " + player.GetPosition().toString());
		}
	}
}
