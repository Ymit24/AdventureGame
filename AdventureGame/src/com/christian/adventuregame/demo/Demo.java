package com.christian.adventuregame.demo;

import java.util.Random;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.logic.ControllerManager;
import com.christian.adventureengine.logic.GameLoop;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.core.CoreRenderer;
import com.christian.adventureengine.utils.Deserializer;
import com.christian.adventureengine.utils.Serializer;
import com.christian.adventuregame.demo.controllers.BulletMovementController;
import com.christian.adventuregame.demo.controllers.BulletSpawnController;
import com.christian.adventuregame.demo.controllers.CameraController;
import com.christian.adventuregame.demo.controllers.DemoController;
import com.christian.adventuregame.demo.data.Data;
import com.christian.adventuregame.demo.data.Enemy;
import com.christian.adventuregame.demo.data.World;
import com.christian.adventuregame.demo.views.GameplayView;

public class Demo {
	public static void main(String[] args) {
		new Demo();
	}
	
	public Demo() {
		Data.world = new World();
		World world = Data.world;
		world.GetEnemies().add(new Enemy(new Vector2(10, 10)));
		
		IRenderer renderer = new CoreRenderer();
		renderer.Initialize("Adventure Game", 1280, 720);
		renderer.CreateInput();
		renderer.CreateSpriteManager();
		renderer.CreateCamera(new Vector2(20, 10));

		GameplayView view = new GameplayView();
		renderer.SetRootView(view);
		
		Serializer serializer = new Serializer();
		Random random = new Random();
		
		serializer.WriteInt(100);
		serializer.WriteInt(100);
		for (int x = 0; x < 100; x++) {
			for (int y = 0; y < 100; y++) {
				serializer.WriteInt(x);
				serializer.WriteInt(y);
				serializer.WriteBoolean(random.nextBoolean());
			}
		}
		
		Deserializer deserializer = new Deserializer(serializer.getBytes());
		int width = deserializer.ReadInt();
		int height = deserializer.ReadInt();
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				int tx = deserializer.ReadInt();
				int ty = deserializer.ReadInt();
				boolean tileState = deserializer.ReadBoolean();
				System.out.println("Read tile: <"+tx+","+ty+","+tileState+">");
			}
		}
		
		ControllerManager.AddController(new DemoController());
		ControllerManager.AddController(new CameraController());
		ControllerManager.AddController(new BulletSpawnController());
		ControllerManager.AddController(new BulletMovementController());
//		ControllerManager.AddController(new MousePickerController());
		
		GameLoop.Initialize(new ControllerManager(), renderer);
		GameLoop.Start();
	}
	
	private void TestingSerialization() {
		Serializer serializer = new Serializer();
		Vector2 someVec = new Vector2(10,15);
		someVec.Serialize(serializer);
		serializer.WriteBoolean(true);
		serializer.WriteString("Hello world!");
		serializer.WriteBoolean(false);
		serializer.WriteInt(22);
		System.out.println("Bytes: " + serializer.getBytes());
		
		Deserializer deserializer = new Deserializer(serializer.getBytes());
		Vector2 other = new Vector2();
		other.Deserialize(deserializer);
		System.out.println("Vector2: " + other.toString());
		System.out.println("Should be true: " + deserializer.ReadBoolean());
		System.out.println("Message: " + deserializer.ReadString());
		System.out.println("Should be false: " + deserializer.ReadBoolean());
		System.out.println("Int: "  + deserializer.ReadInt());
	}
}
