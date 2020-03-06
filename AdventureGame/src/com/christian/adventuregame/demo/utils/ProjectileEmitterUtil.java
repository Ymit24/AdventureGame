package com.christian.adventuregame.demo.utils;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.utils.Randomizer;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.data.WeaponArchetypes;
import com.christian.adventuregame.demo.data.WeaponType;

public class ProjectileEmitterUtil {
    public static void Emit(String emitterId, Vector2 basePosition, Vector2 direction, WeaponType type) {
        switch (emitterId) {
            case "single":
            {
                Single(basePosition, direction, type);
                break;
            }
            case "double":
            {
                Double(basePosition, direction, type);
                break;
            }
            case "triple":
            {
                Triple(basePosition, direction, type);
                break;
            }
            case "circle":
            {
                CircleShot(basePosition, type);
                break;
            }
            case "double_together":
            {
                DoubleTogether(basePosition, direction, type);
                break;
            }
        }
    }

    public static void Single(Vector2 basePosition, Vector2 direction, WeaponType type) {
        State.world.SpawnBullet(basePosition.Add(direction.Mul(0.75f)), direction, type);
    }

    public static void DoubleTogether(Vector2 basePosition, Vector2 direction, WeaponType type) {
        State.world.SpawnBullet(basePosition.Add(direction.Mul(0.75f)), direction, type);
        State.world.SpawnBullet(basePosition.Add(direction.Mul(0.75f)), direction, type);
        State.world.bullets.get(State.world.bullets.size()-1).OffsetWave();
    }

    public static void Double(Vector2 basePosition, Vector2 direction, WeaponType type) {
        Vector2 posOne = basePosition.Add(direction.Mul(0.4f)).Add(direction.GetNormal().Mul(0.25f));
        Vector2 posTwo = basePosition.Add(direction.Mul(0.4f)).Sub(direction.GetNormal().Mul(0.25f));

        State.world.SpawnBullet(posOne, direction, type);
        State.world.SpawnBullet(posTwo, direction, type);
    }

    public static void Triple(Vector2 basePosition, Vector2 direction, WeaponType type) {
        Vector2 posOne   = basePosition.Add(direction.Mul(0.4f)).Add(direction.GetNormal().Mul(0.45f));
        Vector2 posTwo   = basePosition.Add(direction.Mul(0.4f)).Sub(direction.GetNormal().Mul(0.0f));
        Vector2 posThree = basePosition.Add(direction.Mul(0.4f)).Sub(direction.GetNormal().Mul(0.45f));

        State.world.SpawnBullet(posOne, direction, type);
        State.world.SpawnBullet(posTwo, direction, type);
        State.world.SpawnBullet(posThree, direction, type);
    }

    public static void CircleShot(Vector2 basePosition, WeaponType type) {
        CircleShot(basePosition, 12, type);
    }
    public static void CircleShot(Vector2 basePosition, int shotsToFire, WeaponType type) {
        WeaponType[] allTypes = WeaponArchetypes.GetAll();
        for (int i = 0; i < 360; i+=360/shotsToFire) {
            Single(basePosition, new Vector2(i), allTypes[Randomizer.random.nextInt(allTypes.length)]);
        }
    }
}
