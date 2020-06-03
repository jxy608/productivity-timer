import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ThankYouPanel extends JPanel{
	
	public ThankYouPanel() {
		
		setLayout(new GridLayout(1, 2, 10, 10));
		ImageIcon icon = new ImageIcon("summerdrinks.gif");
		JLabel gif = new JLabel(icon);
		add(gif);
		ImageIcon icon2 = new ImageIcon("girlthankyou.jpg");
		JLabel pic = new JLabel(icon2);
		add(pic);
	}
}
