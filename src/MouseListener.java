import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MouseListener implements javax.swing.event.MouseInputListener {
	
	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	public static final int MIDDLE = 2;
	
	public interface ClickListener
	{
		void onClick(int x, int y, int button, boolean isDown);
	}
	
	private int x;
	private int y;
	private ArrayList<ClickListener> clickListeners;
	private boolean[] states;
	
	public MouseListener()
	{
		states = new boolean[3];
		clickListeners = new ArrayList<>();
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	
	public void addClickListener(ClickListener listener)
	{
		clickListeners.add(listener);
	}
	
	public boolean isMouseButtonDown(int button)
	{
		if (button >= 0 && button <= 2)
		{
			return states[button];
		}
		System.out.println("[MouseListener:isMouseButtonDown] Invalid button.");
		return false;
	}
	
	private void invokeClick(int button, boolean isDown)
	{
		if (clickListeners.size() == 0)
		{
			return;
		}
		
		for (ClickListener listener : clickListeners)
		{
			listener.onClick(x, y, button, isDown);
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e)
	{
		x = e.getX();
		y = e.getY();
		
		switch (e.getButton())
		{
		case MouseEvent.BUTTON1:
		{
			states[LEFT] = true;
			invokeClick(LEFT, true);
			break;
		}
		case MouseEvent.BUTTON2:
		{
			states[RIGHT] = true;
			invokeClick(RIGHT, true);
			break;
		}
		case MouseEvent.BUTTON3:
		{
			states[MIDDLE] = true;
			invokeClick(MIDDLE, true);
			break;
		}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		x = e.getX();
		y = e.getY();
		
		switch (e.getButton())
		{
		case MouseEvent.BUTTON1:
		{
			states[LEFT] = false;
			invokeClick(LEFT, false);
			break;
		}
		case MouseEvent.BUTTON2:
		{
			states[RIGHT] = false;
			invokeClick(RIGHT, false);
			break;
		}
		case MouseEvent.BUTTON3:
		{
			states[MIDDLE] = false;
			invokeClick(MIDDLE, false);
			break;
		}
		}
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		x = e.getX();
		y = e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		x = e.getX();
		y = e.getY();
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0)
	{}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{}

	@Override
	public void mouseExited(MouseEvent arg0)
	{}
}
