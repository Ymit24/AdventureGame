import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {

	public Display(int width, int height, Game game)
	{
		Dimension size = new Dimension(width, height);
		
		JFrame frame = new JFrame("RoTMG Clone By Christian v0.0");
		game.setPreferredSize(size);
		frame.add(game);

		frame.setVisible(true);
		frame.setResizable(false);
		
		frame.pack();
		frame.pack();
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
