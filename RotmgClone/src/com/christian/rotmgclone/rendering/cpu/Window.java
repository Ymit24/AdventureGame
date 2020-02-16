package com.christian.rotmgclone.rendering.cpu;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
	private JFrame frame;
	public Window(int width, int height, Canvas canvas) {
		Dimension size = new Dimension(width, height);
		frame = new JFrame("RoTMG Clone by Christian");
		canvas.setPreferredSize(size);
		frame.add(canvas);
		frame.setVisible(true);
		frame.setResizable(false);
		
		frame.pack();
		frame.pack();
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JFrame GetFrame() {
		return this.frame;
	}
}
