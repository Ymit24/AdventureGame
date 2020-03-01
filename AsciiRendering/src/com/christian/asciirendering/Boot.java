package com.christian.asciirendering;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.logic.ControllerManager;
import com.christian.adventureengine.logic.GameLoop;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.core.CoreRenderer;

public class Boot {
	public static void main(String[] args) {
		IRenderer renderer = new CoreRenderer();
		renderer.Initialize("Ascii Rendering Test", 1280, 720);
		renderer.CreateCamera(new Vector2(6,6));
		renderer.CreateSpriteManager();
		
		renderer.SetRootView(new AsciiView());
		
//		int consoleWidth = 80;
//		int pixelsPerCharacter = renderer.GetDisplayWidth() / consoleWidth;
//		renderer.SetFontSize(pixelsPerCharacter);
//		
//		System.out.println(pixelsPerCharacter);
		
//		Global.console = new ConsoleBuffer(consoleWidth, renderer.GetDisplayHeight() / pixelsPerCharacter, pixelsPerCharacter);
//		Global.console.Fill(".", 0, 0, consoleWidth, 1);
//		Global.console.Write("File", 2, 0);
//		Global.console.Write("Edit", 8, 0);
//		Global.console.Write("View", 14, 0);
		
//		Global.console.Fill("=", consoleWidth-10, 0, consoleWidth, Global.console.height);
//		Global.console.Fill(".", consoleWidth-9, 1, consoleWidth-1, Global.console.height-1);
		
		GameLoop.Initialize(new ControllerManager(),renderer);
		GameLoop.Start();
	}
}
