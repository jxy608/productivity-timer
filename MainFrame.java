
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class MainFrame extends JFrame implements ActionListener{
	
	private CardLayout cardlayout;
	private JPanel mainPanel;
	private HomePanel homePanel;
	private ToDoPanel todoPanel;
	private TimerMusicPanel timerPanel;
	private OverviewPanel overviewPanel;
	private ThankYouPanel thanksPanel;
	private JButton homeIcon, listIcon, timerIcon, cutieIcon, thanksIcon;
	
	public MainFrame()
	{
		Font boldFave = new Font("Yu Gothic UI Light", Font.ITALIC, 15);
		Font fave = new Font("Yu Gothic UI Light", Font.PLAIN, 14);
		Font smallFave = new Font("Yu Gothic UI", Font.PLAIN, 13);
		UIManager.put("CheckBox.font", smallFave);
		UIManager.put("ColorChooser.font", fave);
		UIManager.put("ComboBox.font", smallFave);
		UIManager.put("Label.font", boldFave);
		UIManager.put("Panel.font", fave);
		UIManager.put("ScrollPane.font", boldFave);
		UIManager.put("Button.font", smallFave);
		UIManager.put("TextField.font", smallFave);
		UIManager.put("TextArea.font", smallFave);



		
		setTitle("For a better Yu: ");
		setLayout(new BorderLayout());
		
		cardlayout = new CardLayout();
		
		mainPanel = new JPanel(cardlayout);
		homePanel = new HomePanel();
		todoPanel = new ToDoPanel();
		thanksPanel = new ThankYouPanel();
		
		Timer t = new Timer();
		
		timerPanel = new TimerMusicPanel(t);
		overviewPanel = new OverviewPanel(t, todoPanel);
				
		JToolBar tools = new JToolBar();
		tools.setOrientation(SwingConstants.VERTICAL);
		
		homeIcon = new JButton(new ImageIcon("homeIcon.png"));
		homeIcon.addActionListener(this);
		tools.add(homeIcon);
		
	    listIcon = new JButton(new ImageIcon("toDoListIcon.png"));
	    listIcon.addActionListener(this);
	    tools.add(listIcon);
	    
	    timerIcon = new JButton(new ImageIcon("timerIcon.jpg"));
	    timerIcon.addActionListener(this);
	    tools.add(timerIcon);
	    
	    cutieIcon = new JButton(new ImageIcon("cutieIcon.jpg"));
	    cutieIcon.addActionListener(this);
	    tools.add(cutieIcon);
	    
	    thanksIcon = new JButton(new ImageIcon("thanksIcon.png"));
	    thanksIcon.addActionListener(this);
	    tools.add(thanksIcon);
	    
	    mainPanel.add(homePanel, "Home");
	    mainPanel.add(todoPanel, "To-Do List");
	    mainPanel.add(timerPanel, "Timer");
	    mainPanel.add(overviewPanel, "Overview");
	    mainPanel.add(thanksPanel, "Thank You");
	    
		add(tools, BorderLayout.EAST);
		add(mainPanel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == homeIcon)
			cardlayout.show(mainPanel,  "Home");
		else if (e.getSource() == listIcon)
			cardlayout.show(mainPanel,  "To-Do List");
		else if (e.getSource() == timerIcon)
			cardlayout.show(mainPanel,  "Timer");
		else if (e.getSource() == cutieIcon)
			cardlayout.show(mainPanel,  "Overview");
		else if (e.getSource() == thanksIcon)
			cardlayout.show(mainPanel,  "Thank You");
	}
	
	public static void main(String[] args)
	{
		MainFrame window = new MainFrame();
	    window.setBounds(100, 100, 600, 400);
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setVisible(true);
	}

}
