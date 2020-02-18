package com.christian.rotmgclone.rendering.sprites;

import java.awt.image.BufferedImage;

public class Sprite {
	private String filename;
	private BufferedImage image;
	
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
