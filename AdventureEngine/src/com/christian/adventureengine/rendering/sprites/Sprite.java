package com.christian.adventureengine.rendering.sprites;

import java.awt.image.BufferedImage;

import com.christian.adventureengine.data.Vector2;

public class Sprite {
	private String filename;
	private BufferedImage image;
	public Vector2 PixelsToWorld;
	
	public Sprite(String filename, BufferedImage image) {
		this.filename = filename;
		this.image = image;
	}
	
	public String GetFilename() {
		return filename;
	}
	
	public BufferedImage GetImage() {
		return image;
	}
}
