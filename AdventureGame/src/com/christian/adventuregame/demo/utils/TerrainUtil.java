package com.christian.adventuregame.demo.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.christian.adventureengine.utils.Deserializer;
import com.christian.adventureengine.utils.Serializer;
import com.christian.adventuregame.demo.data.terrain.Terrain;

public class TerrainUtil {
	public static void SaveToFile(Terrain terrain) {
		Serializer serializer = new Serializer();
		terrain.Serialize(serializer);
		
		File file = new File("C:\\Dev\\Git\\AdventureGame\\resources\\bin\\terrain.txt");
		try {
			Files.write(file.toPath(), serializer.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Terrain LoadFromFile() {
		File file = new File("C:\\Dev\\Git\\AdventureGame\\resources\\bin\\terrain.txt");
		byte[] bytes;
		try {
			bytes = Files.readAllBytes(file.toPath());
			
			Deserializer deserializer = new Deserializer(bytes);
			return Terrain.Deserialize(deserializer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
