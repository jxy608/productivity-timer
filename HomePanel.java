
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class HomePanel extends JPanel{
	
	public HomePanel()
	{
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel text = new JLabel("let's get productive...");
		text.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 20));
		add(text);
		
		ImageIcon icon = new ImageIcon("bookflipping.gif");
		JLabel gif = new JLabel(icon);
		add(gif);
	}

}
