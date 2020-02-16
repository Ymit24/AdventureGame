import java.awt.Color;
import java.awt.Graphics;

public class Bullet {

	private float x, y;
	private float nx, ny;
	private float angle;
	private float timer;
	private float beta;
	
	public static final float SIZE = 30;
	
	public float getX() { return x; }
	public float getY() { return y; }
	
	public Bullet(float x, float y, float angle, boolean offset)
	{
		this.x = x;
		this.y = y;
		this.nx = x;
		this.ny = y;
		this.angle = angle;
		if (offset)
		{
			this.timer = 0;	
		}
		else
		{
			this.timer = (float)Math.PI;
		}
		
		this.beta = (float)(angle + Math.PI / 2.0);
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.GREEN);
		g.fillOval((int)x, (int)y, (int)SIZE, (int)SIZE);
	}
	
	public void update(float deltaTime)
	{
		this.timer += deltaTime;
		
		float dx = (float)Math.cos(angle);
		float dy = (float)Math.sin(angle);
		
		float mag = (float)Math.sqrt(dx * dx + dy * dy);
		if (mag > 0)
		{
			dx /= mag;
			dy /= mag;
		}
		
		final float speed = 500;
		nx += dx * speed * deltaTime;
		ny += dy * speed * deltaTime;
		
		float c = (float)(Math.sin(timer * 15) * 45);
		
		x = (float)(nx + Math.cos(beta) * c);
		y = (float)(ny + Math.sin(beta) * c);
	}
}
