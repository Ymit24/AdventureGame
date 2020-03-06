package com.christian.adventuregame.demo.utils;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventuregame.demo.data.Bullet;

public class ProjectileMovementUtil {
    public static Vector2 Move(Bullet bullet) {
        switch (bullet.type.projectileBehavior) {
            case "straight": {
                return MoveStraight(bullet);
            }
            case "sine": {
                return MoveSine(bullet);
            }
        }

        return null;
    }

    public static Vector2 MoveStraight(Bullet bullet) {
        return bullet.GetDirection().Normalized().Mul(Bullet.SPEED);
    }

    public static Vector2 MoveSine(Bullet bullet) {
        float c = (float)(Math.sin(bullet.timer * 11) * 1.55f);

        Vector2 direction = MoveStraight(bullet);
        return new Vector2(
            direction.x + (bullet.normal.x * c),
            direction.y + (bullet.normal.y * c)
        ).Normalized().Mul(Bullet.SPEED);
    }
}
