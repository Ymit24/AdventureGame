package com.christian.adventuregame.demo.views;

import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.View;
import com.christian.adventureengine.ui.elements.Label;
import com.christian.adventureengine.ui.elements.ProgressBar;
import com.christian.adventuregame.demo.data.State;

import java.awt.*;

public class PlayerStatsView extends View {
    private final Box bounds = new Box(1000, 0, 280, 720);

    public PlayerStatsView() {
        super(-1);
    }

    @Override
    public void draw(IRenderer renderer) {
        renderer.SetFontSize(24);
        renderer.SetColor(Color.white);

        ((Label)State.mainUILayout.FindElementById("levelIndicator")).text = "Level: " + State.world.player.stats.level;
        ((ProgressBar)State.mainUILayout.FindElementById("xpBar")).SetCurrentValue(State.world.player.stats.xp);
        ((ProgressBar)State.mainUILayout.FindElementById("xpBar")).SetMaxValue(State.world.player.stats.xpNext);
//        renderer.DrawScreenText("Level: " + State.world.player.stats.level, bounds.position);
//        renderer.DrawScreenText("Xp: " + State.world.player.stats.xp + "/" + State.world.player.stats.xpNext, bounds.position.Add(new Vector2(0,24)));
    }
}
