package com.christian.adventuregame.demo.ui;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.ui.VerticalPushLayout;
import com.christian.adventureengine.ui.elements.Label;
import com.christian.adventureengine.ui.elements.ProgressBar;

import java.awt.*;

public class GameSkin {
    public static Label CreateLabel(VerticalPushLayout layout, String id, String text) {
        Label label = new Label(layout, id, text);
        label.SetFontSize(16);
        label.SetPadding(Vector2.One().Mul(14));
        label.SetFontColor(Color.WHITE);
        return label;
    }

    public static ProgressBar CreateBar(VerticalPushLayout layout, String id, String prefix, int startAmt, int maxAmt) {
        return new ProgressBar(
                layout, id, GameSkin.CreateLabel(layout, id + "_text", "").SetAlignment(Label.Alignment.LEFT)
        ).SetPrefix(prefix).SetCurrentValue(startAmt).SetMaxValue(maxAmt).SetFillColor(new Color(219, 87, 87))
                .SetEmptyColor(new Color(186, 68, 68))
                .SetPadding(new Vector2(14,4));
    }
}
