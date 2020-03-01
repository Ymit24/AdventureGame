package com.christian.asciirendering;

public class ConsoleBuffer {
	public Glyph[][] buffer;
	public int width, height;
	public int fontSize;
	
	public ConsoleBuffer(int width, int height, int fontSize) {
		this.width = width;
		this.height = height;
		this.fontSize = fontSize;
		this.buffer = new Glyph[width][height];
		
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				buffer[x][y] = new Glyph(" ");
			}
		}
	}
	
	public void Write(String message, int x, int y) {
		for (int i = 0; i < message.length(); i++) {
			buffer[x + i][y].value = message.substring(i, i+1);
		}
	}
	
	public void Fill(String value, int x1, int y1, int x2, int y2) {
		for (int x = x1; x < x2; x++) {
			for (int y = y1; y < y2; y++) {
				Write(value.substring(0,1), x, y);
			}
		}
	}
}
