package com.christian.rotmgclone.logic;

import com.christian.rotmgclone.rendering.IRenderer;

public class GameLoop {
	public static final int TARGET_FPS = 60;
	
	private Thread thread;
	private boolean isRunning;
	
	private static final double ONE_BILLION = 1000000000.0;
	private final int FRAME_SMOOTH_PERIODS = 12;
	private int[] frameSmoothingBuffer;
	private int frameIndex;
	private int averageFPS;
	
	private InnerLoop innerLoop;
	
	private IUpdater updater;
	private IRenderer renderer;
	
	public GameLoop(IUpdater updater, IRenderer renderer) {
		frameSmoothingBuffer = new int[FRAME_SMOOTH_PERIODS];
		frameIndex = 0;
		innerLoop = new InnerLoop();
		
		this.updater = updater;
		this.renderer = renderer;
	}
	
	public void Start() {
		isRunning = true;
		thread = new Thread(innerLoop);
		thread.start();
	}
	
	public void Stop() {
		isRunning = false;
		try {
			thread.join();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public class InnerLoop implements Runnable {
		public void run() {
			double desiredTime = ONE_BILLION / (double)TARGET_FPS;
			long currentTime = System.nanoTime();
			long nextTime = (long)(currentTime + desiredTime);
			
			int frames = 0;
			long lastSecond = System.nanoTime();
			long lastTime = System.nanoTime();
			double delta = 0;
			while (isRunning) {
				if (System.nanoTime() > nextTime) {
					if (System.nanoTime() - lastSecond > ONE_BILLION) {
						frameSmoothingBuffer[frameIndex] = frames;
						frameIndex = (frameIndex + 1) % FRAME_SMOOTH_PERIODS;
						
						int totalFPS = 0;
						int goodPeriods = 0;
						for (int fps : frameSmoothingBuffer) {
							if (fps < 1) continue;
							totalFPS += fps;
							goodPeriods++;
						}
						
						if (goodPeriods > 0) {
							averageFPS = (int)((double)totalFPS / (double)goodPeriods);
							System.out.println("Average FPS: " + averageFPS + " delta: " + delta);
						}
						frames = 0;
						delta = 0;
						lastSecond = System.nanoTime();
					}
					
					frames++;
					nextTime += desiredTime;
					double frameTime = (System.nanoTime() - lastTime);
					lastTime = System.nanoTime();
					double deltaTime = (frameTime / ONE_BILLION);
					
					delta += deltaTime;
					
					// update & render here
					updater.OnUpdate((float)deltaTime);
					renderer.OnRender();
				}
			}
		}
	}
}






