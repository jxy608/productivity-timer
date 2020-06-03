
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class ToDoPanel extends JPanel implements ActionListener{
	
	private JTextField newthing;
	private Box addNew, doNow, doLater;
	private JComboBox<String> dueDates;
	public int tasksCompleted, tasksToDo;
	public JTextArea taskOverview;
	
	public ToDoPanel()
	{	
		taskOverview = new JTextArea("You have 0 tasks to do and 0 tasks \ncompleted.");
		taskOverview.setEditable(false);
		taskOverview.setLineWrap(true);
		
		this.setLayout(new GridLayout(1, 3, 10, 10));
		addNew = Box.createVerticalBox();
		doNow = Box.createVerticalBox();
		doLater = Box.createVerticalBox();
		
		addNew.add(Box.createVerticalStrut(25));
		JLabel newTask = new JLabel("Add a task...  new");
		newTask.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
		
		addNew.add(newTask);
		addNew.add(Box.createVerticalStrut(10));

		
		String[] dates = {"Do now", "Do later"};
		dueDates = new JComboBox<String>(dates);
		
		newthing = new JTextField();
		newthing.addActionListener(this);

		addNew.add(dueDates);
		addNew.add(newthing);
		addNew.add(Box.createVerticalStrut(25));
		
		ImageIcon icon = new ImageIcon("goodluck.jpg");
		JLabel picture = new JLabel(icon);
		picture.setAlignmentX(JLabel.CENTER_ALIGNMENT);

		addNew.add(picture);
		
		JScrollPane scrollDoNow = new JScrollPane(doNow);
		scrollDoNow.setColumnHeaderView(new JLabel("Do now: "));
		
		JScrollPane scrollDoLater = new JScrollPane(doLater);
		scrollDoLater.setColumnHeaderView(new JLabel("Do later: "));

				
		add(addNew);
		add(scrollDoNow);
		add(scrollDoLater);
		
	}
	
	public void updateTasks()
	{
		if (tasksCompleted > 5)
			taskOverview.setText("You have " + tasksToDo +  " tasks to do and " + tasksCompleted + " tasks \ncompleted. Good job, you worked hard today!");
		else if (tasksToDo > 10)
			taskOverview.setText("You have " + tasksToDo +  " tasks to do and " + tasksCompleted + " tasks \ncompleted. Better get going soon, buddy...");
		else
			taskOverview.setText("You have " + tasksToDo +  " tasks to do and " + tasksCompleted + " tasks \ncompleted.");

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == newthing)
		{
			JTextField temp1 = (JTextField)e.getSource();
			JCheckBox newcb = new JCheckBox(temp1.getText());
			
			if (dueDates.getSelectedIndex() == 0)
			{
				doNow.add(newcb);
				tasksToDo++;
				updateTasks();
			}
			else
			{
				doLater.add(newcb);
				tasksToDo++;
				updateTasks();
			}
			
			newcb.addActionListener(this);
			newthing.setText("");
			revalidate();
			repaint();
		}
		
		if (e.getSource() instanceof JCheckBox)
		{
			doNow.remove((JCheckBox)e.getSource());
			doLater.remove((JCheckBox)e.getSource());
			tasksCompleted++;
			tasksToDo--;
			updateTasks();
			revalidate();
			repaint();
		}
		
	}
}
