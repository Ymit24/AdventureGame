package com.christian.adventuregame.demo.utils;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.utils.Randomizer;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.data.archetypes.Archetypes;
import com.christian.adventuregame.demo.data.archetypes.WeaponType;

import java.util.ArrayList;

public class ProjectileEmitterUtil {
    public static void Emit(WeaponType type, Vector2 basePosition, Vector2 direction) {
        Emit(type, basePosition, direction, false);
    }

    public static void Emit(WeaponType type, Vector2 basePosition, Vector2 direction, boolean isEnemy) {
        switch (type.projectileEmitter) {
            case "single":
            {
                Single(basePosition, direction, type, isEnemy);
                break;
            }
            case "double":
            {
                Double(basePosition, direction, type, isEnemy);
                break;
            }
            case "triple":
            {
                Triple(basePosition, direction, type, isEnemy);
                break;
            }
            case "circle":
            {
                CircleShot(basePosition, type, isEnemy);
                break;
            }
            case "double_together":
            {
                DoubleTogether(basePosition, direction, type, isEnemy);
                break;
            }
        }
    }

    public static void Single(Vector2 basePosition, Vector2 direction, WeaponType type, boolean isEnemy) {
        State.world.SpawnBullet(basePosition.Add(direction.Mul(0.75f)), direction, type).isEnemy = isEnemy;
    }

    public static void DoubleTogether(Vector2 basePosition, Vector2 direction, WeaponType type, boolean isEnemy) {
        State.world.SpawnBullet(basePosition.Add(direction.Mul(0.75f)), direction, type).isEnemy = isEnemy;
        State.world.SpawnBullet(basePosition.Add(direction.Mul(0.75f)), direction, type).isEnemy = isEnemy;
        State.world.bullets.get(State.world.bullets.size()-1).OffsetWave();
    }

    public static void Double(Vector2 basePosition, Vector2 direction, WeaponType type, boolean isEnemy) {
        Vector2 posOne = basePosition.Add(direction.Mul(0.4f)).Add(direction.GetNormal().Mul(0.25f));
        Vector2 posTwo = basePosition.Add(direction.Mul(0.4f)).Sub(direction.GetNormal().Mul(0.25f));

        State.world.SpawnBullet(posOne, direction, type).isEnemy = isEnemy;
        State.world.SpawnBullet(posTwo, direction, type).isEnemy = isEnemy;
    }

    public static void Triple(Vector2 basePosition, Vector2 direction, WeaponType type, boolean isEnemy) {
        Vector2 posOne   = basePosition.Add(direction.Mul(0.4f)).Add(direction.GetNormal().Mul(0.45f));
        Vector2 posTwo   = basePosition.Add(direction.Mul(0.4f)).Sub(direction.GetNormal().Mul(0.0f));
        Vector2 posThree = basePosition.Add(direction.Mul(0.4f)).Sub(direction.GetNormal().Mul(0.45f));

        State.world.SpawnBullet(posOne, direction, type).isEnemy = isEnemy;
        State.world.SpawnBullet(posTwo, direction, type).isEnemy = isEnemy;
        State.world.SpawnBullet(posThree, direction, type).isEnemy = isEnemy;
    }

    public static void CircleShot(Vector2 basePosition, WeaponType type, boolean isEnemy) {
        CircleShot(basePosition, 12, type, isEnemy);
    }
    public static void CircleShot(Vector2 basePosition, int shotsToFire, WeaponType type, boolean isEnemy) {
        ArrayList<WeaponType> allTypes = Archetypes.Weapons.GetAll();
        for (int i = 0; i < 360; i+=360/shotsToFire) {
            Single(basePosition, new Vector2(i), allTypes.get(Randomizer.random.nextInt(allTypes.size())), isEnemy);
        }
    }
}
