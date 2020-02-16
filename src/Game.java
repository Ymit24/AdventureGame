import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Random;

public class Game extends Canvas implements Runnable {
	private Display display;
	private static final int DISPLAY_WIDTH = 640;
	private static final int DISPLAY_HEIGHT = 480;
	
	private Thread thread;
	private boolean isRunning = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private MouseListener mouseListener;
	private KeyboardListener keyListener;
	
	private final int FRAME_SMOOTH_PERIODS = 12;
	private int[] frameSmoothingBuffer;
	private int frameIndex;
	
	private int averageFPS;
	
	private PlayerController playerController;
	private EnemyController enemyController;
	
	private ArrayList<Bullet> bullets;
	
	public Game()
	{
		display = new Display(DISPLAY_WIDTH, DISPLAY_HEIGHT, this);
		
		mouseListener = new MouseListener();
		
		keyListener = new KeyboardListener();
		
		addMouseListener(mouseListener);
		addKeyListener(keyListener);
		
		frameSmoothingBuffer = new int[FRAME_SMOOTH_PERIODS];
		
		playerController = new PlayerController(200, 200);
		enemyController = new EnemyController();
		bullets = new ArrayList<>();
		
		Random random = new Random();
		for (int i = 0; i < 10; i++)
		{
			int rx = random.nextInt(DISPLAY_WIDTH);
			int ry = random.nextInt(DISPLAY_HEIGHT);
			enemyController.SpawnEnemyAt(rx, ry);
		}
	}
	
	public void Start()
	{
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void run()
	{
		final int desiredFps = 120;
		double desiredTime = 1000000000.0 / (double)desiredFps;
		long currentTime = System.nanoTime();
		long nextTime = (long)(currentTime + desiredTime);
		
		int frames = 0;
		
		long lastSecond = System.nanoTime();
		
		final int periods = 12;
		int[] fpsSmooths = new int[periods];
		int fpsIndex = 0;
		
		long lastTime = System.nanoTime();
		double delta = 0;
		while (isRunning)
		{
			if (System.nanoTime() > nextTime)
			{
				if (System.nanoTime() - lastSecond > 1000000000)
				{	
					fpsSmooths[fpsIndex] = frames;
					fpsIndex = (fpsIndex + 1) % periods;
					
					int totalFPS = 0;
					int goodPeriods = 0;
					for (int fps : fpsSmooths)
					{
						if (fps < 1) continue;
						totalFPS += fps;
						goodPeriods++;
					}
					
					if (goodPeriods > 0)
					{
						averageFPS = (int)((double)totalFPS / (double)goodPeriods);
						System.out.println("Average FPS: " + averageFPS + " delta: " + delta);
					}
					frames = 0;
					delta = 0;
					lastSecond = System.nanoTime();
					continue;
				}
				
				frames++;
				nextTime += desiredTime;
				double frameTime = (System.nanoTime() - lastTime);
				lastTime = System.nanoTime();
				double deltaTime = (frameTime/1000000000.0);
				
				delta += deltaTime;
				
				update((float)deltaTime);
				render();
			}
			
			try
			{
				// This stops the game from using ~30% total cpu, down to about 7%.
				Thread.sleep(1);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private float lastSpawn = 0;
	private final float spawnDelay = 0.25f;
	private void update(float deltaTime)
	{
		playerController.update(keyListener, deltaTime);
		
		if (lastSpawn > spawnDelay)
		{
			if (mouseListener.isMouseButtonDown(0))
			{
				lastSpawn -= spawnDelay;
				float dx = mouseListener.getX() - playerController.player.x;
				float dy = mouseListener.getY() - playerController.player.y;
				double angle = Math.atan2(dy, dx);
				
				Bullet b = new Bullet(playerController.player.x, playerController.player.y, (float)angle, true);
				Bullet b2 = new Bullet(playerController.player.x, playerController.player.y, (float)angle, false);
				
				bullets.add(b);
				bullets.add(b2);
				
				System.out.println("Angle: " + angle);
			}
		}
		else
		{
			lastSpawn += deltaTime;
		}
		
		for (Bullet b : bullets)
		{
			b.update(deltaTime);
		}
		
		enemyController.update(bullets);
	}
	
	private void render()
	{
		if (bs == null)
		{
			createBufferStrategy(2);
			bs = getBufferStrategy();
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0,0,DISPLAY_WIDTH,DISPLAY_HEIGHT);

		g.setColor(Color.BLUE);
		Font font = new Font("Arial", Font.PLAIN, 32);
		g.setFont(font);
		g.drawString("FPS: " + averageFPS, 10, 40);
		
		enemyController.render(g);
		playerController.render(g);
		
		for (Bullet b : bullets)
		{
			b.render(g);
		}
		
		bs.show();
		g.dispose();
	}
	
	public static void main(String[] args) {
		new Game().Start();;
	}
}
