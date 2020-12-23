package state_clock;

public class TimeState implements State {

	private TimeState() {}
	
	private static TimeState instance;
	
	public static TimeState getInstance() {
		if (instance == null)
			instance = new TimeState();
		return instance;
	}
	
	@Override
	public void mode(Clock c) {
		c.currentState = HourState.getInstance();
	}

	@Override
	public void change(Clock c) {
		c.isLightOn = !c.isLightOn;
	}

}
