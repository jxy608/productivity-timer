
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Timer extends JPanel implements Runnable, ActionListener{
	
	private Thread runThread;
	private boolean running = false;
	private boolean paused = false;
	private long totalTime = 0;
	private long totalTimeStudied = 0;
	private JLabel studyTime;
	public JTextArea timeStudied;
	private JButton start, pause, reset;
	
	public Timer()
	{
		timeStudied = new JTextArea("You studied for a total of 0 hrs, 0 minutes, \nand 0 seconds today.");
		timeStudied.setEditable(false);
		timeStudied.setLineWrap(true);
		
		studyTime = new JLabel("00:00:00");
		studyTime.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 50));
		start = new JButton("Study!");
		pause = new JButton("Pause");
		reset = new JButton("Reset");
		
		start.addActionListener(this);
		pause.addActionListener(this);
		reset.addActionListener(this);
		
		add(timeStudied);
		add(start);
		add(pause);
		add(reset);
		add(studyTime);

	}
	
	public void startTimer()
	{
		running = true;
		paused = false;
		runThread = new Thread(this);
		runThread.start();
	}
	
	public void pauseTimer()
	{
		paused = true;
	}
	
	public void stopTimer()
	{
		running = false;
		paused = false;
		studyTime.setText("00:00:00");
		totalTime = 0;
	}
	
	@Override
	public void run() {

		long startTime = System.nanoTime();
		while (running && !paused)
		{
			update(totalTime + System.nanoTime() - startTime);
		}
		
		if (paused)
			totalTime += System.nanoTime() - startTime;
		else
		{
			totalTime = 0;
		}
		
	}
	
	public void update(long nanoTime)
	{
		long hrs = TimeUnit.HOURS.convert(nanoTime,  TimeUnit.NANOSECONDS);
		long min = (TimeUnit.MINUTES.convert(nanoTime,  TimeUnit.NANOSECONDS))%60;
		long sec = (TimeUnit.SECONDS.convert(nanoTime,  TimeUnit.NANOSECONDS))%60;
		
		String strH = "" + hrs;
		String strM = "" + min;
		String strS = "" + sec;
		
		if (hrs < 10)
			strH = "" + 0 + strH;
		if (min < 10)
			strM = "" + 0 + strM;
		if (sec < 10)
			strS = "" + 0 + strS;

		studyTime.setText(strH + ":" + strM + ":" + strS);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == start)
			startTimer();
		else if (e.getSource() == pause)
			pauseTimer();
		else if (e.getSource() == reset)
		{
			pauseTimer();
			System.out.print("");
			totalTimeStudied += totalTime;
			timeStudied.setText(getTimeStudied());
			stopTimer();
		}
	}
	
	public String getTimeStudied()
	{
		int minutesStudied = (int)TimeUnit.MINUTES.convert(totalTimeStudied,  TimeUnit.NANOSECONDS);
		String studied = ("You studied for a total of " + 
				TimeUnit.HOURS.convert(totalTimeStudied,  TimeUnit.NANOSECONDS) + " hrs, " +
				(TimeUnit.MINUTES.convert(totalTimeStudied,  TimeUnit.NANOSECONDS)%60) + " minutes, \nand " + 
				(TimeUnit.SECONDS.convert(totalTimeStudied,  TimeUnit.NANOSECONDS)%60) + " seconds today. ");
		if (minutesStudied <= 1)
			studied += "(So basically you've \nbarely studied yet smh.)";
		else if (minutesStudied <= 10)
			studied += "Pretty good!";
		else
			studied += "You worked really \nhard today! I'm proud of you :)";
	
		return studied;
	}
	
	public static void main(String[] args)
	{
		JFrame f = new JFrame("Timer");
		f.setSize(300, 200);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Timer t = new Timer();
		f.getContentPane().add(t);
		f.setVisible(true);
	}

}
