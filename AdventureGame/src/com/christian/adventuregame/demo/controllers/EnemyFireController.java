package com.christian.adventuregame.demo.controllers;

import com.christian.adventureengine.audio.AudioPlayer;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventuregame.demo.data.Enemy;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.data.archetypes.Archetype;
import com.christian.adventuregame.demo.data.archetypes.Archetypes;
import com.christian.adventuregame.demo.data.archetypes.WeaponType;
import com.christian.adventuregame.demo.utils.ProjectileEmitterUtil;

public class EnemyFireController extends Controller {
    @Override
    public void Update(float deltaTime) {
        for (Enemy enemy : State.world.enemies) {
            enemy.isShooting = enemy.Position.Sub(State.world.player.Position).Magnitude() < 9; // TODO: REPLACE THIS WITH DATA

            if (enemy.isShooting) {
                enemy.shootTimer -= deltaTime;

                if (enemy.shootTimer <= 0) {
                    WeaponType weapon = Archetypes.Weapons.Get(Archetypes.Enemies.Get(enemy.id).weaponId);

                    enemy.shootTimer = weapon.firingRate;

                    ProjectileEmitterUtil.Emit(weapon, enemy.Position, State.world.player.Position.Sub(enemy.Position).Normalized(), true);
                    AudioPlayer.Play("shoot.wav");
                }
            }
        }
    }
}