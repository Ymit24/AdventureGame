package com.christian.adventureeditor;

import com.christian.adventureengine.ui.VerticalPushLayout;
import com.christian.adventuregame.demo.data.terrain.Terrain;

public class EditorData {
	public static Terrain terrain;
	public static VerticalPushLayout layout;

	public enum EditorState {
		MetaData,
		Terrain,
		Region,
		Features
	}
	public static EditorState state = EditorState.MetaData;

	public static String paintingTileType = "grass";
	public static String paintingRegionType = "grass_land";
	public static String paintingFeatureType = "tree";
}
