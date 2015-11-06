package org.jp.pomodoro;


import org.junit.Assert;
import org.junit.Test;

public class PomodoroClockTest {
	private PomodoroTimer pomodoroTimer = new PomodoroTimer();

	@Test
	public void test_get_time_well_format(){
		pomodoroTimer.tic();
		String time = pomodoroTimer.getTime();
		Assert.assertTrue(time.length() == 5);
	}
	@Test
	public void test_get_time_one_minute(){
		pomodoroTimer.tic(60);
		Assert.assertEquals(pomodoroTimer.getTime(),"01:00");
	}
	@Test
	public void test_get_time_two_minutes(){
		pomodoroTimer.tic(120);
		Assert.assertEquals(pomodoroTimer.getTime(),"02:00");
	}
	@Test
	public void test_get_time_ten_minutes(){
		pomodoroTimer.tic(600);
		Assert.assertEquals(pomodoroTimer.getTime(),"10:00");
	}
	@Test
	public void test_get_time_twentyfive_minutes(){
		pomodoroTimer.tic(1500);
		Assert.assertEquals(pomodoroTimer.getTime(),"25:00");
	}
	@Test
	public void test_get_time_twentyfive_minutes_and_one_second(){
		pomodoroTimer.tic(1501);
		Assert.assertEquals(pomodoroTimer.getTime(),"00:01");
	}
	@Test
	public void test_get_time_for_break(){
		pomodoroTimer.tic(1620);
		Assert.assertEquals(pomodoroTimer.getTime(),"02:00");
	}
	@Test
	public void test_get_time_for_new_pomodoro(){
		pomodoroTimer.tic(1621);
		Assert.assertEquals(pomodoroTimer.getTime(),"00:01");
	}	
}
