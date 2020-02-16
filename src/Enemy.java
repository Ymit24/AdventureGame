
public class Enemy {
	public float x, y;
	public float health;
	
	public Enemy(float x, float y)
	{
		this.x = x;
		this.y = y;
		this.health = MAX_HEALTH;
	}
	
	private final float MAX_HEALTH = 15;
	public static final float SIZE = 55;
}
