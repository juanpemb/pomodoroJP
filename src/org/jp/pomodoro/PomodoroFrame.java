package org.jp.pomodoro;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class PomodoroFrame extends JFrame implements ActionListener{
	private static final int SECOND_IN_MILISECONDS = 1000;
	private PomodoroTimer pomodoroTimer = new PomodoroTimer();
	private Timer timer;
	private JLabel timeLabel;
	private Component colorLabel;
	private JLabel texto;	
	public PomodoroFrame(){
		configureFrame();
		initTimer();
	}
	private void configureFrame() {
		this.setLayout(new FlowLayout());
		this.setTitle("Pomodoro JP...");
		this.setSize(300, 100);
		JPanel container = new JPanel(new GridLayout(2,1));
		this.timeLabel = new JLabel(makeTimeFormated());		
		container.add(timeLabel);
		texto = new JLabel("Pomodoro activo...");
		colorLabel = this.add(texto);
		colorLabel.setBackground(obtainColor());
		
		container.add(colorLabel);
		this.setLayout(new GridLayout(1,2));
		this.add(container);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
	}
	private void initTimer() {
		timer = new Timer(SECOND_IN_MILISECONDS, this);
		timer.start();
	}
	public static void main(String args[]){
		new PomodoroFrame();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		pomodoroTimer.tic();		
		timeLabel.setText(makeTimeFormated());	
		timeLabel.setBackground(obtainColor());
		colorLabel.setBackground(obtainColor());
		if(obtainColor().equals(Color.RED)){texto.setText("Pomodoro activo");}
		else{texto.setText("Descanso");}
		texto.setBackground(obtainColor());
	
	}
	private Color obtainColor() {
		return pomodoroTimer.isPomodoroTime()?Color.RED:Color.GREEN;
	}
	private String makeTimeFormated() {
		return "<html><h1>"+pomodoroTimer.getTime()+"</h1></html>";
	}	
}
