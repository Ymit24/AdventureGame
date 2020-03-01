package com.christian.adventureengine.rendering.core;

import java.awt.Font;
import java.util.HashMap;

public class Fonts {
	private static HashMap<Integer, Font> fonts = new HashMap<Integer, Font>();
	public static Font GetFont(int size) {
		if (fonts.containsKey(size)) {
			return fonts.get(size);
		}
		
		Font font = new Font("Lucida Console", Font.BOLD, size);
		fonts.put(size, font);
		return font;
	}
}
