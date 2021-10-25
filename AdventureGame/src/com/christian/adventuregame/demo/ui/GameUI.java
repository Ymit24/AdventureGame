package com.christian.adventuregame.demo.ui;

import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.rendering.sprites.Sprite;
import com.christian.adventureengine.rendering.sprites.Sprites;
import com.christian.adventureengine.ui.VerticalPushLayout;
import com.christian.adventureengine.ui.elements.*;
import com.christian.adventureengine.ui.elements.Button;
import com.christian.adventureengine.ui.elements.Container;
import com.christian.adventureengine.ui.elements.Label;
import com.christian.adventureengine.utils.Randomizer;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.data.archetypes.Archetypes;
import com.christian.adventuregame.demo.ui.elements.InventorySlot;

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
                        .SetFillColor(new Color(87, 109, 219)).SetEmptyColor(new Color(69, 89, 188))
        );

        layout.PushElement(new LineBreak(layout, "_", 24).SetColor(Color.BLACK));

        layout.PushElement(
                new SplitContainer(layout, "equipBar", new Element[]{
                        new InventorySlot(
                                layout, "inventorySlot0", 64
                        ).SetColor(new Color(168, 118, 74)).SetPadding(new Vector2(12, 6)).SetData("0"),
                        new InventorySlot(
                                layout, "inventorySlot1", 64
                        ).SetColor(new Color(168, 118, 74)).SetPadding(new Vector2(12, 6)).SetData("1"),
                        new InventorySlot(
                                layout, "inventorySlot2", 64
                        ).SetColor(new Color(168, 118, 74)).SetPadding(new Vector2(12, 6)).SetData("2")
                }).SetBackgroundColor(new Color(219, 149, 87))
        );

        layout.PushElement(new LineBreak(layout, "_", 18).SetColor(Color.BLACK));

        layout.PushElement(
                new Container(layout, "inventoryContainer", new Element[]{
                        new SplitContainer(layout, "inventoryRow0", new Element[]{
                                new InventorySlot(
                                        layout, "inventorySlot3", 64
                                ).SetColor(new Color(168, 118, 74)).SetPadding(new Vector2(12, 6)).SetData("3"),
                                new InventorySlot(
                                        layout, "inventorySlot4", 64
                                ).SetColor(new Color(168, 118, 74)).SetPadding(new Vector2(12, 6)).SetData("4"),
                                new InventorySlot(
                                        layout, "inventorySlot5", 64
                                ).SetColor(new Color(168, 118, 74)).SetPadding(new Vector2(12, 6)).SetData("5")
                        }).SetBackgroundColor(new Color(219, 149, 87)),
                        new SplitContainer(layout, "inventoryRow1", new Element[]{
                                new InventorySlot(
                                        layout, "inventorySlot6", 64
                                ).SetColor(new Color(168, 118, 74)).SetPadding(new Vector2(12, 6)).SetData("6"),
                                new InventorySlot(
                                        layout, "inventorySlot7", 64
                                ).SetColor(new Color(168, 118, 74)).SetPadding(new Vector2(12, 6)).SetData("7"),
                                new InventorySlot(
                                        layout, "inventorySlot8", 64
                                ).SetColor(new Color(168, 118, 74)).SetPadding(new Vector2(12, 6)).SetData("8")
                        }).SetBackgroundColor(new Color(219, 149, 87)),
                        new SplitContainer(layout, "inventoryRow2", new Element[]{
                                new InventorySlot(
                                        layout, "inventorySlot9", 64
                                ).SetColor(new Color(168, 118, 74)).SetPadding(new Vector2(12, 6)).SetData("9"),
                                new InventorySlot(
                                        layout, "inventorySlot10", 64
                                ).SetColor(new Color(168, 118, 74)).SetPadding(new Vector2(12, 6)).SetData("10"),
                                new InventorySlot(
                                        layout, "inventorySlot11", 64
                                ).SetColor(new Color(168, 118, 74)).SetPadding(new Vector2(12, 6)).SetData("11")
                        }).SetBackgroundColor(new Color(219, 149, 87))
                }).SetBackgroundColor(new Color(219, 149, 87))
        );

        layout.Recalculate();
    }
}