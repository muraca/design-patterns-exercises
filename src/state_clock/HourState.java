package state_clock;

public class HourState implements State {

	private HourState() {}
	
	private static HourState instance;
	
	public static HourState getInstance() {
		if (instance == null)
			instance = new HourState();
		return instance;
	}
	
	@Override
	public void mode(Clock c) {
		c.currentState = MinuteState.getInstance();
	}

	@Override
	public void change(Clock c) {
		c.hour++;
		c.hour %= 24;
	}

}
