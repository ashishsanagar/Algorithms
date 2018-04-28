package com.ashish.algorithms.misc;

/**
 * @author Ashish Sanagar
 */
public class ClockAngleBetweenHourAndMinuteHands {

	public static void main(String[] args) {
		int hour = 3;
		int minutes = 15;

		new ClockAngleBetweenHourAndMinuteHands().findAngle(hour, minutes);
	}

	public void findAngle(int hour, int minutes) {
		int minuteAngleFrom12oClock = 360 * minutes / 60;

		int hourAngleFrom12OClock = 360 * (hour % 12) / 12 + 360 * (minutes / 60) * 1 / 12;

		int angleBetweenHourMinute = (hourAngleFrom12OClock - minuteAngleFrom12oClock) % 360;

		System.out.println("angle:" + angleBetweenHourMinute);
	}
}
