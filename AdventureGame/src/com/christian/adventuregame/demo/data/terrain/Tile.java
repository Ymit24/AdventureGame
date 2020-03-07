package com.christian.adventuregame.demo.data.terrain;

import com.christian.adventureengine.data.ISerializable;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.data.WorldObject;
import com.christian.adventureengine.utils.Deserializer;
import com.christian.adventureengine.utils.Serializer;

public class Tile extends WorldObject implements ISerializable {
	public String type;
	public String regionId;

	public Tile(Vector2 position, String type, String regionId) {
		super(position);
		this.type = type;
		this.regionId = regionId;
	}
	
	private Tile(WorldObject object) {
		super(object.Position, object.Size);
	}

	@Override
	public void Serialize(Serializer serializer) {
		super.Serialize(serializer);
		serializer.WriteString(type);
		serializer.WriteString(regionId);
	}

	public static Tile Deserialize(Deserializer deserializer) {
		Tile tile = new Tile(WorldObject.Deserialize(deserializer));
		tile.type = deserializer.ReadString();
		tile.regionId = deserializer.ReadString();
		return tile;
	}
}
