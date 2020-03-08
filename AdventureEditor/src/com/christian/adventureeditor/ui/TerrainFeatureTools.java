package com.christian.adventureeditor.ui;

import com.christian.adventureeditor.EditorData;
import com.christian.adventureeditor.UISkin;
import com.christian.adventureengine.ui.IButtonCallback;
import com.christian.adventureengine.ui.VerticalPushLayout;
import com.christian.adventureengine.ui.elements.Button;
import com.christian.adventureengine.ui.elements.Element;
import com.christian.adventuregame.demo.data.archetypes.Archetypes;
import com.christian.adventuregame.demo.data.archetypes.TerrainFeatureType;
import com.christian.adventuregame.demo.data.archetypes.TileType;

import java.util.ArrayList;

public class TerrainFeatureTools implements IButtonCallback {
    public Element[] Generate(VerticalPushLayout mainLayout) {
        ArrayList<TerrainFeatureType> terrainFeatureTypes = Archetypes.TerrianFeatures.GetAll();
        Element[] terrainTools = new Element[terrainFeatureTypes.size() + 2];
        terrainTools[0] = UISkin.CreateSubHeader(mainLayout, "terrainFeatureTools_label", "Terrain Features Tool");

        terrainTools[1] = UISkin.CreateButton(mainLayout, "none", "Remove").SetCallback(this);
        for (int i = 0; i < terrainFeatureTypes.size(); i++) {
            TerrainFeatureType type = terrainFeatureTypes.get(i);
            terrainTools[i+2] = UISkin.CreateButton(mainLayout, type.id, type.name).SetCallback(this);
        }
        return terrainTools;
    }

    @Override
    public void OnButtonClicked(String id) {
        VerticalPushLayout layout = EditorData.layout;
        EditorData.paintingFeatureType = id.split("_")[0];
    }
}
