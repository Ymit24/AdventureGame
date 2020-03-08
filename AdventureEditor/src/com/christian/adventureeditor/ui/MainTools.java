package com.christian.adventureeditor.ui;

import com.christian.adventureeditor.EditorData;
import com.christian.adventureeditor.UISkin;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.ui.IButtonCallback;
import com.christian.adventureengine.ui.VerticalPushLayout;
import com.christian.adventureengine.ui.elements.*;

public class MainTools implements IButtonCallback {
    public MainTools() {
        VerticalPushLayout mainLayout = EditorData.layout;

        MetaDataTools metaDataTools = new MetaDataTools();
        TerrainTools terrainTools = new TerrainTools();
        RegionTools regionTools = new RegionTools();
        TerrainFeatureTools terrainFeatureTools = new TerrainFeatureTools();

        mainLayout.PushElement(
                new Label(mainLayout, "terrainEditorTitle_label", "Terrain Editor")
                        .SetFontSize(24).SetPadding(Vector2.One().Mul(16))
                        .SetFontColor(UISkin.uiForeground)
        );

        mainLayout.PushElement(
                new LineBreak(mainLayout, "lineBreak_1", 6)
                        .SetColor(UISkin.uiForeground)
        );

        mainLayout.PushElement(
                new SplitContainer(
                        mainLayout,
                        "tabButtons",
                        new Element[] {
                                UISkin.CreateStateButton(mainLayout, "metaMode", "Meta").SetCallback(this),
                                UISkin.CreateStateButton(mainLayout, "terrainMode", "Terrain").SetCallback(this),
                                UISkin.CreateStateButton(mainLayout, "regionMode", "Region").SetCallback(this),
                                UISkin.CreateStateButton(mainLayout, "terrainFeatureMode", "Features").SetCallback(this)
                        }
                )
        );

        mainLayout.PushElement(
                new LineBreak(mainLayout, "toggleBreak", 2)
                        .SetColor(UISkin.uiForeground)
        );

        mainLayout.PushElement(
                new TabContainer(
                        mainLayout,
                        "editorModeTabs",
                        new Container[] {
                                new Container(mainLayout, "_", metaDataTools.Generate(mainLayout)),
                                new Container(mainLayout, "_", terrainTools.Generate(mainLayout)),
                                new Container(mainLayout, "_", regionTools.Generate(mainLayout)),
                                new Container(mainLayout, "_", terrainFeatureTools.Generate(mainLayout))
                        }
                )
        );

        mainLayout.RecalculateHeights();
    }

    @Override
    public void OnButtonClicked(String id) {
        VerticalPushLayout layout = EditorData.layout;
        if (id.contains("metaMode")) {
            TabContainer tc = (TabContainer)layout.FindElementById("editorModeTabs");
            tc.SetActiveIndex(0);
            EditorData.state = EditorData.EditorState.MetaData;
        } else if (id.contains("terrainMode")) {
            TabContainer tc = (TabContainer)layout.FindElementById("editorModeTabs");
            EditorData.state = EditorData.EditorState.Terrain;
            tc.SetActiveIndex(1);
        } else if (id.contains("regionMode")) {
            TabContainer tc = (TabContainer)layout.FindElementById("editorModeTabs");
            EditorData.state = EditorData.EditorState.Region;
            tc.SetActiveIndex(2);
        } else if (id.contains("terrainFeatureMode")) {
            TabContainer tc = (TabContainer)layout.FindElementById("editorModeTabs");
            EditorData.state = EditorData.EditorState.Features;
            tc.SetActiveIndex(3);
        }
    }
}
