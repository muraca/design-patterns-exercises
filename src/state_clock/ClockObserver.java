package state_clock;

public class ClockObserver {

	private Clock observedClock;
	
	public ClockObserver(Clock c) {
		observedClock = c;
		System.out.println("Observing a Clock.");
		System.out.println("Current time: "+ observedClock.hour + ":" + observedClock.minute);
		System.out.println("Current state: " + observedClock.currentState.getClass().getName());
	}
	
	public void notifyMode() {
		System.out.println("Clock state changed in " + observedClock.currentState.getClass().getName());
	}
	
	public void notifyChange() {
		if (observedClock.currentState == TimeState.getInstance()) {
			System.out.println("Clock light is now " + (observedClock.isLightOn ? "on." : "off."));
			return;
		}
		else if (observedClock.currentState == HourState.getInstance()) {
			System.out.println("The hour has been changed.");
		}
		else {
			System.out.println("The minute has been changed.");
		}
		
		System.out.println("Time is now " + observedClock.hour + ":" + observedClock.minute);
	}
}
