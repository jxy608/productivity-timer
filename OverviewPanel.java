import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OverviewPanel extends JPanel{
	
	private ImageIcon icondef, iconstress;
	JLabel picture;
		
	public OverviewPanel(Timer timer, ToDoPanel todo)
	{
		
		setLayout(new GridLayout(1, 2, 10, 10));
		Box cuteGirl = Box.createVerticalBox();
		Box overview = Box.createVerticalBox();
				
		iconstress = new ImageIcon("girlcup.png");
		picture = new JLabel(iconstress);
		cuteGirl.add(picture);
		picture.setAlignmentX(CENTER_ALIGNMENT);
		
		overview.add(new JLabel("Keep working hard :)"));
		overview.add(timer.timeStudied);
		overview.add(todo.taskOverview);
		
		add(cuteGirl);
		add(overview);
		
	}

}
