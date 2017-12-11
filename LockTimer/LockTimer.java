import java.lang.System;//Step 1
import java.lang.Thread;//
import java.lang.InterruptedException;// 

/*
	PSEUDO CODE:
		 This should be a simple code.  A timer runs in the background that resets every week.  A counter is also in the background that resets each week as well.  It starts at an int (i.e. 3) and counts down each time the lock is opened.  Once it reaches 0, it cannot be opened anymore, and you have to wait untill the next week to open it again.

		1) Make a timer
		2) Make an int that counts down each time it is activated (by bool?)
		3) Make method that resets timer and counter each time it reaches 1 week
		4) Find electronic lock that can work with embedded java
*/

public class LockTimer {
	public static void main(String[] args) throws InterruptedException {
		LockTimer lockTimer = new LockTimer();
		lockTimer.start();
	}

	void start() throws InterruptedException {
		long i = System.currentTimeMillis();
		//Button would be activated here
		Thread.sleep(10000);
		String foo = displayTimer(i);
		System.out.print(foo);
		Thread.sleep(1000);
		System.out.print("\b\b\b\b\b\b\b\b\b\b");
	}

	String displayTimer(long startTime) {
		long elapsedTime = System.currentTimeMillis() - startTime;
		String time;
		
		long elaSec = elapsedTime / 1000;
		long disSec = elaSec % 60;
		long elaMin = elaSec / 60;
		long disMin = elaMin % 60;
		long elaHou = elaMin / 60;
		long disHou = elaHou % 24;
		long elaDay = elaHou / 24;
		long disDay = elaDay % 7;
		
		time = disDay + ":" + disHou + ":" + disMin + ":" + disSec;
		return time;
	}
	
	int unlockCounter (int i) {
		if (i > 0) {
			i--;
			return i;
		} else {
			return i;
		}
	}
}
