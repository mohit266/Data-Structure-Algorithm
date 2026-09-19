package com.dsa.DailyChallenges;

// 1401. Circle and Rectangle Overlapping
public class CircleAndRectangleOverlapping {

    public static void main(String[] args) {
        int radius = 1;
        int xCenter = 0;
        int yCenter = 0;
        int x1 = 1;
        int y1 = -1;
        int x2 = 3;
        int y2 = 1;

        CircleAndRectangleOverlapping c = new CircleAndRectangleOverlapping();

        System.out.println(c.checkOverlap(radius, xCenter, yCenter,x1, y1, x2, y2));

    }

    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int closestX = Math.max(x1, Math.min(xCenter, x2));
        int closestY = Math.max(y1, Math.min(yCenter, y2));
        int distanceX = xCenter - closestX;
        int distanceY = yCenter - closestY;
        return (distanceX * distanceX + distanceY * distanceY) <= (radius * radius);
    }
}
