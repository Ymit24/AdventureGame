import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class PlayerController {
	public Player player;
	
	public PlayerController(int x, int y)
	{
		player = new Player(x,y);
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.red);
		g.fillRect((int)player.x, (int)player.y, 50, 50);
	}
	
	public void update(KeyboardListener keyListener, double deltaTime)
	{
		float vx = 0;
		float vy = 0;
		
		if (keyListener.isKeyDown(KeyEvent.VK_W))
		{
			vy -= 1;
		}
		if (keyListener.isKeyDown(KeyEvent.VK_S))
		{
			vy += 1;
		}
		if (keyListener.isKeyDown(KeyEvent.VK_A))
		{
			vx -= 1;
		}
		if (keyListener.isKeyDown(KeyEvent.VK_D))
		{
			vx += 1;
		}
		
		if (vx == 0 && vy == 0) return;
		float mag = (float)Math.sqrt(vx * vx + vy * vy);
		vx /= mag;
		vy /= mag;
		
		player.x += vx * 100 * deltaTime;
		player.y += vy * 100 * deltaTime;
	}
}
