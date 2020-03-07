package com.christian.adventureeditor.views;

import com.christian.adventureeditor.EditorData;
import com.christian.adventureeditor.UISkin;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.View;
import com.christian.adventureengine.ui.IButtonCallback;
import com.christian.adventureengine.ui.VerticalPushLayout;
import com.christian.adventureengine.ui.elements.Label;
import com.christian.adventureengine.ui.elements.LineBreak;
import com.christian.adventuregame.demo.data.terrain.Terrain;
import com.christian.adventuregame.demo.utils.TerrainUtil;

public class MetaDataView extends View implements IButtonCallback {

    public MetaDataView() {
        VerticalPushLayout mainLayout = EditorData.layout;

        mainLayout.PushElement(UISkin.CreateSubHeader(mainLayout, "terrainMetaData_label", "Terrain Meta Data"));

		mainLayout.PushElement(UISkin.CreateInputWithLabel(mainLayout, "width", "Width", "30"));
		mainLayout.PushElement(UISkin.CreateInputWithLabel(mainLayout, "height", "Height", "30"));

		mainLayout.PushElement(
			new LineBreak(mainLayout, "lineBreak_2", 2)
			.SetColor(UISkin.uiForeground)
		);

		mainLayout.PushElement(UISkin.CreateInputWithLabel(mainLayout, "name", "Name", "OVERWORLD_V1"));

		mainLayout.PushElement(UISkin.CreateButton(mainLayout, "new", "New").SetCallback(this));

		mainLayout.PushElement(
			UISkin.CreateSplitContainer(
				mainLayout,
				"save_and_load",
				UISkin.CreateButton(mainLayout, "save", "Save").SetCallback(this),
				UISkin.CreateButton(mainLayout, "load", "Load").SetCallback(this)
			)
		);

    }

    @Override
    public void draw(IRenderer renderer) {

    }

    @Override
    public void OnButtonClicked(String id) {
        VerticalPushLayout layout = EditorData.layout;

        if (id.equals("new_button")) {
            String widthText = ((Label)layout.FindElementById("width_inputfield_label")).text;
            String heightText = ((Label)layout.FindElementById("height_inputfield_label")).text;
            System.out.println("Dimensions: <" + widthText + ", " + heightText + ">");

            EditorData.terrain = new Terrain(Integer.parseInt(widthText), Integer.parseInt(heightText));

        } else if (id.equals("save_button")) {
            TerrainUtil.SaveToFile(EditorData.terrain);
        } else if (id.equals("load_button")) {
            EditorData.terrain = TerrainUtil.LoadFromFile();
        }
        // TODO: MOVE THIS TO THE TERRAIN EDITOR VIEW
//        else {
//            System.out.println("Clicked button: " + id.split("_")[0]);
//            EditorData.paintingTileType = id.split("_")[0];
//        }
    }
}
