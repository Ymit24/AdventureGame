package com.christian.rotmgclone.input;

public class Input {
	public static IKeyboardListener keyboardListener;
	
	public static IKeyboardListener GetKeyboardListener() {
		return keyboardListener;
	}
	
	public static void SetKeyboardListener(IKeyboardListener keyboardListener) {
		Input.keyboardListener = keyboardListener;
	}
}
