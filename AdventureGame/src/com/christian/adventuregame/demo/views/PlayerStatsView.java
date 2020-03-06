package com.christian.adventuregame.demo.views;

import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.View;
import com.christian.adventuregame.demo.data.State;

import java.awt.*;

public class PlayerStatsView extends View {
    private final Box bounds = new Box(1000, 0, 280, 720);
    @Override
    public void draw(IRenderer renderer) {
        renderer.SetFontSize(24);
        renderer.SetColor(Color.white);

        renderer.DrawScreenText("Level: " + State.world.player.stats.level, bounds.position);
        renderer.DrawScreenText("Xp: " + State.world.player.stats.xp + "/" + State.world.player.stats.xpNext, bounds.position.Add(new Vector2(0,24)));
    }
}
