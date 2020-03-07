package com.christian.adventureeditor.ui;

import com.christian.adventureeditor.EditorData;
import com.christian.adventureeditor.UISkin;
import com.christian.adventureengine.ui.IButtonCallback;
import com.christian.adventureengine.ui.VerticalPushLayout;
import com.christian.adventureengine.ui.elements.Button;
import com.christian.adventureengine.ui.elements.Element;
import com.christian.adventuregame.demo.data.archetypes.Archetypes;
import com.christian.adventuregame.demo.data.archetypes.TileType;

import java.util.ArrayList;

public class TerrainTools implements IButtonCallback {
    public Element[] Generate(VerticalPushLayout mainLayout) {
        ArrayList<TileType> tileTypes = Archetypes.Tiles.GetAll();
        Element[] terrainTools = new Element[tileTypes.size() + 1];
        terrainTools[0] = UISkin.CreateSubHeader(mainLayout, "terrainTools_label", "Terrain Tools");

        for (int i = 0; i < tileTypes.size(); i++) {
            TileType type = tileTypes.get(i);
            Button button = UISkin.CreateButton(mainLayout, type.id, type.id);
            button.SetCallback(this);
            terrainTools[i+1] = button;
        }
        return terrainTools;
    }

    @Override
    public void OnButtonClicked(String id) {
        VerticalPushLayout layout = EditorData.layout;
        EditorData.paintingTileType = id.split("_")[0];
    }
}
