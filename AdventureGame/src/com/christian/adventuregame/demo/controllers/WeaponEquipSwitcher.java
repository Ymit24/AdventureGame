package com.christian.adventuregame.demo.controllers;

import com.christian.adventureengine.input.Input;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventureengine.utils.Randomizer;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.data.archetypes.Archetypes;
import com.christian.adventuregame.demo.data.archetypes.ItemType;

import java.awt.event.KeyEvent;

public class WeaponEquipSwitcher extends Controller {
    @Override
    public void Update(float deltaTime) {
        if (Input.GetKeyboardListener().isKeyDown(KeyEvent.VK_O)) {
            System.out.println("Switching player weapon");
            ItemType type = Archetypes.Items.GetRandomType();
            State.world.player.inventory.storageItems[Randomizer.random.nextInt(State.world.player.inventory.storageItems.length)] = type;
        }
    }
}
