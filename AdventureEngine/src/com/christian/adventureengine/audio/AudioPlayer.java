package com.christian.adventureengine.audio;

import java.io.File;
import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioPlayer {
	private static HashMap<String, Clip> clips = new HashMap<String, Clip>();
	
	private static final String ROOT_PATH = "C:\\Dev\\Git\\AdventureGame\\resources\\audio\\";
	public static void Load(String filename) {
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(new File(ROOT_PATH + "/" + filename).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(stream);

			clips.put(filename, clip);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void Play(String filename) {
		if (clips.containsKey(filename) == false) {
			Load(filename);
		}
		Clip clip = clips.get(filename);
		clip.setMicrosecondPosition(0);
		clip.start();
	}
}
