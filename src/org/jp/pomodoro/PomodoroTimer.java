package org.jp.pomodoro;

public class PomodoroTimer {
	private int pomodoroTime = 25;
	private int breakTime = 2;
	private boolean pomodoroActive = true;
	private static final int SECONDS = 60;
	private Integer minutes = 0;
	private Integer seconds = 0;
	
	public void tic(){
		seconds++;		
		if(seconds%SECONDS == 0){
			minutes ++;
			seconds = 0;
		}
		if(minutes == getMaxTime() && seconds > 0){
			minutes = 0;
			pomodoroActive = !pomodoroActive;
		}
	}

	public String getTime() {
		String minutes = this.minutes < 10 ? "0"+this.minutes:this.minutes.toString(); 
		String seconds = this.seconds < 10 ? "0"+this.seconds:this.seconds.toString();
		return minutes+":"+seconds ;
	}

	void tic(int i) {
		while(i-->0){
			tic();			
		}		
	}

	private Integer getMaxTime() {
		if(pomodoroActive)
			return pomodoroTime;
		return breakTime;
	}

	public boolean isPomodoroTime() {
		return pomodoroActive;
	}
}
