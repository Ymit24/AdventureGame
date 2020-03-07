package com.christian.adventureeditor.ui;

import com.christian.adventureeditor.EditorData;
import com.christian.adventureeditor.UISkin;
import com.christian.adventureengine.ui.IButtonCallback;
import com.christian.adventureengine.ui.VerticalPushLayout;
import com.christian.adventureengine.ui.elements.Button;
import com.christian.adventureengine.ui.elements.Element;
import com.christian.adventuregame.demo.data.archetypes.Archetypes;
import com.christian.adventuregame.demo.data.archetypes.RegionType;
import com.christian.adventuregame.demo.data.archetypes.TileType;

import java.util.ArrayList;

public class RegionTools implements IButtonCallback {
    public Element[] Generate(VerticalPushLayout mainLayout) {
        ArrayList<RegionType> regionTypes = Archetypes.Regions.GetAll();
        Element[] regionTools = new Element[regionTypes.size() + 1];
        regionTools[0] = UISkin.CreateSubHeader(mainLayout, "regionTools_label", "Region Editor");

        for (int i = 0; i < regionTypes.size(); i++) {
            RegionType type = regionTypes.get(i);
            Button button = UISkin.CreateButton(mainLayout, type.id, type.name);
            button.SetCallback(this);
            regionTools[i+1] = button;
        }
        return regionTools;
    }

    @Override
    public void OnButtonClicked(String id) {
        String regionId = id.split("_button")[0];
        System.out.println("ID: " + regionId);
        EditorData.paintingRegionType = regionId;
    }
}
