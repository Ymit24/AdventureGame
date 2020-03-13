package com.christian.adventureeditor.ui;

import com.christian.adventureeditor.EditorData;
import com.christian.adventureeditor.UISkin;
import com.christian.adventureengine.ui.IButtonCallback;
import com.christian.adventureengine.ui.VerticalPushLayout;
import com.christian.adventureengine.ui.elements.Element;
import com.christian.adventureengine.ui.elements.Label;
import com.christian.adventureengine.ui.elements.LineBreak;
import com.christian.adventuregame.demo.data.terrain.Terrain;
import com.christian.adventuregame.demo.utils.TerrainUtil;

public class MetaDataTools implements IButtonCallback {
    public Element[] Generate(VerticalPushLayout mainLayout) {
        return new Element[] {
                UISkin.CreateSubHeader(mainLayout, "terrainMetaData_label", "Terrain Meta Data"),
                UISkin.CreateInputWithLabel(mainLayout, "width", "Width", "30"),
                UISkin.CreateInputWithLabel(mainLayout, "height", "Height", "30"),
                new LineBreak(mainLayout, "lineBreak_2", 2)
                        .SetColor(UISkin.uiForeground),
                UISkin.CreateInputWithLabel(mainLayout, "name", "Name", "OVERWORLD_V1"),
                UISkin.CreateSplitContainer(
                        mainLayout,"_",
                        UISkin.CreateButton(mainLayout, "new", "New").SetCallback(this),
                        UISkin.CreateButton(mainLayout, "update", "Update").SetCallback(this)
                ),
                UISkin.CreateSplitContainer(
                        mainLayout,
                        "save_and_load",
                        UISkin.CreateButton(mainLayout, "save", "Save").SetCallback(this),
                        UISkin.CreateButton(mainLayout, "load", "Load").SetCallback(this)
                )
        };
    }

    @Override
    public void OnButtonClicked(String id) {
        VerticalPushLayout layout = EditorData.layout;
        if (id.equals("new_button")) {
            String widthText = ((Label)layout.FindElementById("width_inputfield_label")).text;
            String heightText = ((Label)layout.FindElementById("height_inputfield_label")).text;
            EditorData.terrain = new Terrain(Integer.parseInt(widthText), Integer.parseInt(heightText), 10);
        } else if (id.equals("update_button")) {
            String widthText = ((Label)layout.FindElementById("width_inputfield_label")).text;
            String heightText = ((Label)layout.FindElementById("height_inputfield_label")).text;
            System.out.println("Dimensions: <" + widthText + ", " + heightText + ">");

            Terrain terrain = new Terrain(Integer.parseInt(widthText), Integer.parseInt(heightText), 10);
            terrain.CopyFrom(EditorData.terrain);
            EditorData.terrain = terrain;
        }  else if (id.equals("save_button")) {
            TerrainUtil.SaveToFile(EditorData.terrain);
        } else if (id.equals("load_button")) {
            EditorData.terrain = TerrainUtil.LoadFromFile();
        }
    }
}
