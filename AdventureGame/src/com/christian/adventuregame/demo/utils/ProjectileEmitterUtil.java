package com.christian.adventuregame.demo.utils;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventuregame.demo.data.State;

public class ProjectileEmitterUtil {
    public static void Single(Vector2 basePosition, Vector2 direction) {
        State.world.SpawnBullet(basePosition.Add(direction.Mul(0.75f)), direction);
    }

    public static void Double(Vector2 basePosition, Vector2 direction) {
        State.world.SpawnBullet(basePosition.Add(direction.Mul(0.75f)), direction);
        State.world.SpawnBullet(basePosition.Add(direction.Mul(0.75f)), direction);
        State.world.bullets.get(State.world.bullets.size()-1).OffsetWave();
    }

    public static void DoubleSideBySide(Vector2 basePosition, Vector2 direction) {
        Vector2 posOne = basePosition.Add(direction.Mul(0.4f)).Add(direction.GetNormal().Mul(0.25f));
        Vector2 posTwo = basePosition.Add(direction.Mul(0.4f)).Sub(direction.GetNormal().Mul(0.25f));

        State.world.SpawnBullet(posOne, direction);
        State.world.SpawnBullet(posTwo, direction);
    }

    public static void TripleSideBySide(Vector2 basePosition, Vector2 direction) {
        Vector2 posOne   = basePosition.Add(direction.Mul(0.4f)).Add(direction.GetNormal().Mul(0.45f));
        Vector2 posTwo   = basePosition.Add(direction.Mul(0.4f)).Sub(direction.GetNormal().Mul(0.0f));
        Vector2 posThree = basePosition.Add(direction.Mul(0.4f)).Sub(direction.GetNormal().Mul(0.45f));

        State.world.SpawnBullet(posOne, direction);
        State.world.SpawnBullet(posTwo, direction);
        State.world.SpawnBullet(posThree, direction);
    }

    public static void CircleShot(Vector2 basePosition) {
        CircleShot(basePosition, 12);
    }
    public static void CircleShot(Vector2 basePosition, int shotsToFire) {
        for (int i = 0; i < 360; i+=360/shotsToFire) {
            Single(basePosition, new Vector2(i));
        }
    }
}
