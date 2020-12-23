package state_clock;

public class MinuteState implements State {

	private MinuteState() {}
	
	private static MinuteState instance;
	
	public static MinuteState getInstance() {
		if (instance == null)
			instance = new MinuteState();
		return instance;
	}
	
	@Override
	public void mode(Clock c) {
		c.currentState = TimeState.getInstance();
	}

	@Override
	public void change(Clock c) {
		c.minute++;
		
		if (c.minute == 60) {
			c.minute = 0;
			c.hour++;
			c.hour %= 24;
		}
	}

}