package state_clock;

//a clock has two buttons, mode and change
//mode lets you choose between "time", "change hours", "change minutes"
//change depends on the mode:
//time: sets the display light on and off
//hours: increments the hour
//minutes: increments the minute
public class Clock {
	
	State currentState;
	private ClockObserver observer;
	
	int hour;
	int minute;
	boolean isLightOn;
	
	public Clock() {
		currentState = TimeState.getInstance();
		observer = new ClockObserver(this);
		hour = 0;
		minute = 0;
		isLightOn = false;
	}
	
	public void mode() {
		currentState.mode(this);
		observer.notifyMode();
	}
	
	public void change() {
		currentState.change(this);
		observer.notifyChange();
	}

	
	public static void main(String[] args) {
		Clock c = new Clock();
		
		c.change();
		
		c.mode();
		c.change();
		
		c.mode();
		c.change();
		c.change();
		c.change();
		
		c.mode();
		c.change();
		
	}
}
