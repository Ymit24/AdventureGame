package com.christian.adventuregame.demo.data;

import com.christian.adventureengine.data.ISerializable;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.data.WorldObject;
import com.christian.adventureengine.utils.Deserializer;
import com.christian.adventureengine.utils.Serializer;

public class Tile extends WorldObject implements ISerializable {
	public enum TileType {
		grass, water
	}
	
	public TileType type;
	
	public Tile(Vector2 position, TileType type) {
		super(position);
		this.type = type;
	}
	
	private Tile(WorldObject object) {
		super(object.Position, object.Size);
	}

	@Override
	public void Serialize(Serializer serializer) {
		super.Serialize(serializer);
		serializer.WriteString(type.name());
	}

	public static Tile Deserialize(Deserializer deserializer) {
		Tile tile = new Tile(WorldObject.Deserialize(deserializer));
		tile.type = TileType.valueOf(deserializer.ReadString());
		return tile;
	}
}
