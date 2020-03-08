package com.christian.adventuregame.demo.ui;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.ui.VerticalPushLayout;
import com.christian.adventureengine.ui.elements.Label;
import com.christian.adventureengine.ui.elements.ProgressBar;
import com.christian.adventuregame.demo.data.State;

import java.awt.*;

public class GameUI {
    public GameUI() {
    }

    public void Create() {
        VerticalPushLayout layout = State.mainUILayout;

        layout.PushElement(
            GameSkin.CreateLabel(layout, "levelIndicator", "Level: 1").SetAlignment(Label.Alignment.LEFT)
        );
        layout.PushElement(
            GameSkin.CreateBar(layout, "healthBar", "Health: ", 200, 200)
        );
        layout.PushElement(
            GameSkin.CreateBar(layout, "xpBar", "Xp: ", 12, 18)
                .SetFillColor(new Color(87,109,219)).SetEmptyColor(new Color(69,89,188))
        );
        layout.RecalculateHeights();
    }
}
