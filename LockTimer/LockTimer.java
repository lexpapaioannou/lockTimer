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

public class LockTimer extends Thread {
	public volatile boolean button = false;
	public volatile int tries = 3;

	public static void main(String[] args) throws InterruptedException {
		(new LockTimer()).start();
	}

	public void run() {
		while (true) {
			long i = System.currentTimeMillis();
			if ((System.currentTimeMillis() - 1) > 604800000) {
				i = System.currentTimeMillis();
				continue;
			} 
			
			if (button = true) {
				displayTimer(i);
				unlockCounter(tries);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("FATAL ERROR: InterrutpedException");
				}
				System.out.print("\b\b\b\b\b\b\b\b\b\b");
			}
		}
	}

	String displayTimer(long startTime) {
		long deltaTime = System.currentTimeMillis() - startTime;
		long elapsedTime = 604800000 - deltaTime;
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
	
	boolean unlockCounter (int i) {
		if (i > 0) {
			i--;
			return true;
		} else {
			return false;
		}
	}

}
