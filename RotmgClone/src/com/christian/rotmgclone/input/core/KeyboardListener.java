package com.christian.rotmgclone.input.core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.christian.rotmgclone.input.IKeyListener;
import com.christian.rotmgclone.input.IKeyboardListener;

public class KeyboardListener implements IKeyboardListener, KeyListener {
	private Map<Integer, Boolean> keyStates;
	private ArrayList<IKeyListener> keyListeners;
	
	public KeyboardListener() {
		keyStates = new HashMap<>();
		keyListeners = new ArrayList<IKeyListener>();
	}
	
	public boolean isKeyDown(int keycode) {
		if (keyStates.containsKey(keycode) == false)
			return false;
		return keyStates.get(keycode);
	}
	
	public void AddKeyListener(IKeyListener listener) {
		this.keyListeners.add(listener);
	}
	
	public void RemoveKeyListener(IKeyListener listener) {
		this.keyListeners.remove(listener);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keyStates.put(e.getKeyCode(), true);
		
		for (IKeyListener listener : keyListeners) {
			listener.OnKey(e.getKeyCode(), true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keyStates.put(e.getKeyCode(), false);
		
		for (IKeyListener listener : keyListeners) {
			listener.OnKey(e.getKeyCode(), false);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// not used
	}
	
}
