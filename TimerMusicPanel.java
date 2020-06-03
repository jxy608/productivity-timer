import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimerMusicPanel extends JPanel{
		
	public TimerMusicPanel(Timer t)
	{
		setLayout(new GridLayout(1, 2, 10, 10));
		Box timerMusic = Box.createVerticalBox();
		timerMusic.add(t);
	
		JLabel labelMusic = new JLabel("Lofi to lift your spirits :) ");
		timerMusic.add(labelMusic);
		labelMusic.setAlignmentX(JLabel.CENTER_ALIGNMENT);

		timerMusic.add(new Music("lofimix.wav"));
		
		JLabel labelMusic2 = new JLabel("Calming piano to soothe your soul...");
		timerMusic.add(labelMusic2);
		labelMusic2.setAlignmentX(JLabel.CENTER_ALIGNMENT);

		timerMusic.add(new Music("ghiblipiano.wav"));
		
		add(timerMusic);
		ImageIcon icon = new ImageIcon("studying.png");
		JLabel picture = new JLabel(icon);
		add(picture);
	}

}
