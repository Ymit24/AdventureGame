package com.christian.adventuregame.demo.ui.elements;

import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.sprites.Sprite;
import com.christian.adventureengine.ui.VerticalPushLayout;
import com.christian.adventureengine.ui.elements.Element;
import com.christian.adventuregame.demo.data.Inventory;
import com.christian.adventuregame.demo.utils.InventoryUtil;

import java.awt.*;

public class InventorySlot extends Element {
    private Color slotColor;
    private Sprite iconSprite;
    private int iconHeight;

    public InventorySlot(VerticalPushLayout layout, String id, int height) {
        super(layout, id);

        this.slotColor = Color.white;
        this.iconSprite = null;
        this.iconHeight = height;
    }

    public InventorySlot SetColor(Color color) {
        this.slotColor = color;
        return this;
    }

    public InventorySlot SetPadding(Vector2 padding) {
        this.padding = padding;
        layout.RecalculateHeights();
        return this;
    }

    public InventorySlot SetIcon(Sprite icon) {
        this.iconSprite = icon;
        return this;
    }

    public InventorySlot SetData(String data) {
        this.data = data;
        return this;
    }

    @Override
    public void HandleClick(boolean isDown) {
        if (isDown) {
            InventoryUtil.StartDrag(data);
        }
        else {
            InventoryUtil.StopDrag(data);
        }
        super.HandleClick(isDown);
    }

    @Override
    public int CalculateHeight() {
        return iconHeight;
    }

    @Override
    public void UpdateBounds(Box bounds) {
        this.bounds = new Box(
            bounds.position.Add(padding),
            bounds.size.Sub(padding.Mul(2))
        );
    }

    @Override
    public void draw(IRenderer renderer) {
        renderer.FillBox(bounds, slotColor);
        if (iconSprite != null) {
            renderer.DrawScreenSprite(iconSprite, bounds);
        }
    }
}
