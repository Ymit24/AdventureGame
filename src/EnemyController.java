import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class EnemyController {
	private ArrayList<Enemy> enemies;
	
	public EnemyController()
	{
		enemies = new ArrayList<>();
	}
	
	public void SpawnEnemyAt(float x, float y)
	{
		enemies.add(new Enemy(x, y));
	}
	
	// Needs to be moved to a bullet controller
	public void update(ArrayList<Bullet> bullets)
	{
		ArrayList<Enemy> enemiesToRemove = new ArrayList<>();
		ArrayList<Bullet> bulletsToRemove = new ArrayList<>();
		for (Enemy enemy : enemies)
		{
			for (Bullet bullet : bullets)
			{
				if (bullet.getX() < enemy.x + Enemy.SIZE &&
					bullet.getX() + Bullet.SIZE > enemy.x &&
					bullet.getY() < enemy.y + Enemy.SIZE &&
					bullet.getY() + Bullet.SIZE > enemy.y)
				{
					System.out.println("Collision!");
					enemiesToRemove.add(enemy);
					bulletsToRemove.add(bullet);
				}
			}
		}
		
		for (Enemy enemy : enemiesToRemove)
		{
			enemies.remove(enemy);
		}
		enemiesToRemove.clear();
		
		for (Bullet bullet : bulletsToRemove)
		{
			bullets.remove(bullet);
		}
		bulletsToRemove.clear();
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.blue);
		
		for (Enemy enemy : enemies)
		{
			g.fillOval((int)enemy.x, (int)enemy.y, (int)Enemy.SIZE, (int)Enemy.SIZE);
		}
	}
}
