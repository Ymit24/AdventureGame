package com.christian.adventuregame.demo.data.terrain;

import com.christian.adventureengine.data.ISerializable;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.utils.Deserializer;
import com.christian.adventureengine.utils.Serializer;

public class Chunk implements ISerializable {
    public int chunkSize;
    public Vector2 position;
    public Tile[][] tiles;

    public Chunk(int chunkSize, Vector2 position) {
        this.chunkSize = chunkSize;
        this.position = position;
        System.out.println("Size: " +chunkSize);
        this.tiles = new Tile[chunkSize][chunkSize];
    }

    public Tile GetTileLocal(Vector2 localPosition) {
        if (localPosition.x < 0 || localPosition.y < 0 || localPosition.x >= chunkSize || localPosition.y >= chunkSize) {
            return null;
        }

        return tiles[(int)localPosition.x][(int)localPosition.y];
    }

    public Tile GetTile(Vector2 globalPosition) {
        return GetTileLocal(globalPosition.Sub(position));
    }

    @Override
    public void Serialize(Serializer serializer) {
        serializer.WriteInt(chunkSize);
        position.Serialize(serializer);
        for (int x = 0; x < chunkSize; x++) {
            for (int y = 0; y < chunkSize; y++) {
                tiles[x][y].Serialize(serializer);
            }
        }
    }

    public static Chunk Deserialize(Deserializer deserializer) {
        int chunkSize = deserializer.ReadInt();
        Vector2 position = Vector2.Deserialize(deserializer);
        Chunk chunk = new Chunk(chunkSize, position);

        for (int x = 0; x < chunkSize; x++) {
            for (int y = 0; y < chunkSize; y++) {
                chunk.tiles[x][y] = Tile.Deserialize(deserializer);
            }
        }
        return chunk;
    }
}
