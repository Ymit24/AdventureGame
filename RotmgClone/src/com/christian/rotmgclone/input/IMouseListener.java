package com.christian.rotmgclone.input;

import com.christian.rotmgclone.data.Vector2;

public interface IMouseListener {
	public Vector2 GetPosition();
	public boolean isMouseButtonDown(int button);
}
