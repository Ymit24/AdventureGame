package com.christian.adventuregame.demo.utils;

import com.christian.adventureengine.data.Box;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.rendering.Camera;
import com.christian.adventureengine.utils.Randomizer;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.data.terrain.Tile;

import java.util.ArrayList;
import java.util.Random;

public class EnemyMovementAi {

    public static Vector2 GetWanderTarget(Vector2 position, float wanderRange) {
        Box bounds = Camera.GetCamera().GetCameraBounds();
        float wanderX = Randomizer.Between(
                Math.max(
                        bounds.GetLeft(),
                        position.x - wanderRange
                ),
                Math.min(
                        bounds.GetRight() - 1,
                        position.x + wanderRange
                )
        );

        float wanderY = Randomizer.Between(
                Math.max(
                        bounds.GetTop(),
                        position.y - wanderRange
                ),
                Math.min(
                        bounds.GetBottom() - 1,
                        position.y + wanderRange
                )
        );

        ArrayList<Tile> availableTiles = GetAvailableTiles(position, wanderRange);
        Tile randomTile = availableTiles.get(Randomizer.random.nextInt(availableTiles.size()));

        return new Vector2(randomTile.Position);
    }

    private static ArrayList<Tile> GetAvailableTiles(Vector2 position, float range) {
        ArrayList<Tile> walkableTiles = new ArrayList<>();
        for (int x = Math.max(0,(int)(position.x - range)); x < Math.min ((int)(position.x + range),State.terrain.width); x++) {
            for (int y = Math.max(0,(int)(position.y - range)); y < Math.min((int)(position.y + range),State.terrain.height); y++) {
                if (State.terrain.GetTile(x,y).isWalkable()) {
                    walkableTiles.add(State.terrain.GetTile(x,y));
                }
            }
        }
        return walkableTiles;
    }
}
