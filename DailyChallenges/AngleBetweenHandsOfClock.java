package com.dsa.DailyChallenges;

public class AngleBetweenHandsOfClock {

    public static void main(String[] args) {
        AngleBetweenHandsOfClock angle = new AngleBetweenHandsOfClock();

        int hour = 12;
        int min = 30;

        System.out.println(angle.angleClock(hour, min));
    }

    public double angleClock(int hour, int minutes) {

        double findDegreeOfHour = (30 * hour) + (0.5 * minutes);
        double findDegreeOfMins = 6 * minutes;

        double totalDegree = Math.abs(findDegreeOfHour - findDegreeOfMins);

        return Math.min(totalDegree, 360 - totalDegree);
    }
}
