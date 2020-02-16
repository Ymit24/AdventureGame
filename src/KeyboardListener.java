import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class KeyboardListener implements KeyListener {

	private Map<Integer, Boolean> keyStates;
	
	public KeyboardListener()
	{
		keyStates = new HashMap<>();
	}
	
	public boolean isKeyDown(int keycode)
	{
		if (keyStates.containsKey(keycode) == false)
			return false;
		return keyStates.get(keycode);
	}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		keyStates.put(e.getKeyCode(), true);
		System.out.println(e.getKeyChar());
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		keyStates.put(e.getKeyCode(), false);
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

}
