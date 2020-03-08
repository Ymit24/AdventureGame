package com.christian.adventuregame.demo.utils;

import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.data.WorldObject;
import com.christian.adventureengine.utils.Collision;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.data.World;
import com.christian.adventuregame.demo.data.terrain.Terrain;
import com.christian.adventuregame.demo.data.terrain.Tile;

public class CollisionMovementUtil {
    public static Vector2 TryMove(WorldObject source, Vector2 motion) {
        if (CanBeAt(new Box(source.Position.Add(motion), source.Size))) {
            return motion;
        }

        Vector2 xMove = new Vector2(motion.x, 0);
        if (!CanBeAt(new Box(source.Position.Add(xMove), source.Size))) {
            xMove = Vector2.Zero();

            Vector2 pos = source.Position;
            while (CanBeAt(new Box(pos, source.Size))) {
                pos = pos.Add(new Vector2(motion.x > 0 ? 1 : -1,0));
            }
            pos.x = Math.round(pos.x) - (motion.x > 0 ? 1 : -1);
            xMove.x = pos.x - source.Position.x;
        }

        Vector2 yMove = new Vector2(0, motion.y);
        if (!CanBeAt(new Box(source.Position.Add(yMove), source.Size))) {
            yMove = Vector2.Zero();

            Vector2 pos = source.Position;
            while (CanBeAt(new Box(pos, source.Size))) {
                pos = pos.Add(new Vector2(0, motion.y > 0 ? 1 : -1));
            }
            pos.y = Math.round(pos.y) - (motion.y > 0 ? 1 : -1);
            yMove.y = pos.y - source.Position.y;
        }

        return xMove.Add(yMove);
    }

    public static boolean CanBeAt(Box object) {
        Terrain terrain = State.terrain;
        for (int x = 0; x < terrain.width; x++) {
            for (int y = 0; y < terrain.height; y++) {
                Tile tile = terrain.tiles[x][y];
                if (!tile.isWalkable() && Collision.AABB(new Box(tile.Position, tile.Size), object)) {
                    return false;
                }
            }
        }
        return true;
    }
}
