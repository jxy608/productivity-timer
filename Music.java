
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Music extends JPanel implements ActionListener{
	
	private JButton start, pause, stop;
	private Long currentPos;
	private AudioInputStream audioInputStream;
	private Clip clip;
	private boolean playing = false;
	private boolean firstTime = true;
	private String file;
	
	public Music(String fileName) 
	{
		file = fileName; 
		
		start = new JButton(new ImageIcon("play.jpg"));
		start.addActionListener(this);
		
		pause = new JButton(new ImageIcon("pause.png"));
		pause.addActionListener(this);
		
		stop = new JButton(new ImageIcon("stop.png"));
		stop.addActionListener(this);
		
		add(start);
		add(pause);
		add(stop);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == start && !playing)
		{
			if (firstTime)
			{
				try {
					audioInputStream = AudioSystem.getAudioInputStream(new File(file));
					clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
					playing = true;
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
				firstTime = false;
			}
			else
			{
				clip.setMicrosecondPosition(currentPos);
				try {
					clip.start();
					playing = true;
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		
		else if (e.getSource() == pause && playing)
		{
			currentPos = clip.getMicrosecondPosition();
			clip.stop();
			playing = false;
		}

		else if (e.getSource() == stop && playing)
		{
			currentPos = 0L;
			clip.stop();
			playing = false;
		}
	}

}
